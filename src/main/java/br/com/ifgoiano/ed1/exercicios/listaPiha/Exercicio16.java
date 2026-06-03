package br.com.ifgoiano.ed1.exercicios.listaPiha;

import java.util.Stack;

public class Exercicio16 {

    public static void remover(Stack<Integer> S, int c) {
        Stack<Integer> aux = new Stack<>();

        while (!S.empty()) {
            int valor = S.pop();

            if (valor == c) {
                break;
            }
            aux.push(valor);
        }

        while (!aux.empty()) {
            S.push(aux.pop());
        }
    }

    public static void main(String[] args) {

        Stack<Integer> A = new Stack<>();
        for (int i = 1; i < 6; i++) A.push(i);

        int chave = 3;
        remover(A, chave);

        while (!A.empty()) {
            System.out.print(A.pop() + " ");
        }
    }
}
