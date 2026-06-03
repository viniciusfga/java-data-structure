package br.com.ifgoiano.algoritimos.sort;

/*
    Algoritmo Insertion Sort (Ordenação por seleção)

    Funcionamento:
    - Pega um elemento e "insere" ele no lugar correto à esquerda.

    Trocas:
    - Muitas (para mover elementos e abrir espaço).

    Complexidade:
    - Melhor caso: O(n)
    - Médio caso: O(n²)
    - Pior caso: O(n²)
*/

import static br.com.ifgoiano.algoritimos.sort.Utils.imprimir;

public class Insertion {

    void insertion(int[] vetor) {

        int j = 0;
        for (int i = 1; i < vetor.length; i++) {
            int aux = vetor[i];
            j = i;

            while (j > 0 && aux <= vetor[j - 1]) {
                vetor[j] = vetor[j - 1];
                j--;
            }
            vetor[j] = aux;
            imprimir(vetor);
        }
    }


}
