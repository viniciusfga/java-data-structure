package br.com.ifgoiano.algoritimos.sort;

/*
    Algoritmo Bubble Sort (Ordenação por Bolha)

    Funcionamento:
    - Percorre a lista comparando pares adjacentes e os troca se estiverem fora de ordem.

    Trocas:
    - Muitas trocas contínuas.

    Complexidade:
    - Melhor caso: O(n)
    - Médio caso: O(n²)
    - Pior caso: O(n²)
*/

import static br.com.ifgoiano.algoritimos.sort.Utils.imprimir;

public class Bubble {

    void bubbleSort(int[] vetor) {
        int i, p;
        boolean trocou;
        int aux;

        p = vetor.length - 1;
        trocou = true;

        while (p > 0 && trocou) {
            trocou = false;
            i = 0;

            while (i < p) {
                if (vetor[i] > vetor[i + 1]) {
                    aux = vetor[i];
                    vetor[i] = vetor[i + 1];
                    vetor[i + 1] = aux;
                    trocou = true;
                }
                i++;
            }
            p--;

            imprimir(vetor);
        }
    }
}