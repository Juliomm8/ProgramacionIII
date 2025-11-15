import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tienda implements Buscable {

    private List<Producto> productos;
    private List<Venta> ventas;

    public Tienda() {
        this.productos = new ArrayList<>();
        this.ventas = new ArrayList<>();

        cargarProductosIniciales();
    }

    private void cargarProductosIniciales() {
        productos.add(new Producto("01", "Carne", 12.33));
        productos.add(new Producto("02", "Sal", 2.50));
        productos.add(new Producto("03", "Papel", 8.25));
    }

    public void registrarVenta(String nombreProducto, int cantidad, int mes) {
        Producto productoVendido = buscarPorNombre(nombreProducto);
        if (productoVendido != null) {
            Venta nuevaVenta = new Venta(productoVendido, cantidad, mes);
            ventas.add(nuevaVenta);
        }
    }

    public boolean actualizarPrecio(String nombreProducto, double nuevoPrecio) {
        Producto productoAActualizar = buscarPorNombre(nombreProducto);
        if (productoAActualizar != null) {
            productoAActualizar.setPrecio(nuevoPrecio);
            return true;
        }
        return false;
    }

    @Override
    public Producto buscarPorId(String id) {
        for (Producto p : productos) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public Producto buscarPorNombre(String nombre) {
        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }

    public List<Producto> getProductos() {
        return Collections.unmodifiableList(productos);
    }

    public List<Venta> getVentas() {
        return Collections.unmodifiableList(ventas);
    }
}