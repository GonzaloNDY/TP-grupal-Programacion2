/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unPaquete;

import java.util.ArrayList;

public class ControladorPrincipal {
        
    public static void main(String[] args) {
        
        Cliente cliente1 = new Cliente();        
        Cliente cliente2 = new Cliente();        
        Cliente cliente3 = new Cliente();
        
        cliente1.correo = "qwerty@gmail.com";
        cliente1.contraseña = "ytrewq";
        cliente1.apellidos = "as er";
        cliente1.nombres = "sa re";
        cliente2.correo = "asdfg@gmail.com";
        cliente2.contraseña = "gfdsa";
        cliente2.apellidos = "qw er";
        cliente2.nombres = "as df";
        cliente3.correo = "zxcvb@gmail.com";
        cliente3.contraseña = "bvcxz";
        cliente3.apellidos = "poi oiu";
        cliente3.nombres = "ñlk lkj";
        
        Empleado empleado1 = new Empleado();
        Empleado empleado2 = new Empleado();
        Empleado empleado3 = new Empleado();
        
        empleado1.correo = "qwerty@gmail.com";
        empleado1.contraseña = "ytrewq";
        empleado1.apellidos = "as er";
        empleado1.nombres = "sa re";
        empleado2.correo = "asdfg@gmail.com";
        empleado2.contraseña = "gfdsa";
        empleado2.apellidos = "qw er";
        empleado2.nombres = "as df";
        empleado3.correo = "zxcvb@gmail.com";
        empleado3.contraseña = "bvcxz";
        empleado3.apellidos = "poi oiu";
        empleado3.nombres = "ñlk lkj";
        
        ArrayList<Cliente> listaDeClientes = new ArrayList<>();
        listaDeClientes.add(cliente1);
        listaDeClientes.add(cliente2);
        listaDeClientes.add(cliente3);
        
        ArrayList<Empleado> listaDeEmpleados = new ArrayList<>();
        listaDeEmpleados.add(empleado1);
        listaDeEmpleados.add(empleado2);
        listaDeEmpleados.add(empleado3);
        
        ArrayList<Encargado> listaDeEncargados = new ArrayList<>();
        
        
        ArrayList<Producto> listaDeProductos = new ArrayList<>();
        
        
        
        System.out.println("\tClientes\n");
        for (Cliente unCliente : listaDeClientes) {
            unCliente.mostrarInformacion();
        }
        
        System.out.println("\tEmpleados\n");
        for (Empleado unEmpleado : listaDeEmpleados) {
            unEmpleado.mostrarInformacion();
        }
        
        System.out.println("\tEncargados\n");
        for (Encargado unEncargado : listaDeEncargados) {
            unEncargado.mostrarInformacion();
        }
        
        System.out.println("\tProductos\n");
        for (Producto unProducto : listaDeProductos) {
            unProducto.mostrarInformacion();
        }
    }
}
