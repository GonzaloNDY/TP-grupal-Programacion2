package interfaces;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import pedido.modelos.Pedido;
import pedido.modelos.ProductoDelPedido;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;

public interface IGestorPedidos {

    // Constantes:
    public static final String EXITO = "Pedido creado/modificado/cancelado con éxito";
    public static final String ERROR_FECHA = "La fecha del pedido es incorrecta";
    public static final String ERROR_HORA = "La hora del pedido es incorrecta";
    public static final String ERROR_PRODUCTOS_DEL_PEDIDO = "El pedido no tiene productos";
    public static final String ERROR_CLIENTE = "El pedido no tiene un cliente";
    public static final String ERROR_ESTADO = "El pedido no tiene un estado";
    public static final String ERROR_CANCELAR = "No se puede cancelar el pedido en este estado";
    public static final String PEDIDOS_DUPLICADOS = "Ya existe un pedido con ese número";
    public static final String PEDIDO_INEXISTENTE = "No existe el pedido especificado";
    public static final String VALIDACION_EXITO = "El pedido tiene los datos correctos";

    // Métodos:
    public String crearPedido(LocalDate fecha, LocalTime hora, List<ProductoDelPedido>productosDelPedido, Cliente cliente);

    public List<Pedido> verPedidos();

    public String cambiarEstado(Pedido pedidoAModificar);

    public boolean hayPedidosConEsteCliente(Cliente cliente);

    public boolean hayPedidosConEsteProducto(Producto producto);

    public String cancelarPedido(Pedido pedido);

    public boolean existeEstePedido(Pedido pedido);

    public Pedido obtenerPedido(Integer numero);
}
