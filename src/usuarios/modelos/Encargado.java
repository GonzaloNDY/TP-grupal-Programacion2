
package usuarios.modelos;

import java.util.ArrayList;
import pedido.modelos.Pedido;

public class Encargado extends Usuario {
    // Constructores: 
     public Encargado( String apellido, String nombre, String correo, String clave ) {
      super(apellido, nombre, correo, clave);
    
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