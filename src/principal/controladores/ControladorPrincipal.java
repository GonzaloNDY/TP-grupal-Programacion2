package principal.controladores;

import interfaces.IControladorPrincipal;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import principal.vistas.VentanaPrincipal;
import usuarios.vistas.VentanaUsuarios;

public class ControladorPrincipal implements IControladorPrincipal{
    
    private VentanaPrincipal ventanaRaiz;
    
    public ControladorPrincipal() {
        this.ventanaRaiz = new VentanaPrincipal();
        this.ventanaRaiz.setControlador(this);
    }

    public static void main(String[] args) {
        ControladorPrincipal controladorPrincipal = new ControladorPrincipal();
        controladorPrincipal.ventanaRaiz.setTitle(TITULO + " - Grupo 15");
    }

    @Override
    public void btnUsuariosClic(ActionEvent evt){
        VentanaUsuarios ventanaUsuarios = new VentanaUsuarios();
        ventanaUsuarios.setVisible(true);
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
