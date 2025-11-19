public class Paquete {
    private int trackID;
    private String ubicacion;
    private float peso;
    private String receptor;
    private String estado;

    public Paquete(int trackID, String ubicacion, float peso, String receptor, String estado) {
        this.trackID = trackID;
        this.ubicacion = ubicacion;
        this.peso = peso;
        this.receptor = receptor;
        this.estado = estado;
    }

    public int getTrackID() {
        return trackID;
    }

    public void setTrackID(int trackID) {
        this.trackID = trackID;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getReceptor() {
        return receptor;
    }

    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Paquete " +
                "trackID: " + trackID +
                ", ubicacion: '" + ubicacion +
                ", peso: " + peso +
                ", receptor: '" + receptor  +
                ", estado: '" + estado;
    }
}