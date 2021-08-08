package br.com.venzel.store.modules.profile.profile.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import br.com.venzel.store.modules.profile.profile.dtos.CreateProfileDTO;
import br.com.venzel.store.modules.profile.profile.dtos.ProfileDTO;
import br.com.venzel.store.modules.profile.profile.dtos.UpdateProfileDTO;
import br.com.venzel.store.modules.profile.profile.entities.Profile;



@Component
public class ProfileMapper {

    @Autowired
    private ModelMapper modelMapper;

    public ProfileDTO toDTO(Profile profile) {
        return modelMapper.map(profile, ProfileDTO.class);
    }

    public List<ProfileDTO> toCollectionModel(List<Profile> profiles) {
        return profiles.stream()
                    .map(e -> toDTO(e))
                    .collect(Collectors.toList());
    }

    public Page<ProfileDTO> toCollectionPageModel(Page<Profile> profiles) {
        return profiles.map(e -> toDTO(e));
    }

    public Profile toEntity(CreateProfileDTO dto) {
        return modelMapper.map(dto, Profile.class);
    }

    public void toCopyEntity(UpdateProfileDTO dto, Profile Profile) {
        modelMapper.map(dto, Profile);
    }
}
