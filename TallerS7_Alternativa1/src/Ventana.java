import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class Ventana {
    private JPanel main;
    private JPanel pnlFormulario;
    private JTextField txtId;
    private JTextField txtNombre;
    private JComboBox cmbRango;
    private JTextField txtConstelacion;
    private JSpinner spnNivelPoder;
    private JTextField txtMision;
    private JSpinner spnNivelDificultad;
    private JTextField txtRecompensa;
    private JTable tblCaballeros;
    private JPanel pnlBotones;
    private JButton btnRegistrar;
    private JButton btnModificar;
    private JButton btnEliminar;
    private JButton btnLimpiar;

    private GestorCaballeros gestor;
    private CaballeroTableModel modeloTabla;

    public Ventana() {
        gestor = new GestorCaballeros();
        configurarComponentes();
        registrarEventos();
        actualizarTabla();

    }

    private void configurarComponentes() {
        cmbRango.setModel(new DefaultComboBoxModel<>(RangoCaballero.values()));
        spnNivelPoder.setModel(new SpinnerNumberModel(1, 1, 10, 1));
        spnNivelDificultad.setModel(new SpinnerNumberModel(1, 1, 5, 1));
        modeloTabla = new CaballeroTableModel();
        tblCaballeros.setModel(modeloTabla);
    }

    private void registrarEventos() {
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // 1. Leer ID y demás datos
                    if (txtId.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Debe ingresar un ID");
                        return;
                    }

                    int id = Integer.parseInt(txtId.getText().trim());
                    String nombre = txtNombre.getText().trim();
                    RangoCaballero rango = (RangoCaballero) cmbRango.getSelectedItem();
                    String constelacion = txtConstelacion.getText().trim();
                    int poder = (int) spnNivelPoder.getValue();
                    String mision = txtMision.getText().trim();
                    int dificultad = (int) spnNivelDificultad.getValue();
                    double recompensa = Double.parseDouble(txtRecompensa.getText().trim());

                    if (nombre.isEmpty() || mision.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Faltan datos obligatorios");
                        return;
                    }

                    // 2. Registrar con ID elegido por el usuario
                    gestor.registrarCaballero(id, nombre, rango, constelacion, poder, mision, dificultad, recompensa);

                    // 3. Actualizar tabla y limpiar
                    actualizarTabla();
                    limpiarFormulario();
                    JOptionPane.showMessageDialog(null, "Registrado!");

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null,
                            "ID y recompensa deben ser numéricos",
                            "Error de formato",
                            JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) { // aquí llega el "ID repetido"
                    JOptionPane.showMessageDialog(null,
                            ex.getMessage(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txtId.getText().isEmpty()) return;

                try {
                    int id = Integer.parseInt(txtId.getText());
                    String nombre = txtNombre.getText();
                    RangoCaballero rango = (RangoCaballero) cmbRango.getSelectedItem();
                    String constelacion = txtConstelacion.getText();
                    int poder = (int) spnNivelPoder.getValue();
                    String mision = txtMision.getText();
                    int dificultad = (int) spnNivelDificultad.getValue();
                    double recompensa = Double.parseDouble(txtRecompensa.getText());

                    if(gestor.modificarCaballero(id, nombre, rango, constelacion, poder, mision, dificultad, recompensa)){
                        actualizarTabla();
                        limpiarFormulario();
                        JOptionPane.showMessageDialog(null, "Modificado!");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error en datos");
                }
            }
        });

        tblCaballeros.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = tblCaballeros.getSelectedRow();
                if (fila != -1) {
                    int id = (int) modeloTabla.getValueAt(fila, 0);
                    Caballero c = gestor.buscarPorId(id);
                    if (c != null) {
                        txtId.setText(String.valueOf(c.getIdCaballero()));
                        txtNombre.setText(c.getNombre());
                        cmbRango.setSelectedItem(c.getRango());
                        txtConstelacion.setText(c.getConstelacion());
                        spnNivelPoder.setValue(c.getNivelPoder());
                        txtMision.setText(c.getMisionAsignada());
                        spnNivelDificultad.setValue(c.getNivelDificultad());
                        txtRecompensa.setText(String.valueOf(c.getRecompensa()));
                    }
                }
            }
        });

        btnLimpiar.addActionListener(e -> limpiarFormulario());
        btnEliminar.addActionListener(e -> {
            if(!txtId.getText().isEmpty()){
                gestor.eliminarCaballero(Integer.parseInt(txtId.getText()));
                actualizarTabla();
                limpiarFormulario();
            }
        });
    }

    private void actualizarTabla() {
        List<Caballero> lista = gestor.listarCaballeros();
        modeloTabla.setCaballeros(lista);
    }

    private void limpiarFormulario() {
        txtId.setText("");
        txtNombre.setText("");
        txtConstelacion.setText("");
        txtMision.setText("");
        txtRecompensa.setText("");
        spnNivelPoder.setValue(1);
        spnNivelDificultad.setValue(1);
        tblCaballeros.clearSelection();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
