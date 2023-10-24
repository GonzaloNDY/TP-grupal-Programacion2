
package usuarios.modelos;

import java.util.ArrayList;
import java.util.Objects;
import pedido.modelos.Pedido;

public class Encargado extends Usuario {
    // Constructores: 
     public Encargado(String correo, String clave,String apellido, String nombre ) {
        super( correo, clave,apellido, nombre);

    }

    // Métodos:
     @Override
    public void mostrar() {
        System.out.println("Encargado: " + super.verApellido() + ", " + super.verNombre());
        System.out.println("Correo: " + super.verCorreo() + "\n");
    }
    
    @Override
    public ArrayList<Pedido> verPedidos(){    
        return new ArrayList<>();   // Devuelve un arraylist vacio
    }

}