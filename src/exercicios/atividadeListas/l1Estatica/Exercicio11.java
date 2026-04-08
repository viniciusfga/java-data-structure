package exercicios.atividadeListas.l1Estatica;

public class Exercicio11 {
    /*
    Considere que a lista armazena números inteiros. Crie um método public
    void removerNegativos() que remova todos os números menores que zero da própria
    lista, sem criar uma lista auxiliar.
     */

    public class Lista {

        int[] elementos;
        int tamanho;

        public Lista(int capacidade) {
            elementos = new int[capacidade];
            tamanho = 0;
        }

        public void adicionar(int valor) {
            elementos[tamanho] = valor;
            tamanho++;
        }

        public void removerNegativos() {

            int novaPos = 0;

            for (int i = 0; i < tamanho; i++) {

                if (elementos[i] >= 0) {
                    elementos[novaPos] = elementos[i];
                    novaPos++;
                }

            }

            tamanho = novaPos;
        }

        public void imprimir() {
            for (int i = 0; i < tamanho; i++) {
                System.out.print(elementos[i] + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {

        Exercicio11 ex = new Exercicio11();
        Lista lista = ex.new Lista(10);

        lista.adicionar(10);
        lista.adicionar(-5);
        lista.adicionar(20);
        lista.adicionar(-3);
        lista.adicionar(30);

        System.out.println("Antes:");
        lista.imprimir();

        lista.removerNegativos();

        System.out.println("Depois:");
        lista.imprimir();

    }
}
