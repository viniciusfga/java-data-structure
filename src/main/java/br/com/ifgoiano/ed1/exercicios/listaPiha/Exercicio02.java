package br.com.ifgoiano.ed1.exercicios.listaPiha;

import java.util.Stack;

/*
    Exercício 2) Desenvolva um método para inverter a posição dos elementos de uma pilha P.
 */
public class Exercicio02 {

    public static void inverterPilha(Stack<Integer> P){
        Stack<Integer> auxiliarA = new Stack<>();
        Stack<Integer> auxiliarB = new Stack<>();

        while (!P.empty()){
            auxiliarA.push(P.pop());
        }

        while (!auxiliarA.empty()){
            auxiliarB.push(auxiliarA.pop());
        }

        while (!auxiliarB.empty()){
            P.push(auxiliarB.pop());
        }

    }

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i < 10; i++) {
            stack.push(i);
        }

        System.out.println("ORIGINAL");
        stack.forEach(x -> System.out.print(x + " "));

        inverterPilha(stack);

        System.out.println("\nINVERTIDA");
        stack.forEach(x -> System.out.print(x + " "));
    }
}
