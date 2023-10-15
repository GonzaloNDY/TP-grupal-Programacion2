 package pedidos.modelos;

import productos.modelos.Producto;


public class ProductoDelPedido {
    private int cantidad;
    private Producto producto;

    public ProductoDelPedido(Producto producto, int cantidad ) {
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return   producto.verDescripcion() + "\t" + cantidad ;
    }

   
    
    
}
