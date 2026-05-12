package br.com.ifgoiano.ed1.estruturas.fila;

public class Fila {

    int item[];
    int first;
    int end;

    public Fila(int MaxSize){
        item = new int[MaxSize];
        first = 0;
    }
}
