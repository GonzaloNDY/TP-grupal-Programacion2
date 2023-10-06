
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
        System.out.println("Estado: " + estado + "\n");
    }

    @Override
    public String toString() {
        return "Codigo del producto: " + codigo + "\n" +
                "Descripcion: " + descripcion + "\n" +
                "Precio: $" + precio + "\n" +
                "Categoria: " + categoria + "\n" +
                "Estado: " + estado + "\n";
    }   // Por el momento esta función toString no muestra caracteres acentuados

    // Get/set de los atributos:
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

    public Categoria verCategoria() {
        return categoria;
    }
    public void asignarCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Estado verEstado() {
        return estado;
    }
    public void asignarEstado(String estado) {
        this.estado = estado;
    }
}
