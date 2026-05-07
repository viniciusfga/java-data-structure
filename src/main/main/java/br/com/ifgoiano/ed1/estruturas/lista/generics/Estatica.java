package java.br.com.ifgoiano.ed1.estruturas.lista.generics;

import java.br.com.ifgoiano.ed1.estruturas.base.ListaInt;

public class Estatica<T extends Comparable<T>> extends ListaInt<T> {

    T[] item;
    int primeiro;
    int tamanho;

    Estatica(int maxTam) {
        item = (T[]) new Object[maxTam];
        primeiro = 0;
    }

    @Override
    public void inserirInicio(T valor) throws Exception {
        if (cheia()) throw new Exception("Lista Cheia!");
        if (vazia()) {
            item[0] = valor;
            tamanho++;
            return;
        }

        for (int i = tamanho - 1; i >= 0; i--) {
            item[i + 1] = item[i];
        }

        item[0] = valor;
        tamanho++;
    }

    @Override
    public void inserirFim(T valor) throws Exception {
        if (cheia()) throw new Exception("Lista Cheia!");

        item[tamanho] = valor;
        tamanho++;
    }

    @Override
    public void inserirOrdenado(T valor) throws Exception {

        if (cheia()) throw new Exception("Lista Cheia!");
        if (vazia()) {
            item[0] = valor;
            tamanho++;
            return;
        }

        int meio = tamanho / 2;

        for (int i = tamanho - 1; i >= meio; i--) {
            item[i + 1] = item[i];
        }

        item[meio] = valor;
        tamanho++;
    }

    @Override
    public T removerInicio() throws Exception {
        if (vazia()) {
            throw new Exception("Lista Vazia!");
        }
        T aux = item[0];

        for (int i = 0; i < tamanho - 1; i++) {
            item[i] = item[i + 1];
        }

        item[tamanho - 1] = null;
        tamanho--;

        return aux;
    }

    @Override
    public T removerFim() throws Exception {
        if (vazia()) {
            throw new Exception("Lista Vazia!");
        }

        T aux = item[tamanho - 1];
        item[tamanho - 1] = null;
        tamanho--;
        return aux;
    }

    @Override
    public T remover(T chave) {
        int pos = -1;

        for (int i = 0; i < tamanho; i++) {
            if (item[i] != null && item[i].equals(chave)) {
                pos = i;
                break;
            }
        }
        // SE NAO ENCONTRAR O ELEMENTO
        if (pos == -1) {
            return null;
        }
        T aux = item[pos];
        // SE ENCONTRAR O ELEMENTO
        for (int i = pos; i < tamanho - 1; i++) {
            item[i] = item[i + 1];
        }
        item[tamanho - 1] = null;
        tamanho--;

        return aux;
    }

    @Override
    public T buscar(T chave) {
        for (int i = 0; i < tamanho; i++) {
            if (item[i] != null && item[i].equals(chave)) return item[i];
        }

        return null;
    }

    @Override
    public boolean vazia() {
        return item[0] == null;
    }

    @Override
    public boolean cheia() {
        return tamanho == item.length;
    }

    @Override
    public void imprimir() {
        for (int i = 0; i < item.length; i++) {
            System.out.println("Posição " + i + " : " + item[i]);
        }
    }

    public int tamanho() {
        return tamanho;
    }

    public boolean validaPos(int pos) {
        return pos >= 0 && pos < tamanho;
    }

    public static void main(String[] args) throws Exception {

        Estatica<Integer> lista = new Estatica(4);

        lista.inserirFim(11);
        lista.inserirFim(12);

        lista.imprimir();

    }
}
