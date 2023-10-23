package usuarios.modelos;

import java.util.ArrayList;
import pedidos.modelos.Pedido;

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
    @Override
    public void mostrar() {
        System.out.println("Cliente: " + super.getApellido() + ", " + super.getNombre());
        System.out.println("Correo: " + super.getCorreo() + "\n");
    }

    @Override
    public ArrayList<Pedido> verPedidos(){
        return pedidosCliente;
    }

    public void agregarPedido(Pedido unPedido){
        for (int i = 0; i < pedidosCliente.size(); i++) {
            Pedido pedidoActual = pedidosCliente.get(i);
            if (pedidoActual.equals(unPedido)) {
                pedidosCliente.set(i, unPedido);    // Reemplazo el pedido si ya estaba en el arraylist
                return;
            }
        }
        // Si llegamos aqui significa que no habia pedidos repetidos
        pedidosCliente.add(unPedido);
    }

    public void cancelarPedido(Pedido unPedido){
        pedidosCliente.remove(unPedido);
    }

    // PedidosCliente:
    public ArrayList<Pedido> getPedidosCliente() {
        return pedidosCliente;
    }

    public void setPedidosCliente(ArrayList<Pedido> pedidosCliente) {
        this.pedidosCliente = pedidosCliente;
    }
}
