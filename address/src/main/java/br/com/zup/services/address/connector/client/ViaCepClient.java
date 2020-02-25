package br.com.zup.services.address.connector.client;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.zup.services.address.connector.model.Endereco;

@Component
@EnableFeignClients(basePackages = "br.com.zup.services.address")
@FeignClient(name = "via-cep", url = "${via-cep.endereco.url}")
public interface ViaCepClient {

    @RequestMapping(method = RequestMethod.GET, value = "/ws/{cep}/json/")
    public Endereco getEndereco(@PathVariable("cep") String cep);

}
