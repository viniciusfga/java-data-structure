package br.com.ifgoiano.algoritimos.sort;

public class Teste {

    public static void main(String[] args) {

        Selection selection = new Selection();
        Insertion insertion = new Insertion();
        Bubble bubble = new Bubble();

        int[] vetor = {4, 7, 2 ,8 , 3};

        bubble.bubbleSort(vetor);
    }
}
