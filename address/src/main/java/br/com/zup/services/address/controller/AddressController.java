package br.com.zup.services.address.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.services.address.model.Address;
import br.com.zup.services.address.service.AddressService;
import br.com.zup.services.common.model.GenericResponse;
import br.com.zup.services.common.model.ResultCode;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService service;

    @GetMapping("/zip/{zip}")
    public GenericResponse<Address> getByZip(@PathVariable("zip") String zip){
            return new GenericResponse<>(service.getAddressByZip(zip)).withResultCode(ResultCode.SUCCESS);
    }
}
