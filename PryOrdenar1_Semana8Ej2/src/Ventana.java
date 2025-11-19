import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JList lstPaquete;
    private JButton btnOrdenar;
    private JPanel main;

    Oficina principal = new Oficina();

    public void llenarLista(){
        DefaultListModel dlm = new DefaultListModel();
        for (Paquete p: principal.getOficina()) {
            dlm.addElement(p.toString());
        }
        lstPaquete.setModel(dlm);
    }

    public Ventana() {

        llenarLista();

        btnOrdenar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                principal.ordenar();
                llenarLista();
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
