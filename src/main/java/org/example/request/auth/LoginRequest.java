package org.example.request.auth;


import javax.validation.constraints.NotNull;

public class LoginRequest {
    @NotNull(message = "username is required")
    private String userName;
    @NotNull(message = "password is required")
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
