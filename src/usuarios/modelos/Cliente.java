
package usuarios.modelos;

import java.util.ArrayList;
import pedidos.modelos.Pedido;

public class Cliente {

    // Atributos:
    private String apellido;
    private String nombre;
    private String correo;
    private String clave;
    private ArrayList<Pedido> pedidosCliente;

    // Constructores: 

    public Cliente(String apellido, String nombre, String correo, String clave) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.correo = correo;
        this.clave = clave;
    }
    
    
    public Cliente(String apellido, String nombre, String correo, String clave, ArrayList<Pedido> pedidosCliente) {
       this(apellido,nombre,correo,clave);
        this.pedidosCliente = pedidosCliente;
    }
 

    // Métodos:
    public void mostrarInformacion() {
        System.out.println("Nombre Completo: " + apellido + ", " + nombre);
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

    public ArrayList<Pedido> getPedidosCliente() {
        return pedidosCliente;
    }

    public void setPedidosCliente(ArrayList<Pedido> pedidosCliente) {
        this.pedidosCliente = pedidosCliente;
    }
    
}