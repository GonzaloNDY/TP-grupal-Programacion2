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
        
        cliente1.correo = "qwerty@gmail.com";
        cliente1.contraseña = "ytrewq";
        cliente1.apellidos = "as er";
        cliente1.nombres = "sa re";
        cliente2.correo = "asdfg@gmail.com";
        cliente2.contraseña = "gfdsa";
        cliente2.apellidos = "qw er";
        cliente2.nombres = "as df";
        
        ArrayList<Cliente> listaDeClientes = new ArrayList<>();
        
        listaDeClientes.add(cliente1);
        listaDeClientes.add(cliente2);
        
        /*ArrayList<Empleado> listaDeEmpleados = new ArrayList<>();
        ArrayList<Encargado> listaDeEncargados = new ArrayList<>();
        ArrayList<Producto> listaDeProductos = new ArrayList<>();*/
        
        
        
        for (Cliente unCliente : listaDeClientes) {
            unCliente.mostrarInformacion();
        }
        
        /*for (Empleado unEmpleado : listaDeEmpleados) {
            System.out.println(unEmpleado );
        }
        
        for (Encargado unEncargado : listaDeEncargados) {
            System.out.println(unEncargado );
        }
        
        for (Producto unProducto : listaDeProductos) {
            System.out.println(unProducto );
        }*/
    }
}
