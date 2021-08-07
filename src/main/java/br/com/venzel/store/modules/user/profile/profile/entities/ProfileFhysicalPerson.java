package br.com.venzel.store.modules.user.profile.profile.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "profilePhysicalPerson")
public class ProfileFhysicalPerson extends Profile {
    
    /* Attributes */

    @Column(nullable = true, length = 40)
    private String avatar;

    @Column(nullable = true, length = 15)
    private String cpf;

    /* Constructors */

    public ProfileFhysicalPerson(String avatar, String cpf) {
        super();
        this.avatar = avatar;
        this.cpf = cpf;
    }
}
