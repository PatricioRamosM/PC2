package com.mycompany.pc2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.function.Executable;

public class EmailTest {

    private final Email validator = new Email();

    // 1. Correo null → IllegalArgumentException
    @Test
    void testEmailNull() {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() {
                validator.isValidEmail(null);
            }
        });
    }

    // 2. Correo vacío → IllegalArgumentException
    @Test
    void testEmailEmpty() {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() {
                validator.isValidEmail("");
            }
        });
    }

    // 3. Sin @ → false
    @Test
    void testEmailWithoutAtSymbol() {
        assertFalse(validator.isValidEmail("usuario.gmail.com"));
    }

    // 4. Dominio inválido → false
    @Test
    void testInvalidDomain() {
        assertFalse(validator.isValidEmail("usuario@com"));
    }

    // 5. Correo válido → true
    @Test
    void testValidEmail() {
        assertTrue(validator.isValidEmail("cliente123@tienda.com"));
    }

    // 6. Parte local inválida (empieza con punto) → false
    @Test
    void testInvalidLocalPart() {
        assertFalse(validator.isValidEmail(".cliente123@tienda.com"));
    }

    // 7. Local termina en punto → false
    @Test
    void testLocalTerminaEnPunto() {
        assertFalse(validator.isValidEmail("cliente.@gmail.com"));
    }

    // 8. Local con dos puntos consecutivos → false
    @Test
    void testLocalConDosPuntos() {
        assertFalse(validator.isValidEmail("cli..ente@gmail.com"));
    }

    // 9. Local con caracteres inválidos → false
    @Test
    void testLocalCaracterInvalido() {
        assertFalse(validator.isValidEmail("clie*nte@gmail.com"));
    }

    // 10. Dominio sin punto → false (variante)
    @Test
    void testDominioSinPunto() {
        assertFalse(validator.isValidEmail("cliente@gmailcom"));
    }

    // 11. Nombre de dominio demasiado corto → false
    @Test
    void testNombreDominioMuyCorto() {
        assertFalse(validator.isValidEmail("cliente@a.com"));
    }

    // 12. Extensión no válida → false
    @Test
    void testExtensionNoValida() {
        assertFalse(validator.isValidEmail("cliente@tienda.xyz"));
    }
    @Test
    void testEmailTooShort() {
    assertFalse(validator.isValidEmail("a@b.c"));
    }

// 8. Correo con dominio sin punto (domainParts.length < 2) → false
    @Test
    void testDomainWithoutDot() {
    assertFalse(validator.isValidEmail("usuario@dominio"));
    }

// 9. Correo demasiado largo (>254 chars) → false
    @Test
    void testEmailTooLong() {
    String largo = "a".repeat(260) + "@gmail.com";
    assertFalse(validator.isValidEmail(largo));
    }
   }

