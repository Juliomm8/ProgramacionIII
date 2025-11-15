public class Venta {
    private Producto producto;
    private int cantidad;
    private int mes;
    private double precioAlMomentoDeVenta;

    public Venta(Producto producto, int cantidad, int mes) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.mes = mes;
        this.precioAlMomentoDeVenta = producto.getPrecio();
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getMes() {
        return mes;
    }

    @Override
    public String toString() {
        double valorUnitario = this.precioAlMomentoDeVenta;
        double valorTotal = valorUnitario * cantidad;

        return "Mes: " + mes +
                ", ID: " + producto.getId() +
                ", Producto: " + producto.getNombre() +
                ", valor unitario: $" + valorUnitario +
                ", unidades: " + cantidad +
                ", valor total: $" + valorTotal;
    }
}