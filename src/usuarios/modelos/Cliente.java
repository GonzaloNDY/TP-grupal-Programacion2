package usuarios.modelos;

import java.util.ArrayList;
import pedidos.modelos.Pedido;

public class Cliente extends Usuario {

    // Atributos:
    private ArrayList<Pedido> pedidosCliente;

    // Constructores: 
    public Cliente(String apellido, String nombre, String correo, String clave) {
        super(apellido, nombre, correo, clave);

    }

    public Cliente(String apellido, String nombre, String correo, String clave, ArrayList<Pedido> pedidosCliente) {
        super(apellido, nombre, correo, clave);
        this.pedidosCliente = pedidosCliente;
    }

    // Métodos:
    @Override
    public void mostrar() {
        System.out.println("Cliente: " + super.getApellido() + ", " + super.getNombre());
        System.out.println("Correo: " + super.getCorreo() + "\n");
    }

    // Get/set de los atributos:
//   
// Get/set de los atributos:
// 
//   SI USO LOS METODOS DE LA SUPERCLASE, YA NO SE UTILIZAN ESTOS METODOS DE LA SUBCLASE, SE DEBERIAN BORRAR??? 
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
    // PedidosCliente:
    public ArrayList<Pedido> getPedidosCliente() {
        return pedidosCliente;
    }

    public void setPedidosCliente(ArrayList<Pedido> pedidosCliente) {
        this.pedidosCliente = pedidosCliente;
    }
}
