package br.com.venzel.store.modules.profile.address.use_cases.create_address;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.venzel.store.modules.profile.address.dtos.AddressDTO;
import br.com.venzel.store.modules.profile.address.dtos.CreateAddressDTO;
import br.com.venzel.store.modules.profile.address.entities.Address;
import br.com.venzel.store.modules.profile.address.mappers.AddressMapper;
import br.com.venzel.store.modules.profile.address.repositories.AddressRepository;
import br.com.venzel.store.modules.profile.profile.entities.Profile;
import br.com.venzel.store.modules.profile.profile.repositories.ProfileRepository;

@Service
public class CreateAddressService {
    
    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AddressMapper addressMapper;

    @Transactional
    public AddressDTO execute(CreateAddressDTO dto) {

        Optional<Profile> optionalEntity = profileRepository.findOneById(dto.getProfile().getId());

        if (optionalEntity.isEmpty()) {
            // throw new ProfileNotFoundException(ProfileMessageUtils.Profile_NOT_FOUND);
        }

        // Profile Profile = optionalEntity.get();

        /* Update data dto */

        // dto.setProfile(profile);

        /* Address */

        Address address = addressMapper.toEntity(dto);

        addressRepository.save(address);

        /* End address */

        return addressMapper.toDTO(address);
    }
}
