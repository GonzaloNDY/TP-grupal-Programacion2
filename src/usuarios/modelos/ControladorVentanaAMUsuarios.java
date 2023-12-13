package usuarios.modelos;

import interfaces.IControladorAMUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import static usuarios.modelos.Perfil.CLIENTE;
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
    //  IGestorUsuarios gu = GestorUsuarios.instanciar();

    public ControladorVentanaAMUsuarios(VentanaUsuarios ventanaRaiz) {
        modoModificacion = false;
        this.ventanaAMUsuario = new VentanaAMUsuario(this);
        ventanaUsuarios = ventanaRaiz;
    }

    public ControladorVentanaAMUsuarios(VentanaUsuarios ventanaRaiz, String correoUsuario) {
        modoModificacion = true;
        this.ventanaAMUsuario = new VentanaAMUsuario(this, correoUsuario);
        ventanaUsuarios = ventanaRaiz;
    }

    @Override
    public void btnGuardarClic(ActionEvent evt) {
        System.out.println("si se activa el boton guardar");
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
        System.out.println(validacion);
        System.out.println();

        if (validacion.equals("Usuario creado/modificado con éxito")) {
            ventanaAMUsuario.resetearCamposRegistro();
            ventanaAMUsuario.dispose();
            ventanaUsuarios.setVisible(true);
       //     ControladorUsuarios nuevoControlador = new ControladorUsuarios(VentanaUsuarios);
         //   VentanaUsuarios.setVisible(true);

        }

    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        this.ventanaAMUsuario.dispose();
        ventanaUsuarios.setVisible(true);
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

}
