package br.com.ifgoiano.algoritimos.sort.impl; /**
 * Autores: Vinicius Franco Gonçalves Araújo
 *          Rafael Belem Torres
 *          Rafael Henrico Gonçalves Justino
 *
 * Disciplina: Estrutura de Dados I
 * Data: 26/05/2026
 *
 * Objetivo: Classe utilitária que contém métodos para geração de vetores,
 * leitura e escrita de arquivos, e outras operações auxiliares necessárias
 * para os testes de ordenação.
 */

import java.io.*;
import java.util.Random;

public class Utilidades {

    /**
     * Gera um vetor de Items com valores aleatórios
     * @param tamanho Tamanho do vetor a ser gerado
     * @param seed Semente para o gerador de números aleatórios (para reprodutibilidade)
     * @return Vetor de Items com valores aleatórios
     */
    public static Item[] gerarVetorAleatorio(int tamanho, long seed) {
        Item[] vetor = new Item[tamanho];
        Random random = new Random(seed);

        for (int i = 0; i < tamanho; i++) {
            // Gera valores entre 0 e 1.000.000
            vetor[i] = new Item(random.nextInt(1000000));
        }

        return vetor;
    }

    /**
     * Cria uma cópia de um vetor de Items
     * Importante para manter o vetor original intacto durante os testes
     * @param original Vetor original
     * @return Cópia do vetor
     */
    public static Item[] copiarVetor(Item[] original) {
        Item[] copia = new Item[original.length];

        for (int i = 0; i < original.length; i++) {
            copia[i] = new Item(original[i].getValor());
        }

        return copia;
    }

    /**
     * Salva um vetor de Items em arquivo
     * @param vetor Vetor a ser salvo
     * @param nomeArquivo Nome do arquivo
     * @throws IOException Se houver erro na escrita
     */
    public static void salvarVetorEmArquivo(Item[] vetor, String nomeArquivo) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
            for (Item item : vetor) {
                writer.println(item.getValor());
            }
        }
    }

    /**
     * Carrega um vetor de Items de um arquivo
     * @param nomeArquivo Nome do arquivo
     * @return Vetor carregado
     * @throws IOException Se houver erro na leitura
     */
    public static Item[] carregarVetorDeArquivo(String nomeArquivo) throws IOException {

        long numeroLinhas;

        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            numeroLinhas = reader.lines().count();
        }

        Item[] vetor = new Item[(int) numeroLinhas];

        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            int i = 0;

            while ((linha = reader.readLine()) != null) {
                vetor[i++] = new Item(Integer.parseInt(linha.trim()));
            }
        }

        return vetor;
    }

    /**
     * Salva resultados dos testes em arquivo CSV
     * @param nomeArquivo Nome do arquivo CSV
     * @param conteudo Conteúdo a ser salvo
     * @throws IOException Se houver erro na escrita
     */
    public static void salvarResultadosCSV(String nomeArquivo, String conteudo) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
            writer.print(conteudo);
        }
    }

    /**
     * Formata tempo em nanossegundos para string legível
     * @param nanos Tempo em nanossegundos
     * @return String formatada
     */
    public static String formatarTempo(long nanos) {
        if (nanos < 1000) {
            return nanos + " ns";
        } else if (nanos < 1000000) {
            return String.format("%.2f µs", nanos / 1000.0);
        } else if (nanos < 1000000000) {
            return String.format("%.2f ms", nanos / 1000000.0);
        } else {
            return String.format("%.2f s", nanos / 1000000000.0);
        }
    }

    /**
     * Imprime um vetor (útil para debugging)
     * @param vetor Vetor a ser impresso
     * @param limite Número máximo de elementos a exibir
     */
    public static void imprimirVetor(Item[] vetor, int limite) {
        System.out.print("[");
        for (int i = 0; i < Math.min(vetor.length, limite); i++) {
            System.out.print(vetor[i].getValor());
            if (i < Math.min(vetor.length, limite) - 1) {
                System.out.print(", ");
            }
        }
        if (vetor.length > limite) {
            System.out.print(", ...");
        }
        System.out.println("]");
    }

    /**
     * Gera todos os datasets conforme especificação do projeto
     * @return Matriz com todos os vetores (20 vetores no total)
     */
    public static Item[][] gerarTodosDatasets() {
        // Dataset1: 10 tamanhos de 1000 a 10000
        int[] tamanhosDataset1 = {1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000};

        // Dataset2: 10 tamanhos de 10000 a 100000
        int[] tamanhosDataset2 = {10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000, 100000};

        Item[][] todosVetores = new Item[20][];

        // Gera Dataset1
        for (int i = 0; i < 10; i++) {
            todosVetores[i] = gerarVetorAleatorio(tamanhosDataset1[i], 42 + i);
            System.out.println("Dataset1[" + i + "] gerado: " + tamanhosDataset1[i] + " elementos");
        }

        // Gera Dataset2
        for (int i = 0; i < 10; i++) {
            todosVetores[10 + i] = gerarVetorAleatorio(tamanhosDataset2[i], 142 + i);
            System.out.println("Dataset2[" + i + "] gerado: " + tamanhosDataset2[i] + " elementos");
        }

        return todosVetores;
    }

    /**
     * Obtém os tamanhos dos datasets
     * @return Array com os tamanhos
     */
    public static int[] obterTamanhosDatasets() {
        return new int[]{
                1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000,
                10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000, 100000
        };
    }
}