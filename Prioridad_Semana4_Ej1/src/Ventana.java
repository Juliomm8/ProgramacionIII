import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

public class Ventana {
    private JSpinner spinner1;
    private JTextField textField1;
    private JComboBox comboBox1;
    private JButton btnRegistrar;
    private JTextArea txtListar;
    private JButton btnAtender;
    private JLabel lblPrioridad;
    private JLabel lblNombre;
    private JLabel lblEnfermedad;
    private JPanel main;
    Clinica lista = new Clinica();

    public Ventana() {
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int prioridad = Integer.parseInt(spinner1.getValue().toString());
                String nombre = textField1.getText();
                String enfermedad = comboBox1.getSelectedItem().toString();
                Paciente enfermo = new Paciente(prioridad, nombre, enfermedad);
                lista.encolarPaciente(enfermo);
                List<Paciente> resultado = lista.listarPacientes();
                Collections.sort(resultado);
                for (Paciente p : resultado) {
                    txtListar.append(p.toString() + "\n");
                }
            }
        });

        btnAtender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Paciente paciente = lista.desencolar();
                    List<Paciente> resultado = lista.listarPacientes();
                    Collections.sort(resultado);
                    for (Paciente p : resultado) {
                        txtListar.append(p.toString() + "\n");
                    }

                    JOptionPane.showMessageDialog(null, paciente.toString() + " atendido");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });


    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
