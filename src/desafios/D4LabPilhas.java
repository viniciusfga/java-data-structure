package desafios;

import java.util.Scanner;

/*
    QUESTÃO 1 – VALIDAÇÃO DE CAMINHO (LABIRINTO)
    N → Norte | S → Sul | L → Leste | O → Oeste

    Entrada: N S L O → válido
    Entrada: N N S → inválido
    Entrada: N N S S → válido
 */
public class D4LabPilhas {

    char[] elementos;
    int fim;

    public D4LabPilhas(int maxTam) {
        elementos = new char[maxTam];
        fim = 0;
    }

    public void empilhar(char valor) {
        if (cheia()) {
            throw new IllegalStateException("Pilha cheia");
        }
        elementos[fim] = valor;
        fim++;
    }

    public char desempilhar() {
        if (vazia()) {
            throw new IllegalStateException("Pilha vazia");
        }
        fim--;
        return elementos[fim];
    }

    public char topo() {
        if (vazia()) {
            throw new IllegalStateException("Pilha vazia");
        }
        return elementos[fim - 1];
    }

    public boolean vazia() {
        return fim == 0;
    }

    public boolean cheia() {
        return fim == elementos.length;
    }

    public int tamanho() {
        return fim;
    }

    public void imprimir() {
        for (int i = 0; i < fim; i++) {
            System.out.print(elementos[i] + " ");
        }
        System.out.println();
    }

    private static boolean saoOpostos(char primeira, char segunda) {
        return (primeira == 'N' && segunda == 'S')
                || (primeira == 'S' && segunda == 'N')
                || (primeira == 'L' && segunda == 'O')
                || (primeira == 'O' && segunda == 'L');
    }

    public static boolean validarCaminho(D4LabPilhas lab, String[] direcoes) {
        if (direcoes == null || direcoes.length == 0) {
            System.out.println("Caminho vazio");
            return false;
        }

        for (int i = 0; i < direcoes.length; i++) {
            if (direcoes[i] == null || direcoes[i].isBlank()) {
                return false;
            }

            char direcao = Character.toUpperCase(direcoes[i].charAt(0));

            if (direcao != 'N' && direcao != 'S' && direcao != 'L' && direcao != 'O') {
                return false;
            }

            if (!lab.vazia() && saoOpostos(lab.topo(), direcao)) {
                lab.desempilhar();
            } else {
                lab.empilhar(direcao);
            }
        }

        return lab.vazia();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o caminho: ");
        String caminho = sc.nextLine().replaceAll("\\s+", "");

        if (caminho.isEmpty()) {
            System.out.println("inválido");
            return;
        }

        String[] direcoes = caminho.split("");

        D4LabPilhas lab = new D4LabPilhas(direcoes.length);

        if (validarCaminho(lab, direcoes)) {
            System.out.println("válido");
        } else {
            System.out.println("inválido");
        }

        lab.imprimir();
    }
}