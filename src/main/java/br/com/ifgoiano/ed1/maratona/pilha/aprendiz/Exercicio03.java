package br.com.ifgoiano.ed1.maratona.pilha.aprendiz;

import java.util.Stack;

public class Exercicio03 {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        // EXEMPLO PILHA COM TAMANHO 5
        for (int i = 0; i < 6; i++) {
            if (!stack.empty()) {
                stack.push(i);
            } else {
                System.out.println("Pilha Cheia");
            }

        }
    }
}
