package br.com.venzel.store.modules.order.order.exceptions;

import br.com.venzel.store.shared.exceptions.problems.EntityNotFoundException;

public class OrderNotFoundException extends EntityNotFoundException {

    private static final long serialVersionUID = 1L;
    
    public OrderNotFoundException(String message) {
        super(message);
    }
}
