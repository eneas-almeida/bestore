package br.com.venzel.store.modules.product.category.exceptions;

import br.com.venzel.store.shared.exceptions.problems.EntityNotFoundException;

public class CategoryNotFoundException extends EntityNotFoundException {

    private static final long serialVersionUID = 1L;

    public CategoryNotFoundException(String message) {
        super(message);
    }
}
