import java.util.ArrayList;
import java.util.List;

public class Oficina {
    private List<Paquete> oficina;

    public Oficina(){
        oficina= new ArrayList<Paquete>();
        predefinir();
    }

    public void predefinir(){
        Paquete p2 = new Paquete(2, "Cuenca", 20.5f, "Maria", "Entregado");
        Paquete p1 = new Paquete(1, "Quito", 1.78f, "Juan", "En camino");
        Paquete p3 = new Paquete(3, "Valencia", 15.1f,"Luis", "En camino");
        Paquete p4 = new Paquete(4, "Sevilla", 12.7f, "Ana", "En camino");
        Paquete p5 = new Paquete(5, "Bilbao", 18.9f, "Pedro", "En camino");
        oficina.add(p1);
        oficina.add(p2);
        oficina.add(p3);
        oficina.add(p4);
        oficina.add(p5);
    }

    public void ordenar(){
        Paquete aux;

        for (int i = 0; i < oficina.size() - 1; i++) {
            for (int j = i + 1; j < oficina.size(); j++) {
                if (oficina.get(i).getPeso() > oficina.get(j).getPeso()) {
                    aux = oficina.get(i);
                    oficina.set(i, oficina.get(j));
                    oficina.set(j, aux);
                }
            }
        }

    }

    public List<Paquete> getOficina() {
        return oficina;
    }


}
