package br.com.ifgoiano.ed1.exercicios.listaEstatico;

public class Exercicio09 {

    /*
    Crie um método public int substituirTodos(Object velho, Object novo)
    que procure por todas as ocorrências do item velho e as substitua pelo item novo. O
    método deve retornar um número inteiro informando quantas substituições foram
    realizadas.
     */

    public class Objeto {
        Object[] elementos;
        int tamanho;

        public int substituirTodos(Object velho, Object novo) {

            int contador = 0;

            for (int i = 0; i < this.tamanho; i++) {

                if (this.elementos[i] != null && this.elementos[i].equals(velho)) {

                    elementos[i] = novo;
                    contador++;
                }

            }

            return contador;
        }
    }
}
