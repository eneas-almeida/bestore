package br.com.venzel.store.modules.product.category.exceptions;

import br.com.venzel.store.shared.exceptions.problems.EntityAlreadyExistsException;

public class CategoryInUseException extends EntityAlreadyExistsException {

    private static final long serialVersionUID = 1L;

    public CategoryInUseException(String message) {
        super(message);
    }
}
