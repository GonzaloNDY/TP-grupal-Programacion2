package pedidos.modelos;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;

public class Pedido {
    // Atributos:
    private int numero;
    private LocalDateTime fechaYhora;
    private Cliente cliente;
    private EstadoPedido estado;
    private ArrayList<ProductoDelPedido> productoDelPedido;  
    private Producto producto;

    // Constructores: 

    public Pedido(int numero, LocalDateTime fechaYhora, ArrayList<ProductoDelPedido> productoDelPedido, Cliente cliente ,EstadoPedido estado) {
        this.numero = numero;
        this.fechaYhora = fechaYhora;
        this.cliente = cliente;
        this.productoDelPedido = productoDelPedido;
        this.estado=estado;
    }


    // Métodos:
    public void mostrar() {
        System.out.println("\nNro:" + numero + "\nFecha: " + getFecha()
                + "\t\t\t Hora: " + getHora().getHour() + ":" + getHora().getMinute() + "\nCliente: " + cliente.verApellido()
                + ", " + cliente.verNombre() + "\nEstado: " + estado + "\n\tProducto \t\t Cantidad \n\t=============================");
        System.out.println(productoDelPedido);

    }

    // Get/set de los atributos:
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public LocalDate getFecha() {
        return fechaYhora.toLocalDate();    // Obtiene solo la fecha
    }

    public void setFecha(LocalDate fecha) {
        fechaYhora = fechaYhora.toLocalTime().atDate(fecha);    // Asigna solo a la fecha
    }

    public LocalTime getHora() {
        return fechaYhora.toLocalTime();    // Obtiene solo la hora
    }

    public void setHora(LocalTime hora) {
        fechaYhora = fechaYhora.toLocalDate().atTime(hora);    // Asigna solo a la hora
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }
      public ArrayList<ProductoDelPedido> getProductoDelPedido() {
        return productoDelPedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
      

    public void setProductoDelPedido(ArrayList<ProductoDelPedido> productoDelPedido) {
        this.productoDelPedido = productoDelPedido;
    }
}
