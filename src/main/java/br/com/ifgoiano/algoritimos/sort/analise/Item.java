package br.com.ifgoiano.algoritimos.sort.analise;

/**
 * Autores: Vinicius Franco Gonçalves Araújo
 *          Rafael Belem Torres
 *          Rafael Henrico Gonçalves Justino
 *
 * Disciplina: Estrutura de Dados I
 * Data: 26/05/2026
 *
 * Objetivo: Classe que representa um item a ser ordenado.
 * Contém um valor inteiro e implementa a interface Comparable
 * para permitir comparações entre objetos.
 */

public class Item implements Comparable<Item> {
    private int valor;

    /**
     * Construtor da classe Item
     * @param valor Valor inteiro do item
     */
    public Item(int valor) {
        this.valor = valor;
    }

    /**
     * Obtém o valor do item
     * @return Valor inteiro
     */
    public int getValor() {
        return valor;
    }

    /**
     * Define o valor do item
     * @param valor Novo valor
     */
    public void setValor(int valor) {
        this.valor = valor;
    }

    /**
     * Compara este item com outro item
     * @param outro Item a ser comparado
     * @return Negativo se menor, zero se igual, positivo se maior
     */
    @Override
    public int compareTo(Item outro) {
        return Integer.compare(this.valor, outro.valor);
    }

    /**
     * Representação em string do item
     * @return String com o valor
     */
    @Override
    public String toString() {
        return String.valueOf(valor);
    }
}