import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel principal;
    private JTextField txtCodigo;
    private JTextField txtTitulo;
    private JTextArea txtMensaje;
    private JButton btnRegistrar;
    private JTextArea txtListar;
    
    Pila pila = new Pila();

    public Ventana() {
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int codigo = Integer.parseInt(txtCodigo.getText());
                    if (pila.codigoExiste(codigo)) {
                        JOptionPane.showMessageDialog(null, "El código ya existe en la pila.");
                        return;
                    }

                    String titulo = txtTitulo.getText();
                    String mensaje = txtMensaje.getText();

                    Publicacion p = new Publicacion(codigo, titulo, mensaje);
                    pila.push(p);

                    txtListar.setText(pila.toString());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "El código debe ser un número válido.");
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
