package br.com.ifgoiano.ed1.maratona.pilha.aprendiz;

import java.util.Stack;

public class Exercicio05 {

    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();

        stack.push("A");
        stack.push("B");
        stack.push("C");

        while(!stack.empty()){
            System.out.println(stack.peek());
            stack.pop();
        }


        stack.size();
    }
}
