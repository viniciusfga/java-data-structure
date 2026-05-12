package br.com.ifgoiano.ed1.exercicios.atividadesFila;

public class VerificarTamanhoFila {

    static class Fila {

        int[] item;
        int inicio;
        int fim;

        public Fila(int maxTam) {
            this.item = new int[maxTam];
            this.inicio = 0;
            this.fim = 0;
        }

        public boolean temMaisElementos(Fila f1, Fila f2) {
            int tamanhoF1 = f1.fim - f1.inicio;
            int tamanhoF2 = f2.fim - f2.inicio;

            return tamanhoF1 > tamanhoF2;
        }
    }

    public static void main(String[] args) {

        Fila f1 = new Fila(10);
        Fila f2 = new Fila(10);

        f1.item[0] = 10;
        f1.item[1] = 20;
        f1.item[2] = 30;
        f1.fim = 3;

        f2.item[0] = 5;
        f2.item[1] = 15;
        f2.fim = 2;

        // Comparação
        boolean resultado = f1.temMaisElementos(f1, f2);

        if (resultado) {
            System.out.println("F1 tem mais elementos que F2");
        } else {
            System.out.println("F2 tem mais elementos ou são iguais");
        }

    }
}
