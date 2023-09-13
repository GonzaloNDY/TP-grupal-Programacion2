
package unPaquete;

public class Cliente {
    // Atributos:
    String correo;
    String contraseña;
    String apellidos;
    String nombres;
    
    // Métodos:
    public void mostrarInformacion() {
        System.out.println("Nombre Completo: " + apellidos + " " + nombres);
        System.out.println("Correo: " + correo + "\n");
    }
}
