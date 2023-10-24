package pedido.modelos;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Objects;
import productos.modelos.Producto;
import usuarios.modelos.Usuario;

public class Pedido {

    // Atributos:
    private int numero;
    private LocalDateTime fechaYhora;
    private Usuario cliente;
    private Estado estado;
    private ArrayList<ProductoDelPedido> productoDelPedido;
    private Producto producto;

    // Constructores: 
    public Pedido(int numero, LocalDateTime fechaYhora, ArrayList<ProductoDelPedido> productoDelPedido, Usuario cliente) {
        this(numero, fechaYhora, productoDelPedido, cliente, Estado.CREADO);

    }

    public Pedido(int numero, LocalDateTime fechaYhora, ArrayList<ProductoDelPedido> productoDelPedido, Usuario cliente, Estado estado) {
        this.numero = numero;
        this.fechaYhora = fechaYhora;
        this.cliente = cliente;
        this.productoDelPedido = productoDelPedido;
        this.estado = estado;
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

    @Override
    public boolean equals(Object objeto) {
        if (objeto == null || getClass() != objeto.getClass()) {
            return false;
        }
        if (this == objeto) {
            return true;
        }
        Pedido otroPedido = (Pedido) objeto;
        // Comparo los números de los pedidos:
        return this.numero == otroPedido.numero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }

    // Get/set de los atributos
    // Numero:
    public int vertNumero() {
        return numero;
    }

    public void asginarNumero(int numero) {
        this.numero = numero;
    }

    // Fecha:
    public LocalDate verFecha() {
        return fechaYhora.toLocalDate();    // Obtiene solo la fecha
    }

    public void asignarFecha(LocalDate fecha) {
        fechaYhora = fechaYhora.toLocalTime().atDate(fecha);    // Asigna solo a la fecha
    }

    // Hora:
    public LocalTime verHora() {
        return fechaYhora.toLocalTime();    // Obtiene solo la hora
    }

    public void asignarHora(LocalTime hora) {
        fechaYhora = fechaYhora.toLocalDate().atTime(hora);    // Asigna solo a la hora
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
