package br.com.ifgoiano.ed1.estruturas.pilha;

public class Pilha {

    private int[] elementos;
    private int inicio;
    private int fim;

    public Pilha(int maxTam) {
        elementos = new int[maxTam];
        inicio = 0;
        fim = 0;
    }

    public void empilhar(int valor) throws Exception {
        if (cheia()) {
            throw new Exception("Stack Overflow!");
        }
        elementos[fim] = valor;
        fim++;
    }

    public int desempilhar() throws Exception {
        if (vazia()) {
            throw new Exception("Stack is empty!");
        }
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
