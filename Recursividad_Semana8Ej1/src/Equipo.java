import java.util.ArrayList;
import java.util.List;

public class Equipo {
    private List<Jugador> listado;

    public Equipo(){
        listado=new ArrayList<Jugador>();
    }

    public void agregar(Jugador dato){
        listado.add(dato);
    }

    public boolean editar(int id, Jugador dato){
        int i=0;
        int s=listado.size()-1;
        int c;
        while(i<=s){
            c=(i+s)/2;
            if(id==listado.get(c).getId()){
                listado.set(c,dato);
                return true;
            }else if(id<listado.get(c).getId()){
                s=c-1;
            }else{
                i=c+1;
            }
        }
        return false;

    }

    public List<Jugador> todos(){
        return listado;
    }

    public int sumarRecursivo(int i){
        if(i==listado.size()){
        //caso base
            return 0;
        }else{
        //caso recursivo
            return sumarRecursivo(i+1)+1;
        }
    }

    // Solo sumar los de ID impar

    int sumarRecursivoRendimieto(int i){
        if(i==listado.size()){
            return 0;
        } else {
            return listado.get(i).getRendimiento() + sumarRecursivoRendimieto(i+1);
        }
    }

    int sumarImparRendimieto(int i){
        if(i==listado.size()){
            return 0;
        } else {
            if (listado.get(i).getId() % 2 != 0) {
                return listado.get(i).getRendimiento() + sumarImparRendimieto(i+1);
            } else {
                return sumarImparRendimieto(i+1);
            }
        }
    }

}
