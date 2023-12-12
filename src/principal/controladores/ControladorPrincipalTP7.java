/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.controladores;

import interfaces.IGestorProductos;
import interfaces.IGestorUsuarios;
import java.util.ArrayList;
import java.util.List;
import javax.swing.UIManager;
import productos.modelos.GestorProductos;
import usuarios.modelos.GestorUsuarios;
import usuarios.modelos.Usuario;
import usuarios.vistas.VentanaAMUsuario;

/**
 *
 * @author root
 */
public class ControladorPrincipalTP7 {

    public static void main(String[] args) {
       
        IGestorUsuarios gu = GestorUsuarios.instanciar();
        List<Usuario> usuarios = new ArrayList<>();
     


        establecerLookAndFeel("Nimbus");
        
        VentanaAMUsuario ventanaAMUsuario = new VentanaAMUsuario(null,true);
        VentanaAMUsuario ventanaAMUsuarioMod = new VentanaAMUsuario(null,true,"colmannicolas@");
      
      
        
        System.out.println("USUARIOS");
        System.out.println("=====");
        usuarios = gu.verUsuarios();
        for (Usuario u : usuarios) {
            u.mostrar();
            System.out.println();
        }

    }

    public static void establecerLookAndFeel(String laf) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if (laf.equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                }
            }
        } catch (Exception e) {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e2) {
            }
        }
    }
}
