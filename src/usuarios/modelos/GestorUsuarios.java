package usuarios.modelos;

import interfaces.IGestorUsuarios;
import java.util.ArrayList;
import java.util.List;

public class GestorUsuarios implements IGestorUsuarios {

    // Atributos de GestosUsuarios:
    private List<Usuario> usuarios = new ArrayList<>();

    // Implementación del patrón de diseño singleton:
    private static GestorUsuarios gestor;

    private GestorUsuarios() {
    }

    public static GestorUsuarios instanciar() {
        if (gestor == null) {
            gestor = new GestorUsuarios();
        }
        return gestor;
    }

    // Métodos:
    @Override
    public String crearUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida) {
        String validacion = validarDatos(correo, apellido, nombre, perfil, clave, claveRepetida);
        if (!validacion.equals(VALIDACION_EXITO)) {
            return validacion;
        } else {
            Usuario nuevoUsuario = generarUsuario(correo, apellido, nombre, perfil, clave);
            if (existeEsteUsuario(nuevoUsuario)) {
                return USUARIOS_DUPLICADOS;
            } else {
                usuarios.add(nuevoUsuario);
                return EXITO;
            }
        }
    }

    @Override
    public List<Usuario> verUsuarios() {
        return usuarios;
    }

    @Override
    public List<Usuario> buscarUsuarios(String apellido) {
        List<Usuario> userEncontrados = new ArrayList<>();
        if (apellido != null) {
            for (Usuario user : this.usuarios) {
                if (user.verApellido().toLowerCase().contains(apellido.toLowerCase())) {
                    userEncontrados.add(user);
                }
            }
        }
        return userEncontrados;
    }

    @Override
    public boolean existeEsteUsuario(Usuario usuario) {
        return usuarios.contains(usuario);
    }

    @Override
    public Usuario obtenerUsuario(String correo) {
        for (Usuario user : usuarios) {
            if (user.verCorreo().equals(correo)) {
                return user;
            }
        }
        System.out.println("No existen usuarios con el correo ingresado");
        return null;
    }

    
    @Override
    public String borrarUsuario(Usuario usuario) {

        if (usuarios.contains(usuario)) {
            if (hayPedidosConEsteCliente(usuario)) {   //quiero llamar al metodo dentro de GestorPedidos
                return "no se puede borrar";
            } else {
                usuarios.remove(usuario);
                return EXITO_BORRADO;
            }
        } else {
            return USUARIO_INEXISTENTE;
        }

    }

    // Métodos auxiliares:
    private String validarDatos(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida) {
        if (correo == null || !correo.contains("@")) {
            return ERROR_CORREO;
        }
        if (apellido == null || apellido.isEmpty()) {
            return ERROR_APELLIDO;
        }
        if (nombre == null || nombre.isEmpty()) {
            return ERROR_NOMBRE;
        }
        if (perfil == null) {
            return ERROR_PERFIL;
        }
        if (clave == null || clave.isEmpty()) {
            return ERROR_CLAVES;
        }
        if (claveRepetida == null || claveRepetida.isEmpty() || !claveRepetida.equals(clave)) {
            return ERROR_CLAVES;
        }
        return VALIDACION_EXITO;
    }

    private Usuario generarUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave) {
        Usuario unUsuario = null;
        switch (perfil) {
            case CLIENTE:
                unUsuario = new Cliente(correo, clave, apellido, nombre);
                break;
            case EMPLEADO:
                unUsuario = new Empleado(correo, clave, apellido, nombre);
                break;
            case ENCARGADO:
                unUsuario = new Encargado(correo, clave, apellido, nombre);
                break;
        }
        return unUsuario;
    }


}
