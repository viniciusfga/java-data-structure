package java.br.com.ifgoiano.ed1.estruturas.lista.inteiro;

public class Nodo {

    public int item;
    public Nodo prox;
    Nodo ant;

    public Nodo(int valor){
        this.item = valor;
        this.prox = null;
        this.ant = null;
    }
}
