package java.br.com.ifgoiano.ed1.exercicios.atividadesFila;

class Chamado {

    String nomeCliente;
    String descricaoProblema;
    Chamado prox;

    public Chamado(String nomeCliente, String descricaoProblema) {

    }
}

public class SistemaChamados {

    Chamado inicio;
    Chamado fim;

    public SistemaChamados() {
        inicio = null;
        fim = null;
    }

    public boolean vazia() {
        return inicio == null;
    }

    public void abrirChamado(String nomeCliente, String descricaoProblema) {


    }

    public void inserirUrgente(String nomeCliente, String descricaoProblema) {


    }

    public Chamado atenderChamado() {

        return null;
    }

    public void peek() {
        if (vazia()) {
            System.out.println("Nenhum chamado na fila.");
        } else {
            System.out.println("Próximo da fila: " + inicio.nomeCliente);
            System.out.println("Problema: " + inicio.descricaoProblema);
            System.out.println("Chamados restantes: " + contarChamados());
        }
    }

    public int contarChamados() {

        return -1;
    }

    public void mostrarFila() {
        if (vazia()) {
            System.out.println("Fila vazia.");
            return;
        }

    }

    public static void main(String[] args) {

        SistemaChamados fila = new SistemaChamados();

        fila.abrirChamado("João", "Computador não liga");
        fila.abrirChamado("Maria", "Sem acesso ao sistema");
        fila.abrirChamado("Pedro", "Erro na impressora");

        fila.peek();
        System.out.println();

        fila.inserirUrgente("Diretor", "Servidor parou");
        fila.peek();
        System.out.println();

        fila.mostrarFila();
        System.out.println();

        Chamado atendido = fila.atenderChamado();
        if (atendido != null) {
            System.out.println("Chamado atendido: " + atendido.nomeCliente);
        }

        System.out.println();
        fila.peek();
    }
}