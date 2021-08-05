package br.com.venzel.store.modules.product.product.exceptions;

import br.com.venzel.store.shared.exceptions.problems.EntityNotFoundException;

public class ProductNotFoundException extends EntityNotFoundException {

    private static final long serialVersionUID = 1L;

    public ProductNotFoundException(String message) {
        super(message);
    }
}
