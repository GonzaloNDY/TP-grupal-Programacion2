package pedido.modelos;

import java.util.Objects;
import productos.modelos.Producto;

public class ProductoDelPedido {
    // Atributos:
    private int cantidad;
    private Producto producto;

    // Constructores:
    public ProductoDelPedido(Producto producto, int cantidad ) {
        this.cantidad = cantidad;
        this.producto = producto;
    }
    
    // Métodos:
    @Override
    public boolean equals(Object objeto) {
        if (objeto == null || getClass() != objeto.getClass())
            return false;
        if (this == objeto)
            return true;
        ProductoDelPedido otropdp = (ProductoDelPedido) objeto;
        // Comparo usando el método equals de Producto:
        return this.producto.equals(otropdp.verProducto());
    }

    @Override
    public int hashCode() {
        return Objects.hash(producto);
    }

    // Get/set de los atributos:
    // Cantidad:
    public int verCantidad() {
        return cantidad;
    }
    public void asignarCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    // Producto:
    public Producto verProducto() {
        return producto;
    }
    public void asignarProducto(Producto producto) {
        this.producto = producto;
    }
}
