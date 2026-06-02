package br.com.ifgoiano.algoritimos.sort;

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

    public static void imprimir(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            System.out.printf(" | %d", vetor[i]);
        }
        System.out.println(" |");
    }
}
