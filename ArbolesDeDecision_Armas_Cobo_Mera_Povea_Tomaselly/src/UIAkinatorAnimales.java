import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class UIAkinatorAnimales {

    private final ArbolDecisionAnimales arbol = new ArbolDecisionAnimales();
    private Nodo nodoActual;

    // Elementos de la GUI
    private JFrame frame;
    private JTextArea txtArbolVisual;
    private JLabel lblPreguntaPrincipal;
    private JButton btnSi, btnNo, btnReiniciar;
    private JTextArea txtLogJuego;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        SwingUtilities.invokeLater(() -> new UIAkinatorAnimales().iniciarUI());
    }

    private void iniciarUI() {
        nodoActual = arbol.raiz;

        // Configuración ventana principal
        frame = new JFrame("Sistema Experto: Clasificador de Animales");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1150, 700);
        frame.setLayout(new BorderLayout(15, 15));
        frame.getContentPane().setBackground(new Color(245, 245, 245));

        // Panel Izquierdo: Estructura del árbol
        txtArbolVisual = new JTextArea();
        txtArbolVisual.setEditable(false);
        txtArbolVisual.setFont(new Font("Consolas", Font.PLAIN, 14));
        txtArbolVisual.setBackground(new Color(30, 30, 30));
        txtArbolVisual.setForeground(new Color(100, 255, 100));
        actualizarArbolVisual();

        JScrollPane scrollArbol = new JScrollPane(txtArbolVisual);
        scrollArbol.setBorder(BorderFactory.createTitledBorder(" Estructura Lógica "));
        scrollArbol.setPreferredSize(new Dimension(400, 0));

        // Panel Central
        JPanel panelCentral = new JPanel(new BorderLayout(15, 15));
        panelCentral.setOpaque(false);
        panelCentral.setBorder(new EmptyBorder(10, 10, 10, 20));

        // Etiqueta de Pregunta Actual
        lblPreguntaPrincipal = new JLabel("Iniciando...", SwingConstants.CENTER);
        lblPreguntaPrincipal.setFont(new Font("Segoe UI", Font.BOLD, 26));
        lblPreguntaPrincipal.setOpaque(true);
        lblPreguntaPrincipal.setBackground(Color.WHITE);
        lblPreguntaPrincipal.setForeground(new Color(50, 50, 50));
        lblPreguntaPrincipal.setBorder(new CompoundBorder(
                new LineBorder(new Color(100, 149, 237), 2, true),
                new EmptyBorder(30, 20, 30, 20)
        ));
        lblPreguntaPrincipal.setPreferredSize(new Dimension(0, 140));

        // Log de actividades
        txtLogJuego = new JTextArea();
        txtLogJuego.setEditable(false);
        txtLogJuego.setFont(new Font("Monospaced", Font.PLAIN, 16));
        txtLogJuego.setBorder(new EmptyBorder(10, 10, 10, 10));
        JScrollPane scrollLog = new JScrollPane(txtLogJuego);
        scrollLog.setBorder(BorderFactory.createTitledBorder(" Historial de Decisiones "));

        // Panel de Botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 10));
        panelBotones.setOpaque(false);

        btnSi = crearBoton("SÍ", new Color(34, 139, 34));
        btnNo = crearBoton("NO", new Color(220, 20, 60));
        btnReiniciar = crearBoton("Reiniciar", Color.GRAY);

        panelBotones.add(btnSi);
        panelBotones.add(btnNo);
        panelBotones.add(btnReiniciar);

        panelCentral.add(lblPreguntaPrincipal, BorderLayout.NORTH);
        panelCentral.add(scrollLog, BorderLayout.CENTER);
        panelCentral.add(panelBotones, BorderLayout.SOUTH);

        // Panel Inferior: Recorridos
        JPanel panelRecorridos = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelRecorridos.setBackground(new Color(230, 230, 230));

        JButton btnPre = new JButton("Preorden");
        JButton btnIn = new JButton("Inorden");
        JButton btnPost = new JButton("Postorden");

        btnPre.addActionListener(e -> mostrarRecorrido("Preorden", arbol.preorden()));
        btnIn.addActionListener(e -> mostrarRecorrido("Inorden", arbol.inorden()));
        btnPost.addActionListener(e -> mostrarRecorrido("Postorden", arbol.postorden()));

        panelRecorridos.add(new JLabel("Recorridos: "));
        panelRecorridos.add(btnPre);
        panelRecorridos.add(btnIn);
        panelRecorridos.add(btnPost);

        frame.add(scrollArbol, BorderLayout.WEST);
        frame.add(panelCentral, BorderLayout.CENTER);
        frame.add(panelRecorridos, BorderLayout.SOUTH);

        // Action Listeners
        btnSi.addActionListener(e -> procesarRespuesta(true));
        btnNo.addActionListener(e -> procesarRespuesta(false));
        btnReiniciar.addActionListener(e -> reiniciarJuego());

        reiniciarJuego();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JButton crearBoton(String texto, Color fondo) {
        JButton btn = new JButton(texto);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btn.setBackground(fondo);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setOpaque(true);
        btn.setPreferredSize(new Dimension(180, 60));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return btn;
    }

    private void reiniciarJuego() {
        nodoActual = arbol.raiz;
        txtLogJuego.setText("");
        txtLogJuego.append("--- NUEVO JUEGO ---\n");
        txtLogJuego.append("Esperando entrada...\n\n");
        actualizarPregunta();
        btnSi.setEnabled(true);
        btnNo.setEnabled(true);
        btnReiniciar.setEnabled(false);
    }

    private void procesarRespuesta(boolean respuestaSi) {
        txtLogJuego.append("Pregunta: " + nodoActual.dato + "\n");
        txtLogJuego.append("Respuesta: " + (respuestaSi ? "SÍ" : "NO") + "\n\n");

        nodoActual = respuestaSi ? nodoActual.derecho : nodoActual.izquierdo;
        verificarEstado();
    }

    private void verificarEstado() {
        if (nodoActual.esHoja()) {
            int confirmacion = JOptionPane.showConfirmDialog(frame,
                    "¿Estás pensando en: " + nodoActual.dato + "?",
                    "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (confirmacion == JOptionPane.YES_OPTION) {
                txtLogJuego.append("Resultado: Acierto (" + nodoActual.dato + ")\n");
                lblPreguntaPrincipal.setText("¡Adiviné! Es " + nodoActual.dato);
                lblPreguntaPrincipal.setForeground(new Color(0, 100, 0));
                btnSi.setEnabled(false);
                btnNo.setEnabled(false);
                btnReiniciar.setEnabled(true);
            } else {
                aprenderNuevoAnimal();
            }
        } else {
            actualizarPregunta();
        }
    }

    private void aprenderNuevoAnimal() {
        String animalViejo = nodoActual.dato;
        lblPreguntaPrincipal.setText("No encontrado");

        String nuevoAnimal = JOptionPane.showInputDialog(frame, "No he podido adivinarlo. ¿Qué animal era?");
        if (nuevoAnimal == null || nuevoAnimal.trim().isEmpty()) return;

        String diferencia = JOptionPane.showInputDialog(frame,
                "Escribe una pregunta que sea VERDADERA para " + nuevoAnimal + "\n" +
                        "y FALSA para " + animalViejo + ":");
        if (diferencia == null || diferencia.trim().isEmpty()) return;

        // Inserción de nuevo nodo
        nodoActual.dato = diferencia;
        nodoActual.derecho = new Nodo(nuevoAnimal);
        nodoActual.izquierdo = new Nodo(animalViejo);

        txtLogJuego.append("Nuevo conocimiento agregado: " + nuevoAnimal + "\n");
        actualizarArbolVisual();

        JOptionPane.showMessageDialog(frame, "Base de conocimiento actualizada.");
        reiniciarJuego();
    }

    private void actualizarPregunta() {
        lblPreguntaPrincipal.setForeground(new Color(50, 50, 50));
        lblPreguntaPrincipal.setText("¿" + nodoActual.dato + "?");
    }

    private void actualizarArbolVisual() {
        txtArbolVisual.setText(arbol.obtenerArbolFormato());
        txtArbolVisual.setCaretPosition(0);
    }

    private void mostrarRecorrido(String titulo, String datos) {
        JTextArea area = new JTextArea(datos);
        area.setWrapStyleWord(true);
        area.setLineWrap(true);
        area.setEditable(false);
        area.setFont(new Font("Consolas", Font.PLAIN, 14));
        JScrollPane scroll = new JScrollPane(area);
        scroll.setPreferredSize(new Dimension(500, 300));

        JOptionPane.showMessageDialog(frame, scroll, "Recorrido: " + titulo, JOptionPane.INFORMATION_MESSAGE);
    }
}