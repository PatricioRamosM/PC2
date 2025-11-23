package com.mycompany.pc2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {

    @Test
    void pruebaContrasenaNula() {
        IllegalArgumentException ex = assertThrows(
            IllegalArgumentException.class,
            () -> PasswordValidator.isValid(null)
        );
        assertEquals("La contraseña no puede ser nula o vacía", ex.getMessage());
    }

    @Test
    void pruebaContrasenaVacia() {
        IllegalArgumentException ex = assertThrows(
            IllegalArgumentException.class,
            () -> PasswordValidator.isValid("")
        );
        assertEquals("La contraseña no puede ser nula o vacía", ex.getMessage());
    }

    @Test
    void pruebaContrasenaValida() {
        assertTrue(PasswordValidator.isValid("Secure123!"));
    }

    @Test
    void pruebaFaltaRequisitos() {
        assertFalse(PasswordValidator.isValid("nosecura"));
    }

    @Test
    void pruebaContrasenaCorta() {
        assertFalse(PasswordValidator.isValid("A1$bcd"));
    }

    @Test
    void pruebaCaracterNoPermitido() {
        assertFalse(PasswordValidator.isValid("Abc123~!"));
    }

    @Test
    void pruebaDobleEspacio() {
        String password = "Abc12  #d";
        assertFalse(PasswordValidator.isValid(password));
    }

    @Test
    void pruebaSinCaracterEspecial() {
        assertFalse(PasswordValidator.isValid("Abc12345"));
    }

    // -------------------------------
    // NUEVOS TESTS PARA COBERTURA
    // -------------------------------

    @Test
    void pruebaEspacioInicio() {
        assertFalse(PasswordValidator.isValid(" Abc123!"));
    }

    @Test
    void pruebaEspacioFinal() {
        assertFalse(PasswordValidator.isValid("Abc123! "));
    }

    @Test
    void pruebaSoloMayusculasMinusculas() {
        assertFalse(PasswordValidator.isValid("AbcDefGhi"));
    }

    @Test
    void pruebaLongitudMinimaValida() {
        assertTrue(PasswordValidator.isValid("Abc1!def"));
    }

    @Test
    void pruebaLongitudMaximaValida() {
        String base = "Abc1!";
        String password = base + "a".repeat(59); // total = 64
        assertTrue(PasswordValidator.isValid(password));
    }

    @Test
    void pruebaCaracterEspecialPermitido() {
        PasswordValidator validator = new PasswordValidator();
        assertTrue(validator.isValid("Abcdef1!"), "El carácter especial ! debería ser válido");
    }
 
}
