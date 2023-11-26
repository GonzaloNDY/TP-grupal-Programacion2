package usuarios.modelos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import pedido.modelos.Pedido;

public abstract class Usuario {
    // Atributos de Usuario:
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
    public abstract List<Pedido> verPedidos();

    public void mostrar() {
        System.out.println("Usuario: " + apellido + ", " + nombre);
        System.out.println("Correo: " + correo + "\n");
    }

    //  Métodos redefinidos:
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.correo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Usuario))
            return false;
        if (this == obj)
            return true;
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.correo, other.correo);
    }

    // Métodos get/set:
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
    public void asignaNombre(String nombre) {
        this.nombre = nombre;
    }
    // Clave:
    public String verClave() {
        return clave;
    }
    public void asignaClave(String clave) {
        this.clave = clave;
    }
    // Correo:
    public String verCorreo() {
        return correo;
    }
    public void asignaCorreo(String correo) {
        this.correo = correo;
    }
}
