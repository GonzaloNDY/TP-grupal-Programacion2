
package productos.modelos;

public class Producto {
    // Atributos:
    private int codigo;
    private String descripcion;
    private float precio;
    private Categoria categoria;
    private Estado estado;

    // Constructores:
    public Producto (int codigo, String descripcion, float precio, Categoria categoria, Estado estado){
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
        this.estado = estado;
    }

    // Métodos:
    public void mostrar() {
        System.out.println("Producto: " + descripcion);
        System.out.println("Precio: $" + precio);
        System.out.println("Categoria: " + categoria);
        System.out.println("Estado: " + estado + "\n");
    }

    @Override
    public String toString() {
        return "Producto: " + descripcion + "\n" +
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
    public void asignarCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Estado verEstado() {
        return estado;
    }
    public void asignarEstado(Estado estado) {
        this.estado = estado;
    }
}
