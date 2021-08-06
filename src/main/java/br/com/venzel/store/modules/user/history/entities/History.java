package br.com.venzel.store.modules.user.history.entities;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import br.com.venzel.store.modules.user.user.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "history")
public class History {

    /* Id & strategy to generate */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    /* Attributes */
    
    @Column(nullable = false, length = 100)
    private String description;

    /* Timestamps */

    @Column(nullable = false, columnDefinition = "datetime")
    @CreationTimestamp
    private OffsetDateTime createdAt;

    /* Constructors */

    public History(String description, User user) {
        super();
        this.description = description;
        this.user = user;
    }

    /* Cardinalities */
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
