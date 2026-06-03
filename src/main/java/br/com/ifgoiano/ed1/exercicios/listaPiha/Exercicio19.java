package br.com.ifgoiano.ed1.exercicios.listaPiha;

import java.util.Stack;

public class Exercicio19 {

    public static void ordenarCrescente(Stack<Integer> S){

        Stack<Integer> aux = new Stack<>();

        while (!S.empty()) {
            int topoOriginal = S.pop();

            while (!aux.empty() && aux.peek() < topoOriginal) {
                S.push(aux.pop());
            }

            aux.push(topoOriginal);
        }

        while (!aux.empty()) {
            S.push(aux.pop());
        }
    }

    public static void main(String[] args) {

        Stack<Integer> A = new Stack<>();

        A.push(5);
        A.push(1);
        A.push(9);
        A.push(3);
        A.push(7);

        ordenarCrescente(A);

        System.out.println("PILHA ORDENADA");
        while (!A.empty()) {
            System.out.println(A.pop() + " ");
        }
    }
}
