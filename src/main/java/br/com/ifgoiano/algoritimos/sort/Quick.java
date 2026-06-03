package br.com.ifgoiano.algoritimos.sort;

import static br.com.ifgoiano.algoritimos.sort.Utils.imprimir;

public class Quick {

    public static void quicksort(int[] V) {
        ordena(V, 0, V.length - 1);
    }

    private static void ordena(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int pivo = particao(vetor, inicio, fim);

            ordena(vetor, inicio, pivo - 1);
            ordena(vetor, pivo + 1, fim);
        }
    }

    public static int particao(int[] vetor, int inicio, int fim) {
        int pivo = vetor[inicio];
        int i = inicio + 1;
        int j = fim;

        while (i <= j) {
            if (vetor[i] <= pivo) {
                i++;
            } else if (pivo < vetor[j]) {
                j--;
            } else {
                int troca = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = troca;

                i++;
                j--;
            }
        }

        // Troca final para posicionar o pivô corretamente
        vetor[inicio] = vetor[j];
        vetor[j] = pivo;

        return j;
    }
}