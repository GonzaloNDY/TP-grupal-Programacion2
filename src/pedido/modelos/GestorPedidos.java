package pedido.modelos;

import interfaces.IGestorPedidos;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;
import java.time.LocalDateTime;

public class GestorPedidos implements IGestorPedidos {

    // Atributos de GestorPedidos:
    private ArrayList<Pedido> pedidos;

    // Implementación del patrón de diseño singleton:
    private static GestorPedidos gestor;

    private GestorPedidos() {
    }

    public static GestorPedidos instanciar() {
        if (gestor == null) {
            gestor = new GestorPedidos();
        }
        return gestor;
    }

    @Override
    public String crearPedido(LocalDate fecha, LocalTime hora, ArrayList<ProductoDelPedido> productosDelPedido, Cliente cliente) {
        String validacion = validarDatos(fecha, hora, productosDelPedido, cliente);
        if (!validacion.equals(VALIDACION_EXITO)) {
            return validacion;
        } else {
            LocalDateTime fechaYhora;
            fechaYhora = fecha.atTime(hora);
            Pedido nuevoPedido = new Pedido(pedidos.size() + 1, fechaYhora, productosDelPedido, cliente);
            if (existeEstePedido(nuevoPedido)) {
                return PEDIDOS_DUPLICADOS;
            } else {
                pedidos.add(nuevoPedido);
                return EXITO;
            }
        }
    }

    @Override
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

    @Override
    public ArrayList<Pedido> verPedidos() {
        return pedidos;
    }

    @Override
    public boolean hayPedidosConEsteProducto(Producto producto) {
        for (Pedido pedido : pedidos) {
            for (ProductoDelPedido pdp : pedido.verProductoDelPedido()) {
                if (pdp.verProducto().equals(producto)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean hayPedidosConEsteCliente(Cliente cliente) {
        for (Pedido pedido : pedidos) {
            if (pedido.verCliente().equals(cliente)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean existeEstePedido(Pedido pedido) {
        return pedidos.contains(pedido);
    }

    @Override
    public Pedido obtenerPedido(Integer numero) {
        for (Pedido pedido : pedidos) {
            if (pedido.verNumero() == numero) {
                return pedido;
            }
        }
        return null;
    }

    @Override
    public String cancelarPedido(Pedido pedido) {
        if(pedidos.contains(pedido)){
        pedidos.remove(pedido);
            //tiene que llamar a al metodo dentro de cliente
            // cancelarPedido(pedido);
        return EXITO;
        }else{
        return "Error";
        }
    }

    // Métodos auxiliares:
    private String validarDatos(LocalDate fecha, LocalTime hora, ArrayList<ProductoDelPedido> productosDelPedido, Cliente cliente) {
        if (fecha == null) {
            return ERROR_FECHA;
        }
        if (hora == null) {
            return ERROR_HORA;
        }
        if (productosDelPedido == null || productosDelPedido.isEmpty()) {
            return ERROR_PRODUCTOS_DEL_PEDIDO;
        }
        if (cliente == null) {
            return ERROR_CLIENTE;
        }
        return VALIDACION_EXITO;
    }

}
