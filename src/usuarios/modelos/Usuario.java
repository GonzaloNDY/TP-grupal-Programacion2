package usuarios.modelos;

import java.util.ArrayList;
import java.util.Objects;
import pedidos.modelos.Pedido;

public abstract class Usuario {

    private String apellido;
    private String nombre;
    private String clave;
    private String correo;
    
    // Constructores:
    public Usuario(String apellido, String nombre, String correo, String clave) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.correo = correo;
        this.clave = clave;
    }

    // Métodos:
    public abstract ArrayList<Pedido> verPedidos();

    @Override
    public int hashCode() {
        return Objects.hash(correo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        // Esta línea permite la comparación entre diferentes subclases de Usuario
        if (!(obj instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) obj;
        //comparo los correos de los usuarios
        return Objects.equals(this.correo, other.correo);
    }
    
    public void mostrar() {
        System.out.println("Usuario: " + apellido + ", " + nombre);
        System.out.println("Correo Electronico: " + correo);
    }

    // Métodos get/set:
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

}
