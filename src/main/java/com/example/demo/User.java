package com.example.demo;

/**
 * User class with email validation and password complexity requirements.
 * Ensures username is a valid email (max 50 chars) and password meets length and character rules.
 */
public class User {
    private final String username;
    private final String password;

    /**
     * Constructs a User with validation for username and password.
     * Throws Exception if validation fails.
     *
     * @param username the email address (must be valid and <=50 chars)
     * @param password the password (8-12 chars, with letters, digits, special chars)
     * @throws Exception if username or password is invalid
     */
    public User(String username, String password) throws Exception {
        // Validate username length (max 50 chars)
        if (username.length() > 50) {
            throw new Exception("Username is too long, try something shorter");
        }

        // Validate email format using regex
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

        // Validate password has letters, digits, and special characters using regex
        String passRegex = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[^a-zA-Z0-9]).+$";
        if (!password.matches(passRegex)) {
            throw new Exception("Please enter a valid password");
        }

        this.username = username;
        this.password = password;
    }

    /**
     * Gets the username (email).
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Returns a string representation of the user.
     *
     * @return username and password separated by space
     */
    @Override
    public String toString() {
        return username + " " + password;
    }
}