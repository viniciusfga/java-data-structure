package br.com.ifgoiano.ed1.exercicios.listaPiha;


import java.util.Stack;

public class Exercicio06 {


    public static boolean expressaoCorreta(Stack<Character> E) {

        Stack<Character> aux = new Stack<>();
        while (!E.empty()) {
            char c = E.pop();

            if (c == ')') {
                aux.push(c);
            } else if (c == '(') {
                if (aux.empty()) return false;
                aux.pop();
            }
        }

        return aux.empty();
    }


    public static void main(String[] args) {

        Stack<Character> A = new Stack<>();

        A.push('(');
        A.push('(');
        A.push(')');
        A.push(')');
        A.push('-');
        A.push('-');

        System.out.println(expressaoCorreta(A));
    }
}
