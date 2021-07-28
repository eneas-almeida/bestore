package br.com.venzel.store.shared.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ProblemException> handleAllExceptions(Exception exception, WebRequest webRequest) {

        ProblemException exceptionResponse = new ProblemException(new Date(), exception.getMessage(), webRequest.getDescription(false));
        
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public final ResponseEntity<ProblemException> handleEntityNotFoundException(Exception exception, WebRequest webRequest) {

        ProblemException exceptionResponse = new ProblemException(new Date(), exception.getMessage(), webRequest.getDescription(false));
        
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
}
