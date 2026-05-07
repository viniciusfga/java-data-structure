package java.br.com.ifgoiano.ed1.desafios;

/*
Lista Encadeada
Remova todas as ocorrências de um valor informado
removerTodos(int valor)
 */

import java.br.com.ifgoiano.ed1.estruturas.lista.inteiro.Nodo;

public class D02 {

    Nodo head;
    Nodo ultimo;

    D02() {
        head = null;
        ultimo = null;
    }

    public void removerTodos(int valor) throws Exception {

        if (head == null) throw new Exception("Lista vazia");

        // 1. Remove do início (caso tenha vários iguais)
        while (head != null && head.item == valor) {
            head = head.prox;
        }
        // Se lista ficou vazia
        if (head == null) {
            ultimo = null;
            return;
        }
        // 2. Remove do meio e fim
        Nodo aux = head;
        while (aux.prox != null) {
            if (aux.prox.item == valor) {
                aux.prox = aux.prox.prox;
            } else {
                aux = aux.prox;
            }
        }
        ultimo = aux;
    }

    public void imprimir() {
        Nodo aux = head;
        while (aux != null) {
            System.out.print("[" + aux.item + "] ");
            aux = aux.prox;
        }
    }

    public static void main(String[] args) throws Exception {

        D02 lista = new D02();

        lista.head = new Nodo(1);
        lista.head.prox = new Nodo(2);
        lista.head.prox.prox = new Nodo(3);
        lista.head.prox.prox.prox = new Nodo(3);

        lista.removerTodos(3);

        lista.imprimir();
    }
}
