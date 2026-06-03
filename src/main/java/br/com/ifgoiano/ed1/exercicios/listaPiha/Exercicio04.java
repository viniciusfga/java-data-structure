package br.com.ifgoiano.ed1.exercicios.listaPiha;

/*
    Implemente boolean verificaPalidromo(String s)
 */
public class Exercicio04 {

    private String[] elementos;
    private int topo;
    private int capacidade;

    public Exercicio04(int tamanho) {
        this.capacidade = tamanho;
        this.elementos = new String[tamanho];
        this.topo = -1; // Indica que a pilha está vazia
    }

    public void push(String valor) {
        if (topo < capacidade - 1) {
            elementos[++topo] = valor;
        } else {
            System.out.println("Stack Overflow: A pilha está cheia!");
        }
    }

    public String pop() {
        if (topo >= 0) {
            return elementos[topo--];
        } else {
            System.out.println("Stack Underflow: A pilha está vazia!");
            return "vazio";
        }
    }

    public boolean empty() {
        return topo == -1;
    }

    public static boolean verificaPalidromo(Exercicio04 S) {
        Exercicio04 A = new Exercicio04(S.capacidade);
        Exercicio04 B = new Exercicio04(S.capacidade);
        Exercicio04 C = new Exercicio04(S.capacidade);

        while (!S.empty()) {
            String valor = S.pop();
            A.push(valor);
            B.push(valor);
        }

        while (!B.empty()) {
            String valor = B.pop();
            C.push(valor);
        }

        while (!C.empty()) {
            String valorA = C.pop();
            String valorB = A.pop();
            if (!valorA.equals(valorB)) {
                return false;
            }
            S.push(valorA);
        }

        return true;
    }

    public static void main(String[] args) {

        Exercicio04 A = new Exercicio04(4);

        A.push("A");
        A.push("B");
        A.push("B");
        A.push("A");

        System.out.println(verificaPalidromo(A));
    }
}
