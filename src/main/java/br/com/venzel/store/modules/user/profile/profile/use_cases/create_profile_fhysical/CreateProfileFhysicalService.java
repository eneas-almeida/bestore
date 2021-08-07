package br.com.venzel.store.modules.user.profile.profile.use_cases.create_profile_fhysical;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.venzel.store.modules.user.profile.profile.dtos.CreateProfileFhysicalPersonDTO;
import br.com.venzel.store.modules.user.profile.profile.dtos.ProfilePhysicalPersonDTO;

@Service
public class CreateProfileFhysicalService {

    // @Autowired
    // private ProfileRepository profileRepository;


    @Transactional
    public ProfilePhysicalPersonDTO execute(CreateProfileFhysicalPersonDTO dto, Long id) {
        return null;
    }
}
