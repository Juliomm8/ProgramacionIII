import java.util.LinkedList;
import java.util.Queue;

public class ColaRobot {
    public Queue<Robot> cola;

    public ColaRobot() {
        cola = new LinkedList<>();
        cola.offer(new Robot());
        cola.offer(new Robot(1, "Optimus Prime", "Autobot", 150, "Liderar"));
        cola.offer(new Robot(2, "Megatron", "Decepticon", 200, "Destruir"));
        cola.offer(new Robot(3, "Bumblebee", "Autobot", 120, "Volar"));
        cola.offer(new Robot(4, "Starscream", "Decepticon", 180, "Destruir"));
    }

    public void encolar() {
    }

    public void calcularValorAtaque() {
        for (Robot robot : cola) {
            int valorAtaque = robot.getPoder();
            if (robot.getFaccion().equals("Autobot")) {
                valorAtaque += valorAtaque * 0.25;
            } else if (robot.getFaccion().equals("Decepticon")) {
                valorAtaque += valorAtaque * 0.10;
            }
            System.out.println(robot.toString() + ", Valor de ataque: " + valorAtaque);
        }
    }

    public Queue<Robot> copiarCola(String funcionEspecifica) {
        Queue<Robot> nuevaCola = new LinkedList<>();
        for (Robot robot : cola) {
            if (robot.getFuncion().equals(funcionEspecifica)) {
                nuevaCola.offer(robot);
            }
        }
        return nuevaCola;
    }

    public void mostrarCola() {
        for (Robot robot : cola) {
            System.out.println(robot.toString());
        }
    }
}
