package usuarios.modelos;

import java.util.ArrayList;
import java.util.List;

public class GestorUsuarios {
    // Constantes de GestorUsuarios:
    public static final String EXITO = "Usuario creado/modificado con éxito";
    public static final String ERROR_CORREO = "El correo del usuario es incorrecto";
    public static final String ERROR_APELLIDO = "El apellido del usuario es incorrecto";
    public static final String ERROR_NOMBRE = "El nombre del usuario es incorrecto";
    public static final String ERROR_CLAVES = "Las claves especificadas no coinciden o son incorrectas";
    public static final String ERROR_PERFIL = "El perfil del usuario es incorrecto";
    public static final String PERFIL_CAMBIO = "El usuario no puede cambiarse de perfil";
    public static final String ERROR_PERMISOS = "No se tienen los permisos para realizar esta funcionalidad";
    public static final String USUARIOS_DUPLICADOS = "Ya existe un usuario con ese correo";
    public static final String USUARIO_INEXISTENTE = "No existe el usuario especificado";
    public static final String VALIDACION_EXITO = "Los datos del usuario son correctos";

    // Atributos de GestosUsuarios:
    private List<Usuario> usuarios = new ArrayList<>();
    
    // Implementación del patrón de diseño singleton:
    private static GestorUsuarios gestor;
    private GestorUsuarios(){}
    public static GestorUsuarios instanciar(){
        if (gestor==null)
            gestor = new GestorUsuarios();
        return gestor;
    }

    // Métodos:
    public String crearUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida) {
        String validacion = validarDatos(correo, apellido, nombre, perfil, clave, claveRepetida);
        if (!validacion.equals(VALIDACION_EXITO))
            return validacion;
        else {
            Usuario nuevoUsuario = generarUsuario(correo, apellido, nombre, perfil, clave);
            if (existeEsteUsuario(nuevoUsuario))
                return USUARIOS_DUPLICADOS;
            else {
                usuarios.add(nuevoUsuario);
                return EXITO;
            }
        }
    }

    public List<Usuario> verUsuarios() {
        return usuarios;
    }

    public List<Usuario> buscarUsuarios(String apellido){
        List<Usuario> userEncontrados = new ArrayList<>();
        if (apellido != null) {
            for(Usuario user : this.usuarios){
                if (user.verApellido().toLowerCase().contains(apellido.toLowerCase()))
                    userEncontrados.add(user);
            }
        }
        return userEncontrados;
    }

    public boolean existeEsteUsuario(Usuario usuario) {
        return usuarios.contains(usuario);
    }

    public Usuario obtenerUsuario(String correo) {
        for (Usuario user : usuarios) {
            if (user.verCorreo().equals(correo))
                return user;
        }
        System.out.println("No existen usuarios con el correo ingresado");
        return null;
    }

    // Métodos auxiliares:
    private String validarDatos(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida){
        if (correo == null || !correo.contains("@"))
            return ERROR_CORREO;
        if (apellido == null || apellido.isEmpty())
            return ERROR_APELLIDO;
        if (nombre == null || nombre.isEmpty())
            return ERROR_NOMBRE;
        if (perfil == null)
            return ERROR_PERFIL;
        if (clave == null || clave.isEmpty())
            return ERROR_CLAVES;
        if (claveRepetida == null || claveRepetida.isEmpty())
            return ERROR_CLAVES;
        return VALIDACION_EXITO;
    }

    private Usuario generarUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave){
        Usuario unUsuario = null;
        switch (perfil) {
            case CLIENTE:
                unUsuario = new Cliente(correo, apellido, nombre, clave);
                break;
            case EMPLEADO:
                unUsuario = new Empleado(correo, apellido, nombre, clave);
                break;
            case ENCARGADO:
                unUsuario = new Encargado(correo, apellido, nombre, clave);
                break;
        }
        return unUsuario;
    }
}
