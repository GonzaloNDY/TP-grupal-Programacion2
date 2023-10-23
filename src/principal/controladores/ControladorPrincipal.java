package principal.controladores;

import java.time.LocalDateTime;
import productos.modelos.Producto;
import usuarios.modelos.Encargado;
import usuarios.modelos.Empleado;
import usuarios.modelos.Cliente;
import java.util.ArrayList;
import java.util.Arrays;
import pedidos.modelos.EstadoPedido;
import pedidos.modelos.Pedido;
import pedidos.modelos.ProductoDelPedido;
import productos.modelos.Categoria;
import productos.modelos.Estado;
import usuarios.modelos.Usuario;

public class ControladorPrincipal {

    public static void main(String[] args) {
        // Definición de un arrraylist para cada clase:
        ArrayList<Producto> listaProductos = new ArrayList<>();
        ArrayList<Pedido> listaPedidos = new ArrayList<>();
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        // Lista para ahorrar lineas de codigo y hacer la comparacion para agregar o no a listaUsuario
        ArrayList<Usuario> listaAuxiliarUsuarios = new ArrayList<>();

        // Clientes:
        Usuario unCliente1 = new Cliente("ApellidoCliente1", "NombreCliente1", "cliente1@bar.com", "claveCliente1");
        Usuario unCliente2 = new Cliente("ApellidoCliente2", "NombreCliente2", "cliente2@bar.com", "claveCliente2");
        Usuario unCliente3 = new Cliente("ApellidoCliente3", "NombreCliente3", "cliente3@bar.com", "claveCliente3");
        Usuario unCliente4 = new Cliente("ApellidoCliente4", "NombreCliente4", "cliente4@bar.com", "claveCliente4");
        Usuario unCliente5 = new Cliente("ApellidoCliente5", "NombreCliente5", "cliente1@bar.com", "claveCliente5");
        Usuario unCliente6 = new Cliente("ApellidoCliente6", "NombreCliente6", "cliente1@bar.com", "claveCliente6");

        // Empleados:
        Usuario unEmpleado1 = new Empleado("ApellidoEmpleado1", "NombreEmpleado1", "empleado1@bar.com", "claveEmpleado1");
        Usuario unEmpleado2 = new Empleado("ApellidoEmpleado2", "NombreEmpleado2", "empleado2@bar.com", "claveEmpleado2");
        Usuario unEmpleado3 = new Empleado("ApellidoEmpleado3", "NombreEmpleado3", "empleado3@bar.com", "claveEmpleado3");
        Usuario unEmpleado4 = new Empleado("ApellidoEmpleado4", "NombreEmpleado4", "cliente1@bar.com", "claveEmpleado4");
        Usuario unEmpleado5 = new Empleado("ApellidoEmpleado5", "NombreEmpleado5", "cliente1@bar.com", "claveEmpleado5");
        Usuario unEmpleado6 = new Empleado("ApellidoEmpleado6", "NombreEmpleado6", "empleado6@bar.com", "claveEmpleado6");

        // Encargados:
        Usuario unEncargado1 = new Encargado("ApellidoEncargado1", "NombreEncargado1", "encargado1@bar.com", "claveEncargado1");
        Usuario unEncargado2 = new Encargado("ApellidoEncargado2", "NombreEncargado2", "encargado2@bar.com", "claveEncargado2");
        Usuario unEncargado3 = new Encargado("ApellidoEncargado3", "NombreEncargado3", "encargado3@bar.com", "claveEncargado3");
        Usuario unEncargado4 = new Encargado("ApellidoEncargado4", "NombreEncargado4", "cliente1@bar.com", "claveEncargado4");
        Usuario unEncargado5 = new Encargado("ApellidoEncargado5", "NombreEncargado5", "encargado5@bar.com", "claveEncargado5");
        Usuario unEncargado6 = new Encargado("ApellidoEncargado6", "NombreEncargado6", "cliente1@bar.com", "claveEncargado6");

        // Agrego los objetos 
        listaAuxiliarUsuarios.addAll(Arrays.asList(unCliente1, unCliente2, unCliente3, unCliente4, unCliente5, unCliente6));
        listaAuxiliarUsuarios.addAll(Arrays.asList(unEmpleado1, unEmpleado2, unEmpleado3, unEmpleado4, unEmpleado5, unEmpleado6));
        listaAuxiliarUsuarios.addAll(Arrays.asList(unEncargado1, unEncargado2, unEncargado3, unEncargado4, unEncargado5, unEncargado6));
        
        // No se crearian los nuevos usuarios que hayan ingresado un correo repetido "cliente1@bar.com"
        for (Usuario u : listaAuxiliarUsuarios) {
            if (!listaUsuarios.contains(u))
            {
                listaUsuarios.add(u);
            }
        }

        // Mostrar Usuarios:
        System.out.println("Clientes");
        System.out.println("========");
        for (Usuario u : listaUsuarios) {
            if (u instanceof Cliente) {
                u.mostrar();
            }
        }
        System.out.println();
        
        System.out.println("Empleados");
        System.out.println("=========");
        for (Usuario u : listaUsuarios) {
            if (u instanceof Empleado) {
                u.mostrar();
            }
        }
        System.out.println();
        
        System.out.println("Encargados");
        System.out.println("==========");
        for (Usuario u : listaUsuarios) {
            if (u instanceof Encargado) {
                u.mostrar();
            }
        }
         System.out.println();
         
        System.out.println("TODOS");
        System.out.println("==========");
        for (Usuario u : listaUsuarios) {
                u.mostrar();
            
        }
         System.out.println();

        // Productos:
        Producto unProducto1 = new Producto(1, "Producto1", 100.0f, Categoria.ENTRADA, Estado.DISPONIBLE);
        Producto unProducto2 = new Producto(2, "Producto2", 200.0f, Categoria.PLATO_PRINCIPAL, Estado.DISPONIBLE);
        Producto unProducto3 = new Producto(3, "Producto3", 300.0f, Categoria.POSTRE, Estado.DISPONIBLE);
        Producto unProducto4 = new Producto(4, "Producto4", 400.0f, Categoria.POSTRE, Estado.NO_DISPONIBLE);
        Producto unProducto5 = new Producto(3, "Producto5", 500.0f, Categoria.POSTRE, Estado.NO_DISPONIBLE);
        // Verifico si hay productos repetidos:
        if (!listaProductos.contains(unProducto1)) {
            listaProductos.add(unProducto1);
        }
        if (!listaProductos.contains(unProducto2)) {
            listaProductos.add(unProducto2);
        }
        if (!listaProductos.contains(unProducto3)) {
            listaProductos.add(unProducto3);
        }
        if (!listaProductos.contains(unProducto4)) {
            listaProductos.add(unProducto4);
        }
        if (!listaProductos.contains(unProducto5)) {
            listaProductos.add(unProducto5);    // Producto 5 no se agregará
        }
        System.out.println("Productos");
        System.out.println("=========");
        for (Producto p : listaProductos) {
            p.mostrar();
        }
        System.out.println();

        // Pedidos:
        ArrayList<ProductoDelPedido> listapdp1 = new ArrayList<>();
        ProductoDelPedido pdp1 = new ProductoDelPedido(unProducto1, 1);
        ProductoDelPedido pdp2 = new ProductoDelPedido(unProducto2, 2);
        // Verifico si hay productos repetidos en listapdp1:
        if (!listapdp1.contains(pdp1)) {
            listapdp1.add(pdp1);
        }
        if (!listapdp1.contains(pdp2)) {
            listapdp1.add(pdp2);
        }
        Pedido unPedido1 = new Pedido(1, LocalDateTime.now(), listapdp1, (Cliente)listaUsuarios.get(0), EstadoPedido.CREADO);

        ArrayList<ProductoDelPedido> listapdp2 = new ArrayList<>();
        ProductoDelPedido pdp3 = new ProductoDelPedido(unProducto1, 10);
        ProductoDelPedido pdp4 = new ProductoDelPedido(unProducto2, 20);
        // Verifico si hay productos repetidos en listapdp2:
        if (!listapdp2.contains(pdp3)) {
            listapdp2.add(pdp3);
        }
        if (!listapdp2.contains(pdp4)) {
            listapdp2.add(pdp4);
        }
        Pedido unPedido2 = new Pedido(2, LocalDateTime.now(), listapdp2, (Cliente)listaUsuarios.get(1), EstadoPedido.CREADO);

        ArrayList<ProductoDelPedido> listapdp3 = new ArrayList<>();
        ProductoDelPedido pdp5 = new ProductoDelPedido(unProducto4, 30);
        ProductoDelPedido pdp6 = new ProductoDelPedido(unProducto3, 70);
        ProductoDelPedido pdp7 = new ProductoDelPedido(unProducto5, 70);
        // Verifico si hay productos repetidos en listapdp3:
        if (!listapdp3.contains(pdp5)) {
            listapdp3.add(pdp5);
        }
        if (!listapdp3.contains(pdp6)) {
            listapdp3.add(pdp6);
        }
        if (!listapdp3.contains(pdp7)) {
            listapdp3.add(pdp7);
        }
        Pedido unPedido3 = new Pedido(3, LocalDateTime.now(), listapdp3, (Cliente)listaUsuarios.get(2), EstadoPedido.CREADO);

        ArrayList<ProductoDelPedido> listapdp4 = new ArrayList<>();
        ProductoDelPedido pdp8 = new ProductoDelPedido(unProducto2, 20);
        ProductoDelPedido pdp9 = new ProductoDelPedido(unProducto1, 10);
        ProductoDelPedido pdp10 = new ProductoDelPedido(unProducto2, 20);
        ProductoDelPedido pdp11 = new ProductoDelPedido(unProducto3, 10);
        // Verifico si hay productos repetidos en listapdp4:
        if (!listapdp4.contains(pdp8)) {
            listapdp4.add(pdp8);
        }
        if (!listapdp4.contains(pdp9)) {
            listapdp4.add(pdp9);
        }
        if (!listapdp4.contains(pdp10)) {
            listapdp4.add(pdp10);   //pdp10 no se guardará
        }
        if (!listapdp4.contains(pdp11)) {
            listapdp4.add(pdp11);
        }
        Pedido unPedido4 = new Pedido(4, LocalDateTime.now(), listapdp4, (Cliente)listaUsuarios.get(3), EstadoPedido.CREADO);

        // Verifico si hay pedidos repetidos:
        if (!listaPedidos.contains(unPedido1)) {
            listaPedidos.add(unPedido1);
        }
        if (!listaPedidos.contains(unPedido2)) {
            listaPedidos.add(unPedido2);
        }
        if (!listaPedidos.contains(unPedido3)) {
            listaPedidos.add(unPedido3);
        }
        if (!listaPedidos.contains(unPedido4)) {
            listaPedidos.add(unPedido4);
        }

        System.out.println("Pedidos");
        System.out.println("=======");
        for (Pedido p : listaPedidos) {
            p.mostrar();
        }
        System.out.println();

        ((Cliente)unCliente1).agregarPedido(unPedido1);
        ((Cliente)unCliente1).agregarPedido(unPedido2);
        ((Cliente)unCliente1).agregarPedido(unPedido1); //pedido repetido
        
        System.out.println("Pedidos de " + unCliente1.getApellido() + ", " + unCliente1.getNombre() + ":");
        for(Pedido p : unCliente1.verPedidos()) {
            p.mostrar();
            System.out.println();
        }
        System.out.println();
        
        ((Cliente)unCliente1).cancelarPedido(unPedido1);
        
        System.out.println("Pedidos de " + unCliente1.getApellido() + ", " + unCliente1.getNombre() + ":");
        for(Pedido unPedido : unCliente1.verPedidos()) {
            unPedido.mostrar();
        }
        System.out.println();
    }
}
