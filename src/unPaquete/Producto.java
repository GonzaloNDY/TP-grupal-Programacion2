/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unPaquete;

public class Producto {
    // Atributos:
    String nombre;
    String descripcion;
    float precio;
    int cantidad;  // si cantidad > 0 --> disponible
    String categoria;
    
    // Métodos:
    public void mostrarInformacion() {
        System.out.println("Nombre del producto: " + nombre);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Precio: " + precio);
        System.out.println("Categoria: " + categoria);
        if(cantidad > 0)
            System.out.println("Disponible");
        else
            System.out.println("No disponible");
        System.out.println("");
    }
}