package br.com.ifgoiano.ed1.maratona.pilha.aprendiz;

import java.util.Stack;

public class Exercicio12 {

    public static void main(String[] args) {

        Stack<Integer> stackA = new Stack<>();
        Stack<Integer> stackB = new Stack<>();


        for (int i = 0; i < 10; i++) {
            stackA.push(i);
        }

        for (int i = 0; i < 10; i++) {
            stackB.push(stackA.pop());
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(stackB.pop());
        }
    }
}
