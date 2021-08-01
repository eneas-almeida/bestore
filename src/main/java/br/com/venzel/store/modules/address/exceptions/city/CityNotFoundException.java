package br.com.venzel.store.modules.address.exceptions.city;

import br.com.venzel.store.shared.exceptions.problems.EntityNotFoundException;

public class CityNotFoundException extends EntityNotFoundException {

    private static final long serialVersionUID = 1L;

    public CityNotFoundException(String message) {
        super(message);
    }
}
