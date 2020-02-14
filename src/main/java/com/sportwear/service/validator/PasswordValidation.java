package com.sportwear.service.validator;

public class PasswordValidation {

    public void validate (String password, String passwordRepeat) {
        length(password);
        if (!password.equalsIgnoreCase(passwordRepeat)) {
            throw new IllegalArgumentException("Repeat password must equals password");
        }
    }

    private void length(String password) {
        if (password.length() < 5) {
            throw new IllegalArgumentException("Password length must be at least 5 symbols");
        }
    }
}
