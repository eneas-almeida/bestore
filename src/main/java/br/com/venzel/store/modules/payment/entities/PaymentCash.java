package br.com.venzel.store.modules.payment.entities;

import javax.persistence.Entity;

import br.com.venzel.store.modules.order.entities.Order;
import br.com.venzel.store.modules.payment.entities.types.PaymentState;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "PaymentCash")
public class PaymentCash extends Payment {
    
    /* Attributes */

    /* Constructors */

    public PaymentCash(Double purchaseAmount, PaymentState state, Order order) {
        super(purchaseAmount, state, order);
    }
}
