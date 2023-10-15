package principal.controladores;

import java.time.LocalDateTime;
import java.util.ArrayList;
import pedidos.modelos.EstadoPedido;
import pedidos.modelos.Pedido;
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
        ArrayList<Pedido> listaDePedidos = new ArrayList<>();

        // Clientes:
        Cliente cliente1 = new Cliente("Diaz", "Gonzalo", "qwerty@gmail.com", "ytrewq");
        Cliente cliente2 = new Cliente("Neptali", "Yarahuaman", "asdfg@gmail.com", "gfdsa");
        Cliente cliente3 = new Cliente("Colman", "Nicolas", "zxcvb@gmail.com", "bvcxz");

        listaDeClientes.add(cliente1);
        listaDeClientes.add(cliente2);
        listaDeClientes.add(cliente3);

        System.out.println("Clientes");
        System.out.println("========");
        for (Cliente unCliente : listaDeClientes) {
            unCliente.mostrar();
        }
        System.out.println();

        // Empleados:
        Empleado empleado1 = new Empleado("Mario", "Diaz", "qwerty@gmail.com", "ytrewq");
        Empleado empleado2 = new Empleado("Diego", "Wilfredo", "asdfg@gmail.com", "gfdsa");
        Empleado empleado3 = new Empleado("Eduardo", "Diaz", "zxcvb@gmail.com", "bvcxz");

        listaDeEmpleados.add(empleado1);
        listaDeEmpleados.add(empleado2);
        listaDeEmpleados.add(empleado3);

        System.out.println("Empleados");
        System.out.println("=========");
        for (Empleado unEmpleado : listaDeEmpleados) {
            unEmpleado.mostrar();
        }
        System.out.println();

        //Encargados
        Encargado encargado1 = new Encargado("Juan", "Sanchez", "qwerty@gmail.com", "ytrewq");
        Encargado encargado2 = new Encargado("Carlos", "Perez", "asdfg@gmail.com", "gfdsa");
        Encargado encargado3 = new Encargado("Gabriel", "Diaz", "zxcvb@gmail.com", "bvcxz");

        listaDeEncargados.add(encargado1);
        listaDeEncargados.add(encargado2);
        listaDeEncargados.add(encargado3);

        System.out.println("Encargados");
        System.out.println("==========");
        for (Encargado unEncargado : listaDeEncargados) {
            unEncargado.mostrar();
        }
        System.out.println();

        // Productos:
        Producto producto1 = new Producto(1234, "Taza de cafe", 500f, Categoria.ENTRADA, Estado.DISPONIBLE);
        Producto producto2 = new Producto(5678, "Milanesa con papas", 1500.00f, Categoria.PLATO_PRINCIPAL, Estado.DISPONIBLE);
        Producto producto3 = new Producto(9876, "Flan de leche", 400f, Categoria.POSTRE, Estado.NO_DISPONIBLE);

        listaDeProductos.add(producto1);
        listaDeProductos.add(producto2);
        listaDeProductos.add(producto3);

        System.out.println("Productos");
        System.out.println("=========");
        for (Producto unProducto : listaDeProductos) {
            unProducto.mostrar();
        }
        System.out.println();

        // Punto 10.e del tp2:
        System.out.println("=================");
        cliente1.asignarCorreo("modificado@gmail.com");
        System.out.println("Clientes");
        System.out.println("========");
        for (Cliente unCliente : listaDeClientes) {
            unCliente.mostrar();
        }

        System.out.println(producto1);
        System.out.println("================");

        // Pedidos:
        /*  ArrayList<ProductoDelPedido> pdp1 = new ArrayList<>();
        pdp1.add(new ProductoDelPedido(producto1, 1));
        pdp1.add(new ProductoDelPedido(producto2, 2));
        Pedido pedido1 = new Pedido(1, LocalDateTime.now(), pdp1, cliente1);        

        ArrayList<ProductoDelPedido> pdp2 = new ArrayList<>();
        pdp2.add(new ProductoDelPedido(producto1, 10));
        pdp2.add(new ProductoDelPedido(producto2, 20));
        Pedido pedido2 = new Pedido(2, LocalDateTime.now(), pdp2, cliente2);        

        ArrayList<ProductoDelPedido> pdp3 = new ArrayList<>();
        pdp3.add(new ProductoDelPedido(producto1, 100));
        pdp3.add(new ProductoDelPedido(producto2, 200));
        Pedido pedido3 = new Pedido(3, LocalDateTime.now(), pdp3, cliente3);    */
      
        listaDePedidos.add(pedido1);
        listaDePedidos.add(pedido2);
        listaDePedidos.add(pedido3);

        System.out.println("Pedidos");
        System.out.println("=======");
        for (Pedido unPedido : listaDePedidos) {
            unPedido.mostrar();
        }
        System.out.println();
    }
}
