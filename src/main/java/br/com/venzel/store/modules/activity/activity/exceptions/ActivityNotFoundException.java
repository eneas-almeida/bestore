package br.com.venzel.store.modules.activity.activity.exceptions;

import br.com.venzel.store.shared.exceptions.problems.EntityNotFoundException;

public class ActivityNotFoundException extends EntityNotFoundException {

    private static final long serialVersionUID = 1L;
    
    public ActivityNotFoundException(String message) {
        super(message);
    }
}
