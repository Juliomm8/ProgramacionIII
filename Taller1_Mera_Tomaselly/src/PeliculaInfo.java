public class PeliculaInfo {

    private String nombrePelicula;
    private int entradasVendidas;
    private int ingresos;

    // Constructor
    public PeliculaInfo(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
        this.entradasVendidas = 0;
        this.ingresos = 0;
    }

    // Getters y Setters
    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    public int getEntradasVendidas() {
        return entradasVendidas;
    }

    public void setEntradasVendidas(int entradasVendidas) {
        this.entradasVendidas = entradasVendidas;
        this.ingresos = entradasVendidas * 5; // Calcula los ingresos según las entradas vendidas
    }

    public int getIngresos() {
        return ingresos;
    }

    public void setIngresos(int ingresos) {
        this.ingresos = ingresos;
    }

    // Metodo para agregar entradas vendidas
    public void agregarEntradas(int cantidadEntradas) {
        this.entradasVendidas += cantidadEntradas;
        this.ingresos = this.entradasVendidas * 5; // Actualiza los ingresos
    }

    // Metodo para representar la información de la película como cadena de texto
    @Override
    public String toString() {
        return "Película: " + nombrePelicula + "\n" +
                "Entradas Vendidas: " + entradasVendidas + "\n" +
                "Ingresos: $" + ingresos;
    }
}
