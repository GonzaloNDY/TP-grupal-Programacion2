
package usuarios.modelos;

import java.util.ArrayList;
import pedidos.modelos.Pedido;

public class Empleado extends Usuario{
    // Constructores: 
    public Empleado(String apellido, String nombre, String correo, String clave) {
        super(apellido, nombre, correo, clave);

    }

    // Métodos:
     @Override
    public void mostrar() {
        System.out.println("Empleado: " + super.getApellido() + ", " + super.getNombre());
        System.out.println("Correo: " + super.getCorreo() + "\n");
    }
    
    @Override
    public ArrayList<Pedido> verPedidos(){    
        return new ArrayList<>();   // Devuelve un arraylist vacio
    }

}