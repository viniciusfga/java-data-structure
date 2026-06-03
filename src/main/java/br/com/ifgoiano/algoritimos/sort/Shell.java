package br.com.ifgoiano.algoritimos.sort;

public class Shell {

    void shellSort(int[] vetor) {
        int j, i, gap;
        int x;
        int nElems = vetor.length;

        gap = 1;
        do {
            gap = gap * 3 + 1;
        } while (gap < nElems);

        do {
            gap = gap / 3;

            for (i = gap; i < nElems; i++) {
                x = vetor[i];
                j = i;

                while (j >= gap && vetor[j - gap] > x) {
                    vetor[j] = vetor[j - gap];
                    j = j - gap;
                }
                vetor[j] = x;
            }
        } while (gap != 1);
    }
}
