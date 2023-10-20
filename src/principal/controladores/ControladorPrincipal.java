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
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        ArrayList<Encargado> listaEncargados = new ArrayList<>();
        ArrayList<Producto> listaProductos = new ArrayList<>();
        ArrayList<Pedido> listaPedidos = new ArrayList<>();
        
        // Clientes:
        Cliente unCliente1 = new Cliente("cliente1@bar.com", "claveCliente1", "ApellidoCliente1", "NombreCliente1");        
        Cliente unCliente2 = new Cliente("cliente2@bar.com", "claveCliente2", "ApellidoCliente2", "NombreCliente2");       
        Cliente unCliente3 = new Cliente("cliente3@bar.com", "claveCliente3", "ApellidoCliente3", "NombreCliente3");
        
        listaClientes.add(unCliente1);
        listaClientes.add(unCliente2);
        listaClientes.add(unCliente3);
        
        System.out.println("Clientes");
        System.out.println("========");
        for(Cliente c : listaClientes) {
            c.mostrar();
        }
        System.out.println();        
        
        // Empleados:
        Empleado unEmpleado1 = new Empleado("empleado1@bar.com", "claveEmpleado1", "ApellidoEmpleado1", "NombreEmpleado1");        
        Empleado unEmpleado2 = new Empleado("empleado2@bar.com", "claveEmpleado2", "ApellidoEmpleado2", "NombreEmpleado2");        
        Empleado unEmpleado3 = new Empleado("empleado3@bar.com", "claveEmpleado3", "ApellidoEmpleado3", "NombreEmpleado3");
                
        listaEmpleados.add(unEmpleado1);
        listaEmpleados.add(unEmpleado2);
        listaEmpleados.add(unEmpleado3);
        
        System.out.println("Empleados");
        System.out.println("=========");
        for(Empleado e : listaEmpleados) {
            e.mostrar();
        }
        System.out.println();
        
        // Encargados:
        Encargado unEncargado1 = new Encargado("encargado1@bar.com", "claveEncargado1", "ApellidoEncargado1", "NombreEncargado1");
        Encargado unEncargado2 = new Encargado("encargado2@bar.com", "claveEncargado2", "ApellidoEncargado2", "NombreEncargado2");
        Encargado unEncargado3 = new Encargado("encargado3@bar.com", "claveEncargado3", "ApellidoEncargado3", "NombreEncargado3");

        listaEncargados.add(unEncargado1);
        listaEncargados.add(unEncargado2);
        listaEncargados.add(unEncargado3);
        
        System.out.println("Encargados");
        System.out.println("==========");
        for(Encargado e : listaEncargados) {
            e.mostrar();
        }
        System.out.println();
        
        // Productos:
        Producto unProducto1 = new Producto(1, "Producto1",100.0f, Categoria.ENTRADA, Estado.DISPONIBLE);        
        Producto unProducto2 = new Producto(2, "Producto2", 200.0f, Categoria.PLATO_PRINCIPAL, Estado.DISPONIBLE);
        Producto unProducto3 = new Producto(3, "Producto3",300.0f, Categoria.POSTRE, Estado.DISPONIBLE);
        Producto unProducto4 = new Producto(4, "Producto4", 400.0f, Categoria.POSTRE, Estado.NO_DISPONIBLE);
        Producto unProducto5 = new Producto(3, "Producto5", 500.0f, Categoria.POSTRE, Estado.NO_DISPONIBLE);
        // Verifico si hay productos repetidos:
        if (!listaProductos.contains(unProducto1))
            listaProductos.add(unProducto1);
        if (!listaProductos.contains(unProducto2))
            listaProductos.add(unProducto2);
        if (!listaProductos.contains(unProducto3))
            listaProductos.add(unProducto3);
        if (!listaProductos.contains(unProducto4))
            listaProductos.add(unProducto4);
        if (!listaProductos.contains(unProducto5))
            listaProductos.add(unProducto5);    // Producto 5 no se agregará
        
        System.out.println("Productos");
        System.out.println("=========");
        for(Producto p : listaProductos) {
            p.mostrar();
        }
        System.out.println();

        // Punto 10.e del tp2:
        unCliente1.asignarCorreo("cliente10@bar.com");
        System.out.println("Clientes");
        System.out.println("========");
        for(Cliente c : listaClientes) {
            c.mostrar();
        }
        System.out.println();
        unProducto2.asignarDescripcion("Producto1234567890");

        // Pedidos:
        ArrayList<ProductoDelPedido> listapdp1 = new ArrayList<>();
        ProductoDelPedido pdp1 = new ProductoDelPedido(unProducto1, 1);
        ProductoDelPedido pdp2 = new ProductoDelPedido(unProducto2, 2);
        // Verifico si hay productos repetidos en listapdp1:
        if (!listapdp1.contains(pdp1))
            listapdp1.add(pdp1);
        if (!listapdp1.contains(pdp2))
            listapdp1.add(pdp2);
        Pedido unPedido1 = new Pedido(1, LocalDateTime.now(), listapdp1, unCliente1, EstadoPedido.CREADO );        
        
        ArrayList<ProductoDelPedido> listapdp2 = new ArrayList<>();
        ProductoDelPedido pdp3 = new ProductoDelPedido(unProducto1, 10);
        ProductoDelPedido pdp4 = new ProductoDelPedido(unProducto2, 20);
        // Verifico si hay productos repetidos en listapdp2:
        if (!listapdp2.contains(pdp3))
            listapdp2.add(pdp3);
        if (!listapdp2.contains(pdp4))
            listapdp2.add(pdp4);
        Pedido unPedido2 = new Pedido(2, LocalDateTime.now(), listapdp2, unCliente2, EstadoPedido.CREADO );         
        
        ArrayList<ProductoDelPedido> listapdp3 = new ArrayList<>();
        ProductoDelPedido pdp5 = new ProductoDelPedido(unProducto4, 30);
        ProductoDelPedido pdp6 = new ProductoDelPedido(unProducto3, 70);
        ProductoDelPedido pdp7 = new ProductoDelPedido(unProducto5, 70);
        // Verifico si hay productos repetidos en listapdp3:
        if (!listapdp3.contains(pdp5))
            listapdp3.add(pdp5);
        if (!listapdp3.contains(pdp6))
            listapdp3.add(pdp6);
        if (!listapdp3.contains(pdp7))
            listapdp3.add(pdp7);
        Pedido unPedido3 = new Pedido(3, LocalDateTime.now(), listapdp3, unCliente3, EstadoPedido.CREADO );
        
        ArrayList<ProductoDelPedido> listapdp4 = new ArrayList<>();
        ProductoDelPedido pdp8 = new ProductoDelPedido(unProducto2, 20);
        ProductoDelPedido pdp9 = new ProductoDelPedido(unProducto1, 10);
        ProductoDelPedido pdp10 = new ProductoDelPedido(unProducto2, 20);
        ProductoDelPedido pdp11 = new ProductoDelPedido(unProducto3, 10);
        // Verifico si hay productos repetidos en listapdp4:
        if (!listapdp4.contains(pdp8))
            listapdp4.add(pdp8);
        if (!listapdp4.contains(pdp9))
            listapdp4.add(pdp9);
        if (!listapdp4.contains(pdp10))
            listapdp4.add(pdp10);   //pdp10 no se guardará
        if (!listapdp4.contains(pdp11))
            listapdp4.add(pdp11);
        Pedido unPedido4 = new Pedido(4, LocalDateTime.now(), listapdp4, unCliente2, EstadoPedido.CREADO );   
        
        // Verifico si hay pedidos repetidos:
        if (!listaPedidos.contains(unPedido1))
            listaPedidos.add(unPedido1);
        if (!listaPedidos.contains(unPedido2))
            listaPedidos.add(unPedido2);
        if (!listaPedidos.contains(unPedido3))
            listaPedidos.add(unPedido3);
        if (!listaPedidos.contains(unPedido4))
            listaPedidos.add(unPedido4);

        System.out.println("Pedidos");
        System.out.println("=======");
        for(Pedido p : listaPedidos) {
            p.mostrar();
        }
        System.out.println();
    }
}
