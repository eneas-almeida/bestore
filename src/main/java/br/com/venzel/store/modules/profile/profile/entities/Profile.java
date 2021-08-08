package br.com.venzel.store.modules.profile.profile.entities;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import br.com.venzel.store.modules.profile.address.entities.Address;
import br.com.venzel.store.modules.profile.profile.entities.types.ProfileType;
import br.com.venzel.store.modules.user.user.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "profile")
public class Profile {
    
    /* Id & strategy to generate */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    /* Type */

    @Column(nullable = false)
    private Integer type;

    /* Timestamps */

    @Column(nullable = false, columnDefinition = "datetime")
    @CreationTimestamp
    private OffsetDateTime createdAt;

    @Column(nullable = false, columnDefinition = "datetime")
    @UpdateTimestamp
    private OffsetDateTime updatedAt;

    /* Date for data hiding */

    @Column(nullable = true, columnDefinition = "datetime")
    private OffsetDateTime deletedAt;

    /* Constructors */

    public Profile(User user, ProfileType type) {
        super();
        this.user = user;
        this.type = (type == null) ? ProfileType.PHYSICAL_PERSON.getCode() : type.getCode();
    }

    /* Getters & Setters */

    public ProfileType getType() {
        return ProfileType.toEnum(type);
    }

    public void setType(ProfileType type) {
        this.type = type.getCode();
    }

    /* Elements collections */

    /*
    @ElementCollection
    @CollectionTable(name = "telephone")
    private Set<String> telephones = new HashSet<>();


    @ElementCollection
    @CollectionTable(name = "email")
    private Set<String> emails = new HashSet<>();
    */

    /* Cardinalities */

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "profile")
    private List<Address> adresses = new ArrayList<>();
}
