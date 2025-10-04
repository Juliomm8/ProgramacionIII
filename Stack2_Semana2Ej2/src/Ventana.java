import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel principal;
    private JTextArea txtCodigo;
    private JButton btnComprobar;
    private JLabel lblResultado;


    public Ventana() {
        btnComprobar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pila pila = new Pila();
                try {
                    String codigo = txtCodigo.getText();
                    if (pila.balanceo(codigo)){
                        lblResultado.setText("Código balanceado \n" + pila);
                    } else {
                        lblResultado.setText("Código no balanceado \n" + pila);
                    }
                } catch (Exception ex) {
                    lblResultado.setText(ex.getMessage());
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
