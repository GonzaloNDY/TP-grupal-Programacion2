
package productos.modelos;

public enum Estado {
    DISPONIBLE("DISPONIBLE"),
    NO_DISPONIBLE("NO_DISPONIBLE");
    
    private String valor;
    private Estado(String valor){
        this.valor=valor;
    }

    @Override
    public String toString() {
        return this.valor;
    }
    
}
