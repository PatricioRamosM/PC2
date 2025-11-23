/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pc2;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author USER
 */
public class InventoryManager {

    private Map<String, Integer> inventory = new HashMap<>();

    public void addItem(String item, int quantity) {

        // Validación nombre nulo o vacío
        if (item == null || item.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío");
        }

        // Validación longitud
        if (item.length() < 2 || item.length() > 50) {
            throw new IllegalArgumentException("El nombre del producto debe tener entre 2 y 50 caracteres");
        }

        // Validación cantidad
        if (quantity <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que 0");
        }

        if (quantity > 1000) {
            throw new IllegalArgumentException("La cantidad máxima permitida es 1000");
        }

        // Si ya existe, suma al stock actual
        inventory.put(item, inventory.getOrDefault(item, 0) + quantity);
    }

    public int getStock(String item) {
        return inventory.getOrDefault(item, 0);
    }
}
