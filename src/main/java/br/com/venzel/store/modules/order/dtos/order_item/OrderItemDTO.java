package br.com.venzel.store.modules.order.dtos.order_item;

import br.com.venzel.store.modules.product.dtos.product.ProductDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemDTO {

    /* Attributes */

    private Double discount;

    private Integer quantity;

    private Double price;
   
    /* Geters */

	public double getSubTotal() {
		return (price - discount) * quantity;
	}

    /* Cardinalities */

    private ProductDTO product;
}
