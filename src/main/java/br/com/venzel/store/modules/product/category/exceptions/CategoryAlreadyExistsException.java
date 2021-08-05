package br.com.venzel.store.modules.product.category.exceptions;

import br.com.venzel.store.shared.exceptions.problems.EntityAlreadyExistsException;

public class CategoryAlreadyExistsException extends EntityAlreadyExistsException {

    private static final long serialVersionUID = 1L;

    public CategoryAlreadyExistsException(String message) {
        super(message);
    }
}
