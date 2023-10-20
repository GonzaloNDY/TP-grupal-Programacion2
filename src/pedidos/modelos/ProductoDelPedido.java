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
    
    // Métodos:
    @Override
    public boolean equals(Object objeto) {
        if (objeto == null || getClass() != objeto.getClass())
            return false;
        if (this == objeto)
            return true;
        ProductoDelPedido otropdp = (ProductoDelPedido) objeto;
        // Comparo usando el método equals de Producto:
        return this.producto.equals(otropdp.getProducto());
    }

    @Override
    public int hashCode() {
        int hash = 13;
        hash = 17 * hash + producto.hashCode();
        return hash;
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
