package productos.modelos;

import interfaces.IGestorPedidos;
import interfaces.IGestorProductos;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import pedido.modelos.GestorPedidos;

public class GestorProductos implements IGestorProductos{

    // Atributos de GestorProductos:
    private List<Producto> listaProductos = new ArrayList<>();

    // Implementación del patrón de diseño singleton:
    private static GestorProductos gestor;

    private GestorProductos() {
        this.leerArchivo();
    }

    public static GestorProductos instanciar() {
        if (gestor == null) {
            gestor = new GestorProductos();
        }
        return gestor;
    }

    // Implementación de métodos:
    @Override
    public String crearProducto(int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        String validacion = validarDatos(codigo, descripcion, precio, categoria, estado);
        if (!validacion.equals(VALIDACION_EXITO)) {
            return validacion;
        } else {
            Producto nuevoProducto = new Producto(codigo, descripcion, categoria, estado, precio);
            if (existeEsteProducto(nuevoProducto)) {
                return PRODUCTOS_DUPLICADOS;
            } else {
                listaProductos.add(nuevoProducto);
                escribirArchivo();
                return EXITO;
            }
        }
    }

    @Override
    public String modificarProducto(Producto productoAModificar, int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        if (!existeEsteProducto(productoAModificar)) {
            return PRODUCTO_INEXISTENTE;
        }
        String validacion = validarDatos(codigo, descripcion, precio, categoria, estado);
        if (!validacion.equals(VALIDACION_EXITO)) {
            return validacion;
        }
        if (obtenerProducto(codigo) != null) {
            return PRODUCTOS_DUPLICADOS;
        } else {
            productoAModificar.asignarCodigo(codigo);
            productoAModificar.asignarDescripcion(descripcion);
            productoAModificar.asignarPrecio(precio);
            productoAModificar.asignarCategoria(categoria);
            productoAModificar.asignarEstado(estado); 
            escribirArchivo();
            return EXITO;
        }
    }

    @Override
    public List<Producto> menu() {
        List<Producto> copiaproductos = new ArrayList<>(listaProductos);

        Comparator<Producto> pComp = (Producto p1, Producto p2) -> {
            int resultado = p1.verCategoria().compareTo(p2.verCategoria());
            if (resultado == 0) {
                return p1.verDescripcion().compareTo(p2.verDescripcion());
            }
            return resultado;
        };

        copiaproductos.sort(pComp);
        return copiaproductos;
    }

    @Override
    public List<Producto> buscarProductos(String descripcion) {
        List<Producto> prodEncontrados = new ArrayList<>();
        if (descripcion != null) {
            for (Producto prod : this.listaProductos) {
                if (prod.verDescripcion().toLowerCase().contains(descripcion.toLowerCase())) {
                    prodEncontrados.add(prod);
                }
            }
            if (!prodEncontrados.isEmpty()) {
               Comparator<Producto> pComp = (Producto p1, Producto p2)  -> {
                    int resultado = p1.verCategoria().compareTo(p2.verCategoria());
                    if (resultado == 0) {
                        return p1.verDescripcion().compareTo(p2.verDescripcion());
                    }
                    return resultado;
                };
               prodEncontrados.sort(pComp);
            }
        }
        return prodEncontrados;
    }

    @Override
    public boolean existeEsteProducto(Producto producto) {
        return listaProductos.contains(producto);
    }

    @Override
    public List<Producto> verProductosPorCategoria(Categoria categoria) {
        List<Producto> prodPorCategoria = new ArrayList<>();
        for (Producto prod : listaProductos) {
            if (prod.verCategoria().equals(categoria)) {
                prodPorCategoria.add(prod);
            }
        }
        if (!prodPorCategoria.isEmpty()) {
            Comparator<Producto> pComp = (Producto p1, Producto p2) -> p1.verDescripcion().toLowerCase().compareTo(p2.verDescripcion().toLowerCase());
            prodPorCategoria.sort(pComp);
            return prodPorCategoria;
        } else {
            return prodPorCategoria;
        }
    }

    @Override
    public Producto obtenerProducto(Integer codigo) {
        for (Producto producto : listaProductos) {
            if (producto.verCodigo() == (codigo)) {
                return producto;
            }
        }
        System.out.println("No existen productos con el código ingresado");
        return null;
    }

    @Override
    public String borrarProducto(Producto producto) {
        if (!existeEsteProducto(producto)) {
            return PRODUCTO_INEXISTENTE;
        }
        IGestorPedidos pedidos = GestorPedidos.instanciar();
        if (pedidos.hayPedidosConEsteProducto(producto)) {
            return PRODUCTO_IMBORRABLE;
        } else {
            listaProductos.remove(producto);
           escribirArchivo();
            return BORRAR_PRODUCTO;
        }
    }

    // Métodos auxiliares:
    private String validarDatos(int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        if (codigo <= 0) {
            return ERROR_CODIGO;
        }
        if (descripcion == null || descripcion.isEmpty()) {
            return ERROR_DESCRIPCION;
        }
        if (precio <= 0) {
            return ERROR_PRECIO;
        }
        if (categoria == null) {
            return ERROR_CATEGORIA;
        }
        if (estado == null) {
            return ERROR_ESTADO;
        }
        return VALIDACION_EXITO;
    }

    private void escribirArchivo() {
        File f = new File("productos");
        BufferedWriter bw = null;
        // Inicio del bloque try/catch/finally
        try {
            FileWriter fw = new FileWriter(f, false);
            bw = new BufferedWriter(fw);
            for (Producto p : this.listaProductos) {
                String linea;
                linea = Integer.toString(p.verCodigo()) + ",";
                linea += p.verDescripcion() + ",";
                linea += Float.toString(p.verPrecio()) + ",";
                linea += p.verCategoria() + ",";
                linea += p.verEstado() + ",";
                bw.write(linea);
                bw.newLine();
            }
            bw.flush();
            fw.close();
            bw.close();
        }
        catch (IOException ioe) {
            System.out.println("Problemas en la lectura del archivo");
            ioe.printStackTrace();
        }
        finally {
            if (bw != null) {
                try {
                    bw.close();
                }
                catch (IOException ioe) {
                    System.out.println("Problemas en la creacion del archivo");
                    ioe.printStackTrace();
                }
            }            
        }
        // Fin del bloque try/catch/finally
    }

    private void leerArchivo() {
        File f = new File("productos");
        if (f.exists()) {
            BufferedReader br = null;
            // Inicio del bloque try/catch/finally
            try {
                FileReader fr = new FileReader(f);
                br = new BufferedReader(fr);
                String linea;
                while ((linea = br.readLine()) != null) {
                    String[] vector = linea.split(",");
                    int codigo = Integer.parseInt(vector[0]);
                    String descripcion = vector[1];
                    float precio = Float.parseFloat(vector[2]);
                    Categoria categoria = Categoria.valueOf(vector[3].toUpperCase());
                    Estado estado = Estado.valueOf(vector[4].toUpperCase());
                    Producto prod = new Producto(codigo, descripcion, categoria, estado, precio);
                    this.listaProductos.add(prod);
                }
            }
            catch (IOException ioe) {
                System.out.println("Problemas en la lectura del archivo");
                ioe.printStackTrace();
            }
            finally {
                if (br != null) {
                    try {
                        br.close();
                    }
                    catch (IOException ioe) {
                        System.out.println("Problemas en la lectura del archivo");
                        ioe.printStackTrace();
                    }
                }
            }
            // Fin del bloque try/catch/finally
        }
    }
}
