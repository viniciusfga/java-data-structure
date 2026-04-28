package exercicios.listas;

public class Exercicio14 {

    /*
    Escreva um método public Generics.Lista intercalar(Generics.Lista l2) que retorne uma
    terceira lista contendo os elementos da lista atual e da lista l2 intercalados (um da
    primeira, um da segunda, um da primeira...). Se uma lista for maior que a outra, os
    elementos restantes da lista maior devem ser adicionados ao final da nova lista.
     */

    public static class Lista {

        int[] elementos;
        int tamanho;

        public Lista(int capacidade) {
            elementos = new int[capacidade];
            tamanho = 0;
        }

        public void adicionar(int valor) {
            if (tamanho < elementos.length) {
                elementos[tamanho] = valor;
                tamanho++;
            }
        }

        public Lista intercalar(Lista l2) {

            // cria nova lista com capacidade máxima possível
            Lista nova = new Lista(this.tamanho + l2.tamanho);

            int i = 0;
            int j = 0;

            // intercala enquanto ambas tiverem elementos
            while (i < this.tamanho && j < l2.tamanho) {

                nova.adicionar(this.elementos[i]);
                nova.adicionar(l2.elementos[j]);

                i++;
                j++;
            }

            // adiciona restantes da lista atual
            while (i < this.tamanho) {
                nova.adicionar(this.elementos[i]);
                i++;
            }

            // adiciona restantes da lista l2
            while (j < l2.tamanho) {
                nova.adicionar(l2.elementos[j]);
                j++;
            }

            return nova;
        }


        public void imprimir() {
            for (int i = 0; i < tamanho; i++) {
                System.out.print(elementos[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Lista l1 = new Lista(5);
        Lista l2 = new Lista(5);

        l1.adicionar(10);
        l1.adicionar(20);
        l1.adicionar(30);

        l2.adicionar(1);
        l2.adicionar(2);
        l2.adicionar(3);
        l2.adicionar(4);
        l2.adicionar(5);

        Lista resultado = l1.intercalar(l2);

        resultado.imprimir();
    }
}
