package com.mycompany.pc2;

public class TextProcessor {

    public static String reverseAndCapitalize(String input) {
        if (input == null) throw new IllegalArgumentException("El texto no puede ser nulo");
        String trimmed = input.trim();
        if (trimmed.isEmpty()) throw new IllegalArgumentException("El texto no puede estar vacío");
        if (trimmed.length() > 1000) throw new IllegalArgumentException("El texto excede el límite de 1000 caracteres");
        return new StringBuilder(trimmed).reverse().toString().toUpperCase();
    }

    public int wordCount(String text) {
        if (text == null) throw new IllegalArgumentException("Texto no puede ser nulo");
        String trimmed = text.trim();
        if (trimmed.isEmpty()) return 0;
        return trimmed.split("\\s+").length;
    }

    public int characterCount(String text) {
        if (text == null) throw new IllegalArgumentException("Texto no puede ser nulo");
        return text.length();
    }

    public String replaceText(String original, String target, String replacement) {
        if (original == null) return null;
        return original.replace(target, replacement);
    }

    public String toUpper(String text) {
        if (text == null) return null;
        return text.toUpperCase();
    }

    public String toLower(String text) {
        if (text == null) return null;
        return text.toLowerCase();
    }
}

