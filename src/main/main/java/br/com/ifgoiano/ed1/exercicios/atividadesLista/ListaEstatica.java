package java.br.com.ifgoiano.ed1.exercicios.atividadesLista;

/**
 * Nome: Vinicius Franco Gonçalves Araujo
 * Disciplina: Estrutura de Dados I
 * Data: 27/03/2026
 *
 * Questão 1) Implementar um método para procurar uma substring em uma lista estática de
 * caracteres. O método deve conter a seguinte assinatura: strsbstr(l1, i1, i2),
 * onde l1 é a lista estática de caracteres, i1 é o início da substring e i2 é o fim da substring.
 * Esse método retorna uma lista com a substring desejada. A lista l1 permanece inalterada.
 */

public class ListaEstatica {

    char[] dados;
    int primeiro;
    int ultimo;

    public ListaEstatica(int capacidade) {
        dados = new char[capacidade];
        primeiro = 0;
        ultimo = 0;
    }

    public boolean vazia() {
        return ultimo == 0;
    }

    public boolean cheia() {
        return ultimo == dados.length;
    }

    public void inserir(char valor) throws Exception {
        if (cheia()) {
            throw new Exception("Lista cheia.");
        }

        dados[ultimo] = valor;
        ultimo++;
    }

    public void imprimir() {
        for (int i = primeiro; i < ultimo; i++) {
            System.out.print(dados[i] + " ");
        }
        System.out.println();
    }

    public static ListaEstatica strsbstr(ListaEstatica l1, int i1, int i2) throws Exception {
        if (l1.vazia()) {
            throw new Exception("A lista está vazia.");
        }

        if (i1 < 0 || i2 < 0 || i1 > i2 || i2 >= l1.ultimo) {
            throw new Exception("Índices inválidos.");
        }

        ListaEstatica nova = new ListaEstatica(i2 - i1 + 1);

        for (int i = i1; i <= i2; i++) {
            nova.inserir(l1.dados[i]);
        }

        return nova;
    }

    public static void main(String[] args) throws Exception {
        ListaEstatica lista = new ListaEstatica(10);

        lista.inserir('B');
        lista.inserir('O');
        lista.inserir('L');
        lista.inserir('A');
        lista.inserir('Y');

        System.out.println("Lista original:");
        lista.imprimir();

        ListaEstatica sub = ListaEstatica.strsbstr(lista, 1, 3);

        System.out.println("Substring:");
        sub.imprimir();
    }
}