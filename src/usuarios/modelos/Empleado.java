
package usuarios.modelos;

public class Empleado {

    // Atributos:
    private String apellido;
    private String nombre;
    private String correo;
    private String contraseña;

    // Constructor: 
    public Empleado (String apellido, String nombre, String correo, String contraseña){
        this.apellido = apellido;
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
    }

    // Métodos:
    public void mostrarInformacion() {
        System.out.println("Nombre Completo: " + verApellido() + " " + verNombre());
        System.out.println("Correo: " + verCorreo() + "\n");
    }
    
    //Métodos ver/asignar (get/set):
    public String verApellido() {
        return apellido;
    }

    public void asignarApellido(String apellido) {
        this.apellido = apellido;
    }

    public String verNombre() {
        return nombre;
    }

    public void asignarNombre(String nombre) {
        this.nombre = nombre;
    }

    public String verCorreo() {
        return correo;
    }

    public void asignarCorreo(String correo) {
        this.correo = correo;
    }

    public String verContraseña() {
        return contraseña;
    }

    public void asignarContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}