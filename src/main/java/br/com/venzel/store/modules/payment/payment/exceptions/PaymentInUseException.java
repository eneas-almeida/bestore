package br.com.venzel.store.modules.payment.payment.exceptions;

import br.com.venzel.store.shared.exceptions.problems.EntityInUseException;

public class PaymentInUseException extends EntityInUseException {

    private static final long serialVersionUID = 1L;
    
    public PaymentInUseException(String message) {
        super(message);
    }
}
