package br.com.ifgoiano.ed1.exercicios.listaPiha;

import java.util.Stack;

public class Exercicio15 {

    public static StringBuilder converter(int numero){

        Stack<Integer> pilha = new Stack<>();
        StringBuilder resultadoBinario = new StringBuilder();

        while(numero > 0){
            pilha.push(numero % 2);
            numero = numero / 2;
        }

        while (!pilha.empty()){
            resultadoBinario.append(pilha.pop());
        }

        return resultadoBinario;
    }

    public static void main(String[] args) {
        int n = 11;
        System.out.println("O número " + n + " em binário é: " + converter(n));
        // Saída esperada: 1011
    }
}
