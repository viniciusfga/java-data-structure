package br.com.ifgoiano.ed1.exercicios.atividadesLista;

/**
 * Nome: Vinicius Franco Gonçalves Araujo
 * Disciplina: Estrutura de Dados I
 * Data: 27/03/2026
 *
 * Questão 5) Crie um método removerTodos(int valor) que percorra a lista
 * e remova todos os nós que contenham o valor especificado.
 */

public class EncadeadaDupla05 {

    Nodo primeiro;
    Nodo ultimo;

    public EncadeadaDupla05() {
        primeiro = null;
        ultimo = null;
    }

    public boolean vazia() {
        return primeiro == null;
    }

    public void inserirFim(int valor) {
        Nodo novo = new Nodo(valor);

        if (vazia()) {
            primeiro = novo;
            ultimo = novo;
        } else {
            ultimo.prox = novo;
            ultimo = novo;
        }
    }

    public void imprimir() {
        Nodo aux = primeiro;
        while (aux != null) {
            System.out.print(aux.item + " ");
            aux = aux.prox;
        }
        System.out.println();
    }

    public void removerTodos(int valor) {
        Nodo aux = primeiro;
        Nodo ant = null;

        while (aux != null) {
            if (aux.item == valor) {
                // remove no início
                if (aux == primeiro) {
                    primeiro = primeiro.prox;
                    aux = primeiro;

                    if (primeiro == null) {
                        ultimo = null;
                    }
                } else {
                    // remove no meio ou no fim
                    ant.prox = aux.prox;

                    if (aux == ultimo) {
                        ultimo = ant;
                    }

                    aux = aux.prox;
                }
            } else {
                ant = aux;
                aux = aux.prox;
            }
        }
    }

    public static void main(String[] args) {

        EncadeadaDupla05 lista = new EncadeadaDupla05();

        lista.inserirFim(2);
        lista.inserirFim(5);
        lista.inserirFim(2);
        lista.inserirFim(8);
        lista.inserirFim(2);
        lista.inserirFim(10);

        System.out.println("Lista original:");
        lista.imprimir();

        lista.removerTodos(2);

        System.out.println("Lista após remover todos os 2:");
        lista.imprimir();
    }
}