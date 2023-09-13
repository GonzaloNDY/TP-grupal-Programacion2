
package unPaquete;

import java.util.ArrayList;

public class ControladorPrincipal {
        
    public static void main(String[] args) {

        // Clientes:
        Cliente cliente1 = new Cliente();
        cliente1.correo = "qwerty@gmail.com";
        cliente1.contraseña = "ytrewq";
        cliente1.apellidos = "Diaz";
        cliente1.nombres = "Gonzalo";
        Cliente cliente2 = new Cliente();
        cliente2.correo = "asdfg@gmail.com";
        cliente2.contraseña = "gfdsa";
        cliente2.apellidos = "Yarahuaman";
        cliente2.nombres = "Neptali";
        Cliente cliente3 = new Cliente();
        cliente3.correo = "zxcvb@gmail.com";
        cliente3.contraseña = "bvcxz";
        cliente3.apellidos = "Sonia";
        cliente3.nombres = "Rayo";

        // Empleados:
        Empleado empleado1 = new Empleado();
        empleado1.correo = "qwerty@gmail.com";
        empleado1.contraseña = "ytrewq";
        empleado1.apellidos = "Mario";
        empleado1.nombres = "Puma";
        Empleado empleado2 = new Empleado();
        empleado2.correo = "asdfg@gmail.com";
        empleado2.contraseña = "gfdsa";
        empleado2.apellidos = "Diego";
        empleado2.nombres = "Wilfredo";
        Empleado empleado3 = new Empleado();
        empleado3.correo = "zxcvb@gmail.com";
        empleado3.contraseña = "bvcxz";
        empleado3.apellidos = "Angel";
        empleado3.nombres = "Eduardo";

        // Encargados:
        Encargado encargado1 = new Encargado();
        encargado1.correo = "qwerty@gmail.com";
        encargado1.contraseña = "ytrewq";
        encargado1.apellidos = "Juan";
        encargado1.nombres = "Sanchez";
        Encargado encargado2 = new Encargado();
        encargado2.correo = "asdfg@gmail.com";
        encargado2.contraseña = "gfdsa";
        encargado2.apellidos = "Carlos";
        encargado2.nombres = "Perez";
        Encargado encargado3 = new Encargado();
        encargado3.correo = "zxcvb@gmail.com";
        encargado3.contraseña = "bvcxz";
        encargado3.apellidos = "Gabriel";
        encargado3.nombres = "Diaz";

        // Productos:
        Producto producto1 = new Producto();
        producto1.nombre = "Café";
        producto1.descripcion = "Taza de café";
        producto1.precio = 500.00f;
        producto1.categoria = "Entrada";
        producto1.cantidad = 15;
        Producto producto2 = new Producto();
        producto2.nombre = "Milanesa";
        producto2.descripcion = "Milanesa con papas";
        producto2.precio = 1500.00f;
        producto2.categoria = "Plato principal";
        producto2.cantidad = 10;
        Producto producto3 = new Producto();
        producto3.nombre = "Flan";
        producto3.descripcion = "Flan de leche";
        producto3.precio = 300.00f;
        producto3.categoria = "Postre";
        producto3.cantidad = 0;
        
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
