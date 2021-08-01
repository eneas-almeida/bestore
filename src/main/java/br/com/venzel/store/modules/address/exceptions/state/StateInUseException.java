package br.com.venzel.store.modules.address.exceptions.state;

import br.com.venzel.store.shared.exceptions.problems.EntityAlreadyExistsException;

public class StateInUseException extends EntityAlreadyExistsException {

    private static final long serialVersionUID = 1L;

    public StateInUseException(String message) {
        super(message);
    }
}
