import java.util.LinkedList;
import java.util.Queue;

public class ColaAutos {
    Queue<Auto> cola;

    public ColaAutos() {
        cola = new LinkedList<Auto>();
    }

    public void encolar(Auto auto){
        cola.add(auto);
    }

    public Auto desencolar() throws Exception {
        if (cola.isEmpty()) {
            throw new Exception("Cola sin autos");
        }
        return cola.poll();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Auto auto : cola){
            sb.append(auto.toString()).append("\n");
        }
        return sb.toString();
    }

}
