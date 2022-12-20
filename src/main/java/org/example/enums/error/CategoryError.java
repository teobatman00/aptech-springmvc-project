package org.example.enums.error;

public enum CategoryError {
    NOT_FOUND("Category cannot be found")
    ;

    private final String message;

    CategoryError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
