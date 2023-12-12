
package usuarios.modelos;

import interfaces.IControladorAMUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import usuarios.vistas.VentanaAMUsuario;
import usuarios.vistas.VentanaUsuarios;


public class ControladorVentanaAMUsuarios implements IControladorAMUsuario {
    private VentanaAMUsuario ventanaAMUsuario;           
    private VentanaUsuarios VentanaUsuarios;         //de donde viene
  //  IGestorUsuarios gu = GestorUsuarios.instanciar();

    public ControladorVentanaAMUsuarios(VentanaUsuarios ventanaRaiz) {
        this.ventanaAMUsuario = new VentanaAMUsuario(this);
        VentanaUsuarios = ventanaRaiz;
    }
    public ControladorVentanaAMUsuarios(VentanaUsuarios ventanaRaiz, String correoUsuario) {
    this.ventanaAMUsuario = new VentanaAMUsuario(this,correoUsuario);
        VentanaUsuarios = ventanaRaiz;
    }

    @Override
    public void btnGuardarClic(ActionEvent evt) {
          System.out.println("si se activa el boton guardar");
//        GestorUsuarios gu = GestorUsuarios.instanciar();
//        String correo = this.txtCorreo.getText().trim();
//        String apellido = this.txtApellido.getText().trim();
//        String nombre = this.txtNombre.getText().trim();
//        String clave = new String(this.passClave.getPassword());
//        String claveRepetida = new String(this.passClaveRepetida.getPassword());
//        String perfilSeleccionadoString = (String) comboBoxPerfil.getSelectedItem();
//
//        Perfil perfilSeleccionado = null;
//
//        for (Perfil perfil : Perfil.values()) {
//            if (perfil.verPerfil().equals(perfilSeleccionadoString)) {
//                perfilSeleccionado = perfil;
//                break;
//            }
//        }
//        System.out.println();
//        if (modoModificacion == true) {
//            gu.borrarUsuario(gu.obtenerUsuario(correo));
//        }
//        String validacion = (gu.crearUsuario(correo, apellido, nombre, perfilSeleccionado, clave, claveRepetida));
//        System.out.println(validacion);
//        System.out.println();
//        if (validacion.equals("Usuario creado/modificado con éxito")) {
//            resetearCamposRegistro();
//        }
//        this.dispose();
       this.ventanaAMUsuario.dispose();
        VentanaUsuarios.setVisible(true);
 }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        this.ventanaAMUsuario.dispose();
        VentanaUsuarios.setVisible(true);
        }

    @Override
    public void txtApellidoPresionarTecla(KeyEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void txtNombrePresionarTecla(KeyEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void txtCorreoPresionarTecla(KeyEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void passClavePresionarTecla(KeyEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void passClaveRepetidaPresionarTecla(KeyEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
