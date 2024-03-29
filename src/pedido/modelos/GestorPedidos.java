package pedido.modelos;

import interfaces.IGestorPedidos;
import java.time.LocalDate;
import java.time.LocalTime;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GestorPedidos implements IGestorPedidos {

    // Atributos de GestorPedidos:
    private List<Pedido> pedidos;

    // Implementación del patrón de diseño singleton:
    private static GestorPedidos gestor;

    private GestorPedidos() {
        this.pedidos = new ArrayList<>();
    }

    public static GestorPedidos instanciar() {
        if (gestor == null) {
            gestor = new GestorPedidos();
        }
        return gestor;
    }

    // Implementación de métodos:
    @Override
    public String crearPedido(LocalDate fecha, LocalTime hora, List<ProductoDelPedido> productosDelPedido, Cliente cliente) {
        String validacion = validarDatos(fecha, hora, productosDelPedido, cliente);
        if (!validacion.equals(VALIDACION_EXITO)) {
            return validacion;
        } else {
            LocalDateTime fechaYhora = LocalDateTime.of(fecha, hora);
            Pedido nuevoPedido = new Pedido((pedidos.size() + 1), fechaYhora, productosDelPedido, cliente);
            if (existeEstePedido(nuevoPedido)) {
                return PEDIDOS_DUPLICADOS;
            } else {
                pedidos.add(nuevoPedido);
                cliente.agregarPedido(nuevoPedido);
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
    public List<Pedido> verPedidos() {
        Comparator<Pedido> pComp = (p1, p2) -> p1.verNumero() - p2.verNumero();
        pedidos.sort(pComp);
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
        if (existeEstePedido(pedido)) {
            Cliente clienteDelPedido = (Cliente) pedido.verCliente();
            clienteDelPedido.cancelarPedido(pedido);
            pedidos.remove(pedido);
            return EXITO;
        } else {
            return ERROR_CANCELAR;
        }
    }

    // Métodos auxiliares:
    private String validarDatos(LocalDate fecha, LocalTime hora, List<ProductoDelPedido> productosDelPedido, Cliente cliente) {
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
