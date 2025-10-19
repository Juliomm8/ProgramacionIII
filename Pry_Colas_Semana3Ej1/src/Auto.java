public class Auto {
    private String placa;
    private String modelo;
    String marca;
    private int anio;

    public Auto(String placa, String modelo, String marca, int anio) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.anio = anio;
    }

    public int getAnio() {
        return anio;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "placa='" + placa + '\'' +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", anio=" + anio +
                '}';
    }



}
