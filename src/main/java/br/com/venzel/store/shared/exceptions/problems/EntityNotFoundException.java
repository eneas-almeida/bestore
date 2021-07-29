package br.com.venzel.store.shared.exceptions.problems;

public class EntityNotFoundException extends EntityException {

    private static final long serialVersionUID = 1L;

    public EntityNotFoundException(String message) {
        super(message);
    }
}
