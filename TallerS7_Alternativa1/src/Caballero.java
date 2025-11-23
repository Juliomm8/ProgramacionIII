public class Caballero {
    private int idCaballero;
    private String nombre;
    private RangoCaballero rango;
    private String constelacion;
    private int nivelPoder;
    private String misionAsignada;
    private int nivelDificultad;
    private double recompensa;
    private double aporteSantuario;
    private double impuestoReino;
    private double recompensaNeta;

    public Caballero(int idCaballero, String nombre, RangoCaballero rango, String constelacion, int nivelPoder, String misionAsignada, int nivelDificultad, double recompensa) {
        this.idCaballero = idCaballero;
        this.nombre = nombre;
        this.rango = rango;
        this.constelacion = constelacion;
        this.nivelPoder = nivelPoder;
        this.misionAsignada = misionAsignada;
        this.nivelDificultad = nivelDificultad;
        this.recompensa = recompensa;

        recalcularValoresEconomicos();
    }

    public void recalcularValoresEconomicos() {
        aporteSantuario = CalculadoraImpuestos.calcularAporteSantuario(recompensa);
        impuestoReino = CalculadoraImpuestos.calcularImpuestoReino(recompensa);
        recompensaNeta = CalculadoraImpuestos.calcularRecompensaNeta(recompensa, aporteSantuario, impuestoReino);
    }


    public int getIdCaballero() {
        return idCaballero;
    }

    public void setIdCaballero(int idCaballero) {
        this.idCaballero = idCaballero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public RangoCaballero getRango() {
        return rango;
    }

    public void setRango(RangoCaballero rango) {
        this.rango = rango;
    }

    public String getConstelacion() {
        return constelacion;
    }

    public void setConstelacion(String constelacion) {
        this.constelacion = constelacion;
    }

    public int getNivelPoder() {
        return nivelPoder;
    }

    public void setNivelPoder(int nivelPoder) {
        this.nivelPoder = nivelPoder;
    }

    public String getMisionAsignada() {
        return misionAsignada;
    }

    public void setMisionAsignada(String misionAsignada) {
        this.misionAsignada = misionAsignada;
    }

    public int getNivelDificultad() {
        return nivelDificultad;
    }

    public void setNivelDificultad(int nivelDificultad) {
        this.nivelDificultad = nivelDificultad;
    }

    public double getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(double recompensa) {
        this.recompensa = recompensa;
    }

    public double getAporteSantuario() {
        return aporteSantuario;
    }

    public void setAporteSantuario(double aporteSantuario) {
        this.aporteSantuario = aporteSantuario;
    }

    public double getImpuestoReino() {
        return impuestoReino;
    }

    public void setImpuestoReino(double impuestoReino) {
        this.impuestoReino = impuestoReino;
    }

    public double getRecompensaNeta() {
        return recompensaNeta;
    }

    public void setRecompensaNeta(double recompensaNeta) {
        this.recompensaNeta = recompensaNeta;
    }

    @Override
    public String toString() {
        return "Caballero{" +
                "idCaballero=" + idCaballero +
                ", nombre='" + nombre + '\'' +
                ", rango=" + rango +
                ", constelacion='" + constelacion + '\'' +
                ", nivelPoder=" + nivelPoder +
                ", misionAsignada='" + misionAsignada + '\'' +
                ", nivelDificultad=" + nivelDificultad +
                ", recompensa=" + recompensa +
                ", aporteSantuario=" + aporteSantuario +
                ", impuestoReino=" + impuestoReino +
                ", recompensaNeta=" + recompensaNeta +
                "} \n";
    }
}
