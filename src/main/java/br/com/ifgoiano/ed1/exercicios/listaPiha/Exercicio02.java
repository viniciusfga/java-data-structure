package br.com.ifgoiano.ed1.exercicios.listaPiha;

import java.util.Stack;

/*
    Exercício 2) Desenvolva um método para inverter a posição dos elementos de uma pilha P.
 */
public class Exercicio02 {

    public static void inverterPilha(Stack<Integer> P) {
        Stack<Integer> A = new Stack<>();
        Stack<Integer> B = new Stack<>();

        while (!P.empty()) A.push(P.pop());
        while (!A.empty()) B.push(A.pop());
        while (!B.empty()) P.push(B.pop());
    }

    public static void main(String[] args) {

        Stack<Integer> s = new Stack<>();

        for (int i = 1; i <= 5; i++) s.push(i);

        Stack<Integer> aux = new Stack<>();
        while (!s.empty()) {
            System.out.print(s.peek() + " ");
            aux.push(s.pop());
        }

        while (!aux.empty()) s.push(aux.pop());

        inverterPilha(s);

        System.out.println();
        while (!s.empty()) {
            System.out.print(s.pop() + " ");
        }

    }
}
