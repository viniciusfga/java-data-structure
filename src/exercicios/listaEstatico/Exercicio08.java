package exercicios.listaEstatico;

public class Exercicio08 {

    public class Objeto {
        Object[] elementos;
        int tamanho;

        public int contarOcorrencias(Object elemento) {

            int contador = 0;

            for (int i = 0; i < this.tamanho; i++) {

                if (this.elementos[i].equals(elemento)) {
                    contador++;
                }

            }

            return contador;
        }
    }
}
