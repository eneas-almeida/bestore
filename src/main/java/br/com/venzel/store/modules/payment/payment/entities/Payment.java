package br.com.venzel.store.modules.payment.payment.entities;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import br.com.venzel.store.modules.order.order.entities.Order;
import br.com.venzel.store.modules.payment.payment.entities.types.PaymentState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "payment")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Payment {

    /* Id & strategy to generate */

    @Id
    @EqualsAndHashCode.Include
    private Long id;

    /* Attributes */

    @Column(nullable = false)
    private Integer state = 1;

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

    public Payment(PaymentState state, Order order) {
        super();
		this.state = (state == null) ? null : state.getCode();
		this.order = order;
    }

    /* Getters & Setters */

    public PaymentState getState() {
        return PaymentState.toEnum(state);
    }

    public void setState(PaymentState state) {
        this.state = state.getCode();
    }

    /* Cardinalities */

    @OneToOne
    @JoinColumn(name = "order_id")
    @MapsId
    private Order order;
}
