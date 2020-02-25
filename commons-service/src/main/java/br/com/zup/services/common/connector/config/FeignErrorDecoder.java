package br.com.zup.services.common.connector.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.zup.services.common.connector.error.BadRequestException;
import br.com.zup.services.common.connector.error.InternalServerErrorException;
import feign.Response;
import feign.codec.ErrorDecoder;
import io.opentracing.ScopeManager;
import io.opentracing.Span;
import io.opentracing.Tracer;
import io.opentracing.tag.Tags;

@Component
public class FeignErrorDecoder implements ErrorDecoder {

    @Autowired
    Tracer tracer;

    @Override
    public Exception decode(String methodKey, Response response) {

        Span span = Optional.ofNullable(tracer).map(Tracer::scopeManager).map(ScopeManager::activeSpan).orElse(null);
        if (span != null) {
            span.log(String.format("%s: %d %s", methodKey, response.status(),response.reason()));
            Tags.HTTP_STATUS.set(span, response.status());
        }

        switch (response.status()) {
            case 400:
                return new BadRequestException(response.reason());
            default:
                if (span != null) { Tags.ERROR.set(span, true); }
                return new InternalServerErrorException(response.reason());
        }
    }

}
