package exercicios.listas;

public class Exercicio16 {

    /*
     Suponha que a lista armazene caracteres (ou strings de uma letra). Crie um
    método public boolean isPalindromo() que retorne true se a sequência de elementos da
    lista for a mesma quando lida da esquerda para a direita e da direita para a esquerda, e
    false caso contrário.
     */
    public static class Lista {

        String[] elementos;
        int tamanho;

        public Lista(int capacidade) {
            elementos = new String[capacidade];
            tamanho = 0;
        }

        public void adicionar(String valor) {
            if (tamanho < elementos.length) {
                elementos[tamanho] = valor;
                tamanho++;
            }
        }


        public boolean isPalindromo() {

            for (int i = 0; i < tamanho / 2; i++) {

                if (!elementos[i].equals(elementos[tamanho - 1 - i])) {
                    return false;
                }

            }

            return true;
        }

        public void imprimir() {
            for (int i = 0; i < tamanho; i++) {
                System.out.print(elementos[i] + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {

        Exercicio16.Lista lista = new Exercicio16.Lista(3);

        lista.adicionar("o");
        lista.adicionar("v");
        lista.adicionar("o");
        lista.imprimir();

        System.out.println(lista.isPalindromo());

    }
}
