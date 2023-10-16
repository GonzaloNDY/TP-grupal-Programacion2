package principal.controladores;

import java.time.LocalDateTime;
import productos.modelos.Producto;
import usuarios.modelos.Encargado;
import usuarios.modelos.Empleado;
import usuarios.modelos.Cliente;
import java.util.ArrayList;
import pedidos.modelos.EstadoPedido;
import pedidos.modelos.Pedido;
import pedidos.modelos.ProductoDelPedido;
import productos.modelos.Categoria;
import productos.modelos.Estado;

public class ControladorPrincipal  {
    public static void main(String[] args) {
        // Definición de un arrraylist para cada clase:
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Empleado> empleados = new ArrayList<>();
        ArrayList<Encargado> encargados = new ArrayList<>();
        ArrayList<Producto> productos = new ArrayList<>();
        ArrayList<Pedido> pedidos = new ArrayList<>();
        
        // Clientes:
        Cliente unCliente1 = new Cliente("cliente1@bar.com", "claveCliente1", "ApellidoCliente1", "NombreCliente1");        
        Cliente unCliente2 = new Cliente("cliente2@bar.com", "claveCliente2", "ApellidoCliente2", "NombreCliente2");       
        Cliente unCliente3 = new Cliente("cliente3@bar.com", "claveCliente3", "ApellidoCliente3", "NombreCliente3");
        
        clientes.add(unCliente1);
        clientes.add(unCliente2);
        clientes.add(unCliente3);
        
        System.out.println("Clientes");
        System.out.println("========");
        for(Cliente c : clientes) {
            c.mostrar();
        }
        System.out.println();        
        
        // Empleados:
        Empleado unEmpleado1 = new Empleado("empleado1@bar.com", "claveEmpleado1", "ApellidoEmpleado1", "NombreEmpleado1");        
        Empleado unEmpleado2 = new Empleado("empleado2@bar.com", "claveEmpleado2", "ApellidoEmpleado2", "NombreEmpleado2");        
        Empleado unEmpleado3 = new Empleado("empleado3@bar.com", "claveEmpleado3", "ApellidoEmpleado3", "NombreEmpleado3");
                
        empleados.add(unEmpleado1);
        empleados.add(unEmpleado2);
        empleados.add(unEmpleado3);
        
        System.out.println("Empleados");
        System.out.println("=========");
        for(Empleado e : empleados) {
            e.mostrar();
        }
        System.out.println();
        
        // Encargados:
        Encargado unEncargado1 = new Encargado("encargado1@bar.com", "claveEncargado1", "ApellidoEncargado1", "NombreEncargado1");
        Encargado unEncargado2 = new Encargado("encargado2@bar.com", "claveEncargado2", "ApellidoEncargado2", "NombreEncargado2");
        Encargado unEncargado3 = new Encargado("encargado3@bar.com", "claveEncargado3", "ApellidoEncargado3", "NombreEncargado3");

        encargados.add(unEncargado1);
        encargados.add(unEncargado2);
        encargados.add(unEncargado3);
        
        System.out.println("Encargados");
        System.out.println("==========");
        for(Encargado e : encargados) {
            e.mostrar();
        }
        System.out.println();
        
        // Productos:
        Producto unProducto1 = new Producto(1, "Producto1",1.0f, Categoria.ENTRADA, Estado.DISPONIBLE);        
        Producto unProducto2 = new Producto(2, "Producto2", 2.0f, Categoria.PLATO_PRINCIPAL, Estado.DISPONIBLE);
        Producto unProducto3 = new Producto(3, "Producto3",3.0f, Categoria.POSTRE, Estado.DISPONIBLE);
        
        productos.add(unProducto1);
        productos.add(unProducto2);
        productos.add(unProducto3);
        
        System.out.println("Productos");
        System.out.println("=========");
        for(Producto p : productos) {
            p.mostrar();
        }
        System.out.println();

        // Punto 10.e del tp2:
        unCliente1.asignarCorreo("cliente10@bar.com");
        System.out.println("Clientes");
        System.out.println("========");
        for(Cliente c : clientes) {
            c.mostrar();
        }
        System.out.println();

      //  System.out.println(unProducto1);
        unProducto2.asignarDescripcion("Producto1234567890");

        // Pedidos:
        ArrayList<ProductoDelPedido> pdp1 = new ArrayList<>();
        pdp1.add(new ProductoDelPedido(unProducto1, 1));
        pdp1.add(new ProductoDelPedido(unProducto2, 2));
        Pedido unPedido1 = new Pedido(1, LocalDateTime.now(), pdp1, unCliente1, EstadoPedido.CREADO );        
        
        ArrayList<ProductoDelPedido> pdp2 = new ArrayList<>();
        pdp2.add(new ProductoDelPedido(unProducto1, 10));
        pdp2.add(new ProductoDelPedido(unProducto2, 20));
        Pedido unPedido2 = new Pedido(2, LocalDateTime.now(), pdp2, unCliente2, EstadoPedido.CREADO );        
        
        ArrayList<ProductoDelPedido> pdp3 = new ArrayList<>();
        pdp3.add(new ProductoDelPedido(unProducto1, 100));
        pdp3.add(new ProductoDelPedido(unProducto2, 200));
        Pedido unPedido3 = new Pedido(3, LocalDateTime.now(), pdp3, unCliente3, EstadoPedido.CREADO);        
        
        pedidos.add(unPedido1);
        pedidos.add(unPedido2);
        pedidos.add(unPedido3);
        
        System.out.println("Pedidos");
        System.out.println("=======");
        for(Pedido p : pedidos) {
            p.mostrar();
        }
        System.out.println();
    }   
}
