package br.com.venzel.store.modules.user.profile.profile.entities;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Entity(name = "profile")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Profile {
    
    /* Id & strategy to generate */

    @Id
    @EqualsAndHashCode.Include
    private Long id;

    /* Timestamps */

    @Column(nullable = false, columnDefinition = "datetime")
    @CreationTimestamp
    private OffsetDateTime createdAt;

    @Column(nullable = false, columnDefinition = "datetime")
    @UpdateTimestamp
    private OffsetDateTime updatedAt;

    /* Cardinalities */
}
