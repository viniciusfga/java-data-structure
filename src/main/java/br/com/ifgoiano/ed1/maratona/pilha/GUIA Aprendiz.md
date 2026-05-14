## 🔰 Lista de Exercícios de Pilhas em Java — **Aprendiz**

### 📘 **Nível 1: Primeiros Passos com Pilhas (1–8)**
🔹 *Objetivo: entender o conceito LIFO, criar pilhas manualmente e usar a classe Stack do Java.*

1. **Criar uma pilha vazia usando a classe `Stack<Integer>` do Java.**
2. **Adicionar 5 elementos inteiros em uma pilha e imprimir todos usando `pop()`.**
3. **Verificar se uma pilha está vazia antes e depois de adicionar elementos.**
4. **Usar `peek()` para ver o topo da pilha sem remover o elemento.**
5. **Criar uma pilha de `Strings`, adicionar 3 palavras e removê-las imprimindo na ordem inversa.**
6. **Implementar uma pilha manual usando array de tamanho fixo (10 elementos).**
   Operações:
   - `push`
   - `pop`
   - `isEmpty`
   - `isFull`

7. **Criar uma pilha de caracteres e empilhar cada letra da palavra `"JAVA"`.**  
   **Exemplo de saída:**
   ```
   A
   V
   A
   J
   ```

8. **Simular o comportamento LIFO: adicionar números de 1 a 5 e remover todos mostrando a ordem de remoção.**

---

### 📗 **Nível 2: Manipulação Básica e Lógica (9–16)**
🔹 *Objetivo: praticar operações combinadas, controle de fluxo e validações simples.*

9. **Ler 10 números do teclado, empilhar apenas os pares e desempilhar todos.**
10. **Inverter uma `String` usando uma pilha de caracteres.**  
    **Exemplo:**
    ```
    "hello" → "olleh"
    ```

11. **Verificar se uma palavra é um palíndromo usando pilha.**  
    **Exemplo:**
    ```
    "arara" → Palíndromo
    ```

12. **Criar duas pilhas e transferir todos os elementos de uma para outra.**
13. **Contar quantos elementos existem em uma pilha sem usar `size()` (usar `pop()` e reempilhar).**
14. **Remover todos os elementos ímpares de uma pilha de inteiros.**
15. **Duplicar o topo da pilha (`peek()` + `push()` do mesmo valor).**
16. **Criar uma pilha de notas (0 a 10) e calcular a média sem perder os dados.**

---

### 📙 **Nível 3: Desafios Introdutórios (17–22)**
🔹 *Objetivo: resolver problemas que exigem raciocínio lógico básico aplicado a pilhas.*

17. **Verificar se uma sequência de empilhamentos e desempilhamentos é válida.**  
    **Exemplo:**
    ```
    push(1), push(2), pop(), pop() → Válido
    pop(), push(1) → Inválido
    ```

18. **Simular o "Desfazer" (`Undo`) de um editor de texto usando pilha.**  
    Operações:
   - Adicionar texto
   - Desfazer última ação

19. **Converter um número decimal para binário usando pilha.**  
    **Exemplo:**
    ```
    13 → 1101
    ```

20. **Encontrar o menor elemento de uma pilha sem usar estruturas auxiliares.**
21. **Ordenar uma pilha usando apenas outra pilha auxiliar (sem arrays).**
22. **Implementar uma função que retorna o elemento do meio de uma pilha.**

---

## 🧭 Índice de Exercícios

### Level 1 - Primeiros Passos (1 a 8)

1. [Exercício 01: Criar pilha vazia usando Stack<Integer>](./src/Nivel_1/Exercicio01.java)
2. [Exercício 02: Adicionar 5 elementos e imprimir usando pop()](./src/Nivel_1/Exercicio02.java)
3. [Exercício 03: Verificar se a pilha está vazia](./src/Nivel_1/Exercicio03.java)
4. [Exercício 04: Utilizar peek() para visualizar o topo](./src/Nivel_1/Exercicio04.java)
5. [Exercício 05: Pilha de Strings com remoção inversa](./src/Nivel_1/Exercicio05.java)
6. [Exercício 06: Implementar pilha manual com array](./src/Nivel_1/Exercicio06.java)
7. [Exercício 07: Empilhar caracteres da palavra JAVA](./src/Nivel_1/Exercicio07.java)
8. [Exercício 08: Simular comportamento LIFO](./src/Nivel_1/Exercicio08.java)

---

### Level 2 - Manipulação Básica (9 a 16)

9. [Exercício 09: Empilhar apenas números pares](./aprendiz/Exercicio09.java)
10. [Exercício 10: Inverter String usando pilha](./src/Nivel_2/Exercicio10.java)
11. [Exercício 11: Verificar palíndromo usando pilha](./src/Nivel_2/Exercicio11.java)
12. [Exercício 12: Transferir elementos entre duas pilhas](./src/Nivel_2/Exercicio12.java)
13. [Exercício 13: Contar elementos sem usar size()](./src/Nivel_2/Exercicio13.java)
14. [Exercício 14: Remover elementos ímpares](./src/Nivel_2/Exercicio14.java)
15. [Exercício 15: Duplicar topo da pilha](./src/Nivel_2/Exercicio15.java)
16. [Exercício 16: Calcular média sem perder os dados](./src/Nivel_2/Exercicio16.java)

---

### Level 3 - Desafios (17 a 22)

17. [Exercício 17: Validar sequência de empilhamento e desempilhamento](./src/Nivel_3/Exercicio17.java)
18. [Exercício 18: Simular Undo de editor de texto](./src/Nivel_3/Exercicio18.java)
19. [Exercício 19: Converter decimal para binário usando pilha](./src/Nivel_3/Exercicio19.java)
20. [Exercício 20: Encontrar menor elemento da pilha](./src/Nivel_3/Exercicio20.java)
21. [Exercício 21: Ordenar pilha usando pilha auxiliar](./src/Nivel_3/Exercicio21.java)
22. [Exercício 22: Retornar elemento do meio da pilha](./src/Nivel_3/Exercicio22.java)
