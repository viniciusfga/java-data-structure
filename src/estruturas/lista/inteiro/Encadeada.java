package estruturas.lista.inteiro;

import estruturas.base.ListaGeneritcs;

public class Encadeada extends ListaGeneritcs {

    Nodo head;
    Nodo ultimo;

    Encadeada() {
        head = null;
        ultimo = null;
    }

    @Override
    public void inserirInicio(int item) throws Exception {
        Nodo novo = new Nodo(item);

        if (head == null) {
            head = novo;
            ultimo = novo;
        } else {
            novo.prox = head;
            head = novo;
        }
    }

    @Override
    public void inserirOrdenado(int item) throws Exception {
        Nodo novo = new Nodo(item);

        // 1. Lista vazia ou menor que o primeiro
        if (head == null) {
            head = novo;
            ultimo = novo;
            return;
        }

        if (item < head.item) {
            novo.prox = head;
            head = novo;
            return;
        }

        // 2. Percorrer lista
        Nodo aux = head;
        while (aux.prox != null && aux.prox.item < item) {
            aux = aux.prox;
        }

        // 3. Inserir
        novo.prox = aux.prox;
        aux.prox = novo;

        if (novo.prox == null) {
            ultimo = novo;
        }
    }

    @Override
    public void inserirFim(int item) throws Exception {
        Nodo novo = new Nodo(item);

        if (head == null) {
            head = novo;
            ultimo = novo;
        } else {
            ultimo.prox = novo;
            ultimo = novo;
        }
    }

    @Override
    public int removerInicio() throws Exception {
        if (vazia()) {
            throw new Exception("Lista Vazia");
        }
        int valor = head.item;
        head = head.prox;

        if (head == null) {
            ultimo = null;
        }

        return valor;
    }

    @Override
    public int remover(int chave) throws Exception {
        if (vazia()) {
            throw new Exception("Lista Vazia");
        }

        // um nó
        if (head.item == chave) {
            int valor = head.item;
            head = head.prox;

            if (head == null) {
                ultimo = null;
            }

            return valor;
        }
        // + 1 nó
        Nodo aux = head;
        while (aux.prox != null && aux.prox.item != chave) {
            aux = aux.prox;
        }
        if (aux.prox == null){
            throw new Exception("Elemento não encontrado");
        }

        // remover
        Nodo removido = aux.prox;
        int valor = removido.item;
        aux.prox = removido.prox;

        // se removeu o ultimo
        if(removido == ultimo){
            ultimo =aux;
        }
        return valor;
    }

    @Override
    public int removerFim() throws Exception {
        if (vazia()) {
            throw new Exception("Lista Vazia");
        }
        // um nó
        if (head.prox == null) {
            int valor = head.item;
            head = null;
            ultimo = null;
            return valor;
        }
        // + 1 nó
        Nodo aux = head;
        while (aux.prox.prox != null) {
            aux = aux.prox;
        }
        int valor = aux.prox.item;
        aux.prox = null;
        ultimo = aux;

        return valor;
    }

    @Override
    public int buscar(int chave) throws Exception {
        if (vazia()) {
            throw new Exception("Lista Vazia");
        }
        Nodo aux = head;

        while (aux != null && aux.item != chave) {
            aux = aux.prox;
        }

        if (aux == null) {
            throw new Exception("Elemento não encontrado");
        }

        return aux.item;
    }

    @Override
    public boolean vazia() {
        return head == null;
    }

    @Override
    public boolean cheia() {
        return false;
    }

    @Override
    public void imprimir() {
        Nodo aux = head;
        while (aux != null) {
            System.out.print("[" + aux.item + "] ");
            aux = aux.prox;
        }
    }

    public static void main(String[] args) throws Exception {

        Encadeada lista = new Encadeada();

        lista.inserirFim(3);
        lista.inserirFim(4);
        lista.inserirOrdenado(2);
        lista.inserirFim(1);

        // 2 3 4 1
        lista.imprimir();

    }
}
