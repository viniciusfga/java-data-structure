package exercicios.atividadesFila;

class ListaFila {

    int item[];
    int inicio;
    int fim;
    int quantidade;

    public ListaFila(int maxTam) {
        item = new int[maxTam];
        inicio = 0;
        fim = 0;
        quantidade = 0;
    }

    public void push(int valor) throws Exception {
        if (cheia()) {
            throw new Exception("Fila cheia!");
        }

        item[fim] = valor;
        fim = (fim + 1) % item.length;
        quantidade++;
    }

    public int pop() throws Exception {
        if (vazia()) {
            throw new Exception("Fila vazia!");
        }

        int valor = item[inicio];
        inicio = (inicio + 1) % item.length;
        quantidade--;
        return valor;
    }

    //método que receba uma fila como parâmetro e retire todos os elementos ímpares dessa fila.
    public void removerImpares(ListaFila fila) throws Exception {

        int tamanho = fila.quantidade;

        for (int i = 0; i < tamanho; i++) {
            int valor = fila.pop();

            if (valor % 2 == 0) {
                fila.push(valor);
            }
        }
    }

    public boolean cheia() {
        return quantidade == item.length;
    }

    public boolean vazia() {
        return quantidade == 0;
    }


    public void imprimir() {
        if (vazia()) {
            System.out.println("Fila vazia.");
            return;
        }

        int i = inicio;
        int cont = 0;

        while (cont < quantidade) {
            System.out.print(item[i] + " ");
            i = (i + 1) % item.length;
            cont++;
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {

        try {
            ListaFila fila = new ListaFila(5);

            fila.push(1);
            fila.push(2);
            fila.push(3);
            fila.push(4);
            fila.push(5);

            System.out.print("Fila original: ");
            fila.imprimir();

            fila.removerImpares(fila);

            System.out.print("Fila após remover ímpares: ");
            fila.imprimir();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}