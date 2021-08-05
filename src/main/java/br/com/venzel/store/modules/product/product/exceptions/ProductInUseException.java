package br.com.venzel.store.modules.product.product.exceptions;

import br.com.venzel.store.shared.exceptions.problems.EntityAlreadyExistsException;

public class ProductInUseException extends EntityAlreadyExistsException {

    private static final long serialVersionUID = 1L;

    public ProductInUseException(String message) {
        super(message);
    }
}
