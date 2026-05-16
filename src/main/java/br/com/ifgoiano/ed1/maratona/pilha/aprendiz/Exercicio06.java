package br.com.ifgoiano.ed1.maratona.pilha.aprendiz;

public class Exercicio06 {

    private int[] elements;
    private int size;

    public Exercicio06(int maxSize) {
        elements = new int[maxSize];
        size = 0;
    }

    public void push(int value) throws Exception {

        if (isFull()) {
            throw new Exception("Stack Overflow!");
        }

        elements[size] = value;
        size++;
    }

    public int pop() throws Exception {

        if (isEmpty()) {
            throw new Exception("Stack is empty!");
        }

        size--;
        return elements[size];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == elements.length;
    }

    public static void main(String[] args) {

        Exercicio06 stack = new Exercicio06(3);

        try {

            System.out.println(stack.isEmpty());

            stack.push(10);
            stack.push(20);

            System.out.println(stack.pop());
            System.out.println(stack.pop());

            System.out.println(stack.isEmpty());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}