import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Pila {

    private Stack<Publicacion> pila;
    private Set<String> codigosEnPila = new HashSet<>();


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

    // Validar que el código no esté repetido
    public boolean numeroValido(int codigo) {
        for (Publicacion p : pila) {
            if (p.getCodigo() == codigo) {
                return false;
            }
        }
        return true;
    }

    public boolean push(Publicacion obj, int codigo) {
        if (codigosEnPila.contains(obj.getCodigo())){
            return false;
        } else {
            pila.push(obj);
            codigosEnPila.add(obj.getCodigo());
            return true;
        }
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
