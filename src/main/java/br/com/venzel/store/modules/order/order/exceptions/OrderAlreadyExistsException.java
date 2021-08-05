package br.com.venzel.store.modules.order.order.exceptions;

import br.com.venzel.store.shared.exceptions.problems.EntityAlreadyExistsException;

public class OrderAlreadyExistsException extends EntityAlreadyExistsException {

    private static final long serialVersionUID = 1L;
    
    public OrderAlreadyExistsException(String message) {
        super(message);
    }
}
