public class Robot {
    private int codigo;
    private String nombre;
    private String faccion;
    private int poder;
    private String funcion;

    public Robot() {
        this.codigo = 0;
        this.nombre = "Sin nombre";
        this.faccion = "Autobot";
        this.poder = 100;
        this.funcion = "Volar";
    }

    public Robot(int codigo, String nombre, String faccion, int poder, String funcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.faccion = faccion;
        this.poder = poder;
        this.funcion = funcion;
    }

    // Métodos Getter
    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFaccion() {
        return faccion;
    }

    public int getPoder() {
        return poder;
    }

    public String getFuncion() {
        return funcion;
    }

    public String toString() {
        return "Código: " + codigo + ", Nombre: " + nombre + ", Facción: " + faccion + ", Poder: " + poder + ", Función: " + funcion;
    }
}
