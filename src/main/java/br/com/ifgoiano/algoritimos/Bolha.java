package br.com.ifgoiano.algoritimos;

/*
    Algoritmo Bubble Sort (Ordenação por Bolha)

    Funcionamento:
    - Percorre o vetor várias vezes.
    - Compara elementos adjacentes.
    - Realiza troca caso estejam fora de ordem.
    - A cada passagem, o maior elemento "borbulha"
      para o final do vetor.

    Complexidade:
    - Melhor caso: O(n²)
    - Médio caso: O(n²)
    - Pior caso: O(n²)
*/

public class Bolha {

    public static void main(String[] args) {

        int[] vetor = {2, 8, 5, 3, 6, 9, 4, 1};
        for (int numeros : vetor) {
            System.out.print(numeros + " ");
        }
        System.out.println();
        int n = vetor.length;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n - 1; j++) {

                if (vetor[j] > vetor[j + 1]) {

                    int aux = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = aux;
                }
            }
        }

        for (int numeros : vetor) {
            System.out.print(numeros + " ");
        }
    }
}