package exercicios.atividadesLista;

/**
 * Nome: Vinicius Franco Gonçalves Araujo
 * Disciplina: Estrutura de Dados I
 * Data: 27/03/2026
 *
 * Questão 2) Faça um método para intercalar listas encadeadas ordenadamente:
 * o método recebe duas listas encadeadas ordenadas crescente e retorna
 * uma lista encadeada com os elementos das duas listas intercalados,
 * porém obedecendo a ordem crescente dos números.
 *
 * Questão 3) Escreva um método dividirAoMeio() que divida a lista original
 * em duas novas listas de tamanhos iguais (se o tamanho for ímpar,
 * a primeira lista pode ter um nó a mais). No final, deve imprimir
 * as duas novas listas. Observação: antes de iniciar o processo de divisão
 * deve-se imprimir a lista original.
 */

public class Encadeada {

    Nodo primeiro;
    Nodo ultimo;

    public Encadeada() {
        primeiro = null;
        ultimo = null;
    }

    public boolean vazia() {
        return primeiro == null;
    }

    public void inserirFim(int valor) {
        Nodo novo = new Nodo(valor);

        if (vazia()) {
            primeiro = novo;
            ultimo = novo;
        } else {
            ultimo.prox = novo;
            ultimo = novo;
        }
    }

    public void imprimir() {
        Nodo aux = primeiro;

        while (aux != null) {
            System.out.print(aux.item + " ");
            aux = aux.prox;
        }
        System.out.println();
    }

    public static Encadeada intercalar(Encadeada l1, Encadeada l2) {
        Encadeada nova = new Encadeada();

        Nodo p1 = l1.primeiro;
        Nodo p2 = l2.primeiro;

        while (p1 != null && p2 != null) {
            if (p1.item <= p2.item) {
                nova.inserirFim(p1.item);
                p1 = p1.prox;
            } else {
                nova.inserirFim(p2.item);
                p2 = p2.prox;
            }
        }

        while (p1 != null) {
            nova.inserirFim(p1.item);
            p1 = p1.prox;
        }

        while (p2 != null) {
            nova.inserirFim(p2.item);
            p2 = p2.prox;
        }

        return nova;
    }

    public static void dividirAoMeio(Encadeada l) {

        System.out.println("Lista original:");
        l.imprimir();

        if (l.vazia() || l.primeiro.prox == null) {
            System.out.println("Lista muito pequena para dividir.");
            return;
        }

        Nodo lento = l.primeiro;
        Nodo rapido = l.primeiro;

        while (rapido.prox != null && rapido.prox.prox != null) {
            lento = lento.prox;
            rapido = rapido.prox.prox;
        }

        Encadeada l1 = new Encadeada();
        Encadeada l2 = new Encadeada();

        Nodo aux = l.primeiro;

        while (aux != lento.prox) {
            l1.inserirFim(aux.item);
            aux = aux.prox;
        }

        aux = lento.prox;
        while (aux != null) {
            l2.inserirFim(aux.item);
            aux = aux.prox;
        }

        System.out.println("Primeira metade:");
        l1.imprimir();

        System.out.println("Segunda metade:");
        l2.imprimir();
    }

    public static void main(String[] args) {

        Encadeada l1 = new Encadeada();
        l1.inserirFim(1);
        l1.inserirFim(3);
        l1.inserirFim(5);

        Encadeada l2 = new Encadeada();
        l2.inserirFim(2);
        l2.inserirFim(4);
        l2.inserirFim(6);

        System.out.println("Lista 1:");
        l1.imprimir();

        System.out.println("Lista 2:");
        l2.imprimir();

        Encadeada listaIntercalada = intercalar(l1, l2);

        System.out.println("Lista intercalada:");
        listaIntercalada.imprimir();

        Encadeada lista = new Encadeada();
        lista.inserirFim(1);
        lista.inserirFim(2);
        lista.inserirFim(3);
        lista.inserirFim(4);
        lista.inserirFim(5);

        dividirAoMeio(lista);
    }
}