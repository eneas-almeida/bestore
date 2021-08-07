package br.com.venzel.store.modules.user.profile.address.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.venzel.store.modules.user.profile.address.dtos.AddressDTO;
import br.com.venzel.store.modules.user.profile.address.dtos.CreateAddressDTO;
import br.com.venzel.store.modules.user.profile.address.dtos.UpdateAddressDTO;
import br.com.venzel.store.modules.user.profile.address.entities.Address;

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
