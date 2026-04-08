package exercicios.atividadeListas.l1Estatica;

public class Exercicio10 {

    /*
    Implemente o método public Generics.Lista subLista(int inicio, int fim). Ele deve
    retornar uma nova Generics.Lista contendo os elementos do índice inicio até o índice fim - 1. O
    método deve validar se os índices passados são válidos.
     */

    public static class Lista {

        Object[] elementos;
        int tamanho;

        public Lista(int capacidade) {
            elementos = new Object[capacidade];
            tamanho = 0;
        }

        public Lista subLista(int inicio, int fim) throws Exception {

            if (inicio < 0 || fim > this.tamanho || inicio >= fim) {
                throw new Exception("Índices inválidos");
            }

            Lista novaLista = new Lista(fim - inicio);

            for (int i = inicio; i < fim; i++) {
                novaLista.elementos[novaLista.tamanho] = this.elementos[i];
                novaLista.tamanho++;
            }

            return novaLista;
        }
    }
}
