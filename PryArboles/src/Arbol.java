import java.util.LinkedList;
import java.util.Queue;

public class Arbol {
    private Nodo raiz;

    public Arbol() {
        raiz = null;
    }

    public void predefinir() {
        agregar(new Jugador(6, "Luis", 50f));
        agregar(new Jugador(3, "Pedro", 80f));
        agregar(new Jugador(4, "Ana", 70f));
        agregar(new Jugador(1, "Juan", 100f));
        agregar(new Jugador(5, "Jose", 60f));
        agregar(new Jugador(2, "Maria", 90f));
    }

    public Queue<Nodo> niveles(){
        Queue<Nodo> c1 = new LinkedList<>();
        Queue<Nodo> c2 = new LinkedList<>();
        Nodo aux = null;
        c1.add(raiz);

        while (!c1.isEmpty()){
            aux = c1.poll();
            if(aux.getIzquierda()!=null) c1.add(aux.getIzquierda());
            if(aux.getDerecha()!=null) c1.add(aux.getDerecha());
            c2.add(aux);
        }
        return c2;
    }

    private void agregar(Nodo actual, Jugador j){
        if(j.getId()<actual.getJugador().getId()){
            if(actual.getIzquierda()==null){
                actual.setIzquierda(new Nodo(j));
            }else{
                agregar(actual.getIzquierda(), j);
            }
        }else{
            if(actual.getDerecha()==null){
                actual.setDerecha(new Nodo(j));
            }
        }
    }

    public void agregar(Jugador j) {
        if(raiz == null){
            raiz = new Nodo(j);
        }else{
            agregar(raiz, j); //recursividad
        }

    }

    private String inOrden(Nodo actual){
        if(actual != null){
            return inOrden(actual.getIzquierda())
                    + actual.getJugador().toString()
                    + inOrden(actual.getDerecha());
        }
        return "";
    }

    public String inOrden(){
        if (raiz == null)
            return "Arbol vacio";
        else
            return inOrden(raiz);
    }

}
