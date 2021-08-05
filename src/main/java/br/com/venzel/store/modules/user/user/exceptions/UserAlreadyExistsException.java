package br.com.venzel.store.modules.user.user.exceptions;

import br.com.venzel.store.shared.exceptions.problems.EntityAlreadyExistsException;

public class UserAlreadyExistsException extends EntityAlreadyExistsException {

    private static final long serialVersionUID = 1L;
    
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
