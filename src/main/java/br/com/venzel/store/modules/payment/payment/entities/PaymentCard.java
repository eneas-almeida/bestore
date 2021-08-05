package br.com.venzel.store.modules.payment.payment.entities;

import javax.persistence.Entity;

import br.com.venzel.store.modules.order.order.entities.Order;
import br.com.venzel.store.modules.payment.payment.entities.types.PaymentState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "PaymentCard")
public class PaymentCard extends Payment {
    
    /* Attributes */

    private Integer numberInstallments;

    /* Constructors */

    public PaymentCard( PaymentState state, Order order, Integer numberInstallments) {
        super(state, order);
        this.numberInstallments = numberInstallments;
    }
}
