package br.com.venzel.store.shared.exceptions;

import lombok.Getter;

@Getter
public enum ProblemType {
    
    ENTITY_IN_USER("/ENTITY-IN-USE", "Entity in use"),
    ENTITY_NOT_FOUND("/ENTITY-NOT-FOUND", "Entity not found");

    private String uri;
    private String title;

    ProblemType(String path, String title) {
		this.uri = "https://store.app" + path;
		this.title = title;
    }
}
