package br.com.zup.services.address.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.services.address.connector.client.ViaCepClient;
import br.com.zup.services.address.model.Address;
import br.com.zup.services.address.service.mapper.AddressMapper;

@Service
public class AddressService {
	
	@Autowired
    private ViaCepClient viaCepClient;
    
    @Autowired
    private AddressMapper addressMapper;

    public Address getAddressByZip(String zipCode){
        return addressMapper.convert(viaCepClient.getEndereco(zipCode));
    }

}
