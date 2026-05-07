package java.br.com.ifgoiano.ed1.exercicios.listaEstatico;

public class Exercicio12 {

    /*
    Escreva um método public void concatenar(Generics.Lista l2) que receba uma
    segunda lista l2 e adicione todos os elementos dela ao final da lista atual. Se o array da
    lista atual não tiver espaço suficiente para todos os elementos de l2, o método deve inserir
    até onde couber e parar.
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

        public void concatenar(Lista l2) {

            for (int i = 0; i < l2.tamanho; i++) {

                if (this.tamanho < this.elementos.length) {

                    this.elementos[this.tamanho] = l2.elementos[i];
                    this.tamanho++;

                } else {
                    break;
                }

            }

        }

        public void imprimir() {

            for (int i = 0; i < tamanho; i++) {
                System.out.print(elementos[i] + " ");
            }

            System.out.println();
        }

        public static void main(String[] args) {

            Lista l1 = new Lista(5);
            Lista l2 = new Lista(3);

            l1.adicionar(10);
            l1.adicionar(20);
            l1.adicionar(30);

            l2.adicionar(40);
            l2.adicionar(50);
            l2.adicionar(60);

            l1.concatenar(l2);

            l1.imprimir();

        }

    }

}


