
package usuarios.modelos;

public class Empleado {

    // Atributos:
    private String apellidos;
    private String nombres;
    private String correo;
    private String contraseña;

    // Constructor: 
    public Empleado (String apellidos, String nombres, String correo, String contraseña){
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.correo = correo;
        this.contraseña = contraseña;
    }

    // Métodos:
    public String verApellidos() {
        return apellidos;
    }

    public void asignarApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String verNombres() {
        return nombres;
    }

    public void asignarNombres(String nombres) {
        this.nombres = nombres;
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

    public void mostrarInformacion() {
        System.out.println("Nombre Completo: " + verApellidos() + " " + verNombres());
        System.out.println("Correo: " + verCorreo() + "\n");
    }
}
