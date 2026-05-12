package br.com.ifgoiano.ed1.exercicios.listaPiha;

import java.util.Stack;

/*
    Exercício 3) Escreva um método que receba duas pilhas
    como parâmetro e empilhe a segunda sobre a primeira
 */
public class Exercicio03 {

    private static void empilhar(Stack<Integer> stackA, Stack<Integer> stackB) {
            while(!stackB.empty()){
                stackA.push(stackB.pop());
            }
    }

    public static void main(String[] args) {

        Stack<Integer> stackA = new Stack<>();
        Stack<Integer> stackB = new Stack<>();

        for (int i = 1; i < 5; i++) {
            stackA.push(i);
        }
        for (int i = 5; i < 10; i++) {
            stackB.push(i);
        }

        System.out.println("ORIGINAL");
        stackA.forEach(x -> System.out.print(x + " "));
        System.out.println();
        stackB.forEach(x -> System.out.print(x + " "));

        empilhar(stackA, stackB);

        System.out.println("\nEMPILHADA");
        stackA.forEach(x -> System.out.print(x + " "));

    }
}
