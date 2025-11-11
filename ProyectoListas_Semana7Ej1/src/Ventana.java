import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Ventana {
    private JPanel panel;
    private JTabbedPane tabbedPane1;
    private JTextField txtId;
    private JTextField txtNombre;
    private JComboBox cboPosicion;
    private JSpinner spiRendimiento;
    private JButton btnAgregar;
    private JButton btnEditar;
    private JList lstEquipo;
    private JButton btnMostrar;
    Equipo equipo =new Equipo();
    int codigo=0;
    int indice;

    public Ventana(){
        SpinnerNumberModel spm=new SpinnerNumberModel(
                10,1,20,1);
        spiRendimiento.setModel(spm);
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id=Integer.parseInt(txtId.getText());
                String nombre=txtNombre.getText();
                String posicion=cboPosicion.getSelectedItem().toString();
                int rendimiento=Integer.parseInt(spiRendimiento.getValue().toString());
                if(id<=codigo) {
                JOptionPane.showMessageDialog(null,
                        "id invalido");
                }else{
                Jugador j=new Jugador(id,nombre,posicion,rendimiento);
                equipo.agregar(j);
                codigo=id;
                    JOptionPane.showMessageDialog(null,
                            "Jugador ingresado");
                }
            }
        });
        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultListModel dlm =new DefaultListModel();
                List<Jugador> eq1=equipo.todos();
                for(Jugador j:eq1){
                    dlm.addElement(j.toString());
                }
                lstEquipo.setModel(dlm);
            }
        });
        lstEquipo.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(lstEquipo.getSelectedIndex()!=-1){
                    indice=lstEquipo.getSelectedIndex();
                    Jugador eq=equipo.todos().get(indice);
                    txtId.setText(""+eq.getId());
                    txtNombre.setText(eq.getNombre());
                    cboPosicion.setSelectedItem(eq.getPosicion());
                    spiRendimiento.setValue(eq.getRendimiento());
                    JOptionPane.showMessageDialog(null,
                            "Revise la pantalla de ingreso");
                }
            }
        });
        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id=Integer.parseInt(txtId.getText());
                String nombre=txtNombre.getText();
                String posicion=cboPosicion.getSelectedItem().toString();
                int rendimiento=Integer.parseInt(spiRendimiento.getValue().toString());
                Jugador j=new Jugador(id,nombre,posicion,rendimiento);
                if(equipo.editar(id, j)){
                    JOptionPane.showMessageDialog(null,
                            "Equipo editado");
                }else{
                    JOptionPane.showMessageDialog(null,
                            "No existe el id");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
