
package pedidos.modelos;

public enum EstadoPedido {
        CREADO("CREADO"),
        SOLICITADO("SOLICITADO"),
        MODIFICADO("MODIFICADO"),
        ENTREGADO("ENTREGADO");
        
    private String valor;

    private EstadoPedido(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return this.valor;
    }
    
}   


