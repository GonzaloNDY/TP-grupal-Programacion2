
package usuarios.modelos;

public class Encargado extends Usuario {

    // Constructores: 
     public Encargado( String apellido, String nombre, String correo, String clave ) {
      super(apellido, nombre, correo, clave);
    
    }

    // Métodos:
     @Override
    public void mostrar() {
        System.out.println("Encargado: " + super.getApellido() + ", " + super.getNombre());
        System.out.println("Correo: " + super.getCorreo() + "\n");
    }
        
    
    // Get/set de los atributos:
// 
//   SI USO LOS METODOS DE LA SUPERCLASE, YA NO SE UTILIZAN ESTOS METODOS DE LA SUBCLASE, SE DEBERIAN BORRAR? 
//    
//    public String verApellido() {
//        return apellido;
//    }
//    public void asignarApellido(String apellido) {
//        this.apellido = apellido;
//    }
//    // Nombre:
//    public String verNombre() {
//        return nombre;
//    }
//    public void asignarNombre(String nombre) {
//        this.nombre = nombre;
//    }
//    // Correo:
//    public String verCorreo() {
//        return correo;
//    }
//    public void asignarCorreo(String correo) {
//        this.correo = correo;
//    }
//    // Clave:
//    public String verclave() {
//        return clave;
//    }
//    public void asignarclave(String clave) {
//        this.clave = clave;
//    }

}