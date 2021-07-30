package br.com.venzel.store.modules.product.exceptions.category;

import br.com.venzel.store.shared.exceptions.problems.EntityAlreadyExistsException;

public class CategoryAlreadyExistsException extends EntityAlreadyExistsException {

    private static final long serialVersionUID = 1L;

    public CategoryAlreadyExistsException(String message) {
        super(message);
    }
}
