package productos.modelos;

public enum Estado {
    // Estados disponibles:
    DISPONIBLE("Disponible"),
    NO_DISPONIBLE("No disponible");

    private String valor;

    // Constructor para inicializar el valor del estado:
    private Estado(String valor){
        this.valor=valor;
    }

    // Devuelve un valor legible del estado:
    @Override
    public String toString() {
        return this.valor;
    }
}
