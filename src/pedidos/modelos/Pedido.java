package pedidos.modelos;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import usuarios.modelos.Cliente;

public class Pedido {
    // Atributos:
    private int numero;
    private LocalDateTime fechaYhora;
    private Cliente cliente;
    private EstadoPedido estado;

    // Constructores: 
    public Pedido(int numero, LocalDateTime fechaYhora, Cliente cliente, EstadoPedido estado) {
        this.numero = numero;
        this.fechaYhora = fechaYhora;
        this.cliente = cliente;
        this.estado = estado;
    }

    // Métodos:
    public void mostrar() {
        System.out.println("\nNro:" + numero + "\nFecha: " + getFecha()
                + "\t\t\t Hora: " + getHora().getHour() + ":" + getHora().getMinute() + "\nCliente: " + cliente.verApellido()
                + ", " + cliente.verNombre() + "\nEstado: " + estado);

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
}
