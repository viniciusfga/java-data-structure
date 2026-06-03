package br.com.ifgoiano.ed1.exercicios.listaPiha;

import java.util.Stack;

public class Exercicio08 {

    public static boolean maior(Stack<Integer> A, Stack<Integer> B) {

        Stack<Integer> aux1 = new Stack<>();
        Stack<Integer> aux2 = new Stack<>();
        int cont1 = 0;
        int cont2 = 0;


        while (!A.empty()) {
            aux1.push(A.pop());
            cont1++;
        }

        while (!B.empty()) {
            aux2.push(B.pop());
            cont2++;
        }

        while (!aux1.empty()) A.push(aux1.pop());

        while (!aux2.empty()) B.push(aux2.pop());

        return cont1 > cont2;
    }

    public static void main(String[] args) {

        Stack<Integer> A = new Stack<>();
        Stack<Integer> B = new Stack<>();

        for (int i = 0; i < 5; i++) A.push(i);
        for (int i = 0; i < 4; i++) B.push(i);

        // A TEM MAIS QUE B?
        System.out.println(maior(A, B));
    }
}
