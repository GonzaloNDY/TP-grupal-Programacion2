/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.modelos;

/**
 *
 * @author Windows PC
 */
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
