## QUESTÃO 1 – VALIDAÇÃO DE CAMINHO (LABIRINTO)

Um sistema de navegação de robôs autônomos registra os movimentos realizados dentro de um labirinto por meio de uma sequência de caracteres.

Cada caractere representa um movimento em uma direção:

- `N` → Norte
- `S` → Sul
- `L` → Leste
- `O` → Oeste

Durante a navegação, o robô pode realizar movimentos que se anulam, ou seja:

- um movimento para `Norte (N)` é cancelado por um movimento para `Sul (S)`
- um movimento para `Leste (L)` é cancelado por um movimento para `Oeste (O)`

Dois movimentos são considerados opostos quando se anulam diretamente.

Um caminho é considerado **válido** quando, após considerar todos os cancelamentos possíveis entre movimentos opostos consecutivos, **nenhum movimento restante permanece**.  
Isso significa que o robô terminou exatamente no ponto de partida.

---

## Exemplos

- Entrada: `N S L O` → **válido**
- Entrada: `N N S` → **inválido**
- Entrada: `N N S S` → **válido**
- Entrada: `L S L S O S L L O O N L N O N O` → **válido**

---

## Resolução da última entrada

Sequência:

```text
L S L S O S L L O O N L N O N O