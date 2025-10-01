import java.util.Stack;

public class Pila {

    private Stack<Publicacion> pila;

    public Pila(){
        pila = new Stack<Publicacion>();
    }

    public boolean esVacia(){
        return pila.isEmpty();
    }

    public void push(Publicacion obj){
        pila.push(obj);
    }

    public Publicacion pop() throws Exception{
        if(esVacia())
            throw new Exception("Pila sin elementos");
        return pila.pop();
    }

    public Publicacion peek() throws Exception{
        if(esVacia())
            throw new Exception("Pila vacía");
        return pila.peek();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i=pila.size()-1; i>=0; i--) {
            sb.append(pila.get(i).toString());
        }
        return "Pila:\n" + sb.toString();
    }
}


// Completar una validación para que no se puedan ingresar códigos repetidos.
// hacer una etiqueta de cuantos elementos hay en la pila.
// Agregar un botón para eliminar el último elemento ingresado.
// Agregar un botón para mostrar el último elemento ingresado.
