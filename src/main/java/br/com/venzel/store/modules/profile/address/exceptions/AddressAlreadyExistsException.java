package br.com.venzel.store.modules.profile.address.exceptions;

import br.com.venzel.store.shared.exceptions.problems.EntityAlreadyExistsException;

public class AddressAlreadyExistsException extends EntityAlreadyExistsException {

    private static final long serialVersionUID = 1L;

    public AddressAlreadyExistsException(String message) {
        super(message);
    }
}
