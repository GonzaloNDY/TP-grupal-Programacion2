package productos.modelos;

public enum Categoria {
    ENTRADA("Entrada"),
    PLATOPRINCIPAL("Plato principal"),
    POSTRE("Postre");
    
    private String valor;
    
    private Categoria (String valor){
       this.valor=valor; 
    }  

    @Override
    public String toString() {
        return this.valor;
    }
    
}
    

