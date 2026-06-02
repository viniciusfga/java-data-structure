package br.com.ifgoiano.algoritimos.sort;

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

    public static void imprimir(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            System.out.printf(" | %d", vetor[i]);
        }
        System.out.println(" |");
    }
}
