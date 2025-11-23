public class CalculadoraImpuestos {

    public static double calcularAporteSantuario(double recompensa) {
        return recompensa * 0.10;
    }

    public static double calcularImpuestoReino(double recompensa) {
        double impuesto = 0.0;

        if (recompensa <= 100000) {
            impuesto = 0.0;
        } else if (recompensa <= 200000) {
            impuesto = (recompensa - 100000) * 0.12;
        } else if (recompensa <= 400000) {
            impuesto = (100000 * 0.12) + (recompensa - 200000) * 0.25;
        } else {
            impuesto = (100000 * 0.12) + (200000 * 0.25) + (recompensa - 400000) * 0.35;
        }

        return impuesto;
    }

    public static double calcularRecompensaNeta(double recompensa,
                                                double aporte,
                                                double impuesto) {
        return recompensa - aporte - impuesto;
    }
}
