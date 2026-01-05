public class Nodo {
    String dato;
    Nodo izquierdo; // Representa la opción NO
    Nodo derecho;   // Representa la opción SÍ

    public Nodo(String dato) {
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
    }

    public boolean esHoja() {
        // Es hoja si no tiene hijos (es un resultado final)
        return izquierdo == null && derecho == null;
    }
}