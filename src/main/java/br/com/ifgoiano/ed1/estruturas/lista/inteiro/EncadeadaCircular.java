package br.com.ifgoiano.ed1.estruturas.lista.inteiro;

import br.com.ifgoiano.ed1.estruturas.base.ListaGeneritcs;

public class EncadeadaCircular extends ListaGeneritcs {

    Nodo head;
    Nodo ultimo;

    @Override
    public void inserirInicio(int item) throws Exception {
        Nodo novo = new Nodo(item);

        if (vazia()) {
            head = novo;
            ultimo = novo;
            novo.prox = head;
        } else {
            ultimo.prox = novo;
            novo.prox = head;
            head = novo;
        }
    }

    @Override
    public void inserirOrdenado(int item) throws Exception {
        Nodo novo = new Nodo(item);

        if (vazia()) {
            inserirInicio(item);
            return;
        }
        // caso 1: um elemento
        if (item < head.item) {
            novo.prox = head;
            ultimo.prox = novo;
            head = novo;
            return;
        }

        Nodo aux = head;
        while (aux.prox != head && aux.prox.item < item) {
            aux = aux.prox;
        }
        novo.prox = aux.prox;
        aux.prox = novo;

        if (aux == ultimo) {
            ultimo = novo;
        }

    }

    @Override
    public void inserirFim(int item) throws Exception {
        Nodo novo = new Nodo(item);

        // se vazia
        if (vazia()) {
            head = novo;
            ultimo = novo;
            novo.prox = head;
        } else {
            ultimo.prox = novo;
            novo.prox = head;
            ultimo = novo;
        }
    }

    @Override
    public int removerInicio() throws Exception {
        if (vazia()) throw new Exception("Lista vazia!");
        Nodo removido = head;
        // caso 1: só um elemento
        if (head.prox == head) {
            head = null;
            ultimo = null;
        } else {
            head = head.prox;
            ultimo.prox = head;
        }
        return removido.item;
    }

    @Override
    public int remover(int chave) throws Exception {
        if (vazia()) throw new Exception("Lista vazia");

        Nodo aux = head;
        Nodo anterior = ultimo;

        do {
            if (aux.item == chave) {
                int valorRemovido = aux.item;

                // caso 1: só um elemento
                if (head == ultimo) {
                    head = ultimo = null;
                }
                // caso 2: removendo o head
                else if (aux == head) {
                    head = head.prox;
                    ultimo.prox = head;
                }
                // caso 3: removendo o último
                else if (aux == ultimo) {
                    anterior.prox = head;
                    ultimo = anterior;
                }
                //caso 4: meio da lista
                else {
                    anterior.prox = aux.prox;
                }

                return valorRemovido;
            }
            anterior = aux;
            aux = aux.prox;
        } while (aux != head);

        throw new Exception("Elemento não encontrado");
    }

    @Override
    public int removerFim() throws Exception {
        if (vazia()) throw new Exception("Lista vazia");

        Nodo removido = ultimo;
        // caso 1: só um elemento
        if (ultimo == head) {
            head = null;
            ultimo = null;
        } else {
            Nodo aux = head;
            // achar o penúltimo
            while (aux.prox != ultimo) {
                aux = aux.prox;
            }

            aux.prox = head;
            ultimo = aux;
        }

        return removido.item;
    }

    @Override
    public int buscar(int chave) throws Exception {
        if (head == null) return -1;

        Nodo aux = head;
        do {
            if (aux.item == chave) {
                return aux.item;
            }
            aux = aux.prox;
        } while (aux != head);

        return -1;
    }

    @Override
    public boolean vazia() throws Exception {
        return head == null;
    }

    @Override
    public boolean cheia() {
        return false;
    }

    @Override
    public void imprimir() {
        if (head == null) return;

        Nodo aux = head;
        do {
            System.out.print("[" + aux.item + "] ");
            aux = aux.prox;
        } while (aux != head);
    }

    public static void main(String[] args) throws Exception {

        EncadeadaCircular lista = new EncadeadaCircular();

        lista.inserirFim(1);
        lista.inserirFim(2);
        lista.inserirFim(4);
        lista.inserirOrdenado(3);
        lista.imprimir();


    }
}
