package usuarios.modelos;

import interfaces.IControladorUsuarios;
import interfaces.IGestorUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JOptionPane;
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
//        //        ventanaUsuarios.obtenerModeloTablaUsuarios().fireTableDataChanged();
//        ventanaUsuarios.obtenerModeloTablaUsuarios().fireTableStructureChanged();
////        ventanaUsuarios.getTablaUsuarios().repaint();
//        ventanaUsuarios.getTablaUsuarios().updateUI();
////        ventanaUsuarios.getTablaUsuarios().getParent().validate();
////        ventanaUsuarios.getTablaUsuarios().getParent().repaint();
//        ventanaUsuarios.getTablaUsuarios().getParent().revalidate();

        // Solucion temporal para actualizar la tabla:
        this.ventanaUsuarios.dispose();
        ControladorUsuarios nuevoControlador = new ControladorUsuarios(ventanaPrincipal);
    }

    @Override
    public void btnModificarClic(ActionEvent evt) {
        int filaSeleccionada = ventanaUsuarios.getTablaUsuarios().getSelectedRow();

        if (filaSeleccionada == -1) {
            mostrarMensaje("Seleccione un usuario para modificar");
            return;
        }
        Usuario usuario = ventanaUsuarios.obtenerModeloTablaUsuarios().obtenerUsuarioEnFila(filaSeleccionada);
        VentanaAMUsuario ventanaAMUsuario = new VentanaAMUsuario(ventanaUsuarios, true, usuario.verCorreo());
//        //        ventanaUsuarios.obtenerModeloTablaUsuarios().fireTableDataChanged();
//        ventanaUsuarios.obtenerModeloTablaUsuarios().fireTableStructureChanged();
////        ventanaUsuarios.getTablaUsuarios().repaint();
//        ventanaUsuarios.getTablaUsuarios().updateUI();
////        ventanaUsuarios.getTablaUsuarios().getParent().validate();
////        ventanaUsuarios.getTablaUsuarios().getParent().repaint();
//        ventanaUsuarios.getTablaUsuarios().getParent().revalidate();

        // Solucion temporal para actualizar la tabla:
        this.ventanaUsuarios.dispose();
        ControladorUsuarios nuevoControlador = new ControladorUsuarios(ventanaPrincipal);
    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {
        int filaSeleccionada = ventanaUsuarios.getTablaUsuarios().getSelectedRow();

        if (filaSeleccionada == -1) {
            mostrarMensaje("Seleccione un usuario para eliminar");
            return;
        }

        int opcion = javax.swing.JOptionPane.showOptionDialog(null,
        CONFIRMACION, "Mensaje del sistema",
        javax.swing.JOptionPane.YES_NO_OPTION,
        javax.swing.JOptionPane.QUESTION_MESSAGE, null,           
        new Object[]{"Sí, eliminar", "No, cancelar"}, "Sí, eliminar");
        if (opcion == javax.swing.JOptionPane.YES_OPTION) {
            Usuario usuario = ventanaUsuarios.obtenerModeloTablaUsuarios().obtenerUsuarioEnFila(filaSeleccionada);
            gu.borrarUsuario(usuario);
//            //        ventanaUsuarios.obtenerModeloTablaUsuarios().fireTableDataChanged();
//        ventanaUsuarios.obtenerModeloTablaUsuarios().fireTableStructureChanged();
////        ventanaUsuarios.getTablaUsuarios().repaint();
//        ventanaUsuarios.getTablaUsuarios().updateUI();
////        ventanaUsuarios.getTablaUsuarios().getParent().validate();
////        ventanaUsuarios.getTablaUsuarios().getParent().repaint();
//        ventanaUsuarios.getTablaUsuarios().getParent().revalidate();

            // Solucion temporal para actualizar la tabla:
            this.ventanaUsuarios.dispose();
            ControladorUsuarios nuevoControlador = new ControladorUsuarios(ventanaPrincipal);
        }
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        // No sé que hacer aqui
        List<Usuario> listaUsuarios = gu.verUsuarios();
        ModeloTablaUsuarios mtu = new ModeloTablaUsuarios(listaUsuarios);
        ventanaUsuarios.getTablaUsuarios().setModel(mtu);
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        this.ventanaUsuarios.dispose();
        ventanaPrincipal.setVisible(true);
    }

    @Override
    public void txtApellidoPresionarTecla(KeyEvent evt) {
        String apellido = ventanaUsuarios.obtenerApellido();
        List<Usuario> usuariosFiltrados = gu.buscarUsuarios(apellido);
        // Revisar:
        ModeloTablaUsuarios mtu = new ModeloTablaUsuarios(usuariosFiltrados);
        ventanaUsuarios.getTablaUsuarios().setModel(mtu);
    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {
        // Falta actualizar la tabla:
        String apellido = ventanaUsuarios.obtenerApellido();
        
        if (apellido.isEmpty()) {
            mostrarMensaje("Ingrese un apellido para realizar la búsqueda");
            return;
        }

        List<Usuario> usuariosEncontrados = gu.buscarUsuarios(apellido);
        // Revisar:
        ModeloTablaUsuarios mtu = new ModeloTablaUsuarios(usuariosEncontrados);
        ventanaUsuarios.getTablaUsuarios().setModel(mtu);
//        ventanaUsuarios.obtenerModeloTablaUsuarios().fireTableDataChanged();
        ventanaUsuarios.obtenerModeloTablaUsuarios().fireTableStructureChanged();
//        ventanaUsuarios.getTablaUsuarios().repaint();
        ventanaUsuarios.getTablaUsuarios().updateUI();
//        ventanaUsuarios.getTablaUsuarios().getParent().validate();
//        ventanaUsuarios.getTablaUsuarios().getParent().repaint();
        ventanaUsuarios.getTablaUsuarios().getParent().revalidate();
    }
    
    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Mensaje del sistema:", JOptionPane.INFORMATION_MESSAGE);
    }
}
