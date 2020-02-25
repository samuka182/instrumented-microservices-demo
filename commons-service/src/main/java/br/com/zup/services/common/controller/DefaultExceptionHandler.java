package br.com.zup.services.common.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.zup.services.common.connector.error.BadRequestException;
import br.com.zup.services.common.connector.error.InternalServerErrorException;
import br.com.zup.services.common.model.GenericResponse;
import br.com.zup.services.common.model.MessageResponse;
import br.com.zup.services.common.model.ResultCode;

@ControllerAdvice
public class DefaultExceptionHandler  {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<GenericResponse<?>> badRequestException(BadRequestException e) {
        GenericResponse<Object> response = new GenericResponse<>().withError(new MessageResponse("400", e.getMessage())).withResultCode(ResultCode.ERROR);
        return new ResponseEntity<>(response, headers(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<GenericResponse<?>> internalServerErrorException(InternalServerErrorException e) {
        GenericResponse<Object> response = new GenericResponse<>().withError(new MessageResponse("500", e.getMessage())).withResultCode(ResultCode.ERROR);
        return new ResponseEntity<>(response, headers(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    protected HttpHeaders headers() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return httpHeaders;
    }

}
