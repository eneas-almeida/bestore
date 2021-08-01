package br.com.venzel.store.modules.user.exceptions.address;

import br.com.venzel.store.shared.exceptions.problems.EntityNotFoundException;

public class AddressNotFoundException extends EntityNotFoundException {

    private static final long serialVersionUID = 1L;

    public AddressNotFoundException(String message) {
        super(message);
    }
}
