public class Paciente implements Comparable<Paciente> {
    private int prioridad;
    private String nombre;
    private String enfermedad;

    public Paciente(int prioridad, String nombre, String enfermedad) {
        this.prioridad = prioridad;
        this.nombre = nombre;
        this.enfermedad = enfermedad;
    }


    @Override
    public int compareTo(Paciente o) {
        if (this.prioridad < o.prioridad)
            return -1;
        else
            return 1;
        //return this.prioridad - o.prioridad;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "prioridad=" + prioridad +
                ", nombre='" + nombre + '\'' +
                ", enfermedad='" + enfermedad + '\'' +
                "} \n";
    }
}
