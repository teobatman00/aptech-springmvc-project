package org.example.enums.error;

public enum UserError {
    NOT_FOUND("User cannot be found");

    private final String message;

    UserError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
