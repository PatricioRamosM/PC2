package com.mycompany.pc2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InventoryManagerTest {

    @Test
    void testAgregarNuevoProducto() {
        InventoryManager manager = new InventoryManager();
        manager.addItem("Laptop", 5);
        assertEquals(5, manager.getStock("Laptop"));
    }

    @Test
    void testAgregarCantidadNegativa() {
        InventoryManager manager = new InventoryManager();
        assertThrows(IllegalArgumentException.class,
                () -> manager.addItem("Mouse", -1));
    }

    @Test
    void testAgregarCantidadCero() {
        InventoryManager manager = new InventoryManager();
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> manager.addItem("Teclado", 0));
        assertEquals("La cantidad debe ser mayor que 0", ex.getMessage());
    }

    @Test
    void testAgregarNombreVacio() {
        InventoryManager manager = new InventoryManager();
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> manager.addItem("", 5));
        assertEquals("El nombre del producto no puede estar vacío", ex.getMessage());
    }

    @Test
    void testAgregarNombreSoloEspacios() {
        InventoryManager manager = new InventoryManager();
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> manager.addItem("   ", 5));
        assertEquals("El nombre del producto no puede estar vacío", ex.getMessage());
    }

    @Test
    void testAgregarNombreMuyLargo() {
        InventoryManager manager = new InventoryManager();
        String name = "A".repeat(60);
        assertThrows(IllegalArgumentException.class,
                () -> manager.addItem(name, 5));
    }

    @Test
    void testAgregarProductoExistenteSumaCantidad() {
        InventoryManager manager = new InventoryManager();
        manager.addItem("Mouse", 3);
        manager.addItem("Mouse", 2);
        assertEquals(5, manager.getStock("Mouse"));
    }

    @Test
    void testObtenerStockProductoInexistente() {
        InventoryManager manager = new InventoryManager();
        assertEquals(0, manager.getStock("ProductoFantasma"));
    }

    // -------------------------------
    // NUEVOS TESTS PARA COBERTURA
    // -------------------------------

    @Test
    void testAgregarCantidadExcesiva() {
        InventoryManager manager = new InventoryManager();
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> manager.addItem("Camara", 1001));
        assertEquals("La cantidad máxima permitida es 1000", ex.getMessage());
    }

    @Test
    void testAgregarMultiplesProductos() {
        InventoryManager manager = new InventoryManager();
        manager.addItem("Mouse", 5);
        manager.addItem("Teclado", 10);
        assertEquals(5, manager.getStock("Mouse"));
        assertEquals(10, manager.getStock("Teclado"));
    }

    @Test
    void testAgregarNombreLongitudMinima() {
        InventoryManager manager = new InventoryManager();
        manager.addItem("AB", 1);
        assertEquals(1, manager.getStock("AB"));
    }

    @Test
    void testAgregarNombreLongitudMaxima() {
        InventoryManager manager = new InventoryManager();
        String name = "A".repeat(50);
        manager.addItem(name, 5);
        assertEquals(5, manager.getStock(name));
    }

    @Test
    void testAgregarCantidadMinima() {
        InventoryManager manager = new InventoryManager();
        manager.addItem("Mouse", 1);
        assertEquals(1, manager.getStock("Mouse"));
    }

    @Test
    void testAgregarCantidadMaxima() {
        InventoryManager manager = new InventoryManager();
        manager.addItem("Teclado", 1000);
        assertEquals(1000, manager.getStock("Teclado"));
    }
}
