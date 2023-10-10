
package pedidos.modelos;


 public enum  Estado{
        CREADO("CREADO"),
        SOLICITADO("SOLICITADO"),
        MODIFICADO("MODIFICADO"),
        ENTREGADO("ENTREGADO");
        
    private String valor;

    private Estado(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return this.valor;
    }
    
 }   


