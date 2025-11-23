package com.mycompany.pc2;

import java.util.HashSet;
import java.util.Set;

public class PasswordValidator {

    private static final Set<Character> SPECIAL_CHARS = new HashSet<>();

    static {
        // SOLO escapamos \ y " correctamente
        for (char c : "!@#$%^&*()_-+=\\{}[]|:;\"'<>,.?/".toCharArray()) {
            SPECIAL_CHARS.add(c);
        }
    }

    public static boolean isValid(String password) {

        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("La contraseña no puede ser nula o vacía");
        }

        if (password.startsWith(" ") || password.endsWith(" ")) {
            return false;
        }

        if (password.contains("  ")) {
            return false;
        }

        if (password.length() < 8 || password.length() > 64) {
            return false;
        }

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasUpper = true;
            } else if (Character.isLowerCase(ch)) {
                hasLower = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else if (SPECIAL_CHARS.contains(ch)) {
                hasSpecial = true;
            } else if (ch == ' ') {
                // permitido
            } else {
                return false;
            }
        }

        return hasUpper && hasLower && hasDigit && hasSpecial;
    }
}


