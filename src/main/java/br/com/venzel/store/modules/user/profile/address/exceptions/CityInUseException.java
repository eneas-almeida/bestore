package br.com.venzel.store.modules.user.profile.address.exceptions;

import br.com.venzel.store.shared.exceptions.problems.EntityAlreadyExistsException;

public class CityInUseException extends EntityAlreadyExistsException {

    private static final long serialVersionUID = 1L;

    public CityInUseException(String message) {
        super(message);
    }
}
