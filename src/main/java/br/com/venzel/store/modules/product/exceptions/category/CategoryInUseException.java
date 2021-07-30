package br.com.venzel.store.modules.product.exceptions.category;

import br.com.venzel.store.shared.exceptions.problems.EntityAlreadyExistsException;

public class CategoryInUseException extends EntityAlreadyExistsException {

    private static final long serialVersionUID = 1L;

    public CategoryInUseException(String message) {
        super(message);
    }
}
