package pedidos.modelos;

import java.time.LocalDateTime;
import usuarios.modelos.Cliente;

public class Pedido {

    private int numero;
    private LocalDateTime fechaYhora;
    private Cliente cliente;
    private EstadoPedido estado;

    public Pedido(int numero, LocalDateTime fechaYhora, Cliente cliente, EstadoPedido estado) {
        this.numero = numero;
        this.fechaYhora = fechaYhora;
        this.cliente = cliente;
        this.estado = estado;
    }

   

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public LocalDateTime getFechaYhora() {
        return fechaYhora;
    }

    public void setFechaYhora(LocalDateTime fechaYhora) {
        this.fechaYhora = fechaYhora;
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
    

    public void mostrar() {
        System.out.println("\nNro:" + numero + "\n Fecha: " + fechaYhora
                + "\t\t\t Hora: " + fechaYhora + "\nCliente: " + cliente.verApellido()
                + ", " + cliente.verNombre() + "\nEstado: " + estado);

    }

}
