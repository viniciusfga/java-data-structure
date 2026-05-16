package br.com.ifgoiano.ed1.maratona.pilha.aprendiz;

import java.util.Stack;

public class Exercicio08 {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i < 6; i++) {
            stack.push(i);
        }

        while (!stack.empty()){
            System.out.println(stack.pop());
        }

    }
}
