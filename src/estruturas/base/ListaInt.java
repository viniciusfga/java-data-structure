package estruturas.base;

public abstract class ListaInt<T> {

    protected int tamanho;

    // INSERÇÃO
    public abstract void inserirInicio(T item) throws Exception;
    public abstract void inserirOrdenado(T item) throws Exception;
    public abstract void inserirFim(T item) throws Exception;

    // REMOÇÃO
    public abstract T removerInicio() throws Exception;
    public abstract T remover(T chave) throws Exception;
    public abstract T removerFim() throws Exception;

    // BUSCA
    public abstract T buscar(T chave);

    // ESTADO
    public boolean vazia() {
        return tamanho == 0;
    }

    public abstract boolean cheia();

    public int tamanho() {
        return tamanho;
    }

    // UTIL
    public abstract void imprimir();
}