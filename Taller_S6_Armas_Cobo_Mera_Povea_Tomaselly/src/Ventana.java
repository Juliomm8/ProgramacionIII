import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Ventana {
    private JPanel main;
    private JTabbedPane tabbedPane1;
    private JComboBox cbProducto;
    private JSpinner spiCantidad;
    private JComboBox cbMes;
    private JButton btnRegistrarVenta;
    private JTextArea jtxtVentasRegistradas;
    private JComboBox cbProductosPrecio;
    private JTextField txtNuevoValor;
    private JButton btnActualizarPrecio;
    private JTextArea jtxtPrecioActualizado;
    private JComboBox cbBuscar;
    private JTextField txtBuscar;
    private JButton btnBuscar;
    private JTextArea jtxtProductoBuscado;
    private JLabel lblPrecioActual;
    private Tienda tienda;

    public Ventana() {
        tienda = new Tienda();
        SpinnerNumberModel spinnerModel = new SpinnerNumberModel(1, 1, 999, 1);
        spiCantidad.setModel(spinnerModel);

        cbProductosPrecio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarLabelPrecio();
            }
        });

        actualizarLabelPrecio();

        btnRegistrarVenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreProducto = (String) cbProducto.getSelectedItem();
                int cantidad = (int) spiCantidad.getValue();
                String mesTexto = (String) cbMes.getSelectedItem();
                int mes = Integer.parseInt(Objects.requireNonNull(mesTexto).split(" ")[1]);
                tienda.registrarVenta(nombreProducto, cantidad, mes);
                actualizarReporteVentas();
                JOptionPane.showMessageDialog(main, "Venta registrada exitosamente!");
                spiCantidad.setValue(1);
            }
        });

        btnActualizarPrecio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombreProducto = (String) cbProductosPrecio.getSelectedItem();
                    double nuevoPrecio = Double.parseDouble(txtNuevoValor.getText());
                    boolean exito = tienda.actualizarPrecio(nombreProducto, nuevoPrecio);

                    if (exito) {
                        jtxtPrecioActualizado.setText("Precio de " + nombreProducto + " actualizado a $" + nuevoPrecio);
                        actualizarLabelPrecio();
                    } else {
                        jtxtPrecioActualizado.setText("Error al actualizar el precio.");
                    }
                    txtNuevoValor.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(main, "Error: El precio debe ser un número válido.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String termino = txtBuscar.getText().trim();
                String tipoBusqueda = (String) cbBuscar.getSelectedItem();
                Producto productoEncontrado = null;

                if (Objects.equals(tipoBusqueda, "Buscar por ID")) {
                    productoEncontrado = tienda.buscarPorId(termino);
                } else if (Objects.equals(tipoBusqueda, "Buscar por Nombre")) {
                    productoEncontrado = tienda.buscarPorNombre(termino);
                }

                if (productoEncontrado != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Producto Encontrado:\n");
                    sb.append(productoEncontrado.toString()).append("\n\n");
                    sb.append("Historial de Ventas Registradas:\n");
                    boolean ventasEncontradas = false;
                    for (Venta v : tienda.getVentas()) {
                        if (v.getProducto().getId().equals(productoEncontrado.getId())) {
                            sb.append(v.toString()).append("\n");
                            ventasEncontradas = true;
                        }
                    }
                    if (!ventasEncontradas) {
                        sb.append("Aún no se han registrado ventas para este producto.");
                    }
                    jtxtProductoBuscado.setText(sb.toString());
                } else {
                    jtxtProductoBuscado.setText("Producto no encontrado.");
                }
            }
        });
    }

    private void actualizarLabelPrecio() {
        String nombreProducto = (String) cbProductosPrecio.getSelectedItem();
        if (nombreProducto == null) return;

        Producto p = tienda.buscarPorNombre(nombreProducto);

        if (p != null) {
            String precioFormateado = String.format("%.2f", p.getPrecio());
            lblPrecioActual.setText("Precio actual: $" + precioFormateado);
        } else {
            lblPrecioActual.setText("Precio actual: (Error)");
        }
    }

    private void actualizarReporteVentas() {
        jtxtVentasRegistradas.setText("");
        for (Venta v : tienda.getVentas()) {
            jtxtVentasRegistradas.append(v.toString() + "\n");
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Gestión de Tienda");
        frame.setContentPane(new Ventana().main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}