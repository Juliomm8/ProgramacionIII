import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Clinica {
    private PriorityQueue<Paciente> pacientes;

    public Clinica() {
        pacientes = new PriorityQueue<Paciente>();
    }

    public void encolarPaciente(Paciente p) {
        pacientes.add(p);
    }

    public Paciente desencolar() throws Exception{
        if (pacientes.isEmpty())
            throw new Exception("No hay pacientes en la clinica");
        return pacientes.poll();
    }

    public List<Paciente> listarPacientes() {
        return new ArrayList<>(pacientes);
    }

}
