package pedidos.modelos;

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

    // Get/set de los atributos:
    // Cantidad:
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    // Producto:
    public Producto getProducto() {
        return producto;
    }
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
