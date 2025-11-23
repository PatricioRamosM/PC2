package com.mycompany.pc2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TextProcessorTest {

    @Test
    void testContarPalabrasVacio() {
        TextProcessor tp = new TextProcessor();
        assertEquals(0, tp.wordCount(""));
    }

    @Test
    void testContarPalabrasEspacios() {
        TextProcessor tp = new TextProcessor();
        assertEquals(0, tp.wordCount("     "));
    }

    @Test
    void testContarPalabrasUna() {
        TextProcessor tp = new TextProcessor();
        assertEquals(1, tp.wordCount("Hola"));
    }

    @Test
    void testContarPalabrasMultiples() {
        TextProcessor tp = new TextProcessor();
        assertEquals(6, tp.wordCount("Este es un texto de prueba"));
    }

    @Test
    void testContarPalabrasConSaltosLinea() {
        TextProcessor tp = new TextProcessor();
        String texto = "Hola\nmundo\nJUnit\nTest";
        assertEquals(4, tp.wordCount(texto));
    }

    @Test
    void testContarCaracteresVacio() {
        TextProcessor tp = new TextProcessor();
        assertEquals(0, tp.characterCount(""));
    }

    @Test
    void testContarCaracteresNormales() {
        TextProcessor tp = new TextProcessor();
        String texto = "Hola mundo";
        assertEquals(10, tp.characterCount(texto));
    }

    @Test
    void testContarCaracteresConEspacios() {
        TextProcessor tp = new TextProcessor();
        String texto = " Hola  mundo ";
        assertEquals(13, tp.characterCount(texto));
    }

   // -------------------------------
    // reverseAndCapitalize
    // -------------------------------

    @Test
    void testReverseAndCapitalizeNormal() {
        assertEquals("OLAH", TextProcessor.reverseAndCapitalize("haLo "));
    }

    @Test
    void testReverseAndCapitalizeNulo() {
        assertThrows(IllegalArgumentException.class, () -> TextProcessor.reverseAndCapitalize(null));
    }

    @Test
    void testReverseAndCapitalizeVacio() {
        assertThrows(IllegalArgumentException.class, () -> TextProcessor.reverseAndCapitalize("   "));
    }

    @Test
    void testReverseAndCapitalizeMasDe1000() {
        String texto = "a".repeat(1001);
        assertThrows(IllegalArgumentException.class, () -> TextProcessor.reverseAndCapitalize(texto));
    }

    // -------------------------------
    // replaceText
    // -------------------------------

    @Test
    void testReemplazarTexto() {
        TextProcessor tp = new TextProcessor();
        assertEquals("Hola JUnit", tp.replaceText("Hola mundo", "mundo", "JUnit"));
    }

    @Test
    void testReemplazarTextoNoExiste() {
        TextProcessor tp = new TextProcessor();
        assertEquals("Hola mundo", tp.replaceText("Hola mundo", "Python", "JUnit"));
    }

    @Test
    void testReemplazarTextoNulo() {
        TextProcessor tp = new TextProcessor();
        assertNull(tp.replaceText(null, "a", "b"));
    }

    @Test
    void testReemplazarTextoVacio() {
        TextProcessor tp = new TextProcessor();
        assertEquals("", tp.replaceText("", "a", "b"));
    }

    // -------------------------------
    // toUpper y toLower
    // -------------------------------

    @Test
    void testConvertirAMayusculas() {
        TextProcessor tp = new TextProcessor();
        assertEquals("HOLA MUNDO", tp.toUpper("Hola mundo"));
    }

    @Test
    void testConvertirAMayusculasNulo() {
        TextProcessor tp = new TextProcessor();
        assertNull(tp.toUpper(null));
    }

    @Test
    void testConvertirAMinusculas() {
        TextProcessor tp = new TextProcessor();
        assertEquals("hola mundo", tp.toLower("HOLA MUNDO"));
    }

    @Test
    void testConvertirAMinusculasNulo() {
        TextProcessor tp = new TextProcessor();
        assertNull(tp.toLower(null));
    }

    // -------------------------------
    // validaciones nulas
    // -------------------------------

    @Test
    void testTextoNuloEnContarPalabras() {
        TextProcessor tp = new TextProcessor();
        assertThrows(IllegalArgumentException.class, () -> tp.wordCount(null));
    }

    @Test
    void testTextoNuloEnContarCaracteres() {
        TextProcessor tp = new TextProcessor();
        assertThrows(IllegalArgumentException.class, () -> tp.characterCount(null));
    }

    @Test
    void testTextoConTabulaciones() {
        TextProcessor tp = new TextProcessor();
        assertEquals(3, tp.wordCount("Hola\tmundo\tJUnit"));
    }

    @Test
    void testTextoConMultiplesEspaciosEntrePalabras() {
        TextProcessor tp = new TextProcessor();
        assertEquals(3, tp.wordCount("Hola    mundo    JUnit"));
    }
}

