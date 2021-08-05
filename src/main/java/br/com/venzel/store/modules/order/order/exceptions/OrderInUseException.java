package br.com.venzel.store.modules.order.order.exceptions;

import br.com.venzel.store.shared.exceptions.problems.EntityInUseException;

public class OrderInUseException extends EntityInUseException {

    private static final long serialVersionUID = 1L;
    
    public OrderInUseException(String message) {
        super(message);
    }
}
