    package desafios;

    import java.util.*;

    public class D02Fracao {

        static class Fracao {
            int numerador;
            int denominador;

            Fracao(int n, int d) {
                numerador = n;
                denominador = d;
            }
        }

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            int qtd = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < qtd; i++) {

                String[] partes = sc.nextLine().split(" ");

                int n1 = Integer.parseInt(partes[0]);
                int d1 = Integer.parseInt(partes[2]);
                String op = partes[3];
                int n2 = Integer.parseInt(partes[4]);
                int d2 = Integer.parseInt(partes[6]);

                Fracao resultado = null;

                switch (op) {
                    case "+" -> resultado = soma(n1, d1, n2, d2);
                    case "-" -> resultado = subtracao(n1, d1, n2, d2);
                    case "*" -> resultado = multiplicacao(n1, d1, n2, d2);
                    case "/" -> resultado = divisao(n1, d1, n2, d2);
                }

                // guarda antes de simplificar
                int numOriginal = resultado.numerador;
                int denOriginal = resultado.denominador;

                simplificar(resultado);

                System.out.println(
                        numOriginal + "/" + denOriginal +
                                " = " +
                                resultado.numerador + "/" + resultado.denominador
                );
            }

            sc.close();
        }

        // operações corretas
        public static Fracao soma(int n1, int d1, int n2, int d2) {
            return new Fracao(n1 * d2 + n2 * d1, d1 * d2);
        }

        public static Fracao subtracao(int n1, int d1, int n2, int d2) {
            return new Fracao(n1 * d2 - n2 * d1, d1 * d2);
        }

        public static Fracao multiplicacao(int n1, int d1, int n2, int d2) {
            return new Fracao(n1 * n2, d1 * d2);
        }

        public static Fracao divisao(int n1, int d1, int n2, int d2) {
            return new Fracao(n1 * d2, d1 * n2);
        }

        // simplificação correta
        private static void simplificar(Fracao f) {
            int mdc = mdc(f.numerador, f.denominador);
            f.numerador /= mdc;
            f.denominador /= mdc;
        }

        // Euclides correto
        public static int mdc(int a, int b) {
            a = Math.abs(a);
            b = Math.abs(b);

            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }
    }