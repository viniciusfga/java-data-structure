package br.com.ifgoiano.ed1.estruturas.pilha;

public class Pilha {
    int[] elementos;
    int inicio;
    int fim;

    public Pilha(int maxTam) {
        elementos = new int[maxTam];
        inicio = 0;
        fim = 0;
    }

    public void empilhar(int valor) {
        elementos[fim] = valor;
        fim++;
    }

    public int desempilhar() {
        fim--;
        return elementos[fim];
    }

    public boolean vazia() {
        return inicio == fim;
    }

    public boolean cheia() {
        return fim == elementos.length;
    }

    public int tamanho() {
        return fim - inicio;
    }

    public void imprimir() {
        for (int i = inicio; i < fim; i++) {
        System.out.println("[" + elementos[i] + "]");
        }
    }
}
