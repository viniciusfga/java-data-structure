package java.br.com.ifgoiano.ed1.estruturas.lista.inteiro;

import java.br.com.ifgoiano.ed1.estruturas.base.ListaGeneritcs;

public class EncadeadaDupla extends ListaGeneritcs {

    Nodo head;
    Nodo ultimo;

    @Override
    public void inserirInicio(int item) throws Exception {
        Nodo novo = new Nodo(item);
        if (vazia()) {
            head = novo;
            ultimo = novo;
        } else {
            novo.prox = head;
            head.ant = novo;
            head = novo;
        }
    }

    @Override
    public void inserirOrdenado(int item) throws Exception {
        Nodo novo = new Nodo(item);

        if (vazia()) {
            head = novo;
            ultimo = novo;
        } else if (head.item > item) {
            novo.prox = head;
            head.ant = novo;
            head = novo;
        } else {
            Nodo aux = head;
            while (aux.prox != null && aux.prox.item < item) {
                aux = aux.prox;
            }

            // Inserir no final
            if (aux.prox == null) {
                aux.prox = novo;
                novo.ant = aux;
                ultimo = novo;
            }
            // Inserir no meio
            else {
                novo.prox = aux.prox;
                novo.ant = aux;
                aux.prox.ant = novo;
                aux.prox = novo;
            }
        }
    }

    @Override
    public void inserirFim(int item) throws Exception {
        Nodo novo = new Nodo(item);
        if (vazia()) {
            head = novo;
            ultimo = novo;
        } else {
            ultimo.prox = novo;
            novo.ant = ultimo;
            ultimo = novo;
        }

    }

    @Override
    public int removerInicio() throws Exception {
        if (vazia()) throw new Exception("Lista vazia!");

        int valorRemovido = head.item;
        // Caso 1: só um elemento
        if (head.prox == null) {
            head = null;
            ultimo = null;
        }
        // Caso 2: mais de um elemento
        else {
            head = head.prox;
            head.ant = null;
        }

        return valorRemovido;
    }

    @Override
    public int remover(int chave) throws Exception {
        if (vazia()) throw new Exception("Lista vazia!");

        Nodo aux = head;

        // Procura o elemento
        while (aux != null && aux.item != chave) {
            aux = aux.prox;
        }
        // Não encontrou
        if (aux == null) return -1;

        int valorRemovido = aux.item;

        // Caso 1: único elemento
        if (head == ultimo) {
            head = null;
            ultimo = null;
        }
        // Caso 2: remover inicio
        else if (aux == head) {
            aux.prox.ant = null;
        }
        // Caso 3: remover fim
        else if (aux == ultimo) {
            ultimo = aux.ant;
            ultimo.prox = null;
        }
        // Caso 4: remover meio
        else {
            aux.ant.prox = aux.prox;
            aux.prox.ant = aux.ant;
        }
        // Não achou a chave
        return valorRemovido;
    }

    @Override
    public int removerFim() throws Exception {
        if (vazia()) throw new Exception("Lista vazia!");

        int valorRemovido = ultimo.item;
        // Apenas um elemento
        if (head == ultimo) {
            head = null;
            ultimo = null;
        }
        // Mais de um elemento
        else {
            ultimo = ultimo.ant;
            ultimo.prox = null;
        }
        return valorRemovido;
    }

    @Override
    public int buscar(int chave) throws Exception {
        if (vazia()) throw new Exception("Lista vazia!");

        Nodo aux = head;

        while (aux != null) {
            if (aux.item == chave) {
                return aux.item;
            }
            aux = aux.prox;
        }

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
        while (aux != null) {
            System.out.print("[" + aux.item + "] ");
            aux = aux.prox;
        }
    }

    public static void main(String[] args) throws Exception {

        EncadeadaDupla lista = new EncadeadaDupla();

        lista.inserirFim(1);
        lista.inserirFim(2);
        lista.inserirFim(3);
        lista.inserirInicio(4);

        lista.imprimir();
    }
}
