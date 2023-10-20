package pedidos.modelos;

public enum EstadoPedido {
        CREADO("Creado"),
        SOLICITADO("Solicitado"),
        MODIFICADO("Modificado"),
        ENTREGADO("Entregado");
        
    private String valor;

    private EstadoPedido(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return this.valor;
    }
    
}   


