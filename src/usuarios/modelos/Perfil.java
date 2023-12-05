package usuarios.modelos;

public enum Perfil {
    // Perfiles disponibles:
    CLIENTE("Cliente"),
    EMPLEADO("Empleado"),
    ENCARGADO("Encargado");
        
    private String valor;

    // Constructor para inicializar el valor de perfil:
    private Perfil(String valor) {
        this.valor = valor;
    }

    public String verPerfil() {
        return valor;
    }

    public void asignarPerfil(String valor) {
        this.valor = valor;
    }

    // Devuelve un valor legible de perfil:
    @Override
    public String toString() {
        return this.valor;
    }
}
