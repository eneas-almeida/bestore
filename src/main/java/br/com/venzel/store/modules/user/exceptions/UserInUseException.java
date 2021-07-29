package br.com.venzel.store.modules.user.exceptions;

import br.com.venzel.store.shared.exceptions.problems.EntityInUseException;

public class UserInUseException extends EntityInUseException {

    private static final long serialVersionUID = 1L;
    
    public UserInUseException(String message) {
        super(message);
    }
}
