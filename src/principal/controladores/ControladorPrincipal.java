package principal.controladores;

import interfaces.IGestorPedidos;
import interfaces.IGestorProductos;
import interfaces.IGestorUsuarios;
import java.util.List;
import pedido.modelos.GestorPedidos;
import productos.modelos.GestorProductos;
import usuarios.modelos.GestorUsuarios;
import usuarios.modelos.Perfil;
import usuarios.modelos.Usuario;

/*
 *
 * @author Mariana
 */
public class ControladorPrincipal {

    public static void main(String[] args) {
        IGestorUsuarios gu = GestorUsuarios.instanciar();
        IGestorProductos gprod = GestorProductos.instanciar();
        IGestorPedidos gped = GestorPedidos.instanciar();

        //metodo CrearUsuario
        System.out.println(gu.crearUsuario("Colman@gmail.com", "colman", "nicolas", Perfil.CLIENTE, "123456", "123456"));
        System.out.println(gu.crearUsuario("colman@hotmail.com", "colman", "nicolas", Perfil.CLIENTE, "clave123", "otraClave"));
        System.out.println(gu.crearUsuario("colman@hotmail.com", "sanchez", "pablo", Perfil.ENCARGADO, "clave123", "clave123"));

        //metodo verUsuarios      
        List<Usuario> listaUsuarios = gu.verUsuarios();
        for (Usuario u : listaUsuarios) {
            u.mostrar();
        }
            //metodo obtenerUsuario
            Usuario unUsuario = gu.obtenerUsuario("Colman@gmail.com");
            unUsuario.mostrar();
            Usuario otroUsuario = gu.obtenerUsuario("432432523");
         

            if (otroUsuario != null) {
                otroUsuario.mostrar();
            }
    }
}


