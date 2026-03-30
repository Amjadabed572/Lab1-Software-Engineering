package com.example.demo;

/**
 * User class with email validation and password complexity requirements.
 */
public class User {
    private final String username;
    private final String password;

    public User(String username, String password) throws Exception {
        // Validate username length (max 50 chars)
        if (username.length() > 50) {
            throw new Exception("Username is too long, try something shorter");
        }

        // Validate email format
        String emailRegex = "^[a-zA-Z0-9%+\\-._]+@[a-zA-Z0-9][a-zA-Z0-9.\\-]*\\.[a-zA-Z.]{2,}$";
        if (!username.matches(emailRegex)) {
            throw new Exception("Please enter a valid Email as username");
        }

        // Validate password length (8-12 characters)
        if (password.length() < 8) {
            throw new Exception("Your password is too short, add more characters");
        }
        if (password.length() > 12) {
            throw new Exception("Your password is too long, try a shorter one");
        }

        // Validate password has letters, digits, and special characters
        String passRegex = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[^a-zA-Z0-9]).+$";
        if (!password.matches(passRegex)) {
            throw new Exception("Please enter a valid password");
        }

        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return username + " " + password;
    }
}