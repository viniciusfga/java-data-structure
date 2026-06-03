package br.com.ifgoiano.ed1.exercicios.listaPiha;

import java.util.Stack;

public class Exercicio20 {

    public static Stack<Integer> geraFibonacci(int n) {
        Stack<Integer> pilha = new Stack<>();

        if (n <= 0) return pilha;

        pilha.push(0);
        if (n == 1) return pilha;

        pilha.push(1);
        if (n == 2) return pilha;

        for (int i = 3; i <= n; i++) {
            int ultimo = pilha.pop();
            int penultimo = pilha.peek();
            int proximo = ultimo + penultimo;

            pilha.push(ultimo);
            pilha.push(proximo);
        }

        return pilha;
    }

    public static void main(String[] args) {
        int n = 8;

        Stack<Integer> resultado = geraFibonacci(n);

        System.out.println("PILHA DE FIBONACCI");
        while (!resultado.empty()) {
            System.out.print(resultado.pop() + " ");
        }
    }
}
