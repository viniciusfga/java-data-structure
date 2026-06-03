package br.com.ifgoiano.ed1.exercicios.listaPiha;

import java.util.Stack;

public class Exercicio07 {

    public static void temMaisElementos(Stack<Integer> S) {
        if (S.empty()) return;

        Stack<Integer> A = new Stack<>();

        int primeiro = S.pop();
        int min = primeiro;
        int max = primeiro;
        int soma = 0;
        int cont = 1;
        A.push(primeiro);

        while (!S.empty()) {
            int valor = S.pop();
            A.push(valor);

            if (valor < min) min = valor;
            if (valor > max) max = valor;

            soma += valor;
            cont++;
        }

        while (!A.empty()){
            S.push(A.pop());
        }

        System.out.println("Maior " + max);
        System.out.println("Menor " + min);
        System.out.println("Média " + (double) soma / cont);

    }

    public static void main(String[] args) {

        Stack<Integer> A = new Stack<>();

        for (int i = 1; i <= 5; i++) A.push(i);
        temMaisElementos(A);
    }
}
