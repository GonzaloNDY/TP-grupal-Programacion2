
package usuarios.modelos;

public class Encargado {
    // Atributos:
    private String apellido;
    private String nombre;
    private String correo;
    private String clave;

    // Constructores: 
    public Encargado (String apellido, String nombre, String correo, String clave){
        this.apellido = apellido;
        this.nombre = nombre;
        this.correo = correo;
        this.clave = clave;
    }

    // Métodos:
    public void mostrar() {
        System.out.println("Encargado: " + apellido + ", " + nombre);
        System.out.println("Correo: " + correo + "\n");
    }
        
    // Get/set de los atributos:
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

    public String verclave() {
        return clave;
    }
    public void asignarclave(String clave) {
        this.clave = clave;
    }
}