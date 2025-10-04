import java.util.Stack;

public class Pila {
    private Stack<Character> pila;

    private int contadorCorchetes = 0;
    private int contadorLlaves = 0;
    private int contadorParentesis = 0;

    public Pila() {
        pila = new Stack<Character>();
    }

    public boolean esVacia() {
        return pila.isEmpty();
    }

    public void push(Character c){
        pila.push(c);
    }

    public Character pop() throws Exception {
        if (esVacia())
            throw new Exception("Codigo no balanceado");
        return pila.pop();
    }

    public boolean balanceo(String codigo) throws Exception {
        for (int i = 0; i < codigo.length(); i++) {
            if (codigo.charAt(i) == '(') {
                pila.push(codigo.charAt(i));
                contadorParentesis++;
            } else {
                if (codigo.charAt(i) == ')') {
                    if(this.pop() != '(') {
                        return false;
                    }
                }
            }

            if (codigo.charAt(i) == '{') {
                pila.push(codigo.charAt(i));
                contadorLlaves++;
            } else {
                if (codigo.charAt(i) == '}') {
                    if(this.pop() != '{') {}
                }
            }

            if (codigo.charAt(i) == '[') {
                pila.push(codigo.charAt(i));
                contadorCorchetes++;
            } else {
                if (codigo.charAt(i) == ']') {
                    if(this.pop() != '[') {
                        return false;
                    }
                }
            }
        }
        if(esVacia())
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "\nParéntesis abiertos: " + contadorParentesis +
                ", Llaves abiertas: " + contadorLlaves +
                ", Corchetes abiertos: " + contadorCorchetes;
    }
}
