public class Jugador {
    private int id;
    private String nombre;
    private float rendimiento;

    public Jugador(int id, String nombre, float rendimiento) {
        this.id = id;
        this.nombre = nombre;
        this.rendimiento = rendimiento;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getRendimiento() {
        return rendimiento;
    }

    public void setRendimiento(float rendimiento) {
        this.rendimiento = rendimiento;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Rendimiento: " + rendimiento + "\n";
    }
}
