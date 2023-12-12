package usuarios.vistas;

import interfaces.IControladorAMUsuario;
import interfaces.IGestorUsuarios;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import usuarios.modelos.ControladorVentanaAMUsuarios;
import usuarios.modelos.GestorUsuarios;
import usuarios.modelos.Perfil;
import usuarios.modelos.Usuario;

public class VentanaAMUsuario extends javax.swing.JDialog {

    private ControladorVentanaAMUsuarios controladorAMUsuario;
    private boolean modoModificacion = false;
    public void setControlador(ControladorVentanaAMUsuarios controlador) {
        this.controladorAMUsuario = controlador;
    }


    // Constructor para crear usuarios
    public VentanaAMUsuario(ControladorVentanaAMUsuarios controlador) {
        
        initComponents();
        modoModificacion = false;
        setVisible(true); // Hace visible la ventana
        this.controladorAMUsuario = controlador;
        if (controladorAMUsuario != null) {
            this.setControlador(controladorAMUsuario);
        }
    }

    // Constructor para casos de modificación (requiere correo de usuario)
    public VentanaAMUsuario(ControladorVentanaAMUsuarios controlador , String correoUsuario) {
        
        initComponents();
        llenarDatosParaModificacion(correoUsuario);
        modoModificacion = true;
        setVisible(true); // Hace visible la ventana
        
        this.controladorAMUsuario = controlador;
        if (controladorAMUsuario != null) {
            this.setControlador(controladorAMUsuario);
        }

    }

    public void llenarComboPerfil() {
        for (Perfil perf : Perfil.values()) {
            comboBoxPerfil.addItem(perf.verPerfil());
        }
    }

    public void llenarDatosParaModificacion(String correoUsuario) {

        IGestorUsuarios gu = GestorUsuarios.instanciar();
        Usuario u = gu.obtenerUsuario(correoUsuario);

        this.txtCorreo.setEnabled(false);
        this.comboBoxPerfil.setEnabled(false);

        this.txtCorreo.setText(u.verCorreo());
        this.txtApellido.setText(u.verApellido());
        this.txtNombre.setText(u.verNombre());
        this.comboBoxPerfil.addItem(gu.obtenerPerfilUsuario(u));
        this.passClave.setText(u.verClave());
        this.passClaveRepetida.setText(u.verClave());

    }

    public void resetearCamposRegistro() {
        this.txtApellido.setText("");
        this.txtNombre.setText("");
        this.txtCorreo.setText("");
        this.passClave.setText("");
        this.passClaveRepetida.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        comboBoxPerfil = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        passClaveRepetida = new javax.swing.JPasswordField();
        passClave = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("Apellido");

        jLabel2.setText("Nombre");

        jLabel3.setText("Correo");

        jLabel4.setText("Clave");

        jLabel5.setText("Perfil");

        jLabel6.setText("Clave Repetida");

        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoKeyTyped(evt);
            }
        });

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        txtCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCorreoKeyTyped(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        passClaveRepetida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passClaveRepetidaKeyTyped(evt);
            }
        });

        passClave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passClaveKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                        .addComponent(btnCancelar)
                        .addGap(73, 73, 73))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtApellido)
                            .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                            .addComponent(comboBoxPerfil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(passClaveRepetida)
                            .addComponent(passClave, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCorreo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellido))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passClaveRepetida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        llenarComboPerfil();
    }//GEN-LAST:event_formWindowOpened

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        controladorAMUsuario.btnGuardarClic(evt);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        controladorAMUsuario.btnCancelarClic(evt);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtCorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoKeyTyped
        controladorAMUsuario.txtCorreoPresionarTecla(evt);
    }//GEN-LAST:event_txtCorreoKeyTyped

    private void txtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyTyped
         controladorAMUsuario.txtApellidoPresionarTecla(evt);
    }//GEN-LAST:event_txtApellidoKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        controladorAMUsuario.txtNombrePresionarTecla(evt);
    }//GEN-LAST:event_txtNombreKeyTyped

    private void passClaveKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passClaveKeyTyped
         controladorAMUsuario.passClavePresionarTecla(evt);
    }//GEN-LAST:event_passClaveKeyTyped

    private void passClaveRepetidaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passClaveRepetidaKeyTyped
         controladorAMUsuario.passClaveRepetidaPresionarTecla(evt);
    }//GEN-LAST:event_passClaveRepetidaKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> comboBoxPerfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField passClave;
    private javax.swing.JPasswordField passClaveRepetida;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    public void btnGuardarClic(ActionEvent evt) {
        System.out.println("si se activa el boton guardar");
        GestorUsuarios gu = GestorUsuarios.instanciar();
        String correo = this.txtCorreo.getText().trim();
        String apellido = this.txtApellido.getText().trim();
        String nombre = this.txtNombre.getText().trim();
        String clave = new String(this.passClave.getPassword());
        String claveRepetida = new String(this.passClaveRepetida.getPassword());
        String perfilSeleccionadoString = (String) comboBoxPerfil.getSelectedItem();

        Perfil perfilSeleccionado = null;

        for (Perfil perfil : Perfil.values()) {
            if (perfil.verPerfil().equals(perfilSeleccionadoString)) {
                perfilSeleccionado = perfil;
                break;
            }
        }
        System.out.println();
        if (modoModificacion == true) {
            gu.borrarUsuario(gu.obtenerUsuario(correo));
        }
        String validacion = (gu.crearUsuario(correo, apellido, nombre, perfilSeleccionado, clave, claveRepetida));
        System.out.println(validacion);
        System.out.println();
        if (validacion.equals("Usuario creado/modificado con éxito")) {
            resetearCamposRegistro();
        }
        this.dispose();
    }

    public void btnCancelarClic(ActionEvent evt) {
        this.dispose();
    }

}
