package br.com.ifgoiano.ed1.desafios;

/*
   Crie um método intercalarPilhas(Pilha a, Pilha b) que retorne uma terceira Pilha (Pilha c).
   A Pilha C deve ser formada alternando os elementos de A e B (Um de A, um e B, um e A...),
 */


import br.com.ifgoiano.ed1.estruturas.pilha.Pilha;

public class D3intercalarPilhas {

    public static void intercalar(Pilha a, Pilha b) {
        Pilha a1 = new Pilha(a.tamanho() + b.tamanho());
        Pilha b1 = new Pilha(a.tamanho() + b.tamanho());
        Pilha c = new Pilha(a.tamanho() + b.tamanho());
        int i = 0;
        int j = 0;

        while (i < a.tamanho() || j < b.tamanho()) {
            if (i < a.tamanho()) {
                a1.empilhar(a.desempilhar());
            }
            if (j < b.tamanho()) {
                b1.empilhar(b.desempilhar());
            }
        }

        while (i < a1.tamanho() || j < b1.tamanho()) {
            if (i < a1.tamanho()) {
                c.empilhar(a1.desempilhar());
            }
            if (j < b1.tamanho()) {
                c.empilhar(b1.desempilhar());
            }
        }

        c.imprimir();
    }

    public static void main(String[] args) {

        Pilha pilhaA = new Pilha(4);
        Pilha pilhaB = new Pilha(4);

        pilhaA.empilhar(1);
        pilhaA.empilhar(3);

        pilhaB.empilhar(2);
        pilhaB.empilhar(4);
        pilhaB.empilhar(5);

        intercalar(pilhaA, pilhaB);
    }
}
