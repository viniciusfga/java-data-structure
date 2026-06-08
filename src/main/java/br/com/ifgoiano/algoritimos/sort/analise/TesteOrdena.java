package br.com.ifgoiano.algoritimos.sort.analise;

/**
 * Autores: Vinicius Franco Gonçalves Araújo
 * <p>
 * Disciplina: Estrutura de Dados I
 * Data: 26/05/2026
 * <p>
 * Objetivo: Classe responsável por realizar os testes de desempenho dos
 * algoritmos de ordenação. Executa cada algoritmo 100 vezes para cada
 * dataset e calcula a média dos tempos de execução.
 */

import java.io.IOException;

public class TesteOrdena {

    private static final int NUMERO_EXECUCOES = 100;

    /**
     * Testa um algoritmo de ordenação específico
     * @param vetorOriginal Vetor original (não será modificado)
     * @param algoritmo Nome do algoritmo (selectionSort, insertionSort, quickSort)
     * @return Tempo médio em nanossegundos
     */
    public static long testarAlgoritmo(Item[] vetorOriginal, String algoritmo) {
        long tempoTotal = 0;

        for (int i = 0; i < NUMERO_EXECUCOES; i++) {
            // Cria uma cópia do vetor para não modificar o original
            Item[] vetorCopia = Utilidades.copiarVetor(vetorOriginal);

            // Inicia a contagem de tempo
            long inicio = System.nanoTime();

            // Executa o algoritmo apropriado
            switch (algoritmo.toLowerCase()) {
                case "selectionsort":
                    Ordena.selectionSort(vetorCopia);
                    break;
                case "insertionsort":
                    Ordena.insertionSort(vetorCopia);
                    break;
                case "quicksort":
                    Ordena.quickSort(vetorCopia);
                    break;
                default:
                    throw new IllegalArgumentException("Algoritmo desconhecido: " + algoritmo);
            }

            // Finaliza a contagem de tempo
            long fim = System.nanoTime();
            tempoTotal += (fim - inicio);

            // Verifica se está ordenado corretamente (apenas na primeira execução)
            if (i == 0 && !Ordena.estaOrdenado(vetorCopia)) {
                System.err.println("ERRO: Vetor não está ordenado corretamente!");
            }
        }

        // Retorna a média dos tempos
        return tempoTotal / NUMERO_EXECUCOES;
    }

    /**
     * Executa todos os testes para todos os datasets e algoritmos
     */
    public static void executarTodosTestes() {
        System.out.println("=".repeat(80));
        System.out.println("INICIANDO TESTES DE DESEMPENHO DOS ALGORITMOS DE ORDENAÇÃO");
        System.out.println("=".repeat(80));
        System.out.println();

        // Gera todos os datasets
        System.out.println("Gerando datasets...");
        Item[][] datasets = Utilidades.gerarTodosDatasets();
        int[] tamanhos = Utilidades.obterTamanhosDatasets();
        System.out.println();

        // Algoritmos a serem testados
        String[] algoritmos = {"SelectionSort", "InsertionSort", "QuickSort"};

        // Armazena resultados
        StringBuilder resultadosCSV = new StringBuilder();
        resultadosCSV.append("Dataset,Tamanho,SelectionSort(ms),InsertionSort(ms),QuickSort(ms)\n");

        // Testa cada dataset
        for (int i = 0; i < datasets.length; i++) {
            String nomeDataset = (i < 10) ? "Dataset1" : "Dataset2";
            int tamanho = tamanhos[i];

            System.out.println("-".repeat(80));
            System.out.println(nomeDataset + " - Tamanho: " + tamanho + " elementos");
            System.out.println("-".repeat(80));

            double[] tempos = new double[3];

            // Testa cada algoritmo
            for (int j = 0; j < algoritmos.length; j++) {
                System.out.print("Testando " + algoritmos[j] + "... ");
                System.out.flush();

                long tempoNano = testarAlgoritmo(datasets[i], algoritmos[j]);
                double tempoMs = tempoNano / 1000000.0;
                tempos[j] = tempoMs;

                System.out.println("Tempo médio: " + String.format("%.2f", tempoMs) + " ms");
            }

            // Adiciona ao CSV
            resultadosCSV.append(String.format(java.util.Locale.US,
                    "%s,%d,%.2f,%.2f,%.2f\n",
                    nomeDataset, tamanho, tempos[0], tempos[1], tempos[2]));

            System.out.println();
        }

        // Salva resultados
        try {
            Utilidades.salvarResultadosCSV("resultados.csv", resultadosCSV.toString());
            System.out.println("Resultados salvos em: resultados.csv");
        } catch (IOException e) {
            System.err.println("Erro ao salvar resultados: " + e.getMessage());
        }

        System.out.println();
        System.out.println("=".repeat(80));
        System.out.println("TESTES CONCLUÍDOS!");
        System.out.println("=".repeat(80));
    }

    /**
     * Executa um teste rápido (apenas 10 execuções) para verificação
     */
    public static void testeRapido() {
        System.out.println("Executando teste rápido...\n");

        int[] tamanhosTeste = {1000, 5000, 10000};
        String[] algoritmos = {"SelectionSort", "InsertionSort", "QuickSort"};

        for (int tamanho : tamanhosTeste) {
            System.out.println("Tamanho: " + tamanho);
            Item[] vetor = Utilidades.gerarVetorAleatorio(tamanho, 42);

            for (String algoritmo : algoritmos) {
                Item[] copia = Utilidades.copiarVetor(vetor);

                long inicio = System.nanoTime();

                switch (algoritmo.toLowerCase()) {
                    case "selectionsort":
                        Ordena.selectionSort(copia);
                        break;
                    case "insertionsort":
                        Ordena.insertionSort(copia);
                        break;
                    case "quicksort":
                        Ordena.quickSort(copia);
                        break;
                }

                long fim = System.nanoTime();

                System.out.println("  " + algoritmo + ": " +
                        Utilidades.formatarTempo(fim - inicio) +
                        " - Ordenado: " + Ordena.estaOrdenado(copia));
            }
            System.out.println();
        }
    }

    /**
     * Método principal
     */
    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("--rapido")) {
            testeRapido();
        } else {
            executarTodosTestes();
        }
    }
}