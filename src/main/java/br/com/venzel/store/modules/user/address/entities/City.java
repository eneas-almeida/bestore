package br.com.venzel.store.modules.user.address.entities;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "city")
public class City {

    /* Id & strategy to generate */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    /* Attributes */

    @Column(nullable = false, length = 50)
    private String name;

    /* Timestamps */

    @Column(nullable = false, columnDefinition = "datetime")
    @CreationTimestamp
    private OffsetDateTime createdAt;
    
     /* Constructors */

    public City(String name, State state) {
        this.name = name;
        this.state = state;
    }

    /* Cardinalities */

    @ManyToOne
    @JoinColumn(name = "state_id")
    private State state;
}
