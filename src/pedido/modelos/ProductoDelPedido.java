package pedido.modelos;

import java.util.Objects;
import productos.modelos.Producto;

public class ProductoDelPedido {
    // Atributos de ProductoDelPedido:
    private int cantidad;
    private Producto producto;

    // Constructores:
    public ProductoDelPedido(Producto producto, int cantidad ) {
        this.cantidad = cantidad;
        this.producto = producto;
    }

    // Métodos:

    // Métodos redefinidos:
    @Override
    public int hashCode() {
        return Objects.hash(producto);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass())
            return false;
        if (this == obj)
            return true;
        ProductoDelPedido otropdp = (ProductoDelPedido) obj;
        return this.producto.equals(otropdp.verProducto());
    }

    // Métodos get/set:
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
