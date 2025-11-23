import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestorCaballeros {

    private Map<Integer, Caballero> caballeros;

    public GestorCaballeros() {
        caballeros = new HashMap<Integer, Caballero>();

        try {
            cargarCaballerosIniciales();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Caballero registrarCaballero(int idCaballero,String nombre, RangoCaballero rango, String constelacion, int nivelPoder, String misionAsignada, int nivelDificultad, double recompensa) throws Exception {

        if (caballeros.containsKey(idCaballero)) {
            throw new Exception("Ya existe un caballero con el ID " + idCaballero);
        }

        Caballero caballero = new Caballero(idCaballero, nombre, rango, constelacion, nivelPoder, misionAsignada, nivelDificultad, recompensa
        );

        caballeros.put(idCaballero, caballero);
        return caballero;
    }


    public Caballero buscarPorId(int idCaballero) {
        return caballeros.get(idCaballero);
    }

    public List<Caballero> listarCaballeros() {
        return new ArrayList<Caballero>(caballeros.values());
    }

    public boolean modificarCaballero(int idCaballero, String nombre, RangoCaballero rango, String constelacion,int nivelPoder, String misionAsignada, int nivelDificultad, double recompensa) {
        Caballero caballero = caballeros.get(idCaballero);

        if (caballero == null) {
            return false;
        }

        caballero.setNombre(nombre);
        caballero.setRango(rango);
        caballero.setConstelacion(constelacion);
        caballero.setNivelPoder(nivelPoder);
        caballero.setMisionAsignada(misionAsignada);
        caballero.setNivelDificultad(nivelDificultad);
        caballero.setRecompensa(recompensa);
        caballero.recalcularValoresEconomicos();

        return true;
    }

    public boolean eliminarCaballero(int idCaballero) {
        Caballero eliminado = caballeros.remove(idCaballero);
        return (eliminado != null);
    }

    public void recalcularValoresEconomicosTodos() {
        for (Caballero c : caballeros.values()) {
            c.recalcularValoresEconomicos();
        }
    }

    private void cargarCaballerosIniciales() throws Exception {
        registrarCaballero(1, "Seiya", RangoCaballero.BRONCE, "Pegaso", 8, "Proteger a Atena", 3, 150000);
        registrarCaballero(2, "Shiryu", RangoCaballero.BRONCE, "Dragón", 8, "Defender los cinco picos", 4, 180000);
        registrarCaballero(3, "Hyoga", RangoCaballero.ORO, "Cisne", 7, "Salvar a su madre", 2, 120000);
        registrarCaballero(4, "Shun", RangoCaballero.BRONCE, "Andrómeda", 7, "Proteger el santuario", 3, 200000);
        registrarCaballero(5, "Ikki", RangoCaballero.PLATA, "Fénix", 9, "Derrotar espectros", 5, 400000);
    }

}
