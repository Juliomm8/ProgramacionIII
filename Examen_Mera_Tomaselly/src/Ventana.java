import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Queue;

public class Ventana {
    private JPanel main;
    private JTextArea txtMostrar;  // Para mostrar robots y resultados generales
    private JTextArea txtCopiados; // Para mostrar robots copiados según función
    private JButton btnMostrar;
    private JButton btnCalcularAtaque;
    private JComboBox<String> cbElegir;
    private JButton btnCopiar;

    private ColaRobot colaRobot;

    public Ventana() {
        colaRobot = new ColaRobot();

        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtMostrar.setText("");
                for (Robot robot : colaRobot.cola) {
                    txtMostrar.append(robot.toString() + "\n");
                }
            }
        });

        btnCalcularAtaque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder resultado = new StringBuilder();

                for (Robot robot : colaRobot.cola) {
                    int valorAtaque = robot.getPoder();
                    if (robot.getFaccion().equals("Autobot")) {
                        valorAtaque += valorAtaque * 0.25;
                    } else if (robot.getFaccion().equals("Decepticon")) {
                        valorAtaque += valorAtaque * 0.10;
                    }
                    resultado.append(robot.toString()).append(" -> Valor de ataque: ").append(valorAtaque).append("\n");
                }

                txtMostrar.setText(resultado.toString());
            }
        });

        btnCopiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String funcionSeleccionada = (String) cbElegir.getSelectedItem();
                Queue<Robot> nuevaCola = colaRobot.copiarCola(funcionSeleccionada);

                txtCopiados.setText("");
                for (Robot robot : nuevaCola) {
                    txtCopiados.append(robot.toString() + "\n");
                }

                txtMostrar.setText("");
                for (Robot robot : colaRobot.cola) {
                    txtMostrar.append(robot.toString() + "\n");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Cola de Robots");
        frame.setContentPane(new Ventana().main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
