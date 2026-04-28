package exercicios.listas;

public class Exercicio13 {

    /*
    Escreva um método public void inverter() que inverta a ordem dos
    elementos da lista atual. O primeiro elemento passa a ser o último, o segundo passa a ser
    o penúltimo, e assim por diante. A inversão não pode instanciar uma nova Generics.Lista ou um
    novo vetor auxiliar.
    */

    public static class Lista {

        int[] elementos;
        int tamanho;

        public Lista(int capacidade) {
            elementos = new int[capacidade];
            tamanho = 0;
        }

        public void adicionar(int valor) {
            if (tamanho < elementos.length) {
                elementos[tamanho] = valor;
                tamanho++;
            }
        }


        public void inverter() {

            int inicio = 0;
            int fim = this.tamanho - 1;

            while (inicio < fim) {

                // troca elementos[inicio] com elementos[fim]
                int temp = this.elementos[inicio];
                this.elementos[inicio] = this.elementos[fim];
                this.elementos[fim] = temp;

                inicio++;
                fim--;
            }
        }

        public void imprimir() {
            for (int i = 0; i < tamanho; i++) {
                System.out.print(elementos[i] + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {

        Lista lista = new Lista(5);

        lista.adicionar(10);
        lista.adicionar(20);
        lista.adicionar(30);
        lista.adicionar(40);
        lista.adicionar(50);

        lista.imprimir();

        lista.inverter();

        lista.imprimir();

    }
}
