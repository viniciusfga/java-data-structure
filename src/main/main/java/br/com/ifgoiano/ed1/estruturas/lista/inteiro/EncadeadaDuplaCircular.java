package java.br.com.ifgoiano.ed1.estruturas.lista.inteiro;

import java.br.com.ifgoiano.ed1.estruturas.base.ListaGeneritcs;

public class EncadeadaDuplaCircular extends ListaGeneritcs {

    Nodo head;
    Nodo ultimo;

    @Override
    public void inserirInicio(int item) throws Exception {

        Nodo novo = new Nodo(item);

        if (vazia()) {
            head = novo;
            ultimo = novo;

            head.prox = novo;
            head.ant = novo;
        } else {
            ultimo.prox = novo;
            novo.ant = ultimo;

            novo.prox = head;
            head.ant = novo;

            head = novo;
        }
    }

    @Override
    public void inserirOrdenado(int item) throws Exception {

        // CASO 1: lista vazia ou menor que o 1 item
        if (vazia() || item < head.item) {
            inserirInicio(item);
            return;
        }

        Nodo novo = new Nodo(item);

        Nodo aux = head;
        while (aux.prox != head && aux.prox.item < item) {
            aux = aux.prox;
        }
        novo.prox = aux.prox;
        novo.ant = aux;
        aux.prox.ant = novo;

        aux.prox = novo;

        if (aux == ultimo) {
            ultimo = novo;
        }
    }

    @Override
    public void inserirFim(int item) throws Exception {

        Nodo novo = new Nodo(item);

        if (vazia()) {
            head = novo;
            ultimo = novo;

            head.prox = head;
            head.ant = head;
        } else {
            novo.ant = ultimo;
            novo.prox = head;

            ultimo.prox = novo;
            head.ant = novo;

            ultimo = novo;
        }
    }

    @Override
    public int removerInicio() throws Exception {

        if (vazia()) throw new Exception("Lista vazia");

        int valorRemovido = head.item;

        if (head == ultimo) {
            head = null;
            ultimo = null;
            return valorRemovido;
        } else {
            ultimo.prox = head.prox;
            head.prox.ant = ultimo;
            head = head.prox;
            return valorRemovido;
        }
    }

    @Override
    public int remover(int chave) throws Exception {

        int valorRemovido;

        if (vazia()) {
            throw new Exception("Lista vazia");
        }

        // CASO 1: lista com um único elemento
        if (head == ultimo && head.item == chave) {
            valorRemovido = head.item;
            head = null;
            ultimo = null;
            return valorRemovido;
        }

        // CASO 2: remover o primeiro
        if (head.item == chave) {
            valorRemovido = head.item;

            head = head.prox;
            head.ant = ultimo;
            ultimo.prox = head;

            return valorRemovido;
        }
        // CASO 03: remover o ultimo
        else if (ultimo.item == chave) {
            valorRemovido = ultimo.item;

            ultimo = ultimo.ant;
            ultimo.prox = head;

            head.ant = ultimo;

            return valorRemovido;
        }
        // CASO 03: remover no meio
        else {

            Nodo aux = head.prox;

            while (aux != head && aux.item != chave) {
                aux = aux.prox;
            }
            if (aux == head) {
                throw new Exception("Elemento não encontrado");
            }
            valorRemovido = aux.item;

            aux.ant.prox = aux.prox;
            aux.prox.ant = aux.ant;

            return valorRemovido;
        }
    }

    @Override
    public int removerFim() throws Exception {

        if (vazia()) {
            throw new Exception("Lista vazia");
        }

        int valorRemovido = ultimo.item;

        if (head == ultimo) {
            head = null;
            ultimo = null;
        } else {
            ultimo = ultimo.ant;
            ultimo.prox = head;
            head.ant = ultimo;
        }
        return valorRemovido;
    }

    @Override
    public int buscar(int chave) throws Exception {

        if (vazia()) throw new Exception("Lista vazia");

        Nodo aux = head;

        if (aux.item == chave) return aux.item;

        do {
            if (aux.prox.item == chave) return aux.prox.item;
            aux = aux.prox;
        } while (aux.prox != head && aux.prox.item != chave);

        throw new Exception("Elemento não encontrado");
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
        if (head == null) {
            System.out.println("Lista vazia");
            return;
        }

        Nodo aux = head;

        do {
            System.out.print(aux.item + " ");
            aux = aux.prox;
        } while (aux != head);

        System.out.println();
    }

    public static void main(String[] args) throws Exception {

        EncadeadaDuplaCircular lista = new EncadeadaDuplaCircular();

        lista.inserirOrdenado(2);
        lista.inserirOrdenado(5);
        lista.inserirOrdenado(1);
        lista.inserirOrdenado(3);

        lista.imprimir();
    }
}
