package br.com.ifgoiano.algoritimos.sort;

public class Quick {

    public static void main(String[] args) {

        int[] vetor = {26, 34, 9, 0, 4, 89, 6, 15, 27, 44};

        System.out.println("Vetor inicial:");
        imprimirVetor(vetor);

        System.out.println("\n================ INÍCIO DO QUICKSORT ================\n");

        quicksort(vetor);

        System.out.println("\n================ VETOR ORDENADO ================\n");
        imprimirVetor(vetor);
    }

    // ======================================================
    public static void quicksort(int V[]) {
        ordena(V, 0, V.length - 1);
    }

    // ======================================================
    private static void ordena(int[] vetor, int inicio, int fim) {

        if (inicio < fim) {

            System.out.println("------------------------------------------------");
            System.out.println("Ordenando intervalo [" + inicio + " até " + fim + "]");

            int posicaoPivo = particao(vetor, inicio, fim);

            System.out.println("Pivô colocado na posição: " + posicaoPivo);
            imprimirVetor(vetor);

            ordena(vetor, inicio, posicaoPivo - 1);
            ordena(vetor, posicaoPivo + 1, fim);
        }
    }

    // ======================================================
    public static int particao(int[] vetor, int inicio, int fim) {

        int pivo = vetor[inicio];

        int i = inicio + 1;
        int j = fim;

        System.out.println("\n>>> Nova Partição");
        System.out.println("Pivô escolhido: " + pivo + " (posição " + inicio + ")");

        while (i <= j) {

            System.out.println("\nAnalisando:");
            System.out.println("i = " + i + " -> " + vetor[i]);
            System.out.println("j = " + j + " -> " + vetor[j]);

            if (vetor[i] <= pivo) {

                System.out.println(vetor[i] + " <= " + pivo + "  -> i avança");
                i++;

            } else if (pivo < vetor[j]) {

                System.out.println(pivo + " < " + vetor[j] + " -> j recua");
                j--;

            } else {

                System.out.println("Troca entre " + vetor[i] + " e " + vetor[j]);

                int troca = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = troca;

                imprimirVetor(vetor);

                i++;
                j--;
            }
        }

        System.out.println("\nTroca final do pivô:");
        System.out.println("Troca " + vetor[inicio] + " com " + vetor[j]);

        vetor[inicio] = vetor[j];
        vetor[j] = pivo;

        imprimirVetor(vetor);

        return j;
    }

    public static void imprimirVetor(int[] vetor) {

        System.out.print("[ ");

        for (int valor : vetor) {
            System.out.print(valor + " ");
        }

        System.out.println("]");
    }
}