/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unPaquete;

public class Empleado {
    // Atributos:
    String correo;
    String contraseña;
    String apellidos;
    String nombres;
    
    // Métodos:
    public void mostrarInformacion() {
        System.out.println("Correo: " + correo);
        System.out.println("Nombre Completo: " + apellidos + " " + nombres + "\n");
    }
}
