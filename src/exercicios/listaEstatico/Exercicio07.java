package exercicios.listaEstatico;

public class Exercicio07 {

    /*
    Considere uma lista contendo números inteiros. Escreva um método public
    Generics.Lista extrairPares() que crie e retorne uma nova Generics.Lista contendo apenas os números
    pares da lista original. A lista original não deve ser modificada. Se não houver pares,
    retorne uma lista vazia.
     */

    public class Lista {
        int[] elementos;
        int tamanho;

        public Lista extrairPares() {

            Lista novaLista = new Lista();

            for (int i = 0; i < this.tamanho; i++) {

                if (this.elementos[i] % 2 == 0) {
                    novaLista.adiciona(this.elementos[i]);
                }

            }

            return novaLista;
        }

        private void adiciona(int elemento) {
        }
    }
}
