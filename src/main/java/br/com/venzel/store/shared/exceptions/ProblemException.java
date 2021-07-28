package br.com.venzel.store.shared.exceptions;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProblemException implements Serializable {

    static final long serialVersionID = 1L;

    private Date timestamps;

    private String message;

    private String details;
}
