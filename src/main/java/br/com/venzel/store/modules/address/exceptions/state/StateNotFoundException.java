package br.com.venzel.store.modules.address.exceptions.state;

import br.com.venzel.store.shared.exceptions.problems.EntityNotFoundException;

public class StateNotFoundException extends EntityNotFoundException {

    private static final long serialVersionUID = 1L;

    public StateNotFoundException(String message) {
        super(message);
    }
}
