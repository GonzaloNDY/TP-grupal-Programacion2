package usuarios.modelos;

import interfaces.IGestorPedidos;
import interfaces.IGestorUsuarios;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
        this.leerArchivo();
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
                this.escribirArchivo();
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
        }            
        Comparator<Usuario> uComp = (u1, u2) -> {
            int resultado = u1.verApellido().toLowerCase().compareTo(u2.verApellido().toLowerCase());
            if (resultado == 0) {
                resultado = u1.verNombre().toLowerCase().compareTo(u2.verNombre().toLowerCase());
            }
            return resultado;
        };
        userEncontrados.sort(uComp);
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
        } if (usuario instanceof Cliente) {
            IGestorPedidos pedidos = GestorPedidos.instanciar();
            if (pedidos.hayPedidosConEsteCliente((Cliente) usuario)) {
                return ERROR_PERMISOS;
            }
        }
        usuarios.remove(usuario);
        return EXITO_BORRADO;
    }
    
    @Override
    public String modificarUsuario(Usuario usuarioAModificar, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida){
        if (!existeEsteUsuario(usuarioAModificar)) {
            return USUARIO_INEXISTENTE;
        }
        String validacion = validarDatos(usuarioAModificar.verCorreo(),apellido, nombre, perfil, clave, claveRepetida);
        if (!validacion.equals(VALIDACION_EXITO)) {
            return validacion;
        }
        if (obtenerUsuario(usuarioAModificar.verCorreo()) != null) {
            return USUARIOS_DUPLICADOS;
        } else {
            usuarioAModificar.asignarApellido(apellido);
            usuarioAModificar.asignaNombre(nombre);
            usuarioAModificar.asignaClave(clave);
            return EXITO;
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

    public void escribirArchivo() {
        leerArchivo();                      // se puede poner en otra parte
        File f = new File("usuarios");
        BufferedWriter bw = null;
        try {
            FileWriter fw = new FileWriter(f, false);
            bw = new BufferedWriter(fw);
            for (Usuario u : usuarios) {
                String linea;
                linea = u.verCorreo() + ",";
                linea += u.verApellido() + ",";
                linea += u.verNombre() + ",";
                linea += u.verClave() + ",";
                linea += obtenerPerfilUsuario(u) + ",";
                bw.write(linea);
                bw.newLine();
            }
            bw.flush();
            fw.close();
            bw.close();
        } catch (IOException ioe) {
            System.out.println("Problemas en la lectura del archivo");
            ioe.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException ioe) {
                    System.out.println("Problemas en la creacion del archivo");
                    ioe.printStackTrace();
                }
            }
        }
        // Fin del bloque try/catch/finally
    }

    private void leerArchivo() {
        File f = new File("usuarios");  // cambiar por caden constante
        if (f.exists()) {
            BufferedReader br = null;
            // Inicio del bloque try/catch/finally
            try {
                FileReader fr = new FileReader(f);
                br = new BufferedReader(fr);
                String linea;
                while ((linea = br.readLine()) != null) {
                    String[] vector = linea.split(",");
                    String correo = vector[0];
                    String apellido = vector[1];
                    String nombre = vector[2];
                    String clave = vector[3];
                    Perfil perfil = Perfil.valueOf(vector[4].toUpperCase());
                    crearUsuario(correo, apellido, nombre, perfil, clave, clave);

                }
            } catch (IOException ioe) {
                System.out.println("Problemas en la lectura del archivo");
                ioe.printStackTrace();
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException ioe) {
                        System.out.println("Problemas en la lectura del archivo");
                        ioe.printStackTrace();
                    }
                }
            }
            // Fin del bloque try/catch/finally
        }
    }

    public String obtenerPerfilUsuario(Usuario unUsuario) {

        Class<?> claseDelObjeto = unUsuario.getClass();
        String perfil = claseDelObjeto.getName();
        String[] partes = perfil.split("\\.");
        String ultimaParte = partes[partes.length - 1];

        return ultimaParte;
    }
}
