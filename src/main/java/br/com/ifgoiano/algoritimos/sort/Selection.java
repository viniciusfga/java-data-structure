package br.com.ifgoiano.algoritimos.sort;

import static br.com.ifgoiano.algoritimos.sort.Utils.imprimir;

/*
    Algoritmo Selection Sort (Ordenação por seleção)

    Funcionamento:
    - Minimiza trocas
    - Busca o menor elemento a cada iteração e o coloca na posição correta

     Trocas:
    - Poucas trocas (no máximo uma por passada).

    Complexidade:
    - Melhor caso: O(n²)
    - Médio caso: O(n²)
    - Pior caso: O(n²)
*/
public class Selection {

    void selectionSort(int[] vetor) {

        for (int i = 0; i < vetor.length - 1 ; i++) {
            int min = i;

            for (int j = i + 1; j < vetor.length ; j++) {
                if (vetor[j] < vetor[min] ) {
                    min = j;
                }
            }
            int aux = vetor[min];
            vetor[min] = vetor[i];
            vetor[i] = aux;

            imprimir(vetor);
        }
    }
}
