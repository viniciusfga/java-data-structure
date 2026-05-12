package br.com.ifgoiano.ed1.exercicios.atividadesLista;

/**
 * Nome: Vinicius Franco Gonçalves Araujo
 * Disciplina: Estrutura de Dados I
 * Data: 27/03/2026
 * <p>
 * Questão 4) Implemente o jogo de Josephus: N pessoas estão em um círculo. Começando pela
 * primeira pessoa, você pula M pessoas e elimina a próxima, repetindo o processo até que reste
 * apenas uma. Escreva um método josephus(int n, int m) que cria uma lista circular de N nós
 * (numerados de 1 a N) e retorna o número do nó sobrevivente. Fazer com que o método imprima a
 * ordem em que as pessoas são eliminadas antes de retornar o vencedor.
 *
 **/

public class EncadeadaCircular {

    Nodo primeiro;
    Nodo ultimo;
    int qtd;

    public EncadeadaCircular() {
        primeiro = null;
        ultimo = null;
    }

    public int josephus(int n, int m) throws Exception {

        if (n <= 0 || m <= 0) {
            throw new Exception("n e m devem ser maiores que zero.");
        }

        for (int i = 1; i <= n; i++) {
            inserirFim(i);
        }

        Nodo aux = primeiro;
        Nodo ant = ultimo;

        System.out.println("Ordem de eliminação:");

        while (qtd > 1) {
            // pula m pessoas e elimina a próxima
            for (int i = 1; i <= m; i++) {
                ant = aux;
                aux = aux.prox;
            }
            System.out.println("Eliminado: " + aux.item);
            if (aux == primeiro) {
                primeiro = primeiro.prox;
                ultimo.prox = primeiro;
            } else if (aux == ultimo) {
                ant.prox = primeiro;
                ultimo = ant;
            } else {
                ant.prox = aux.prox;
            }

            aux = ant.prox;
            qtd--;
        }

        System.out.println("Vencedor: " + primeiro.item);
        return primeiro.item;
    }

    public boolean vazia() {
        return primeiro == null;
    }

    public void inserirFim(int valor) {
        Nodo novo = new Nodo(valor);

        if (vazia()) {
            primeiro = novo;
            ultimo = novo;
            novo.prox = primeiro;
        } else {
            ultimo.prox = novo;
            novo.prox = primeiro;
            ultimo = novo;
        }

        qtd++;
    }


    public static void main(String[] args) throws Exception {
        EncadeadaCircular lista = new EncadeadaCircular();

        lista.josephus(5, 2);
    }
}
