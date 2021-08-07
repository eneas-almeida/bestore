package br.com.venzel.store.modules.user.profile.profile.dtos;

import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonTypeName("profilePhysicalPersonDTO")
public class ProfilePhysicalPersonDTO {
    
    private String avatar;

    private String cpf;
}
