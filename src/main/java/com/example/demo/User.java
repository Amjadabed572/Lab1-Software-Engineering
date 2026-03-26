package com.example.demo;

public class User {
    private final String username;
    private final String password;

    public User(String username, String password) throws Exception {
        // 1. Validate Username (Email) Length
        if (username.length() > 50) {
            throw new Exception("Username is too long, try something shorter");
        }

        // 2. Validate Username (Email) Format
        // Part 1: letters, numbers, %+-. and _
        // Part 2: starts with letter/number, followed by letters/numbers/./-
        // Part 3: separated by dot, at least 2 letters
        String emailRegex = "^[a-zA-Z0-9%+\\-._]+@[a-zA-Z0-9][a-zA-Z0-9.\\-]*\\.[a-zA-Z.]{2,}$";
        if (!username.matches(emailRegex)) {
            throw new Exception("Please enter a valid Email as username");
        }

        // 3. Validate Password Length
        if (password.length() < 8) {
            throw new Exception("Your password is too short, add more characters");
        }
        if (password.length() > 12) {
            throw new Exception("Your password is too long, try a shorter one");
        }

        // 4. Validate Password Format
        // Requires at least one letter, at least one digit, and at least one special character
        String passRegex = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[^a-zA-Z0-9]).+$";
        if (!password.matches(passRegex)) {
            throw new Exception("Please enter a valid password");
        }

        // If all checks pass, assign values (Encapsulation)
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    /**public String getPassword() {
        return password;
    }**/

    @Override
    public String toString() {
        return username + " " + password;
    }
}
