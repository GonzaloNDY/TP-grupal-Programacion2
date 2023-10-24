package usuarios.modelos;

import java.util.ArrayList;
import pedido.modelos.Pedido;

public class Cliente extends Usuario {
    // Atributos:
    private ArrayList<Pedido> pedidosCliente = new ArrayList<>();

    // Constructores: 
    public Cliente(String apellido, String nombre, String correo, String clave) {
        super(apellido, nombre, correo, clave);

    }

    public Cliente(String apellido, String nombre, String correo, String clave, ArrayList<Pedido> pedidosCliente) {
        super(apellido, nombre, correo, clave);
        this.pedidosCliente = pedidosCliente;
    }

    // Métodos:
    public void agregarPedido(Pedido unPedido){
        int index = pedidosCliente.indexOf(unPedido);

        if (index != -1) {
            pedidosCliente.set(index, unPedido);    // Reemplazo el pedido si ya estaba en el arraylist
        } else
            pedidosCliente.add(unPedido);
    }

    public void cancelarPedido(Pedido unPedido){
        pedidosCliente.remove(unPedido);
    }
    
    @Override
    public void mostrar() {
        System.out.println("Cliente: " + super.verApellido() + ", " + super.verNombre());
        System.out.println("Correo: " + super.verCorreo() + "\n");
    }

    @Override
    public ArrayList<Pedido> verPedidos(){
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
