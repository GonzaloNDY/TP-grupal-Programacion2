
package usuarios.modelos;

public class Cliente {

    // Atributos:
    private String apellido;
    private String nombre;
    private String correo;
    private String clave;

    // Constructores: 
    public Cliente (String apellido, String nombre, String correo, String clave){
        this.apellido = apellido;
        this.nombre = nombre;
        this.correo = correo;
        this.clave = clave;
    }

    // Métodos:
    public void mostrarInformacion() {
        System.out.println("Nombre Completo: " + apellido + ", " + nombre);
        System.out.println("Correo: " + correo + "\n");
    }
    
    // Get/set de apellido:
    public String verApellido() {
        return apellido;
    }
    public void asignarApellido(String apellido) {
        this.apellido = apellido;
    }
    // Get/set de nombre:
    public String verNombre() {
        return nombre;
    }
    public void asignarNombre(String nombre) {
        this.nombre = nombre;
    }
    // Get/set de correo:
    public String verCorreo() {
        return correo;
    }
    public void asignarCorreo(String correo) {
        this.correo = correo;
    }
    // Get/set de clave:
    public String verclave() {
        return clave;
    }
    public void asignarclave(String clave) {
        this.clave = clave;
    }
}