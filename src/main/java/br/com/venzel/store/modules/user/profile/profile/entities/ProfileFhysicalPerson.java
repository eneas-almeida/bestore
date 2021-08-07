package br.com.venzel.store.modules.user.profile.profile.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonTypeName;

import br.com.venzel.store.modules.user.user.entities.User;
import br.com.venzel.store.modules.user.user.entities.types.UserType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "profilePhysicalPerson")
@JsonTypeName("profilePhysicalPerson")
public class ProfileFhysicalPerson extends Profile {
    
    /* Attributes */

    @Column(nullable = true, length = 40)
    private String avatar;

    @Column(nullable = true, length = 15)
    private String cpf;

    /* Constructors */

    public ProfileFhysicalPerson(User user, UserType type) {
        super(user, type);
    }

    public ProfileFhysicalPerson(User user,UserType type, String avatar, String cpf) {
        super(user, type);
        this.avatar = avatar;
        this.cpf = cpf;
    }
}
