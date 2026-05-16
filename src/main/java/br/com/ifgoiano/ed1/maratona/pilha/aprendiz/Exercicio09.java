package br.com.ifgoiano.ed1.maratona.pilha.aprendiz;

import java.util.Scanner;
import java.util.Stack;

public class Exercicio09 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 10; i++) {
           int valor = sc.nextInt();
            if (valor % 2 == 0) {
                stack.push(valor);
            }
        }

        while(!stack.empty()){
            System.out.println(stack.pop());
        }
    }
}
