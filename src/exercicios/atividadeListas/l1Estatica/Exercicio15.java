package exercicios.atividadeListas.l1Estatica;

public class Exercicio15 {

    /*
    Implemente o método public void removerDuplicatas(). Este método
    deve varrer a lista e, sempre que encontrar um elemento que já apareceu anteriormente,
    deve removê-lo, mantendo apenas a primeira ocorrência de cada item. Ao final, a lista
    deve ter seu tamanho ajustado corretamente e não ter "buracos" no vetor.
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


        public void removerDuplicatas() {

            for (int i = 0; i < this.tamanho; i++) {

                for (int j = i + 1; j < this.tamanho; j++) {

                    if (this.elementos[i] == this.elementos[j]) {

                        // desloca para a esquerda
                        for (int k = j; k < this.tamanho - 1; k++) {
                            this.elementos[k] = this.elementos[k + 1];
                        }

                        this.tamanho--;

                        j--; // volta uma posição para verificar o novo elemento

                    }

                }

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

        Exercicio15.Lista lista = new Exercicio15.Lista(5);

        lista.adicionar(10);
        lista.adicionar(20);
        lista.adicionar(10);
        lista.adicionar(40);
        lista.adicionar(50);

        lista.imprimir();

        lista.removerDuplicatas();

        lista.imprimir();

    }
}
