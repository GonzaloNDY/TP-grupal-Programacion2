
package usuarios.modelos;

import java.util.ArrayList;
import java.util.List;
import pedido.modelos.Pedido;

public class Encargado extends Usuario {
    // Atributos de Encargado:

    // Constructores: 
    public Encargado(String correo, String clave,String apellido, String nombre ) {
        super( correo, clave,apellido, nombre);

    }

    // Métodos:

    // Métodos redefinidos:
    @Override
    public void mostrar() {
        System.out.println("Encargado: " + super.verApellido() + ", " + super.verNombre());
        System.out.println("Correo: " + super.verCorreo() + "\n");
    }

    @Override
    public List<Pedido> verPedidos(){
        return new ArrayList<>();   // Devuelve un arraylist vacio
    }
}