package br.com.venzel.store.modules.payment.exceptions;

import br.com.venzel.store.shared.exceptions.problems.EntityNotFoundException;

public class PaymentNotFoundException extends EntityNotFoundException {

    private static final long serialVersionUID = 1L;
    
    public PaymentNotFoundException(String message) {
        super(message);
    }
}
