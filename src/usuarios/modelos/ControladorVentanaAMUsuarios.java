package usuarios.modelos;

import interfaces.IControladorAMUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import usuarios.vistas.VentanaAMUsuario;
import usuarios.vistas.VentanaUsuarios;

public class ControladorVentanaAMUsuarios implements IControladorAMUsuario {

    private String textoApellido = null;
    private String textoNombre = null;
    private String textoCorreo = null;
    private String textoContraseña = null;
    private String textoContraseñaRepetida = null;
    private boolean modoModificacion = false;
    private VentanaAMUsuario ventanaAMUsuario;
    private VentanaUsuarios ventanaUsuarios;

    public ControladorVentanaAMUsuarios(VentanaUsuarios ventanaRaizU) {
        modoModificacion = false;
        this.ventanaAMUsuario = new VentanaAMUsuario(this);
        ventanaUsuarios = ventanaRaizU;
    }

    public ControladorVentanaAMUsuarios(VentanaUsuarios ventanaRaizU, String correoUsuario) {
        modoModificacion = true;
        this.ventanaAMUsuario = new VentanaAMUsuario(this, correoUsuario);
        ventanaUsuarios = ventanaRaizU;
    }

    @Override
    public void btnGuardarClic(ActionEvent evt) {
        GestorUsuarios gu = GestorUsuarios.instanciar();
        String perfilSeleccionadoString = (String) ventanaAMUsuario.comboBoxPerfil.getSelectedItem();

        Perfil perfilSeleccionado = null;

        for (Perfil perfil : Perfil.values()) {
            if (perfil.verPerfil().equals(perfilSeleccionadoString)) {
                perfilSeleccionado = perfil;
                break;
            }
        }
        System.out.println();
        if (modoModificacion == true) {
            GestorUsuarios guMod = GestorUsuarios.instanciar();
            textoCorreo = this.ventanaAMUsuario.txtCorreo.getText();
            guMod.borrarUsuario(guMod.obtenerUsuario(textoCorreo));
            textoApellido = this.ventanaAMUsuario.txtApellido.getText();
            textoNombre = this.ventanaAMUsuario.txtNombre.getText();
            textoContraseña = new String(this.ventanaAMUsuario.passClave.getPassword());
            textoContraseñaRepetida = new String(this.ventanaAMUsuario.passClaveRepetida.getPassword());
        }

        String validacion = (gu.crearUsuario(textoCorreo, textoApellido, textoNombre, perfilSeleccionado, textoContraseña, textoContraseñaRepetida));

        if (validacion.equals("Usuario creado/modificado con éxito")) {
            ventanaUsuarios.setEnabled(true);
            ventanaAMUsuario.resetearCamposRegistro();
            ventanaAMUsuario.dispose();
        } else {
            mostrarMensaje(validacion);
        }

    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        ventanaUsuarios.setEnabled(true);
        this.ventanaAMUsuario.dispose();
    }

    @Override
    public void txtApellidoPresionarTecla(KeyEvent evt) {
        textoApellido = ventanaAMUsuario.txtApellido.getText().trim();

    }

    @Override
    public void txtNombrePresionarTecla(KeyEvent evt) {
        textoNombre = ventanaAMUsuario.txtNombre.getText().trim();
    }

    @Override
    public void txtCorreoPresionarTecla(KeyEvent evt) {
        textoCorreo = ventanaAMUsuario.txtCorreo.getText().trim();
        System.out.println(textoCorreo);
    }

    @Override
    public void passClavePresionarTecla(KeyEvent evt) {
        textoContraseña = new String(ventanaAMUsuario.passClave.getPassword());
    }

    @Override
    public void passClaveRepetidaPresionarTecla(KeyEvent evt) {
        textoContraseñaRepetida = new String(ventanaAMUsuario.passClaveRepetida.getPassword());
    }
    
    // Métodos auxiliares:
    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Mensaje del sistema:", JOptionPane.INFORMATION_MESSAGE);
    }
}
