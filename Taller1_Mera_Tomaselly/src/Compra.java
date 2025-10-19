public class Compra {

    private String cedula;
    private String pelicula;
    private int cantidadEntradas;
    private int valorTotal;

    // Constructor de la clase
    public Compra(String cedula, String pelicula, int cantidadEntradas) {
        this.cedula = cedula;
        this.pelicula = pelicula;
        this.cantidadEntradas = cantidadEntradas;
        this.valorTotal = cantidadEntradas * 5; // El valor de cada entrada es $5
    }

    // Métodos getters y setters
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getPelicula() {
        return pelicula;
    }

    public void setPelicula(String pelicula) {
        this.pelicula = pelicula;
    }

    public int getCantidadEntradas() {
        return cantidadEntradas;
    }

    public void setCantidadEntradas(int cantidadEntradas) {
        this.cantidadEntradas = cantidadEntradas;
        this.valorTotal = cantidadEntradas * 5; // Actualiza el valor total si cambia la cantidad de entradas
    }

    public int getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(int valorTotal) {
        this.valorTotal = valorTotal;
    }

    // Método para representar la compra como una cadena de texto
    @Override
    public String toString() {
        return "Película: " + pelicula + "\n" +
                "Cédula: " + cedula + "\n" +
                "Entradas compradas: " + cantidadEntradas + "\n" +
                "Valor a pagar: $" + valorTotal;
    }
}
