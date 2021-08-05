package br.com.venzel.store.modules.user.address.exceptions;

import br.com.venzel.store.shared.exceptions.problems.EntityNotFoundException;

public class StateNotFoundException extends EntityNotFoundException {

    private static final long serialVersionUID = 1L;

    public StateNotFoundException(String message) {
        super(message);
    }
}
