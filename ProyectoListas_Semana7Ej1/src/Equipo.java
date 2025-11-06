import java.util.ArrayList;
import java.util.List;

public class Equipo {
    private List<Jugador> listado;

    public Equipo() {
        listado = new ArrayList<>();
    }

    public void agregar(Jugador jugador) {
        listado.add(jugador);
    }

    public boolean buscarEditar(int id, Jugador jugador) {
        int i = 0;
        int s = listado.size();
        int c;
        while (i <= s) {
            c=(i+s)/2;
            if(id==listado.get(c).getId()){
                listado.set(c,jugador);
                return true;
            } else if (id<listado.get(c).getId()) {
                s = c-1;
            } else  {
                i = c+1;
            }
        }
        return false;
    }

    public List<Jugador> obtenerTodos() {
        return listado;
    }



}

