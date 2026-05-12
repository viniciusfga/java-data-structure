package br.com.ifgoiano.ed1.exercicios.listaPiha;

import java.util.Stack;

/*
    Exercício 1) Escreva um método que receba uma pilha como parâmetro e retire todos os
    elementos ímpares dessa pilha.
 */
public class Exercicio01 {

    private static void removerImpares(Stack<Integer> stack) {
        Stack<Integer> auxiliar = new Stack<>();

        while(!stack.empty()){
            int valor = stack.pop();
            if (valor % 2 == 0) {
                auxiliar.push(valor);
            }
        }

        while(!auxiliar.empty()){
            stack.push(auxiliar.pop());
        }
    }

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i < 10; i++) {
            stack.push(i);
        }

        System.out.println("ORIGINAL");
        stack.forEach(x -> System.out.print(x + " "));

        removerImpares(stack);

        // DEPOIS DE RETIRAR OS IMPARES
        System.out.println("\nNova pilha:");
        stack.forEach(x -> System.out.print( + x + " "));

    }
}
