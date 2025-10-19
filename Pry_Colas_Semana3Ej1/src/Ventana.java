import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel principal;
    private JTabbedPane tabbedPane1;
    private JTextField txtPlaca;
    private JComboBox cboMarca;
    private JTextField txtModelo;
    private JSpinner spiAnio;
    private JButton btnLimpiar;
    private JButton btnAgregar;
    private JTextArea txtListado;
    private JButton btnPagar;
    private JButton btnListar;
    private JLabel lblResultado;
    private JComboBox cboMarcas;
    private JButton btnBuscar;
    private JTextArea textArea1;

    private ColaAutos cola = new ColaAutos();

    public Ventana() {
        spiAnio.setModel(new SpinnerNumberModel(2025, 1950, 2028, 1));
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtPlaca.setText("");
                txtModelo.setText("");
                cboMarca.setSelectedIndex(0);
            }
        });

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String placa = txtPlaca.getText();
                String marca = cboMarca.getSelectedItem().toString();
                String modelo = txtModelo.getText();
                int anio = Integer.parseInt(spiAnio.getValue().toString());

                Auto auto = new Auto(placa, marca, modelo, anio);
                cola.encolar(auto);
                JOptionPane.showMessageDialog(null, "Se agrego el auto " + auto.toString() + " a la cola" );


            }
        });

        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtListado.setText(cola.toString());
            }
        });

        btnPagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Auto auto = cola.desencolar();
                    txtListado.setText(cola.toString());
                    float valor;
                    if (auto.getAnio() < 2000) {
                        valor = 50.25f;
                    } else {
                        valor = 100.79f;
                    }
                    lblResultado.setText( auto.toString() + " pago: " + valor);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                for (Auto auto : cola.cola) {
                    if (auto.marca.equals(cboMarcas.getSelectedItem().toString())) {
                        textArea1.append(auto.toString() + "\n");
                    }

                }
            }
        });
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
