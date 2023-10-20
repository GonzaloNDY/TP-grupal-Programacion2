
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
        System.out.println("Categoria: " + categoria + "\tVigencia: " + estado + "\n");
    }

    @Override
    public String toString() {
        return "Producto: " + descripcion + "\n" +
                "Precio: $" + precio + "\n" +
                "Categoria: " + categoria + "\t" +
                "Vigencia: " + estado + "\n";
    }

    @Override
    public boolean equals(Object objeto) {
        if (objeto == null || getClass() != objeto.getClass())
            return false;
        if (this == objeto)
            return true;
        Producto otroProducto = (Producto) objeto;
        // Comparo los códigos de los productos:
        return this.codigo == otroProducto.codigo;
    }

    @Override
    public int hashCode() {
        int hash = 11;
        hash = 19 * hash + this.codigo;
        return hash;
    }

    // Get/set de los atributos:
    // Codigo:
    public int verCodigo() {
        return codigo;
    }
    public void asignarCodigo(int codigo) {
        this.codigo = codigo;
    }
    // Descripcion:
    public String verDescripcion() {
        return descripcion;
    }
    public void asignarDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    // Precio:
    public float verPrecio() {
        return precio;
    }
    public void asignarPrecio(float precio) {
        this.precio = precio;
    }
    // Categoria:
    public Categoria verCategoria() {
        return categoria;
    }
    public void asignarCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    // Estado:
    public Estado verEstado() {
        return estado;
    }
    public void asignarEstado(Estado estado) {
        this.estado = estado;
    }
}
