package br.com.venzel.store.modules.user.user.entities;

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

import br.com.venzel.store.modules.order.order.entities.Order;
import br.com.venzel.store.modules.user.address.entities.Address;
import br.com.venzel.store.modules.user.user.entities.types.UserType;
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

    /* Id & strategy to generate */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    /* Attributes */

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

    /* Activated attribute */

    @Column(nullable = false)
    private Boolean activated = Boolean.FALSE;

    public void active() {
        setActivated(true);
    }

    public void inactive() {
        setActivated(false);
    }

    /* Allowed attribute */

    @Column(nullable = false)
    private Boolean allowed = Boolean.TRUE;

    public void allow() {
        setAllowed(true);
    }

    public void disallow() {
        setAllowed(false);
    }

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
        this.type = (type == null) ? null : type.getCode();
    }

    /* Getters & Setters */

    public UserType getType() {
        return UserType.toEnum(type);
    }

    public void setType(UserType type) {
        this.type = type.getCode();
    }

    /* Elements collections */

    @ElementCollection
    @CollectionTable(name = "telephone")
    private Set<String> telephones = new HashSet<>();

    /* Cardinalities */

    @OneToMany(mappedBy = "user")
    private List<Order> orders = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Address> adresses = new ArrayList<>();
}
