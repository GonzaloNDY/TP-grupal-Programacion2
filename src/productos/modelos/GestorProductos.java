package productos.modelos;

import interfaces.IGestorPedidos;
import interfaces.IGestorProductos;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import pedido.modelos.GestorPedidos;

public class GestorProductos implements IGestorProductos, Comparator<Producto> {

    // Atributos de GestorProductos:
    private List<Producto> productos = new ArrayList<>();

    // Implementación del patrón de diseño singleton:
    private static GestorProductos gestor;

    private GestorProductos() {
        this.productos = new ArrayList<>();
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
        List<Producto> copiaproductos = new ArrayList<>(productos);

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
            for (Producto prod : this.productos) {
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
        for (Producto producto : productos) {
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
            productos.remove(producto);
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

    @Override
    public int compare(Producto o1, Producto o2) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
