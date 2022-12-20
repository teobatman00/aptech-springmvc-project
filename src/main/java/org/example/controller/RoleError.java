package org.example.controller;

public enum RoleError {
    NOT_FOUND("Role cannot be found"),
    ;

    private final String message;

    RoleError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

