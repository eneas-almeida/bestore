package br.com.venzel.store.modules.order.entities;

import java.time.OffsetDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import br.com.venzel.store.modules.payment.entities.Payment;
import br.com.venzel.store.modules.user.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "purchase_order")
public class Order {

    /* Id & strategy to generate */
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    /* Attributes */

    /* Activated */

    @Column(nullable = true)
    private Boolean activated = Boolean.TRUE;

    public void active() {
        setActivated(true);
    }

    public void inactive() {
        setActivated(false);
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

	public Order(User user) {
		super();
		this.user = user;
	}

    /* Getters & Setters */

    /* Cardinalities */

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "order")
    private Payment payment;
}

