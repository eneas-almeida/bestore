package br.com.venzel.store.modules.user.history.exceptions;

import br.com.venzel.store.shared.exceptions.problems.EntityNotFoundException;

public class HistoryNotFoundException extends EntityNotFoundException {

    private static final long serialVersionUID = 1L;
    
    public HistoryNotFoundException(String message) {
        super(message);
    }
}
