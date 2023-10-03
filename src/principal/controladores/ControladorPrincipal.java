
package principal.controladores;

import java.util.ArrayList;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;
import usuarios.modelos.Empleado;
import usuarios.modelos.Encargado;

public class ControladorPrincipal {
        
    public static void main(String[] args) {

        // Clientes:
        Cliente cliente1 = new Cliente("Diaz", "Gonzalo", "qwerty@gmail.com", "ytrewq");
        Cliente cliente2 = new Cliente("Neptali", "Yarahuaman", "asdfg@gmail.com", "gfdsa");
        Cliente cliente3 = new Cliente("Colman", "Nicolas", "zxcvb@gmail.com", "bvcxz");

        // Empleados:
        Empleado empleado1 = new Empleado("Mario", "Diaz", "qwerty@gmail.com", "ytrewq");
        Empleado empleado2 = new Empleado("Diego", "Wilfredo", "asdfg@gmail.com", "gfdsa");
        Empleado empleado3 = new Empleado("Eduardo", "Diaz", "zxcvb@gmail.com", "bvcxz");

        // Encargados:
        Encargado encargado1 = new Encargado("Juan", "Sanchez", "qwerty@gmail.com", "ytrewq");
        Encargado encargado2 = new Encargado("Carlos", "Perez", "asdfg@gmail.com", "gfdsa");
        Encargado encargado3 = new Encargado("Gabriel", "Diaz", "zxcvb@gmail.com", "bvcxz");

        // Productos:
        Producto producto1 = new Producto(1234, "Taza de café", 500.00f, "Entrada", "Disponible");
        Producto producto2 = new Producto(5678, "Milanesa con papas", 1500.00f, "Plato principal", "Disponible");
        Producto producto3 = new Producto(9012, "Flan de leche", 300.00f, "Postre", "Disponible");
        
        // Definición de un arrraylist e instanciamiento de 3 objetos para cada clase:
        
        ArrayList<Cliente> listaDeClientes = new ArrayList<>();
        listaDeClientes.add(cliente1);
        listaDeClientes.add(cliente2);
        listaDeClientes.add(cliente3);
        
        ArrayList<Empleado> listaDeEmpleados = new ArrayList<>();
        listaDeEmpleados.add(empleado1);
        listaDeEmpleados.add(empleado2);
        listaDeEmpleados.add(empleado3);
        
        ArrayList<Encargado> listaDeEncargados = new ArrayList<>();
        listaDeEncargados.add(encargado1);
        listaDeEncargados.add(encargado2);
        listaDeEncargados.add(encargado3);
        
        ArrayList<Producto> listaDeProductos = new ArrayList<>();
        listaDeProductos.add(producto1);
        listaDeProductos.add(producto2);
        listaDeProductos.add(producto3);
        
        System.out.println("\n-------Clientes-------\n");
        for (Cliente unCliente : listaDeClientes) {
            unCliente.mostrarInformacion();
        }
        
        System.out.println("\n-------Empleados-------\n");
        for (Empleado unEmpleado : listaDeEmpleados) {
            unEmpleado.mostrarInformacion();
        }
        
        System.out.println("\n-------Encargados-------\n");
        for (Encargado unEncargado : listaDeEncargados) {
            unEncargado.mostrarInformacion();
        }
        
        System.out.println("\n-------Productos-------\n");
        for (Producto unProducto : listaDeProductos) {
            unProducto.mostrarInformacion();
        }
    }
}