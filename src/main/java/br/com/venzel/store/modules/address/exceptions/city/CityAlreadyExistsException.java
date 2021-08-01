package br.com.venzel.store.modules.address.exceptions.city;

import br.com.venzel.store.shared.exceptions.problems.EntityAlreadyExistsException;

public class CityAlreadyExistsException extends EntityAlreadyExistsException {

    private static final long serialVersionUID = 1L;

    public CityAlreadyExistsException(String message) {
        super(message);
    }
}
