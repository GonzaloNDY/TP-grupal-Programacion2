package pedidos.modelos;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import productos.modelos.Producto;
import usuarios.modelos.Usuario;

public class Pedido {
    // Atributos:
    private int numero;
    private LocalDateTime fechaYhora;
    private Usuario cliente;
    private EstadoPedido estado;
    private ArrayList<ProductoDelPedido> productoDelPedido;  
    private Producto producto;

    // Constructores: 
    public Pedido(int numero, LocalDateTime fechaYhora, ArrayList<ProductoDelPedido> productoDelPedido, Usuario cliente ,EstadoPedido estado) {
        this.numero = numero;
        this.fechaYhora = fechaYhora;
        this.cliente = cliente;
        this.productoDelPedido = productoDelPedido;
        this.estado=estado;
    }

    // Métodos:
    public void mostrar() {
        System.out.println("\n\nNro:" + numero + "\nFecha: " + getFecha() + "\t\tHora: " + getHora().getHour() + ":" + getHora().getMinute()
                + "\nCliente: " + cliente.getApellido() + ", " + cliente.getNombre()
                + "\nEstado: " + estado
                + "\n\tProducto \t\t Cantidad "
                + "\n\t=================================");
        for (ProductoDelPedido pdp: productoDelPedido){
            System.out.printf("\t%-24s %d\n", pdp.getProducto().verDescripcion(), pdp.getCantidad());
        }
    }

    @Override
    public boolean equals(Object objeto) {
        if (objeto == null || getClass() != objeto.getClass())
            return false;
        if (this == objeto)
            return true;
        Pedido otroPedido = (Pedido) objeto;
        // Comparo los números de los pedidos:
        return this.numero == otroPedido.numero;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.numero;
        return hash;
    }

    // Get/set de los atributos
    // Numero:
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    // Fecha:
    public LocalDate getFecha() {
        return fechaYhora.toLocalDate();    // Obtiene solo la fecha
    }
    public void setFecha(LocalDate fecha) {
        fechaYhora = fechaYhora.toLocalTime().atDate(fecha);    // Asigna solo a la fecha
    }
    // Hora:
    public LocalTime getHora() {
        return fechaYhora.toLocalTime();    // Obtiene solo la hora
    }
    public void setHora(LocalTime hora) {
        fechaYhora = fechaYhora.toLocalDate().atTime(hora);    // Asigna solo a la hora
    }
    // Cliente:
    public Usuario getCliente() {
        return cliente;
    }
    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }
    // Estado:
    public EstadoPedido getEstado() {
        return estado;
    }
    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }
    // ProductoDelPedido:
    public ArrayList<ProductoDelPedido> getProductoDelPedido() {
        return productoDelPedido;
    }
    public void setProductoDelPedido(ArrayList<ProductoDelPedido> productoDelPedido) {
        this.productoDelPedido = productoDelPedido;
    }
    // Producto:
    public Producto getProducto() {
        return producto;
    }
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
