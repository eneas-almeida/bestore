package br.com.venzel.store.modules.product.category.entities;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.CreationTimestamp;

import br.com.venzel.store.modules.product.product.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    /* Cardinality */

    @ManyToMany(mappedBy = "categories")
    private List<Product> products = new ArrayList<>();

    /* Timestamp */

    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "datetime")
    private OffsetDateTime createdAt;

    /* Constructor */

    public Category(String name) {
        super();
        this.name = name;
    }
}
