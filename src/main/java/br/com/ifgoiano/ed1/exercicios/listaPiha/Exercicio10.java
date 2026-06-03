package br.com.ifgoiano.ed1.exercicios.listaPiha;

import java.util.Stack;

public class Exercicio10 {

    public static Stack copia(Stack<Integer> A) {
        Stack<Integer> B = new Stack<>();
        Stack<Integer> aux = new Stack<>();

        while (!A.empty()) {
            aux.push(A.pop());
        }

        while (!aux.empty()){
            int valor = aux.pop();
            A.push(valor);
            B.push(valor);
        }

        return B;
    }

    public static void main(String[] args) {

        Stack<Integer> A = new Stack<>();
        for (int i = 0; i < 4; i++) A.push(i);

        Stack<Integer> B = copia(A);
    }
}
