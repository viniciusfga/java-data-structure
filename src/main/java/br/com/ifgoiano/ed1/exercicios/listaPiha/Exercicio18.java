package br.com.ifgoiano.ed1.exercicios.listaPiha;

import java.util.Stack;

public class Exercicio18 {

    private static class Carro {
        String placa;
        int manobras;

        Carro(String placa) {
            this.placa = placa;
            this.manobras = 0;
        }
    }

    private static final int CAPACIDADE = 10;
    private static Stack<Carro> estacionamento = new Stack<>();

    private static void saiCarro(String placaAlvo) {
        Stack<Carro> ruaDireita = new Stack<>();
        Carro cliente = null;
        boolean encontrado = false;

        while (!estacionamento.empty()) {
            Carro atual = estacionamento.pop();

            if (atual.placa.equals(placaAlvo)) {
                cliente = atual;
                encontrado = true;
                break;
            } else {
                atual.manobras++;
                ruaDireita.push(atual);
            }
        }

        while (!ruaDireita.empty()) {
            estacionamento.push(ruaDireita.pop());
        }

        if (encontrado) {
            System.out.println("Carro " + cliente.placa + " SAIU. Foi manobrado " + cliente.manobras + " vezes para dar passagem.");
        } else {
            System.out.println("Erro: Carro com a placa " + placaAlvo + " não está no estacionamento.");
        }
    }

    private static void chegaCarro(String placa) {
        if (estacionamento.size() < CAPACIDADE) {
            estacionamento.push(new Carro(placa));
            System.out.println("Carro " + placa + " ENTROU.");
        } else {
            System.out.println("Carro " + placa + " CHEGOU, mas NÃO há vagas.");
        }

    }

    public static void main(String[] args) {
        System.out.println("SIMULAÇÃO DO ESTACIONAMENTO ");

        chegaCarro("ABC-1234");
        chegaCarro("XYZ-5678");
        chegaCarro("MNO-9999");

        saiCarro("XYZ-5678");

        saiCarro("MNO-9999");

        saiCarro("ABC-1234");
    }
}
