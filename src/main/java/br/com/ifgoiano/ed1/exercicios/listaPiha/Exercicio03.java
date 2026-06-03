package br.com.ifgoiano.ed1.exercicios.listaPiha;

import java.util.Stack;

/*
    Exercício 3) Escreva um método que receba duas pilhas
    como parâmetro e empilhe a segunda sobre a primeira
 */
public class Exercicio03 {

    private static void empilhar(Stack<Integer> A, Stack<Integer> B) {
        Stack<Integer> K = new Stack<>();

        while(!B.empty()) K.push(B.pop());

        while(!K.empty()) A.push(K.pop());
    }

    public static void main(String[] args) {

        Stack<Integer> A = new Stack<>();
        Stack<Integer> B = new Stack<>();

        for (int i = 1; i < 5; i++) {
            A.push(i);
        }
        for (int i = 5; i < 10; i++) {
            B.push(i);
        }

        empilhar(A, B);

        while (!A.empty()) System.out.println(A.pop() + " ");
    }
}
