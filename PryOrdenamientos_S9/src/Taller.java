import java.util.ArrayList;
import java.util.List;

public class Taller {
    private List<Motocicleta> taller;

    public Taller(){
        taller = new ArrayList<Motocicleta>();
        predefinir();
    }

    public void predefinir(){
        taller.add(new Motocicleta(2,"Yamaha",200,15000.24f,2015));
        taller.add(new Motocicleta(3,"Suzuki",250,2999.99f,2020));
        taller.add(new Motocicleta(5,"Ducati",350,30000.25f,2030));
        taller.add(new Motocicleta(4,"Kawasaki",300,25000.99f,2025));
        taller.add(new Motocicleta(1,"Honda",150,10000f,2010));
    }

    public void agregar(Motocicleta moto){
        taller.add(moto);
    }

    // Se ordena con el algoritmo de la burbuja
    public void ordenarID(){
        Motocicleta aux;

        for(int i = 0; i < taller.size() - 1 ; i++){
            for (int j = i + 1; j < taller.size(); j++){
                if(taller.get(i).getCodigo() > taller.get(j).getCodigo()){
                    aux = taller.get(i);
                    taller.set(i, taller.get(j));
                    taller.set(j, aux);
                }
            }
        }
    }

    // Se ordena con el algoritmo de Inserción
    public void ordenarPrecio(){
        Motocicleta aux;
        int j;
        for(int i = 1; i < taller.size(); i++){
            aux = taller.get(i);
            j = i - 1;

            while (j >= 0 && taller.get(j).getPrecio() > aux.getPrecio()){
                taller.set(j + 1, taller.get(j));
                j--;
            }
            taller.set(j + 1, aux);
        }
    }

    // se ordena con el algoritmo de burbuja
    public void ordenarCilindraje(){
        Motocicleta aux;

        for(int i = 0; i < taller.size() - 1 ; i++){
            for (int j = i + 1; j < taller.size(); j++){
                if(taller.get(i).getCilindraje() < taller.get(j).getCilindraje()){
                    aux = taller.get(i);
                    taller.set(i, taller.get(j));
                    taller.set(j, aux);
                }
            }
        }
    }

    public List<Motocicleta> getTaller() {
        return taller;
    }

}
