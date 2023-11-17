package usuarios.modelos;

import java.util.ArrayList;
import pedido.modelos.Pedido;

public class Cliente extends Usuario {
    // Atributos de Cliente:
    private ArrayList<Pedido> pedidosCliente = new ArrayList<>();

    // Constructores:
    public Cliente(String correo, String clave, String apellido, String nombre) {
        super(correo, clave, apellido, nombre);

    }

    public Cliente(String correo, String clave, String apellido, String nombre, ArrayList<Pedido> pedidosCliente) {
        super(correo, clave, apellido, nombre);
        this.pedidosCliente = pedidosCliente;
    }

    // Métodos:
    public void agregarPedido(Pedido nuevoPedido) {
        int indiceExistente = pedidosCliente.indexOf(nuevoPedido);
        if (indiceExistente != -1)
            pedidosCliente.set(indiceExistente, nuevoPedido);
        else
            pedidosCliente.add(nuevoPedido);
    }

    public void cancelarPedido(Pedido unPedido) {
        if (pedidosCliente.indexOf(unPedido) != -1) {
            pedidosCliente.remove(unPedido);
        }
    }

    // Métodos redefinidos:
    @Override
    public void mostrar() {
        System.out.println("Cliente: " + super.verApellido() + ", " + super.verNombre());
        System.out.println("Correo: " + super.verCorreo() + "\n");
    }

    @Override
    public ArrayList<Pedido> verPedidos() {
        return pedidosCliente;
    }

    // get/set de PedidosCliente:
    public ArrayList<Pedido> getPedidosCliente() {
        return pedidosCliente;
    }
    public void setPedidosCliente(ArrayList<Pedido> pedidosCliente) {
        this.pedidosCliente = pedidosCliente;
    }
}
