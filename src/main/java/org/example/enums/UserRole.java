package org.example.enums;

public enum UserRole {
    ADMIN("admin"),
    USER("user")
    ;

    private final String admin;

    UserRole(String admin) {
        this.admin = admin;
    }

    public String getAdmin() {
        return admin;
    }
}
