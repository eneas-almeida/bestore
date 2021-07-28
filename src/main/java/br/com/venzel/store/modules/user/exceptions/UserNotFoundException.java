package br.com.venzel.store.modules.user.exceptions;

import br.com.venzel.store.shared.exceptions.EntityNotFoundException;

public class UserNotFoundException extends EntityNotFoundException {

    public UserNotFoundException(String message) {
        super(message);
    }
}
