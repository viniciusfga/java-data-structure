package exercicios.atividadesLista;

/**
 * Nome: Vinicius Franco Gonçalves Araujo
 * Disciplina: Estrutura de Dados I
 * Data: 27/03/2026
 *
 * Questão 6) Implementar um método para procurar uma substring em uma lista duplamente
 * encadeada de caracteres. O método deve conter a seguinte assinatura: strsbstr(l1, i1, i2),
 * onde l1 é a lista duplamente encadeada de caracteres, i1 é o início da substring e i2 é o fim
 * da substring. Esse método retorna uma lista com a substring desejada. A lista l1 permanece
 * inalterada.
 */

public class EncadeadaDupla06 {

    NodoDuplo primeiro;
    NodoDuplo ultimo;

    public EncadeadaDupla06() {
        primeiro = null;
        ultimo = null;
    }

    public boolean vazia() {
        return primeiro == null;
    }

    public void inserirFim(char valor) {
        NodoDuplo novo = new NodoDuplo(valor);

        if (vazia()) {
            primeiro = novo;
            ultimo = novo;
        } else {
            ultimo.prox = novo;
            novo.ant = ultimo;
            ultimo = novo;
        }
    }

    public void imprimir() {
        NodoDuplo aux = primeiro;

        while (aux != null) {
            System.out.print(aux.item + " ");
            aux = aux.prox;
        }
        System.out.println();
    }

    public static EncadeadaDupla06 strsbstr(EncadeadaDupla06 l1, int i1, int i2) throws Exception {
        if (l1.vazia()) {
            throw new Exception("A lista está vazia.");
        }

        if (i1 < 0 || i2 < 0 || i1 > i2) {
            throw new Exception("Índices inválidos.");
        }

        EncadeadaDupla06 sub = new EncadeadaDupla06();

        NodoDuplo aux = l1.primeiro;
        int pos = 0;

        while (aux != null) {
            if (pos >= i1 && pos <= i2) {
                sub.inserirFim(aux.item);
            }

            aux = aux.prox;
            pos++;
        }

        if (i1 >= pos || i2 >= pos) {
            throw new Exception("Índices fora do tamanho da lista.");
        }

        return sub;
    }

    public static void main(String[] args) throws Exception {
        EncadeadaDupla06 lista = new EncadeadaDupla06();

        lista.inserirFim('A');
        lista.inserirFim('B');
        lista.inserirFim('C');
        lista.inserirFim('D');
        lista.inserirFim('E');
        lista.inserirFim('F');

        System.out.println("Lista original:");
        lista.imprimir();

        EncadeadaDupla06 sub = strsbstr(lista, 1, 4);

        System.out.println("Substring:");
        sub.imprimir();

        System.out.println("Lista original após o método:");
        lista.imprimir();
    }
}