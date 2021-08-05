package br.com.venzel.store.modules.user.address.exceptions;

import br.com.venzel.store.shared.exceptions.problems.EntityAlreadyExistsException;

public class StateAlreadyExistsException extends EntityAlreadyExistsException {

    private static final long serialVersionUID = 1L;

    public StateAlreadyExistsException(String message) {
        super(message);
    }
}
