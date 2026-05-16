package br.com.ifgoiano.ed1.maratona.pilha.aprendiz;

import java.util.Stack;

public class Exercicio07 {

    public static void main(String[] args) {

        Stack<Character> stack = new Stack<Character>();

        stack.push('J');
        stack.push('A');
        stack.push('V');
        stack.push('A');

        while (!stack.empty()){
            System.out.println(stack.pop());
        }
    }
}
