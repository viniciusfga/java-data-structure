package br.com.ifgoiano.algoritimos.sort.impl;

public class Ordena {

    public void selection(int v[]) {
        for (int i = 0; i < v.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < v.length; j++) {
                if (v[j] < v[min])
                    min = j;
            }
            int aux = v[min];
            v[min] = v[i];
            v[i] = aux;
        }
    }

    public static void insertionSort_1(int v[]) {
        int j = 0;
        for (int i = 1; i < v.length; i++) {
            int aux = v[i];
            j = i;
            while (j > 0 && aux <= v[j - 1]) {
                v[j] = v[j - 1];
                j--;
            }
            v[j] = aux;
        }
    }

    public static void quicksort(int V[]) {
        ordena(V, 0, V.length - 1);
    }

    // ********************************************
    private static void ordena(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int posicaoPivo = particao(vetor, inicio, fim);
            ordena(vetor, inicio, posicaoPivo - 1);
            ordena(vetor, posicaoPivo + 1, fim);
        }
    }

    public static int particao(int[] vetor,
                               int inicio, int fim) {
        int pivo = vetor[inicio];
        int i = inicio + 1;
        int j = fim;
        while (i <= j) {
            if (vetor[i] <= pivo)
                i++;
            else if (pivo < vetor[j])
                j--;
            else {
                int troca = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = troca;
                i++;
                j--;
            }
        }
        vetor[inicio] = vetor[j];
        vetor[j] = pivo;
        return j;
    }
}
