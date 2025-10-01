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
                int codigo = Integer.parseInt(txtCodigo.getText());                
                String titulo = txtTitulo.getText();
                String mensaje = txtMensaje.getText();
                Publicacion p = new Publicacion(codigo, titulo, mensaje);
                txtListar.append(p.toString());
                pila.push(p);
                txtListar.setText(pila.toString());
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
