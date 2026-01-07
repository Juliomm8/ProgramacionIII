public class Nodo {
    private Jugador jugador;
    private Nodo izquierda;
    private Nodo derecha;

    public Nodo(Jugador jugador) {
        this.jugador = jugador;
        izquierda = derecha = null;
    }

    public Nodo(Jugador jugador, Nodo izquierda, Nodo derecha) {
        this.jugador = jugador;
        this.izquierda = izquierda;
        this.derecha = derecha;
    }

    // Getters y setters

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Nodo getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Nodo izquierda) {
        this.izquierda = izquierda;
    }

    public Nodo getDerecha() {
        return derecha;
    }

    public void setDerecha(Nodo derecha) {
        this.derecha = derecha;
    }

}
