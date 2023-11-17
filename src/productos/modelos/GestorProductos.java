package productos.modelos;

import java.util.ArrayList;
import java.util.List;

public class GestorProductos {
    // Constantes de GestorProductos:
    public static final String EXITO = "Producto creado/modificado con éxito";
    public static final String ERROR_CODIGO = "El código del producto es incorrecto";
    public static final String ERROR_DESCRIPCION = "La descripción del producto es incorrecta";
    public static final String ERROR_PRECIO = "El precio del producto es incorrecto";
    public static final String ERROR_CATEGORIA = "La categoría del producto es incorrecta";
    public static final String ERROR_ESTADO = "El estado del producto es incorrecto";
    public static final String PRODUCTOS_DUPLICADOS = "Ya existe un producto con ese código";
    public static final String VALIDACION_EXITO = "Los datos del producto son correctos";
    public static final String PRODUCTO_INEXISTENTE = "No existe el producto especificado";
    
    // Atributos de GestorProductos:
    private List<Producto> productos = new ArrayList<>();
    
    // Implementación del patrón de diseño singleton:
    private static GestorProductos gestor;
    private GestorProductos(){}
    public static GestorProductos instanciar(){
        if (gestor==null)
            gestor = new GestorProductos();
        return gestor;
    }
    
    // Métodos:
    public String crearProducto(int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        validarDatos(codigo, descripcion, precio, categoria, estado);
        Producto nuevoProducto = new Producto(codigo, descripcion, precio, categoria, estado);
        if (existeEsteProducto(nuevoProducto))
            return PRODUCTOS_DUPLICADOS;
        productos.add(nuevoProducto);
        return EXITO;
    }

    public String modificarProducto(Producto productoAModificar, int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        if (!existeEsteProducto(productoAModificar))
            return PRODUCTO_INEXISTENTE;
        do {
            productoAModificar.asignarCodigo(codigo);
            productoAModificar.asignarDescripcion(descripcion);
            productoAModificar.asignarPrecio(precio);
            productoAModificar.asignarCategoria(categoria);
            productoAModificar.asignarEstado(estado);
        } while (validarDatos(codigo, descripcion, precio, categoria, estado) != VALIDACION_EXITO);
        return EXITO;
    }

    public List<Producto> menu() {
        return productos;
    }

    public List<Producto> buscarProductos(String descripcion) {
        List<Producto> prodEncontrados = new ArrayList<>();
        if (descripcion != null) {
            for (Producto prod : this.productos) {
                if (prod.verDescripcion().toLowerCase().contains(descripcion.toLowerCase()))
                    prodEncontrados.add(prod);
            }
        }
        return prodEncontrados;
    }

    public boolean existeEsteProducto(Producto producto) {
        return productos.contains(producto);
    }

    public List<Producto> verProductosPorCategoria(Categoria categoria) {
        List<Producto> prodPorCategoria = new ArrayList<>();
        for (Producto prod : productos) {
            if (prod.verCategoria() == categoria)
                prodPorCategoria.add(prod);
        }
        return prodPorCategoria;
    }

    public Producto obtenerProducto(Integer codigo) {
        for (Producto producto : productos) {
            if (producto.verCodigo() == codigo)
                return producto;
        }
        System.out.println("No existen productos con el código ingresado");
        return null;
    }

    // Métodos auxiliares:
    private String validarDatos(int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        if (codigo <= 0)
            return ERROR_CODIGO;
        if (descripcion == null || descripcion.isEmpty())
            return ERROR_DESCRIPCION;
        if (precio <= 0)
            return ERROR_PRECIO;
        if (categoria == null)
            return ERROR_CATEGORIA;
        if (estado == null)
            return ERROR_ESTADO;
        return VALIDACION_EXITO;
    }    
}
