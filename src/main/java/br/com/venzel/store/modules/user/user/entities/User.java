package br.com.venzel.store.modules.user.user.entities;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import br.com.venzel.store.modules.order.order.entities.Order;
import br.com.venzel.store.modules.profile.profile.entities.Profile;
import br.com.venzel.store.modules.user.history.entities.History;
import br.com.venzel.store.modules.user.user.entities.types.UserState;
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

    /* Types */

    @Column(nullable = false)
    private Integer state = UserState.NEW.getCode();
    
    /* Attributes */

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, unique = true, length = 50)
    private String email;

    @Column(nullable = false, length = 50)
    private String password;

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

    public User(String name, String email, String password, UserState state) {
        super();
        this.name = name;
        this.email = email;
        this.password = password;
        this.state = (state == null) ? UserState.NEW.getCode() : state.getCode();
    }

    /* Getters & Setters */

    public UserState getState() {
        return UserState.toEnum(state);
    }

    public void setState(UserState state) {
        this.state = state.getCode();
    }

    /* Cardinalities */

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Profile profile;

    @OneToMany(mappedBy = "user")
    private List<Order> orders = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<History> histories = new ArrayList<>();
}
