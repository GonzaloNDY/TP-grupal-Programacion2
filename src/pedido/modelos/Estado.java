package pedido.modelos;

public enum Estado {
    // Estados disponibles:
    CREADO("Creado"),
    SOLICITADO("Solicitado"),
    MODIFICADO("Modificado"),
    ENTREGADO("Entregado");
        
    private String valor;

    // Constructor para inicializar el valor del estado:
    private Estado(String valor) {
        this.valor = valor;
    }

    // Devuelve un valor legible del estado:
    @Override
    public String toString() {
        return this.valor;
    }
    
}   


