package br.com.ifgoiano.ed1.maratona.pilha.aprendiz;

import java.util.Stack;

public class Exercicio13 {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }

        int cont = 0;
        while(!stack.empty()){
            stack.pop();
            cont++;
        }

        System.out.println(cont);
    }
}
