package br.com.ifgoiano.ed1.exercicios.atividadesLista;

/**
 * Nome: Vinicius Franco Gonçalves Araujo
 * Disciplina: Estrutura de Dados I
 * Data: 27/03/2026
 *
 * Questão 7) Escreva um método que receba uma lista duplamente encadeada circular
 * e retorne a quantidade de elementos da lista.
 */

public class DuplaCircular {

    Nodo head;

    public DuplaCircular() {
        head = null;
    }

    public boolean vazia() {
        return head == null;
    }

    public void inserir(int valor) {
        Nodo novo = new Nodo(valor);

        if (vazia()) {
            head = novo;
            novo.prox = novo;
            novo.ant = novo;
        } else {
            Nodo ultimo = head.ant;

            novo.prox = head;
            novo.ant = ultimo;

            ultimo.prox = novo;
            head.ant = novo;
        }
    }

    public int quantidadeElementos() {
        if (head == null) {
            return 0;
        }

        int count = 0;
        Nodo aux = head;

        do {
            count++;
            aux = aux.prox;
        } while (aux != head);

        return count;
    }

    public static void main(String[] args) {
        DuplaCircular lista = new DuplaCircular();

        lista.inserir(1);
        lista.inserir(2);
        lista.inserir(3);
        lista.inserir(4);

        System.out.println("Quantidade de elementos: " + lista.quantidadeElementos());
    }
}