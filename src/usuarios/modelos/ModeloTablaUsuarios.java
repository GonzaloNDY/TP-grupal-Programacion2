package usuarios.modelos;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModeloTablaUsuarios extends AbstractTableModel {
    private ArrayList<String> nombreColumnas = new ArrayList<>();
    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public ModeloTablaUsuarios(ArrayList<Usuario> usuarios) {
        this.nombreColumnas.add("Apellidos");
        this.nombreColumnas.add("Nombres");
        this.nombreColumnas.add("Perfil");
        this.usuarios = usuarios;
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
        Perfil p = Perfil.valueOf(null);
        switch(columna) {
            case 0 : return u.verApellido();
            case 1 : return u.verNombre();
            default : return p.verPerfil();
        }
    }

    @Override
    public String getColumnName(int columna) {
        return this.nombreColumnas.get(columna);
    }
}
