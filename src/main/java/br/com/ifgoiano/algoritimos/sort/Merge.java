package br.com.ifgoiano.algoritimos.sort;

public class Merge {

    public static void mergeSort(int[] vetor, int ini, int fim) {
        if (ini >= fim) {
            return; // Caso base: subvetor com 0 ou 1 elemento já está ordenado
        }

        int meio = (ini + fim) / 2;

        // Divisão recursiva
        mergeSort(vetor, ini, meio);
        mergeSort(vetor, meio + 1, fim);

        // Conquista: Intercalação dos subvetores ordenados
        intercala(vetor, ini, meio, fim);
    }

    private static void intercala(int[] A, int ini, int meio, int fim) {
        // Vetor auxiliar B temporário para armazenar a junção
        int[] B = new int[A.length];

        // i1: início da primeira metade | i2: início da segunda metade
        int i = ini;
        int j = meio + 1;
        int k = ini;

        // Enquanto houver elementos em ambas as metades
        while (i <= meio && j <= fim) {
            if (A[i] <= A[j]) {
                B[k] = A[i];
                i++;
            } else {
                B[k] = A[j];
                j++;
            }
            k++;
        }

        // Copia os elementos restantes da primeira metade, se houver
        while (i <= meio) {
            B[k] = A[i];
            i++;
            k++;
        }

        // Copia os elementos restantes da segunda metade, se houver
        while (j <= fim) {
            B[k] = A[j];
            j++;
            k++;
        }

        // Transfere os elementos ordenados do vetor auxiliar B de volta para o vetor original A
        for (int idx = ini; idx <= fim; idx++) {
            A[idx] = B[idx];
        }
    }
}
