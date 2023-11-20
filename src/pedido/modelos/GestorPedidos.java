package pedido.modelos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;
import java.time.LocalDateTime;

public class GestorPedidos {
    // Constantes de GestorPedidos:
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

    // Atributos de GestorPedidos:
    private ArrayList<Pedido> pedidos;

    // Implementación del patrón de diseño singleton:
    private static GestorPedidos gestor;
    private GestorPedidos(){}
    public static GestorPedidos instanciar(){
        if (gestor == null)
            gestor = new GestorPedidos();
        return gestor;
    }

    public String crearPedido(LocalDate fecha, LocalTime hora, ArrayList<ProductoDelPedido> productosDelPedido, Cliente cliente){
        String validacion = validarDatos(fecha, hora, productosDelPedido, cliente);
        if (!validacion.equals(VALIDACION_EXITO))
            return validacion;
        else {
            LocalDateTime fechaYhora;
            fechaYhora = fecha.atTime(hora);
            Pedido nuevoPedido = new Pedido(pedidos.size() + 1, fechaYhora, productosDelPedido, cliente);
            if (existeEstePedido(nuevoPedido))
                return PEDIDOS_DUPLICADOS;
            else {
                pedidos.add(nuevoPedido);
                return EXITO;
            }
        }
    }

    public String cambiarEstado(Pedido pedidoAModificar) {
        switch (pedidoAModificar.verEstado()) {
            case CREADO:
                pedidoAModificar.asignarEstado(Estado.PROCESANDO);
                break;
            case PROCESANDO:
                pedidoAModificar.asignarEstado(Estado.ENTREGADO);
                break;
            default:
                return ERROR_ESTADO;
        }
        return null;
    }

    public ArrayList<Pedido> verPedidos(){
        return pedidos;
    }

    public boolean hayPedidosConEsteProducto(Producto producto) {
        for (Pedido pedido : pedidos) {
            for (ProductoDelPedido pdp : pedido.verProductoDelPedido()) {
                if (pdp.verProducto().equals(producto))
                    return true;
            }
        }
        return false;
    }

    public boolean existeEstePedido(Pedido pedido) {
        return pedidos.contains(pedido);
    }

    public Pedido obtenerPedido(Integer numero) {
        for (Pedido pedido : pedidos) {
            if (pedido.verNumero() == numero)
                return pedido;
        }
        return null;
    }

    // Métodos auxiliares:
    private String validarDatos(LocalDate fecha, LocalTime hora, ArrayList<ProductoDelPedido> productosDelPedido, Cliente cliente){
        if (fecha == null)
            return ERROR_FECHA;
        if (hora == null)
            return ERROR_HORA;
        if (productosDelPedido == null || productosDelPedido.isEmpty())
            return ERROR_PRODUCTOS_DEL_PEDIDO;
        if (cliente == null)
            return ERROR_CLIENTE;
        return VALIDACION_EXITO;
    }
}
