package usuarios.modelos;

import java.util.ArrayList;
import java.util.Objects;
import pedido.modelos.Pedido;

public abstract class Usuario {

    private String apellido;
    private String nombre;
    private String clave;
    private String correo;
    
    // Constructores:
    public Usuario(String correo, String clave,String apellido, String nombre ) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.correo = correo;
        this.clave = clave;
    }

    // Métodos:
    public abstract ArrayList<Pedido> verPedidos();

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.correo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
          if (!(obj instanceof Usuario))
          {
               return false;
          }
           
         Usuario other = (Usuario) obj;
        return Objects.equals(this.correo, other.correo);
    }

  
    public void mostrar() {
        System.out.println("Usuario: " + apellido + ", " + nombre);
        System.out.println("Correo Electronico: " + correo);
    }

    // Métodos get/set:
    public String verApellido() {
        return apellido;
    }

    public void asignarApellido(String apellido) {
        this.apellido = apellido;
    }

    public String verNombre() {
        return nombre;
    }

    public void asignaNombre(String nombre) {
        this.nombre = nombre;
    }

    public String verClave() {
        return clave;
    }

    public void asignaClave(String clave) {
        this.clave = clave;
    }

    public String verCorreo() {
        return correo;
    }

    public void asignaCorreo(String correo) {
        this.correo = correo;
    }

}
