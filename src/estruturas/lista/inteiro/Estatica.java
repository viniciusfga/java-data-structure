package estruturas.lista.inteiro;

import estruturas.base.ListaGeneritcs;

public class Estatica extends ListaGeneritcs {

    int[] item;
    int primeiro;
    int tamanho;

    Estatica(int maxTam) {
        item = new int[maxTam];
        primeiro = 0;
    }

    @Override
    public void inserirInicio(int valor) throws Exception {
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
    public void inserirFim(int valor) throws Exception {
        if (cheia()) throw new Exception("Lista Cheia!");

        item[tamanho] = valor;
        tamanho++;
    }

    @Override
    public void inserirOrdenado(int valor) throws Exception {
        if (cheia()) throw new Exception("Lista Cheia!");

        int k = 0;

        while(k < tamanho && item[k] < valor){
            k++;
        }

        for (int i = tamanho - 1; i >= k; i--) {
            item[i + 1] = item[i];
        }

        item[k] = valor;
        tamanho++;
    }

    @Override
    public int removerInicio() throws Exception {
        if (vazia()) {
            throw new Exception("Lista Vazia!");
        }
        int aux = item[0];

        for (int i = 0; i < tamanho - 1; i++) {
            item[i] = item[i + 1];
        }

        item[tamanho - 1] = 0;
        tamanho--;

        return aux;
    }

    @Override
    public int removerFim() throws Exception {
        if (vazia()) {
            throw new Exception("Lista Vazia!");
        }

        int aux = item[tamanho - 1];
        item[tamanho - 1] = 0;
        tamanho--;
        return aux;
    }

    @Override
    public int remover(int chave) {
        int pos = -1;

        for (int i = 0; i < tamanho; i++) {
            if (item[i] != 0 && item[i] == chave) {
                pos = i;
                break;
            }
        }
        // SE NAO ENCONTRAR O ELEMENTO
        if (pos == -1) {
            return 0;
        }
        int aux = item[pos];
        // SE ENCONTRAR O ELEMENTO
        for (int i = pos; i < tamanho - 1; i++) {
            item[i] = item[i + 1];
        }
        item[tamanho - 1] = 0;
        tamanho--;

        return aux;
    }

    @Override
    public int buscar(int chave) {
        for (int i = 0; i < tamanho; i++) {
            if (item[i] != 0 && item[i] == chave) return item[i];
        }

        return -1;
    }

    @Override
    public boolean vazia() {
        return item[0] == 0;
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

    public static void main(String[] args) throws Exception {

        Estatica lista = new Estatica(4);

        lista.inserirFim(11);
        lista.inserirFim(12);

        lista.imprimir();

    }
}
