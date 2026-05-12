package br.com.ifgoiano.ed1.exercicios.atividadesLista;

public class Nodo {

    int item;
    Nodo prox;
    Nodo ant;

    public Nodo(int valor) {
        this.item = valor;
        this.prox = null;
        this.ant = null;
    }
}