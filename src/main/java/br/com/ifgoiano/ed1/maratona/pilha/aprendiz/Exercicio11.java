package br.com.ifgoiano.ed1.maratona.pilha.aprendiz;

import java.util.Stack;

public class Exercicio11 {

    public static void main(String[] args) {

        Stack<Character> stack = new Stack<>();

        String palavra = "arara";
        boolean palindromo = true;

        for (char c : palavra.toCharArray()) {
            stack.push(c);
        }

        for (char c : palavra.toCharArray()) {
            if (c != stack.pop()) {
                palindromo = false;
                break;
            }
        }

        System.out.println(palindromo ? "True" : "False");

    }
}
