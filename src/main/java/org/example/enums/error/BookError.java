package org.example.enums.error;

public enum BookError {
    NOT_FOUND("Book cannot be found")
    ;

    private final String message;

    BookError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
