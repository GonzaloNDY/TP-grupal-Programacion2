package pedidos.modelos;

public enum Estado {
        CREADO("Creado"),
        SOLICITADO("Solicitado"),
        MODIFICADO("Modificado"),
        ENTREGADO("Entregado");
        
    private String valor;

    private Estado(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return this.valor;
    }
    
}   


