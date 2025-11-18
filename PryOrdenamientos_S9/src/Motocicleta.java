public class Motocicleta {
    private int codigo;
    private String marca;
    private int cilindraje;
    private float precio;
    private int anio;

    public Motocicleta(int codigo, String marca, int cilindraje, float precio, int anio) {
        this.codigo = codigo;
        this.marca = marca;
        this.cilindraje = cilindraje;
        this.precio = precio;
        this.anio = anio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Override
    public String toString() {
        return "Motocicleta " +
                "codigo:" + codigo +
                ", marca:'" + marca + '\'' +
                ", cilindraje:" + cilindraje + " cc" +
                ", anio:" + anio +
                ", precio:" + precio;
    }
}
