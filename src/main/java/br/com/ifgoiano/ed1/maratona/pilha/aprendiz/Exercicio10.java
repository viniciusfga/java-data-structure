package br.com.ifgoiano.ed1.maratona.pilha.aprendiz;

import java.util.Stack;

public class Exercicio10 {

    public static void main(String[] args) {

        Stack<Character> stack = new Stack<>();

       String palavra = "hello";

        for (char c : palavra.toCharArray()) {
            stack.push(c);
        }

        while(!stack.empty()){
            System.out.print(stack.pop());
        }
    }
}
