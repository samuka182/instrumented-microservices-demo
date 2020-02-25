package br.com.zup.services.address.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.com.zup.services.address.connector.model.Endereco;
import br.com.zup.services.address.model.Address;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    @Mapping(target = "zipCode", source = "cep")
    @Mapping(target = "streetName", source = "logradouro")
    @Mapping(target = "complement", source = "complemento")
    @Mapping(target = "neighborhood", source = "bairro")
    @Mapping(target = "city", source = "localidade")
    @Mapping(target = "state", source = "uf")
    Address convert(Endereco endereco);
}
