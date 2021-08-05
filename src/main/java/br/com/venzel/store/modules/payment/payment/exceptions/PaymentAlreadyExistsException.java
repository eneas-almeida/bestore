package br.com.venzel.store.modules.payment.payment.exceptions;

import br.com.venzel.store.shared.exceptions.problems.EntityAlreadyExistsException;

public class PaymentAlreadyExistsException extends EntityAlreadyExistsException {

    private static final long serialVersionUID = 1L;
    
    public PaymentAlreadyExistsException(String message) {
        super(message);
    }
}
