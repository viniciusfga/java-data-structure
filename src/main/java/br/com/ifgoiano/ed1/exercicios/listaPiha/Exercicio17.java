package br.com.ifgoiano.ed1.exercicios.listaPiha;

import java.util.Stack;

public class Exercicio17 {

    public static void inverterPalavras(String str){

        Stack<Character> pilha = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == ' ' || c == '.') {
                while (!pilha.empty()) {
                    System.out.print(pilha.pop());
                }
                System.out.print(c);
            } else {
                pilha.push(c);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 1. Definição da entrada exatamente como o enunciado sugere
        String textoExemplo = "ESTE EXERCÍCIO É MUITO FÁCIL.";

        System.out.println(" ENTRADA ");
        System.out.println(textoExemplo);

        System.out.println("\n SAÍDA ESPERADA ");
        System.out.println("ETSE OICÍCREXE É OTIUM LICÁF.");

        System.out.println("\n SAÍDA DO ALGORITMO ");
        inverterPalavras(textoExemplo);
    }
}
