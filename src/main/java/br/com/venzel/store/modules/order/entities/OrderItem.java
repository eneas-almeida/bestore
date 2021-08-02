package br.com.venzel.store.modules.order.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import br.com.venzel.store.modules.product.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "orderItem")
public class OrderItem {

    /* Id & strategy to generate */

    @EmbeddedId
    @EqualsAndHashCode.Include
    private OrderItemPK id = new OrderItemPK();

    /* Attributes */

    @Column(nullable = true, length = 10)
    private Double discount;

    @Column(nullable = true, length = 5)
    private Integer quantity;

    @Column(nullable = true, length = 5)
    private Double price;

    /* Constructors */

    public OrderItem(Order order, Product product, Double discount, Integer quantity, Double price) {
        super();
        id.setOrder(order);
        id.setProduct(product);
        this.discount = discount;
        this.quantity = quantity;
        this.price = price;
    }

    /* Getters & Setters */

    public Order getOrder() {
        return id.getOrder();
    }

    public Product getProduct() {
        return id.getProduct();
    }

    /* Cardinalities */
}
