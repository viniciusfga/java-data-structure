package br.com.ifgoiano.ed1.estruturas.fila.inteiro;

import br.com.ifgoiano.ed1.estruturas.base.FilaInt;

public class Estatica extends FilaInt {

    private int[] elementos;
    private int inicio;
    private int fim;
    private int quantidade;
    private int capacidade;

    public Estatica(int capacidade) {
        this.capacidade = capacidade;
        this.elementos = new int[capacidade];
        this.inicio = 0;
        this.fim = 0;
        this.quantidade = 0;
    }

    @Override
    public boolean vazia() {
        return quantidade == 0;
    }

    @Override
    public boolean cheia() {
        return quantidade == capacidade;
    }

    @Override
    public int tamanho() {
        return quantidade;
    }

    @Override
    public void enfileirar(int valor) throws Exception {

        if (cheia()) throw new Exception("Fila Cheia!");

        elementos[fim] = valor;
        fim = (fim + 1) % capacidade;
        quantidade++;
    }

    @Override
    public int desenfileirar() throws Exception {

        if (vazia()) throw new Exception("Fila vazia");

        int valor = elementos[inicio];
        inicio = (inicio + 1) % capacidade;
        quantidade--;
        return valor;
    }

    @Override
    public int inicio() throws Exception {
        if (vazia()) throw new Exception("Fila vazia");
        return elementos[inicio];
    }

    @Override
    public void imprimir() {
        if (vazia()) {
            System.out.println("Fila vazia");
            return;
        }

        System.out.print("Início -> ");
        for (int i = 0; i < quantidade; i++) {
            int pos = (inicio + i) % capacidade;
            System.out.print("[" + elementos[pos] + "] ");
        }
        System.out.println("<- Fim");
    }

    public static void main(String[] args) throws Exception {

        Estatica fila = new Estatica(5);

        fila.enfileirar(1);
        fila.enfileirar(2);
        fila.enfileirar(3);

        fila.desenfileirar();

        fila.imprimir();

    }
}