package exercicios.listaEstatico;

public class Exercicio05 {

    /*
    Implemente um método que receba um número inteiro como parâmetro e
    retorne quantas vezes ele aparece na lista.
     */

    public static int contar(int numero, int[] vetor){
        int quantidade = 0;

        for (int i = 0; i < vetor.length; i++) {
            if (numero == vetor[i]) {
                quantidade++;
            }
        }

        return quantidade;
    }

    public static void main(String[] args) {

        int[] lista = {1,2,3,4,4,4,5,6,7,8,9,10};

        int resultado = contar(4, lista);

        System.out.println("Quantidade: " + resultado);

    }
}
