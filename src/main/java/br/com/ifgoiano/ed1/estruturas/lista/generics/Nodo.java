package br.com.ifgoiano.ed1.estruturas.lista.generics;

class Nodo<T> {

    T item;
    Nodo<T> prox;
    Nodo<T> ant;

    public Nodo(T valor){
        this.item = valor;
        this.prox = null;
        this.ant = null;
    }
}