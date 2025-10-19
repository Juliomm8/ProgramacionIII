import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCine extends JFrame {

    private JTextField cedulaField;
    private JSpinner entradasSpinner;
    private JTextArea comprasTextArea;
    private JLabel ingresosPiratasLabel, ingresosNarutoLabel, ingresosAntmanLabel, totalRecaudadoLabel;
    private CineServiceBasico cineService;
    private PeliculaInfo piratas, naruto, antman;

    public VentanaCine() {
        cineService = new CineServiceBasico();

        piratas = new PeliculaInfo("Piratas");
        naruto = new PeliculaInfo("Naruto");
        antman = new PeliculaInfo("Antman");

        setTitle("Cine - Venta de Entradas");
        setSize(900, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel panelNuevaCompra = new JPanel();
        panelNuevaCompra.setLayout(new GridLayout(4, 2, 10, 10));
        panelNuevaCompra.setBorder(BorderFactory.createTitledBorder("Nueva Compra"));

        panelNuevaCompra.add(new JLabel("Película:"));
        JComboBox<String> peliculaComboBox = new JComboBox<>(new String[]{"Piratas", "Naruto", "Antman"});
        panelNuevaCompra.add(peliculaComboBox);

        panelNuevaCompra.add(new JLabel("Cédula:"));
        cedulaField = new JTextField();
        setCedulaFilter(cedulaField);
        panelNuevaCompra.add(cedulaField);

        panelNuevaCompra.add(new JLabel("Entradas (1-5):"));
        entradasSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 5, 1));
        panelNuevaCompra.add(entradasSpinner);

        JPanel panelBotones = new JPanel();
        JButton comprarButton = new JButton("Comprar");
        comprarButton.setPreferredSize(new Dimension(250, 40));
        panelBotones.add(comprarButton);
        panelNuevaCompra.add(panelBotones);

        JPanel panelEstado = new JPanel();
        panelEstado.setLayout(new GridLayout(5, 1, 10, 10));
        panelEstado.setBorder(BorderFactory.createTitledBorder("Estado"));

        ingresosPiratasLabel = new JLabel("Película: Piratas - Vendidos: 0 - Disponibles: 17 - Ingresos: $0");
        ingresosNarutoLabel = new JLabel("Película: Naruto - Vendidos: 0 - Disponibles: 17 - Ingresos: $0");
        ingresosAntmanLabel = new JLabel("Película: Antman - Vendidos: 0 - Disponibles: 17 - Ingresos: $0");
        totalRecaudadoLabel = new JLabel("Total recaudado: $0");

        panelEstado.add(ingresosPiratasLabel);
        panelEstado.add(ingresosNarutoLabel);
        panelEstado.add(ingresosAntmanLabel);
        panelEstado.add(totalRecaudadoLabel);

        JPanel panelCompras = new JPanel();
        panelCompras.setLayout(new BorderLayout(10, 10));
        panelCompras.setBorder(BorderFactory.createTitledBorder("Compras"));

        comprasTextArea = new JTextArea(15, 30);
        comprasTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(comprasTextArea);
        panelCompras.add(scrollPane, BorderLayout.CENTER);

        add(panelNuevaCompra, BorderLayout.WEST);
        add(panelEstado, BorderLayout.CENTER);
        add(panelCompras, BorderLayout.EAST);

        comprarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cedula = cedulaField.getText();
                if (cedula.length() != 10 || !cedula.matches("\\d{10}")) {
                    JOptionPane.showMessageDialog(null, "La cédula debe contener exactamente 10 dígitos numéricos.", "Error de Cédula", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int entradas = (int) entradasSpinner.getValue();
                String peliculaSeleccionada = (String) peliculaComboBox.getSelectedItem();

                String resultado = cineService.realizarCompra(cedula, peliculaSeleccionada, entradas);

                if ("cedula_repetida".equals(resultado)) {
                    JOptionPane.showMessageDialog(null, "La cédula ya ha realizado una compra.", "Error de Cédula", JOptionPane.ERROR_MESSAGE);
                } else if ("no_capacidad".equals(resultado)) {
                    JOptionPane.showMessageDialog(null, "No hay suficiente capacidad para la película seleccionada.", "Error de Capacidad", JOptionPane.ERROR_MESSAGE);
                } else if ("compra_exitosa".equals(resultado)) {
                    String mensaje = "Compra realizada con éxito. Película: " + peliculaSeleccionada + " - Entradas compradas: " + entradas;
                    comprasTextArea.append(mensaje + "\n");

                    if ("Piratas".equals(peliculaSeleccionada)) {
                        piratas.agregarEntradas(entradas);
                        ingresosPiratasLabel.setText("Película: Piratas - Vendidos: " + piratas.getEntradasVendidas() + " - Disponibles: " + (17 - piratas.getEntradasVendidas()) + " - Ingresos: $" + piratas.getIngresos());
                    } else if ("Naruto".equals(peliculaSeleccionada)) {
                        naruto.agregarEntradas(entradas);
                        ingresosNarutoLabel.setText("Película: Naruto - Vendidos: " + naruto.getEntradasVendidas() + " - Disponibles: " + (17 - naruto.getEntradasVendidas()) + " - Ingresos: $" + naruto.getIngresos());
                    } else if ("Antman".equals(peliculaSeleccionada)) {
                        antman.agregarEntradas(entradas);
                        ingresosAntmanLabel.setText("Película: Antman - Vendidos: " + antman.getEntradasVendidas() + " - Disponibles: " + (17 - antman.getEntradasVendidas()) + " - Ingresos: $" + antman.getIngresos());
                    }

                    int totalRecaudado = piratas.getIngresos() + naruto.getIngresos() + antman.getIngresos();
                    totalRecaudadoLabel.setText("Total recaudado: $" + totalRecaudado);
                }

                cedulaField.setText("");
                entradasSpinner.setValue(1);
            }
        });
    }

    public void mostrarVentana() {
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                VentanaCine ventana = new VentanaCine();
                ventana.mostrarVentana();
            }
        });
    }

    private void setCedulaFilter(JTextField cedulaField) {
        AbstractDocument doc = (AbstractDocument) cedulaField.getDocument();
        doc.setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (string.matches("\\d*") && fb.getDocument().getLength() + string.length() <= 10) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text.matches("\\d*") && fb.getDocument().getLength() + text.length() <= 10) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
    }
}
