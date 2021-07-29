package br.com.venzel.store.shared.exceptions.problems;

public class EntityException extends RuntimeException {

    static final long serialVersionUID = 1L;

	public EntityException(String message) {
		super(message);
	}
	
	public EntityException(String message, Throwable cause) {
		super(message, cause);
	}
}
