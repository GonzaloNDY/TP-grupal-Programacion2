
package usuarios.modelos;

public class Empleado {
    // Atributos:
    private String apellido;
    private String nombre;
    private String correo;
    private String clave;

    // Constructores: 
   public Empleado(String correo, String clave , String apellido, String nombre) {
        this.correo = correo;
        this.clave = clave;
        this.apellido = apellido;
        this.nombre = nombre;
    }

    // Métodos:
    public void mostrar() {
        System.out.println("Empleado: " + apellido + ", " + nombre);
        System.out.println("Correo: " + correo + "\n");
    }
    
    // Get/set de los atributos:
    // Apellido:
    public String verApellido() {
        return apellido;
    }
    public void asignarApellido(String apellido) {
        this.apellido = apellido;
    }
    // Nombre:
    public String verNombre() {
        return nombre;
    }
    public void asignarNombre(String nombre) {
        this.nombre = nombre;
    }
    // Correo:
    public String verCorreo() {
        return correo;
    }
    public void asignarCorreo(String correo) {
        this.correo = correo;
    }
    // Clave:
    public String verclave() {
        return clave;
    }
    public void asignarclave(String clave) {
        this.clave = clave;
    }
}