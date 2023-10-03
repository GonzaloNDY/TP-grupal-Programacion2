
package productos.modelos;

public class Producto {

    // Atributos:
    private int codigo;
    private String descripcion;
    private float precio;
    private String categoria;
    private String estado;


    // Constructores:
    public Producto (int codigo, String descripcion, float precio, String categoria, String estado){
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
        this.estado = estado;
    }

    // Métodos:
    public void mostrarInformacion() {
        System.out.println("Código del producto: " + codigo);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Precio: $" + precio);
        System.out.println("Categoria: " + categoria);
        System.out.println("Estado: " + estado);
    }

    // Get/set de codigo:
    public int verCodigo() {
        return codigo;
    }
    public void asignarCodigo(int codigo) {
        this.codigo = codigo;
    }
    // Get/set de descripcion:
    public String verDescripcion() {
        return descripcion;
    }
    public void asignarDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    // Get/set de precio:
    public float verPrecio() {
        return precio;
    }
    public void asignarPrecio(float precio) {
        this.precio = precio;
    }
    // Get/set de categoria:
    public String verCategoria() {
        return categoria;
    }
    public void asignarCategoria(String categoria) {
        this.categoria = categoria;
    }
    // Get/set de estado:
    public String verEstado() {
        return estado;
    }
    public void asignarEstado(String estado) {
        this.estado = estado;
    }
}