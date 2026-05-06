package exercicios.listaEstatico;

public class Exercicio06 {
    /*
    Crie uma classe de teste para adicionar elementos no vetor (exercício
    anterior) e imprimir o vetor.
     */

    public static int contar(int numero, int[] vetor) {
        int quantidade = 0;

        for (int i = 0; i < vetor.length; i++) {
            if (numero == vetor[i]) {
                quantidade++;
            }
        }

        return quantidade;
    }

    public static void imprimir(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i] + ", ");
        }
    }

    public static void main(String[] args) {

        int[] lista = new int[5];

        // adicionando elementos
        lista[0] = 10;
        lista[1] = 20;
        lista[2] = 30;
        lista[3] = 40;
        lista[4] = 50;

        // imprimindo vetor
        imprimir(lista);

    }
}
