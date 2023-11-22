package productos.modelos;

import interfaces.IGestorPedidos;
import interfaces.IGestorProductos;
import java.util.ArrayList;
import java.util.List;

public class GestorProductos implements IGestorProductos {

    // Atributos de GestorProductos:
    private List<Producto> productos = new ArrayList<>();

    // Implementación del patrón de diseño singleton:
    private static GestorProductos gestor;

    private GestorProductos() {
    }

    public static GestorProductos instanciar() {
        if (gestor == null) {
            gestor = new GestorProductos();
        }
        return gestor;
    }

    // Métodos:
    @Override
    public String crearProducto(int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        String validacion = validarDatos(codigo, descripcion, precio, categoria, estado);
        if (!validacion.equals(VALIDACION_EXITO)) {
            return validacion;
        } else {
            Producto nuevoProducto = new Producto(codigo, descripcion, precio, categoria, estado);
            if (existeEsteProducto(nuevoProducto)) {
                return PRODUCTOS_DUPLICADOS;
            } else {
                productos.add(nuevoProducto);
                return EXITO;
            }
        }
    }

    @Override
    public String modificarProducto(Producto productoAModificar, int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        if (!existeEsteProducto(productoAModificar)) {
            return PRODUCTO_INEXISTENTE;
        }
        do {
            productoAModificar.asignarCodigo(codigo);
            productoAModificar.asignarDescripcion(descripcion);
            productoAModificar.asignarPrecio(precio);
            productoAModificar.asignarCategoria(categoria);
            productoAModificar.asignarEstado(estado);
        } while (!validarDatos(codigo, descripcion, precio, categoria, estado).equals(VALIDACION_EXITO));
        return EXITO;
    }

    @Override
    public List<Producto> menu() {
        return productos;
    }

    @Override
    public List<Producto> buscarProductos(String descripcion) {
        List<Producto> prodEncontrados = new ArrayList<>();
        if (descripcion != null) {
            for (Producto prod : this.productos) {
                if (prod.verDescripcion().toLowerCase().contains(descripcion.toLowerCase())) {
                    prodEncontrados.add(prod);
                }
            }
        }
        return prodEncontrados;
    }

    @Override
    public boolean existeEsteProducto(Producto producto) {
        return productos.contains(producto);
    }

    @Override
    public List<Producto> verProductosPorCategoria(Categoria categoria) {
        List<Producto> prodPorCategoria = new ArrayList<>();
        for (Producto prod : productos) {
            if (prod.verCategoria().equals(categoria)) {
                prodPorCategoria.add(prod);
            }
        }
        return prodPorCategoria;
    }

    @Override
    public Producto obtenerProducto(Integer codigo) {
        for (Producto producto : productos) {
            if (producto.verCodigo() == (codigo)) {
                return producto;
            }
        }
        System.out.println("No existen productos con el código ingresado");
        return null;
    }
    
//falta metodo hayPedidosConEsteProducto
    @Override
    public String borrarProducto(Producto producto) {
        if (productos.contains(producto)) {
            if (hayPedidosConEsteProducto(producto)) {     //quiero llamar al metodo dentro de GestorPedido
                return PRODUCTO_IMBORRABLE;
            } else {
                productos.remove(producto);
                return BORRAR_PRODUCTO;
            }
        } else {
            return PRODUCTO_INEXISTENTE;
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

}
