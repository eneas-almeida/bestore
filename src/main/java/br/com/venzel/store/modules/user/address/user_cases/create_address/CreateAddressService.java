package br.com.venzel.store.modules.user.address.user_cases.create_address;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.venzel.store.modules.user.address.dtos.AddressDTO;
import br.com.venzel.store.modules.user.address.dtos.CreateAddressDTO;
import br.com.venzel.store.modules.user.address.entities.Address;
import br.com.venzel.store.modules.user.address.mappers.AddressMapper;
import br.com.venzel.store.modules.user.address.repositories.AddressRepository;
import br.com.venzel.store.modules.user.user.entities.User;
import br.com.venzel.store.modules.user.user.exceptions.UserNotFoundException;
import br.com.venzel.store.modules.user.user.repositories.UserRepository;
import br.com.venzel.store.modules.user.user.utils.UserMessageUtils;

@Service
public class CreateAddressService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AddressMapper addressMapper;

    @Transactional
    public AddressDTO execute(CreateAddressDTO dto) {

        Optional<User> optionalUserWithId = userRepository.findOneById(dto.getUser().getId());

        if (optionalUserWithId.isEmpty()) {
            throw new UserNotFoundException(UserMessageUtils.USER_NOT_FOUND);
        }

        User user = optionalUserWithId.get();

        /* Update data dto */

        dto.setUser(user);

        /* Address */

        Address address = addressMapper.toEntity(dto);

        addressRepository.save(address);

        /* End address */

        return addressMapper.toDTO(address);
    }
}
