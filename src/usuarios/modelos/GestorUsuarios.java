package usuarios.modelos;

import interfaces.IGestorPedidos;
import interfaces.IGestorUsuarios;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import pedido.modelos.GestorPedidos;

public class GestorUsuarios implements IGestorUsuarios {

    // Atributos de GestosUsuarios:
    private List<Usuario> usuarios = new ArrayList<>();

    // Implementación del patrón de diseño singleton:
    private static GestorUsuarios gestor;

    private GestorUsuarios() {
        this.usuarios = new ArrayList<>();
    }

    public static GestorUsuarios instanciar() {
        if (gestor == null) {
            gestor = new GestorUsuarios();
        }
        return gestor;
    }

    // Implementación de métodos:
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
        List<Usuario> todosLosUsuarios = new ArrayList<>(usuarios);
        Comparator<Usuario> uComp = (u1, u2) -> {
            int resultado = u1.verApellido().toLowerCase().compareTo(u2.verApellido().toLowerCase());
            if (resultado == 0) {
                resultado = u1.verNombre().toLowerCase().compareTo(u2.verNombre().toLowerCase());
            }
            return resultado;
        };
        todosLosUsuarios.sort(uComp);

        return todosLosUsuarios;
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
            Comparator<Usuario> uComp = (u1, u2) -> {
                int resultado = u1.verApellido().toLowerCase().compareTo(u2.verApellido().toLowerCase());
                if (resultado == 0) {
                    resultado = u1.verNombre().toLowerCase().compareTo(u2.verNombre().toLowerCase());
                }
                return resultado;
            };
            userEncontrados.sort(uComp);

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
        return null;
    }

    @Override
    public String borrarUsuario(Usuario usuario) {
        if (!existeEsteUsuario(usuario)) {
            return USUARIO_INEXISTENTE;
        }
        IGestorPedidos pedidos = GestorPedidos.instanciar();
        if (pedidos.hayPedidosConEsteCliente((Cliente) usuario)) {
            return ERROR_PERMISOS;
        } else {
            usuarios.remove(usuario);
            return EXITO_BORRADO;
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
