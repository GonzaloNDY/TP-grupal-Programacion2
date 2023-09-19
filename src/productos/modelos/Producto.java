
package productos.modelos;

public class Producto {

    // Atributos:
    private String nombre;
    private String descripcion;
    private float precio;
    private String categoria;
    private int cantidad;

    // Constructor:
    public Producto (String nombre, String descripcion, float precio, String categoria, int cantidad){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        
        this.categoria = categoria;
        this.cantidad = cantidad;
    }
    
    // Métodos:
    public void mostrarInformacion() {
        System.out.println("Nombre del producto: " + verNombre());
        System.out.println("Descripción: " + verDescripcion());
        System.out.println("Precio: $" + verPrecio());
        System.out.println("Categoria: " + verCategoria());
        if(verCantidad() > 0)
            System.out.println("Disponible\n");
        else
            System.out.println("No disponible\n");
    }
    
    public String verNombre() {
        return nombre;
    }

    public void asignarNombre(String nombre) {
        this.nombre = nombre;
    }

    public String verDescripcion() {
        return descripcion;
    }

    public void asignarDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float verPrecio() {
        return precio;
    }

    public void asignarPrecio(float precio) {
        this.precio = precio;
    }

    public String verCategoria() {
        return categoria;
    }

    public void asignarCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int verCantidad() {
        return cantidad;
    }

    public void asignarCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    
}
