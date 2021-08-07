package br.com.venzel.store.modules.user.profile.profile.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "profileLegalPerson")
public class ProfileLegalPerson extends Profile {
    
    /* Attributes */

    @Column(nullable = true, length = 100)
    private String socialReason;

    @Column(nullable = true, length = 40)
    private String cnpj;

    /* Constructors */

    public ProfileLegalPerson(String socialReason, String cnpj) {
        super();
        this.socialReason = socialReason;
        this.cnpj = cnpj;
    }
}
