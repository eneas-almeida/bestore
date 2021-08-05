package br.com.venzel.store.modules.user.user.exceptions;

import br.com.venzel.store.shared.exceptions.problems.EntityNotFoundException;

public class UserNotFoundException extends EntityNotFoundException {

    private static final long serialVersionUID = 1L;
    
    public UserNotFoundException(String message) {
        super(message);
    }
}
