package exercicios.atividadeListas.l1Estatica.Exercicio03;

public class Vetor {

    private String[] elementos;
    private int tamanho;

    // construtor padrão
    public Vetor() {
        elementos = new String[100];
        tamanho = 0;
    }

    // construtor com capacidade inicial
    public Vetor(int capacidade) {
        elementos = new String[capacidade];
        tamanho = 0;
    }

    // adiciona no final
    public boolean adiciona(String elemento) {

        if (tamanho < elementos.length) {
            elementos[tamanho] = elemento;
            tamanho++;
            return true;
        }
        return false;
    }

    // adiciona em uma posição
    public boolean adiciona(String elemento, int posicao) {
        if (posicao < 0 || posicao > tamanho) {
            throw new IllegalArgumentException("Posição inválida");
        }

        if (tamanho >= elementos.length) {
            return false;
        }

        // desloca elementos para a direita
        for (int i = tamanho - 1; i >= posicao; i--) {
            elementos[i + 1] = elementos[i];
        }

        elementos[posicao] = elemento;
        tamanho++;

        return true;
    }

    // busca por posição
    public String busca(int posicao){
        if (posicao < 0 || posicao >= tamanho) {
            throw new IllegalArgumentException("Posição inválida");
        }

        return elementos[posicao];
    }

    // busca por elemento
    public int busca(String elemento){
        for (int i = 0; i < tamanho; i++) {
            if (elementos[i].equals(elemento)) {
                return i;
            }
        }

        return -1;
    }

    // retorna tamanho
    public int tamanho() {
        return tamanho;
    }

    // remove por posição
    public void remove(int posicao) {

        if (posicao < 0 || posicao >= tamanho) {
            throw new IllegalArgumentException("Posição inválida");
        }

        // desloca elementos para esquerda
        for (int i = posicao; i < tamanho - 1; i++) {
            elementos[i] = elementos[i + 1];
        }

        tamanho--;
    }

    // imprimir vetor
    public String toString() {

        StringBuilder s = new StringBuilder();

        s.append("[");

        for (int i = 0; i < tamanho; i++) {

            s.append(elementos[i]);

            if (i < tamanho - 1) {
                s.append(", ");
            }
        }

        s.append("]");

        return s.toString();
    }

}
