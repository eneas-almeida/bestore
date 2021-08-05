package br.com.venzel.store.modules.payment.payment.entities;

import java.time.OffsetDateTime;

import javax.persistence.Column;
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
@Entity(name = "PaymentBillet")
public class PaymentBillet extends Payment {

    /* Attributes */

    @Column(nullable = true, columnDefinition = "datetime")
    private OffsetDateTime dueDate;
    
    @Column(nullable = true, columnDefinition = "datetime")
    private OffsetDateTime payDay;

    /* Constructors */

    public PaymentBillet(PaymentState state, Order order, OffsetDateTime dueDate, OffsetDateTime payDay) {
        super("Billet", state, order);
        this.dueDate = dueDate;
        this.payDay = payDay;
    }
}
