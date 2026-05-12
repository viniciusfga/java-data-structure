package br.com.ifgoiano.ed1.estruturas.base;

public abstract class ListaGeneritcs {

    // INSERÇÃO
    public abstract void inserirInicio(int item) throws Exception;
    public abstract void inserirOrdenado(int item) throws Exception;
    public abstract void inserirFim(int item) throws Exception;

    // REMOÇÃO
    public abstract int removerInicio() throws Exception;
    public abstract int remover(int chave) throws Exception;
    public abstract int removerFim() throws Exception;

    // BUSCA
    public abstract int buscar(int chave) throws Exception;

    // ESTADO
    public abstract boolean vazia()  throws Exception;
    public abstract boolean cheia();

    // UTIL
    public abstract void imprimir();
}
