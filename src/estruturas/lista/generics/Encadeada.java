package estruturas.lista.generics;

import estruturas.base.ListaInt;

public class Encadeada<T extends Comparable<T>> extends ListaInt<T> {

    Nodo<T> head;
    Nodo<T> ultimo;

    Encadeada() {
        head = null;
        ultimo = null;
    }

    @Override
    public void inserirInicio(T item) {
        Nodo<T> novo = new Nodo<>(item);
        novo.item = item;

        if (head == null) {
            head = novo;
            ultimo = novo;
        } else {
            novo.prox = head;
            head = novo;
        }
    }

    @Override
    public void inserirFim(T item) {
        Nodo<T> novo = new Nodo<>(item);
        novo.item = item;
        novo.prox = null;

        if (head == null) {
            head = novo;
            ultimo = novo;
        } else {
            ultimo.prox = novo;
            ultimo = novo;
        }
    }

    @Override
    public void inserirOrdenado(T chave) {
        Nodo<T> novo = new Nodo<>(chave);
        novo.item = chave;

        // se a lista está vazia, insere no início
        if (head == null) {
            head = ultimo = novo;
            return;
        }

        // se for menor que o primeiro, insere no início
        if (chave.compareTo(head.item) < 0){
            novo.prox = head;
            head = novo;
            return;
        }

        Nodo<T> aux = head;
        // percorre até achar a posição correta
        while(aux.prox != null && chave.compareTo(aux.prox.item) > 0) {
            aux = aux.prox;
        }

        // insere o novo nodo
        novo.prox = aux.prox;
        aux.prox = novo;

        // atualiza o ultimo se inseriu no final
        if(aux == ultimo) ultimo = novo;

    }

    @Override
    public T removerInicio() {
        return null;
    }

    @Override
    public T remover(T chave) {
        return null;
    }

    @Override
    public T removerFim() {
        if (head == null) {
            return null;
        }

        // caso 1 nó
        if (head == ultimo) {
            T item = head.item;
            head = null;
            ultimo = null;
            return item;
        }

        // caso +1 nó
        Nodo aux = head;

        while (aux.prox != ultimo) {
            aux = aux.prox;
        }
        T item = ultimo.item;
        aux.prox = null;
        ultimo = aux;

        return item;
    }

    @Override
    public T buscar(T chave) {
        Nodo<T> aux = head;

        while (aux != null) {
            if ((aux.item == null && chave == null) || (aux.item != null && aux.item.equals(chave))) {
                return aux.item;
            }
            aux = aux.prox;
        }

        return null;
    }

    @Override
    public boolean vazia() {
        return head == null;
    }

    @Override
    public boolean cheia() {
        return head == null;
    }

    @Override
    public void imprimir() {
        Nodo aux = head;
        while (aux != null) {
            System.out.println(aux.item);
            aux = aux.prox;
        }
    }

    public static void main(String[] args) {

        Encadeada<String> lista = new Encadeada<>();

        lista.inserirInicio("10");
        lista.inserirInicio("20");

        lista.removerFim();

        lista.imprimir();

    }
}
