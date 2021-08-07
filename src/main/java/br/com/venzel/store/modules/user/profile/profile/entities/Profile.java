package br.com.venzel.store.modules.user.profile.profile.entities;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import br.com.venzel.store.modules.user.user.entities.User;
import br.com.venzel.store.modules.user.user.entities.types.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "profile")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
    @Type(value = ProfileFhysicalPerson.class, name = "physical"),
    @Type(value = ProfileLegalPerson.class, name = "legal")
})
public abstract class Profile {
    
    /* Id & strategy to generate */

    @Id
    @EqualsAndHashCode.Include
    private Long id;

    private String type;

    /* Type */

    // @Column(nullable = false)
    // private Integer type;

    /* Timestamps */

    @Column(nullable = false, columnDefinition = "datetime")
    @CreationTimestamp
    private OffsetDateTime createdAt;

    @Column(nullable = false, columnDefinition = "datetime")
    @UpdateTimestamp
    private OffsetDateTime updatedAt;

    /* Constructors */

    public Profile(User user, UserType type) {
        super();
        this.user = user;
        // this.type = (type == null) ? UserType.PHYSICAL_PERSON.getCode() : type.getCode();
    }

    /* Getters & Setters */

    // public UserType getType() {
    //     return UserType.toEnum(type);
    // }

    // public void setType(UserType type) {
    //     this.type = type.getCode();
    // }

    /* Cardinalities */

    @OneToOne
    @JoinColumn(name = "user_id")
    @MapsId
    private User user;
}
