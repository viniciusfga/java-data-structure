package estruturas.base;

public abstract class FilaInt {

    public abstract boolean vazia();

    public abstract boolean cheia();

    // RETORNAR TAMANHO
    public abstract int tamanho();

    // INSERÇÃO NO INICIO
    public abstract void enfileirar(int valor) throws Exception;

    // REMOÇÃO NO INICIO
    public abstract int desenfileirar() throws Exception;

    // RETORNAR INICIO
    public abstract int inicio() throws Exception;

    public abstract void imprimir();
}