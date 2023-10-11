/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.modelos;

/**
 *
 * @author Windows PC
 */
public enum Categoria {
    ENTRADA("ENTRADA"),
    PLATO_PRINCIPAL("PLATO_PRINCIPAL"),
    POSTRE("POSTRE");
    
    private String valor;
    
    private Categoria (String valor){
       this.valor=valor; 
    }  

    @Override
    public String toString() {
        return this.valor;
    }
    
}
    

