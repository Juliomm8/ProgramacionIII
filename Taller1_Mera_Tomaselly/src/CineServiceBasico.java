import java.util.HashSet;
import java.util.Set;

public class CineServiceBasico {

    private static final int CAPACIDAD_SALA = 17;
    private int entradasPiratas = 0;
    private int entradasNaruto = 0;
    private int entradasAntman = 0;

    private Set<String> cedulasRegistradas = new HashSet<>();

    private static final int PRECIO_ENTRADA = 5;

    // Método para realizar la compra
    public String realizarCompra(String cedula, String pelicula, int cantidadEntradas) {
        // Verificar si la cédula ya está registrada
        if (cedulasRegistradas.contains(cedula)) {
            return "cedula_repetida";  // Error por cédula repetida
        }

        // Validar la cantidad de entradas
        if (cantidadEntradas < 1 || cantidadEntradas > 5) {
            return "cantidad_invalida";  // Error por cantidad no válida
        }

        // Validar la capacidad de la sala para cada película
        if (pelicula.equals("Piratas") && entradasPiratas + cantidadEntradas > CAPACIDAD_SALA) {
            return "no_capacidad";  // Error por falta de capacidad
        }
        if (pelicula.equals("Naruto") && entradasNaruto + cantidadEntradas > CAPACIDAD_SALA) {
            return "no_capacidad";  // Error por falta de capacidad
        }
        if (pelicula.equals("Antman") && entradasAntman + cantidadEntradas > CAPACIDAD_SALA) {
            return "no_capacidad";  // Error por falta de capacidad
        }

        // Registrar la compra
        cedulasRegistradas.add(cedula);

        // Actualizar la cantidad de entradas vendidas para la película correspondiente
        if (pelicula.equals("Piratas")) {
            entradasPiratas += cantidadEntradas;
        } else if (pelicula.equals("Naruto")) {
            entradasNaruto += cantidadEntradas;
        } else if (pelicula.equals("Antman")) {
            entradasAntman += cantidadEntradas;
        }

        return "compra_exitosa";  // Compra realizada con éxito
    }

    // Consultar los ingresos de cada película
    public String consultarIngresos() {
        int ingresosPiratas = entradasPiratas * PRECIO_ENTRADA;
        int ingresosNaruto = entradasNaruto * PRECIO_ENTRADA;
        int ingresosAntman = entradasAntman * PRECIO_ENTRADA;

        return "Ingresos por película:\n" +
                "Piratas: $" + ingresosPiratas + "\n" +
                "Naruto: $" + ingresosNaruto + "\n" +
                "Antman: $" + ingresosAntman;
    }
}
