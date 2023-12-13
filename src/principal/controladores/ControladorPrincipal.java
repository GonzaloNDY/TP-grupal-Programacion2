package principal.controladores;


import interfaces.IControladorPrincipal;
import interfaces.IControladorUsuarios;
import interfaces.IGestorUsuarios;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import principal.vistas.VentanaPrincipal;
import usuarios.modelos.ControladorUsuarios;
import usuarios.modelos.GestorUsuarios;


public class ControladorPrincipal implements IControladorPrincipal{
    private VentanaPrincipal ventanaPrincipal;
    public ControladorPrincipal() {
        this.ventanaPrincipal = new VentanaPrincipal();
        this.ventanaPrincipal.setControlador(this);
    }

    public static void main(String[] args) {
        IGestorUsuarios gu = GestorUsuarios.instanciar();
        ControladorPrincipal controladorPrincipal = new ControladorPrincipal();
        controladorPrincipal.ventanaPrincipal.setTitle(TITULO + " - Grupo 15");
    }
    
    @Override
    public void btnUsuariosClic(ActionEvent evt){
        IControladorUsuarios controladorUsuarios = new ControladorUsuarios(ventanaPrincipal);
        ventanaPrincipal.setVisible(false);
    }

    @Override
    public void btnProductosClic(ActionEvent evt){
        mostrarMensaje("Funcionalidad no disponible");
    }

    @Override
    public void btnPedidosClic(ActionEvent evt){
        mostrarMensaje("Funcionalidad no disponible");
    }

    @Override
    public void btnSalirClic(ActionEvent evt){
        int opcion = javax.swing.JOptionPane.showOptionDialog(null,
        "¿Estás seguro de que quieres salir?", "Confirmar Salida",
        javax.swing.JOptionPane.YES_NO_OPTION,
        javax.swing.JOptionPane.QUESTION_MESSAGE, null,           
        new Object[]{"Sí, salir", "No, quedarme"}, "Sí, salir");
        if (opcion == javax.swing.JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Mensaje del sistema:", JOptionPane.INFORMATION_MESSAGE);
    }
}
