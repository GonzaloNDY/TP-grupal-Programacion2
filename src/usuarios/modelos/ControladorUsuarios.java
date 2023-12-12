package usuarios.modelos;

import interfaces.IControladorUsuarios;
import interfaces.IGestorUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import principal.vistas.VentanaPrincipal;
import usuarios.vistas.VentanaAMUsuario;
import usuarios.vistas.VentanaUsuarios;

public class ControladorUsuarios implements IControladorUsuarios{
    private VentanaUsuarios ventanaUsuarios;
    private VentanaPrincipal ventanaPrincipal;
    IGestorUsuarios gu = GestorUsuarios.instanciar();

    public ControladorUsuarios(VentanaPrincipal ventanaRaiz) {
        this.ventanaUsuarios = new VentanaUsuarios(this);
        ventanaPrincipal = ventanaRaiz;
    }

    @Override
    public void btnNuevoClic(ActionEvent evt) {
        VentanaAMUsuario ventanaAMUsuario = new VentanaAMUsuario(null,true);
    }

    @Override
    public void btnModificarClic(ActionEvent evt) {                 //ACA TIENE QUE RECIBIR EL CORREO DEL USUARIO SELEECIONADO EN LA TABLA
        VentanaAMUsuario ventanaAMUsuario = new VentanaAMUsuario(null,true,"colmannicolas@");
    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {
        int opcion = javax.swing.JOptionPane.showOptionDialog(null,
        "¿Estás seguro de que quiere eliminar este usuario?", "Confirmar eliminación de usuario",
        javax.swing.JOptionPane.YES_NO_OPTION,
        javax.swing.JOptionPane.QUESTION_MESSAGE, null,           
        new Object[]{"Sí, eliminar", "No, cancelar"}, "Sí, eliminar");
        if (opcion == javax.swing.JOptionPane.YES_OPTION) {
            gu.borrarUsuario(null);
        }
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        this.ventanaUsuarios.dispose();
        ventanaPrincipal.setVisible(true);
    }

    @Override
    public void txtApellidoPresionarTecla(KeyEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
