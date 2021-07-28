package br.com.venzel.store.shared.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_EXTENDED)
public class EntityNotFoundException extends NegotiationException {

    public static final long serialVersionID = 1L;

    public EntityNotFoundException(String message) {
        super(message);
    }
}
