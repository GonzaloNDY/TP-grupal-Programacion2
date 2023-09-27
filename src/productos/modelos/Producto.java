
package productos.modelos;

public class Producto {

    // Atributos:
    private int codigo;
    private String descripcion;
    private float precio;
    private String categoria;
    private String estado;


    // Constructor:
    public Producto (int codigo, String descripcion, float precio, String categoria, String estado){
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
        this.estado = estado;
    }

    // Métodos:
    public void mostrarInformacion() {
        System.out.println("Código del producto: " + verCodigo());
        System.out.println("Descripción: " + verDescripcion());
        System.out.println("Precio: $" + verPrecio());
        System.out.println("Categoria: " + verCategoria());
        System.out.println("Estado: " + verEstado());
    }

    public int verCodigo() {
        return codigo;
    }

    public void asignarCodigo(int codigo) {
        this.codigo = codigo;
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
    
    public String verEstado() {
        return estado;
    }

    public void asignarEstado(String estado) {
        this.estado = estado;
    }
}