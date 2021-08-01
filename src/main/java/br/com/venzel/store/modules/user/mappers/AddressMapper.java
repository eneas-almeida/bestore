package br.com.venzel.store.modules.user.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.venzel.store.modules.user.dtos.address.AddressDTO;
import br.com.venzel.store.modules.user.dtos.address.CreateAddressDTO;
import br.com.venzel.store.modules.user.dtos.address.UpdateAddressDTO;
import br.com.venzel.store.modules.user.entities.Address;

@Component
public class AddressMapper {

    @Autowired
    private ModelMapper modelMapper;

    public AddressDTO toDTO(Address address) {
        return modelMapper.map(address, AddressDTO.class);
    }

    public List<AddressDTO> toCollectionModel(List<Address> adresses) {
        return adresses.stream()
                    .map(e -> toDTO(e))
                    .collect(Collectors.toList());
    }

    public Address toEntity(CreateAddressDTO dto) {
        return modelMapper.map(dto, Address.class);
    }

    public void toCopyEntity(UpdateAddressDTO dto, Address address) {
        modelMapper.map(dto, address);
    }
}
