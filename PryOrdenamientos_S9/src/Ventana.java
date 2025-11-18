import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JTabbedPane tabbedPane1;
    private JPanel main;
    private JList lstTaller;
    private JButton btnOrdenarID;
    private JButton btnOrdenarPrecio;

    // Crear el objeto Taller (Se van a poner los datos automáticamente, porque en Taller pusimos el metodo predefinir en el constructor)
    private Taller miTaller = new Taller();

    // LLenar el JList con los datos del Taller
    public void llenarJList(){
        DefaultListModel dlm = new DefaultListModel();
        for(Motocicleta moto : miTaller.getTaller()){
            dlm.addElement(moto.toString());
        }
        lstTaller.setModel(dlm);
    }

    public Ventana() {
        llenarJList();
        btnOrdenarID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                miTaller.ordenarID();
                llenarJList();
            }
        });

        btnOrdenarPrecio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                miTaller.ordenarPrecio();
                llenarJList();
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
