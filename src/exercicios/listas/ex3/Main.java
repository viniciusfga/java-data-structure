package exercicios.listas.ex3;

public class Main {

    public static void main(String[] args) {

        Vetor vetor = new Vetor(5);

        vetor.adiciona("A");
        vetor.adiciona("B");
        vetor.adiciona("C");

        vetor.adiciona("X", 1);

        System.out.println(vetor);

        vetor.remove(2);

        System.out.println(vetor);

        System.out.println("Busca B: " + vetor.busca("B"));
        System.out.println("Tamanho: " + vetor.tamanho());
    }
}