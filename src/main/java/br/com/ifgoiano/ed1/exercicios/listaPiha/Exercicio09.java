package br.com.ifgoiano.ed1.exercicios.listaPiha;

import java.util.Stack;

public class Exercicio09 {

    public static boolean iguais(Stack<Integer> A, Stack<Integer> B) {

        Stack<Integer> aux1 = new Stack<>();
        Stack<Integer> aux2 = new Stack<>();
        boolean saoIguais = true;

        while (!A.empty()) {
            int valA = A.pop();
            int valB = B.pop();

            aux1.push(valA); aux2.push(valB);

            if (valA != valB) {
                saoIguais = false;
                break;
            }
        }

        if (!A.empty() || !B.empty()) {
            saoIguais = false;
        }

        while (!aux1.empty()) A.push(aux1.pop());
        while (!aux2.empty()) B.push(aux2.pop());

        return saoIguais;
    }

    public static void main(String[] args) {

        Stack<Integer> A = new Stack<>();
        Stack<Integer> B = new Stack<>();

        for (int i = 0; i < 4; i++) A.push(i);
        for (int i = 0; i < 3; i++) B.push(i);

        // A É IGUAL B?
        System.out.println(iguais(A, B));

    }
}
