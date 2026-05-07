package java.br.com.ifgoiano.ed1.desafios;

/*
    Lista Estática (Validação + Inserção)

    Implemente o método:
    inserirMeio(int pos, int valor)
     */
public class D01 {

    int[] item;
    int primeiro;
    int ultimo;

    D01(int maxTam) {
        item = new int[maxTam];
        primeiro = 0;
        ultimo = 0;
    }

    private void inserirMeio(int pos, int valor) throws Exception {

        if(pos < primeiro || pos > item.length){
            throw  new Exception("Posição Invalida");
        }

        for (int i = ultimo; i >= pos; i--) {
            item[i + 1] = item[i];
        }

        item[pos] = valor;
        ultimo++;
    }

    public void imprimir(){
        for (int i = 0; i < item.length; i++) {
            System.out.print(item[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {

        D01 lista = new D01(5);

        lista.inserirMeio(2,4);

        lista.imprimir();

    }
}
