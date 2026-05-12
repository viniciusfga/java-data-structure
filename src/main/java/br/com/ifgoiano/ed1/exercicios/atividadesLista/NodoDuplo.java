package br.com.ifgoiano.ed1.exercicios.atividadesLista;

public class NodoDuplo {

    char item;
    NodoDuplo prox;
    NodoDuplo ant;

    public NodoDuplo(char item) {
        this.item = item;
        this.prox = null;
        this.ant = null;
    }
}