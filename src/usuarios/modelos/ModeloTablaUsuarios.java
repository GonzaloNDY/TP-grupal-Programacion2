package usuarios.modelos;

import interfaces.IGestorUsuarios;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModeloTablaUsuarios extends AbstractTableModel {
    private List<String> nombreColumnas = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();

    public ModeloTablaUsuarios(List<Usuario> usuarios) {
        this.nombreColumnas.add("Apellidos");
        this.nombreColumnas.add("Nombres");
        this.nombreColumnas.add("Perfil");
        IGestorUsuarios gu = GestorUsuarios.instanciar();
        this.usuarios = gu.verUsuarios();
    }

    @Override
    public int getRowCount() {
        return this.usuarios.size();
    }

    @Override
    public int getColumnCount() {
        return this.nombreColumnas.size();
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        Usuario u = this.usuarios.get(fila);
        switch(columna) {
            case 0 : return u.verApellido();
            case 1 : return u.verNombre();
            default : return obtenerPerfil(u);
        }
    }

    @Override
    public String getColumnName(int columna) {
        return this.nombreColumnas.get(columna);
    }

    private String obtenerPerfil(Usuario usuario) {
        if (usuario instanceof Cliente) {
            return "Cliente";
        }
        if (usuario instanceof Empleado) {
            return "Empleado";
        }
        else {
            return "Encargado";
        }
    }
}