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
@Entity(name = "PaymentCash")
@NoArgsConstructor
@AllArgsConstructor
public class PaymentCash extends Payment {
    
    /* Attributes */

    private Double amount;

    /* Constructors */

    public PaymentCash(PaymentState state, Order order, Double amount) {
        super("Cash", state, order);
        this.amount = amount;
    }
}
