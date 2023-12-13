package usuarios.modelos;

import interfaces.IControladorAMUsuario;
import interfaces.IControladorUsuarios;
import interfaces.IGestorUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JOptionPane;
import principal.vistas.VentanaPrincipal;
import usuarios.vistas.VentanaUsuarios;

public class ControladorUsuarios implements IControladorUsuarios {

    private VentanaUsuarios ventanaUsuarios;
    private VentanaPrincipal ventanaPrincipal;
    IGestorUsuarios gu = GestorUsuarios.instanciar();
    
    // Constructores:
    public ControladorUsuarios(VentanaPrincipal ventanaRaiz) {
        this.ventanaUsuarios = new VentanaUsuarios(this);
        ventanaPrincipal = ventanaRaiz;
    }
    
    public ControladorUsuarios(VentanaPrincipal ventanaRaiz, String apellido) {
        this.ventanaUsuarios = new VentanaUsuarios(this, apellido);
        ventanaPrincipal = ventanaRaiz;
    }

    // Métodos implementados:
    @Override
    public void btnNuevoClic(ActionEvent evt) {
        ventanaUsuarios.setEnabled(false);
        IControladorAMUsuario ControladorAMUsuarios = new ControladorVentanaAMUsuarios(ventanaUsuarios);
    }

    @Override
    public void btnModificarClic(ActionEvent evt) {
        int filaSeleccionada = ventanaUsuarios.getTablaUsuarios().getSelectedRow();

        if (filaSeleccionada == -1) {
            mostrarMensaje("Seleccione un usuario para modificar");
            return;
        }
        Usuario usuario = ventanaUsuarios.getModeloTablaUsuarios().obtenerUsuarioEnFila(filaSeleccionada);

        IControladorAMUsuario ControladorAMUsuariosMod = new ControladorVentanaAMUsuarios(ventanaUsuarios, usuario.verCorreo());
        ventanaUsuarios.setEnabled(false);
    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {
        int filaSeleccionada = ventanaUsuarios.getTablaUsuarios().getSelectedRow();

        if (filaSeleccionada == -1) {
            mostrarMensaje("Seleccione un usuario para eliminar");
            return;
        }

        int opcion = javax.swing.JOptionPane.showOptionDialog(null,
                "¿Estás seguro de que quiere eliminar este usuario?", "Confirmar eliminación de usuario",
                javax.swing.JOptionPane.YES_NO_OPTION,
                javax.swing.JOptionPane.QUESTION_MESSAGE, null,
                new Object[]{"Sí, eliminar", "No, cancelar"},
                 "Sí, eliminar");

        if (opcion == javax.swing.JOptionPane.YES_OPTION) {
            Usuario usuario = ventanaUsuarios.getModeloTablaUsuarios().obtenerUsuarioEnFila(filaSeleccionada);
            gu.borrarUsuario(usuario);
        }
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        IGestorUsuarios gu = GestorUsuarios.instanciar();
        ModeloTablaUsuarios mtu = new ModeloTablaUsuarios(gu.verUsuarios());
        ventanaUsuarios.tablaUsuarios.setModel(mtu);
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        ventanaPrincipal.setEnabled(true);
        this.ventanaUsuarios.dispose();
    }

    @Override
    public void txtApellidoPresionarTecla(KeyEvent evt) {
        String apellido = ventanaUsuarios.getApellido();
        List<Usuario> usuariosFiltrados = gu.buscarUsuarios(apellido);
        ModeloTablaUsuarios mtu = new ModeloTablaUsuarios(usuariosFiltrados);
        ventanaUsuarios.getTablaUsuarios().setModel(mtu);
    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {
        String apellido = ventanaUsuarios.getApellido();

        if (apellido.isEmpty()) {
            mostrarMensaje("Ingrese un apellido para realizar la búsqueda");
            return;
        }
    }

    // Métodos auxiliares:
    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Mensaje del sistema:", JOptionPane.INFORMATION_MESSAGE);
    }
}
