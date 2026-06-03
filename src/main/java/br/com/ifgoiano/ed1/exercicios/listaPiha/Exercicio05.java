package br.com.ifgoiano.ed1.exercicios.listaPiha;

import java.util.Stack;

public class Exercicio05 {

    public static boolean verificaPalidromo(Stack<String> S) {
        Stack<String> A = new Stack<>();
        Stack<String> B = new Stack<>();
        Stack<String> C = new Stack<>();

        while (!S.empty()) {
            String valor = S.pop();
            A.push(valor);
            B.push(valor);
        }

        while (!B.empty()) {
            String valor = B.pop();
            C.push(valor);
        }

        while (!C.empty()) {
            String valorA = C.pop();
            String valorB = A.pop();
            if (!valorA.equals(valorB)) {
                return false;
            }
            S.push(valorA);
        }

        return true;
    }

    public static void main(String[] args) {

        Stack<String> A = new Stack();

        A.push("A");
        A.push("B");
        A.push("B");
        A.push("E");

        System.out.println(verificaPalidromo(A));
    }
}
