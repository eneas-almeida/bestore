package br.com.venzel.store.modules.user.entities;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import br.com.venzel.store.modules.address.entities.Address;
import br.com.venzel.store.modules.user.entities.types.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false)
    private Integer type = 1;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, unique = true, length = 50)
    private String email;

    @Column(nullable = true, length = 10)
    private String document;

    @Column(nullable = false, length = 50)
    private String password;

    @Column(nullable = true, length = 50)
    private String avatar;

    /* Activated */

    @Column(nullable = false)
    private Boolean activated = Boolean.FALSE;

    public void active() {
        setActivated(true);
    }

    public void inactive() {
        setActivated(false);
    }

    /* Allowed */

    @Column(nullable = false)
    private Boolean allowed = Boolean.TRUE;

    public void allow() {
        setAllowed(true);
    }

    public void disallow() {
        setAllowed(false);
    }

    /* Cardinality */

    @OneToMany(mappedBy = "user")
    private List<Address> adresses = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "telephone")
    private Set<String> telephones = new HashSet<>();

    /* Timestamp */

    @Column(nullable = false, columnDefinition = "datetime")
    @CreationTimestamp
    private OffsetDateTime createdAt;

    @Column(nullable = false, columnDefinition = "datetime")
    @UpdateTimestamp
    private OffsetDateTime updatedAt;

    @Column(nullable = true, columnDefinition = "datetime")
    private OffsetDateTime deletedAt;

    /* Getters & Setters */

    public UserType getType() {
        return UserType.toEnum(type);
    }

    public void setType(UserType type) {
        this.type = type.getCode();
    }

    /* Constructor */

    public User(String name, String email, String password) {
        super();
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(String name, String email, String password, UserType type) {
        super();
        this.name = name;
        this.email = email;
        this.password = password;
        this.type = type.getCode();
    }
}
