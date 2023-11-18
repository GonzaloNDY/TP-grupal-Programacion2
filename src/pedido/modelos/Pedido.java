package pedido.modelos;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Objects;
import productos.modelos.Producto;
import usuarios.modelos.Usuario;

public class Pedido {
    // Atributos de Pedido:
    private int numero;
    private LocalDateTime fechaYhora;
    private Usuario cliente;
    private Estado estado;
    private ArrayList<ProductoDelPedido> productoDelPedido;
    private Producto producto;

    // Constructores:
    public Pedido(int numero, LocalDateTime fechaYhora, ArrayList<ProductoDelPedido> productoDelPedido, Usuario cliente, Estado estado) {
        this.numero = numero;
        this.fechaYhora = fechaYhora;
        this.cliente = cliente;
        this.productoDelPedido = productoDelPedido;
        this.estado = estado;
    }

    public Pedido(int numero, LocalDateTime fechaYhora, ArrayList<ProductoDelPedido> productoDelPedido, Usuario cliente) {
        this(numero, fechaYhora, productoDelPedido, cliente, Estado.CREADO);
    }

    // Métodos:
    public void mostrar() {
        System.out.println("\nNro:" + numero
                + "\nFecha: " + verFecha() + "\t\tHora: " + verHora().getHour() + ":" + verHora().getMinute()
                + "\nCliente: " + cliente.verApellido() + ", " + cliente.verNombre()
                + "\nEstado: " + estado
                + "\n\tProducto \t\t Cantidad "
                + "\n\t=================================");
        for (ProductoDelPedido pdp : productoDelPedido) {
            System.out.printf("\t%-24s %d\n", pdp.verProducto().verDescripcion(), pdp.verCantidad());
        }
    }

    // Métodos redefinidos:
    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }

    @Override
    public boolean equals(Object objeto) {
        if (objeto == null || getClass() != objeto.getClass())
            return false;
        if (this == objeto)
            return true;
        Pedido otroPedido = (Pedido) objeto;
        return this.numero == otroPedido.numero;
    }

    // Métodos get/set:
    // Numero:
    public int verNumero() {
        return numero;
    }
    public void asignarNumero(int numero) {
        this.numero = numero;
    }
    // Fecha y hora:
    public LocalDate verFecha() {
        return fechaYhora.toLocalDate();    // Obtiene solo la fecha
    }
    public LocalTime verHora() {
        return fechaYhora.toLocalTime();    // Obtiene solo la hora
    }
    public void asignarFechaYHora(LocalDateTime fechaYhora) {
        this.fechaYhora = fechaYhora;
    }
    // Cliente:
    public Usuario verCliente() {
        return cliente;
    }
    public void asignarCliente(Usuario cliente) {
        this.cliente = cliente;
    }
    // Estado:
    public Estado verEstado() {
        return estado;
    }
    public void asignarEstado(Estado estado) {
        this.estado = estado;
    }
    // ProductoDelPedido:
    public ArrayList<ProductoDelPedido> verProductoDelPedido() {
        return productoDelPedido;
    }
    public void asignarProductoDelPedido(ArrayList<ProductoDelPedido> productoDelPedido) {
        this.productoDelPedido = productoDelPedido;
    }
    // Producto:
    public Producto verProducto() {
        return producto;
    }
    public void asignarProducto(Producto producto) {
        this.producto = producto;
    }
}
