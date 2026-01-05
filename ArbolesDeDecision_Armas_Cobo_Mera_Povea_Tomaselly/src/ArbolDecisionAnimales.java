public class ArbolDecisionAnimales {

    Nodo raiz;

    public ArbolDecisionAnimales() {
        raiz = construirArbolInicial();
    }

    // Inicialización del árbol con datos base
    private Nodo construirArbolInicial() {
        Nodo n1 = new Nodo("Vive principalmente en el agua");

        // Rama Derecha
        Nodo n2 = new Nodo("Es un mamífero");
        Nodo n3 = new Nodo("Es muy grande");
        Nodo n4 = new Nodo("Es un depredador con dientes grandes");

        n3.izquierdo = new Nodo("Delfín");
        n3.derecho   = new Nodo("Ballena");
        n4.izquierdo = new Nodo("Pez Payaso");
        n4.derecho   = new Nodo("Tiburón");

        n2.izquierdo = n4;
        n2.derecho   = n3;
        n1.derecho = n2;

        // Rama Izquierda
        Nodo n5 = new Nodo("Puede volar");
        Nodo n6 = new Nodo("Es nocturno");
        Nodo n7 = new Nodo("Es un reptil");
        Nodo n8 = new Nodo("Tiene caparazón");
        Nodo n9 = new Nodo("Es doméstico");
        Nodo n10 = new Nodo("Ladra");
        Nodo n11 = new Nodo("Es muy grande");
        Nodo n12 = new Nodo("Tiene el cuello muy largo");
        Nodo n13 = new Nodo("Es un felino que ruge");

        n6.izquierdo = new Nodo("Águila");
        n6.derecho   = new Nodo("Búho");
        n5.derecho   = n6;

        n8.izquierdo = new Nodo("Serpiente");
        n8.derecho   = new Nodo("Tortuga");
        n7.derecho   = n8;

        n10.izquierdo = new Nodo("Gato");
        n10.derecho   = new Nodo("Perro");
        n9.derecho    = n10;

        n12.izquierdo = new Nodo("Elefante");
        n12.derecho   = new Nodo("Jirafa");
        n11.derecho   = n12;

        n13.izquierdo = new Nodo("Zorro");
        n13.derecho   = new Nodo("León");
        n11.izquierdo = n13;

        n9.izquierdo = n11;
        n7.izquierdo = n9;
        n5.izquierdo = n7;
        n1.izquierdo = n5;

        return n1;
    }

    // Método para generar la representación en texto del árbol
    public String obtenerArbolFormato() {
        StringBuilder sb = new StringBuilder();
        generarVistaRecursiva(raiz, sb, "", true);
        return sb.toString();
    }

    private void generarVistaRecursiva(Nodo nodo, StringBuilder sb, String prefijo, boolean esUltimo) {
        if (nodo != null) {
            sb.append(prefijo);
            sb.append(esUltimo ? "└── " : "├── ");

            if (nodo.esHoja()) {
                sb.append(" ").append(nodo.dato).append("\n");
            } else {
                sb.append("¿").append(nodo.dato).append("?\n");
            }

            String nuevoPrefijo = prefijo + (esUltimo ? "    " : "│   ");

            generarVistaRecursiva(nodo.izquierdo, sb, nuevoPrefijo, false);
            generarVistaRecursiva(nodo.derecho, sb, nuevoPrefijo, true);
        }
    }

    // Recorridos en profundidad
    public String preorden() { StringBuilder sb = new StringBuilder(); preorden(raiz, sb); return sb.toString(); }
    private void preorden(Nodo n, StringBuilder sb) { if(n!=null){ sb.append(n.dato).append("\n"); preorden(n.izquierdo, sb); preorden(n.derecho, sb); } }

    public String inorden() { StringBuilder sb = new StringBuilder(); inorden(raiz, sb); return sb.toString(); }
    private void inorden(Nodo n, StringBuilder sb) { if(n!=null){ inorden(n.izquierdo, sb); sb.append(n.dato).append("\n"); inorden(n.derecho, sb); } }

    public String postorden() { StringBuilder sb = new StringBuilder(); postorden(raiz, sb); return sb.toString(); }
    private void postorden(Nodo n, StringBuilder sb) { if(n!=null){ postorden(n.izquierdo, sb); postorden(n.derecho, sb); sb.append(n.dato).append("\n"); } }
}