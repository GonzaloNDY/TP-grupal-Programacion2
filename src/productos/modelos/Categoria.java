package productos.modelos;

public enum Categoria {
    // Categorias disponibles:
    ENTRADA("Entrada"),
    PLATOPRINCIPAL("Plato principal"),
    POSTRE("Postre");

    private String valor;

    // Constructor para inicializar el valor de la categoria:
    private Categoria (String valor){
        this.valor=valor;
    }

    // Devuelve un valor legible de la categoria:
    @Override
    public String toString() {
        return this.valor;
    }
}
