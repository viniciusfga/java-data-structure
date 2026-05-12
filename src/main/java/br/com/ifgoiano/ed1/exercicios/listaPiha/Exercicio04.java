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

    public boolean vazia(){
        return topo == -1;
    }

    public static boolean verificaPalidromo(Exercicio04 stack) {
        Exercicio04 auxiliarA = new Exercicio04(stack.capacidade);
        Exercicio04 auxiliarB = new Exercicio04(stack.capacidade);
        Exercicio04 auxiliarC = new Exercicio04(stack.capacidade);

        while(!stack.vazia()){
            String valor = stack.pop();
            auxiliarA.push(valor);
            auxiliarB.push(valor);
        }

        while(!auxiliarB.vazia()){
            String valor = auxiliarB.pop();
            auxiliarC.push(valor);
        }

        while (!auxiliarC.vazia()){
            String elementoA = auxiliarA.pop();
            String elementoC = auxiliarC.pop();

            stack.push(elementoA);

            if (!elementoA.equals(elementoC)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Exercicio04 stack = new Exercicio04(4);

        stack.push("A");
        stack.push("B");
        stack.push("B");
        stack.push("E");

        System.out.println(verificaPalidromo(stack));
    }
}
