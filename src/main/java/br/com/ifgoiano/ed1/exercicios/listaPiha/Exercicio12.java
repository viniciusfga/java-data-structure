package br.com.ifgoiano.ed1.exercicios.listaPiha;

import java.util.Stack;

public class Exercicio12 {

    public static int ElementosImpares(Stack<Integer> S){

        Stack<Integer> aux = new Stack<>();
        int cont = 0;
        while (!S.empty()){
            int valor = aux.push(S.pop());
            if (valor % 2 != 0) {
                cont++;
            }
        }

        while (!aux.empty()) S.push(aux.pop());

        return cont;
    }

    public static void main(String[] args) {

        Stack<Integer> A = new Stack<>();
        for (int i = 0; i <= 5; i++) A.push(i);

        System.out.println(ElementosImpares(A));

    }
}
