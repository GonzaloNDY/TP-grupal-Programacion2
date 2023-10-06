
package principal.controladores;

import java.util.ArrayList;
import productos.modelos.Categoria;
import productos.modelos.Estado;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;
import usuarios.modelos.Empleado;
import usuarios.modelos.Encargado;

public class ControladorPrincipal {

    public static void main(String[] args) {
        // Definición de un arrraylist para cada clase:
        ArrayList<Cliente> listaDeClientes = new ArrayList<>();
        ArrayList<Empleado> listaDeEmpleados = new ArrayList<>();
        ArrayList<Encargado> listaDeEncargados = new ArrayList<>();
        ArrayList<Producto> listaDeProductos = new ArrayList<>();
        
        // Instanciamiento de 3 objetos para cada clase:
        Cliente cliente1 = new Cliente("Diaz", "Gonzalo", "qwerty@gmail.com", "ytrewq");
        Cliente cliente2 = new Cliente("Neptali", "Yarahuaman", "asdfg@gmail.com", "gfdsa");
        Cliente cliente3 = new Cliente("Colman", "Nicolas", "zxcvb@gmail.com", "bvcxz");

        Empleado empleado1 = new Empleado("Mario", "Diaz", "qwerty@gmail.com", "ytrewq");
        Empleado empleado2 = new Empleado("Diego", "Wilfredo", "asdfg@gmail.com", "gfdsa");
        Empleado empleado3 = new Empleado("Eduardo", "Diaz", "zxcvb@gmail.com", "bvcxz");

        Encargado encargado1 = new Encargado("Juan", "Sanchez", "qwerty@gmail.com", "ytrewq");
        Encargado encargado2 = new Encargado("Carlos", "Perez", "asdfg@gmail.com", "gfdsa");
        Encargado encargado3 = new Encargado("Gabriel", "Diaz", "zxcvb@gmail.com", "bvcxz");

        Producto producto1 = new Producto(1234, "Taza de café", 500f, "ENTRADA", "DISPONIBLE");
        Producto producto2 = new Producto(5678, "Milanesa con papas", 1500.00f, "PLATO_PRINCIPAL", "DISPONIBLE");
        Producto producto3 = new Producto(9876, "Flan de leche", 400f, "ENTRADA", "DISPONIBLE");
        
        // Adición de objetos a sus respectivos arraylist:
        listaDeClientes.add(cliente1);
        listaDeClientes.add(cliente2);
        listaDeClientes.add(cliente3);
        
        listaDeEmpleados.add(empleado1);
        listaDeEmpleados.add(empleado2);
        listaDeEmpleados.add(empleado3);
        
        listaDeEncargados.add(encargado1);
        listaDeEncargados.add(encargado2);
        listaDeEncargados.add(encargado3);
        
        listaDeProductos.add(producto1);
        listaDeProductos.add(producto2);
        listaDeProductos.add(producto3);
        
        // Muestra de la información de los objetos:
        System.out.println("\n-------Clientes-------\n");
        for (Cliente unCliente : listaDeClientes) {
            unCliente.mostrarInformacion();
        }
        /* Punto 10.e del tp2:
        cliente2.asignarApellido("Pérez");
        cliente2.asignarNombre("Pablo");
        cliente1.asignarCorreo("aeiou@gmail.com");
        cliente3.asignarCorreo("unCorreo@gmail.com");
        for (Cliente unCliente : listaDeClientes) {
            unCliente.mostrarInformacion();
        } */
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
            System.out.println(unProducto);;
        }
    }
}