package br.com.ifgoiano.algoritimos.sort.impl;

/**
 * Autores: Vinicius Franco Gonçalves Araújo
 * Rafael Belem Torres
 * Rafael Henrico Gonçalves Justino
 * <p>
 * Disciplina: Estrutura de Dados I
 * Data: 26/05/2026
 * <p>
 * Objetivo: Classe genérica que contém as implementações dos algoritmos de ordenação.
 * Funciona para qualquer tipo de dado que implemente a interface Comparable.
 */
public class Ordena {

    /**
     * Selection Sort - Ordenação por Seleção
     * Complexidade: O(n²) em todos os casos
     *
     * @param vetor Array de elementos genéricos a ser ordenado
     */
    public static <T extends Comparable<T>> void selectionSort(T[] vetor) {
        for (int i = 0; i < vetor.length - 1; i++) {
            int min = i;

            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[j].compareTo(vetor[min]) < 0) {
                    min = j;
                }
            }

            T aux = vetor[min];
            vetor[min] = vetor[i];
            vetor[i] = aux;
        }
    }

    /**
     * Insertion Sort - Ordenação por Inserção
     * Complexidade: O(n²) no pior caso, O(n) no melhor caso
     *
     * @param vetor Array de elementos genéricos a ser ordenado
     */
    public static <T extends Comparable<T>> void insertionSort(T[] vetor) {
        for (int i = 1; i < vetor.length; i++) {
            T aux = vetor[i];
            int j = i;

            while (j > 0 && aux.compareTo(vetor[j - 1]) < 0) {
                vetor[j] = vetor[j - 1];
                j--;
            }

            vetor[j] = aux;
        }
    }

    /**
     * Quick Sort - Ordenação Rápida
     * Complexidade: O(n log n) em média, O(n²) no pior caso
     *
     * @param vetor Array de elementos genéricos a ser ordenado
     */
    public static <T extends Comparable<T>> void quickSort(T[] vetor) {
        ordena(vetor, 0, vetor.length - 1);
    }

    private static <T extends Comparable<T>> void ordena(T[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int posicaoPivo = particao(vetor, inicio, fim);
            ordena(vetor, inicio, posicaoPivo - 1);
            ordena(vetor, posicaoPivo + 1, fim);
        }
    }

    private static <T extends Comparable<T>> int particao(T[] vetor, int inicio, int fim) {
        T pivo = vetor[inicio];
        int i = inicio + 1;
        int j = fim;

        while (i <= j) {
            if (vetor[i].compareTo(pivo) <= 0) {
                i++;
            } else if (pivo.compareTo(vetor[j]) < 0) {
                j--;
            } else {
                T troca = vetor[i];
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

    /**
     * Verifica se um vetor está ordenado (útil para testes)
     * @param vetor Array de elementos genéricos
     * @return true se ordenado, false caso contrário
     */
    public static <T extends Comparable<T>> boolean estaOrdenado(T[] vetor) {
        for (int i = 0; i < vetor.length - 1; i++) {
            if (vetor[i].compareTo(vetor[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }
}