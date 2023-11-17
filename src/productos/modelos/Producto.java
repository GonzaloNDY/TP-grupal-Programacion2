package productos.modelos;

import java.util.Objects;

public class Producto {
    // Atributos de Producto:
    private int codigo;
    private String descripcion;
    private float precio;
    private Categoria categoria;
    private Estado estado;

    // Constructores:
    public Producto (int codigo, String descripcion, float precio, Categoria categoria, Estado estado){
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.estado = estado;
        this.precio = precio;
    }

    // Métodos:
    public void mostrar() {
        System.out.println("Producto: " + descripcion);
        System.out.println("Precio: $" + precio);
        System.out.println("Categoria: " + categoria + "\tVigencia: " + estado + "\n");
    }

    // Métodos redefinidos:
    @Override
    public String toString() {
        return "Producto: " + descripcion + "\n" +
                "Precio: $" + precio + "\n" +
                "Categoria: " + categoria + "\t" +
                "Vigencia: " + estado + "\n";
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass())
            return false;
        if (this == obj)
            return true;
        Producto otroProducto = (Producto) obj;
        return this.codigo == otroProducto.codigo;
    }

    // Métodos get/set:
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
