
package usuarios.modelos;

public class Encargado {

    // Atributos:
    private String apellidos;
    private String nombres;
    private String correo;
    private String contraseña;

    // Constructor: 
    public Encargado (String apellido, String nombre, String email, String clave){
        apellidos = apellido;
        nombres = nombre;
        correo = email;
        contraseña = clave;
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