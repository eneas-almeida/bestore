package br.com.venzel.store.shared.exceptions;

public class NegotiationException extends RuntimeException {
    
    static final long serialVersionUID = 1L;

    public NegotiationException(String message) {
        super(message);
    }

    public NegotiationException(String message, Throwable cause) {
        super(message, cause);
    }
}
