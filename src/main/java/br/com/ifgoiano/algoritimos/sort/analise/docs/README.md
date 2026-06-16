# Análise Comparativa de Algoritmos de Ordenação

**Autor:** Vinicius Franco Gonçalves Araújo  
**Disciplina:** Estrutura de Dados I — IFGoiano  
**Data:** 26/05/2026

---

## Descrição

Este projeto implementa e compara o desempenho de três algoritmos clássicos de ordenação — **SelectionSort**, **InsertionSort** e **QuickSort** — aplicados a dois conjuntos de dados com tamanhos progressivos. Para cada combinação de algoritmo e dataset, o tempo de execução é medido como a **média de 100 execuções**, garantindo resultados estatisticamente mais confiáveis.

---

## Objetivos

1. Implementar corretamente os três algoritmos de ordenação em Java com suporte a tipos genéricos (`Comparable<T>`)
2. Gerar datasets com valores aleatórios reproduzíveis (semente fixa)
3. Medir e comparar o tempo médio de execução por algoritmo e tamanho de entrada
4. Analisar empiricamente o crescimento assintótico de cada algoritmo
5. Documentar os resultados com tabelas e gráficos comparativos

---

## Estrutura do Projeto

```
📦 sort-analise/
└── src/
    └── br/com/ifgoiano/algoritimos/sort/analise/
         ├── docs/
         │    ├── README.md     
         │    ├── resultados.csv             # Saída gerada após a execução dos testes
         │    └── gerar_graficos.ipynb       # Notebook Python para geração dos gráficos comparativos
         │    
         ├── Item.java          # Objeto a ser ordenado (implementa Comparable<Item>)
         ├── Ordena.java        # Implementações dos algoritmos (genérico com <T extends Comparable<T>>)
         ├── Utilidades.java    # Geração de vetores, leitura/escrita de arquivos e utilitários
         └── TesteOrdena.java   # Tomada de tempo e orquestração dos testes

```

### Descrição das Classes

**`Item.java`**  
Representa o objeto a ser ordenado. Contém um valor inteiro e implementa `Comparable<Item>`, permitindo que os algoritmos de ordenação realizem comparações de forma padronizada.

**`Ordena.java`**  
Contém as implementações genéricas dos três algoritmos. Todos os métodos aceitam `T[] vetor` onde `T extends Comparable<T>`, tornando a classe reutilizável para qualquer tipo comparável. Inclui também o método auxiliar `estaOrdenado()` para validação dos resultados.

**`Utilidades.java`**  
Responsável pela geração de vetores aleatórios com semente fixa (garantindo reprodutibilidade), cópia de vetores, persistência em arquivo e formatação de saídas. Também centraliza a definição dos tamanhos dos dois datasets.

**`TesteOrdena.java`**  
Orquestra a execução dos testes: para cada algoritmo e dataset, executa 100 repetições com cópias independentes do vetor original, calcula a média dos tempos e persiste os resultados em `resultados.csv`.

---

## Datasets

| Dataset   | Tamanhos dos vetores                                               | Faixa         |
|-----------|--------------------------------------------------------------------|---------------|
| Dataset 1 | 1.000 · 2.000 · 3.000 · 4.000 · 5.000 · 6.000 · 7.000 · 8.000 · 9.000 · 10.000 | Pequeno–Médio |
| Dataset 2 | 10.000 · 20.000 · 30.000 · 40.000 · 50.000 · 60.000 · 70.000 · 80.000 · 90.000 · 100.000 | Médio–Grande  |

Cada vetor é gerado com `Random(seed)` utilizando semente incrementada a partir de 42 (Dataset 1) e 142 (Dataset 2), garantindo que todos os algoritmos recebam **exatamente os mesmos dados** em todas as execuções.

---

## Pré-requisitos

- Java JDK 8 ou superior
- Python 3.6+ com as bibliotecas `pandas`, `matplotlib` e `numpy`

---

## Como Executar

**1. Compilar o projeto**
```bash
javac -d out src/br/com/ifgoiano/algoritimos/sort/analise/*.java
cd out
```

**2. Teste rápido — verificação de correção (execução única por tamanho)**
```bash
java br.com.ifgoiano.algoritimos.sort.analise.TesteOrdena --rapido
```

**3. Testes completos — 100 execuções por dataset/algoritmo**
```bash
java br.com.ifgoiano.algoritimos.sort.analise.TesteOrdena
```

> ⚠️ O teste completo pode levar **entre 10 e 40 minutos** dependendo do hardware, pois executa 20 datasets × 3 algoritmos × 100 repetições = 6.000 ordenações no total.

Os resultados são salvos automaticamente em `resultados.csv`.

**4. Gerar gráficos comparativos**
```bash
jupyter notebook gerar_graficos.ipynb
```

---

## Complexidade Teórica

| Algoritmo     | Melhor Caso | Caso Médio  | Pior Caso | Estável | Memória |
|---------------|-------------|-------------|-----------|---------|---------|
| SelectionSort | O(n²)       | O(n²)       | O(n²)     | Não     | O(1)    |
| InsertionSort | O(n)        | O(n²)       | O(n²)     | Sim     | O(1)    |
| QuickSort     | O(n log n)  | O(n log n)  | O(n²)     | Não     | O(log n)|

---

## Resultados Obtidos

Os tempos abaixo representam a **média de 100 execuções** em milissegundos:

### Dataset 1 — Vetores Pequenos a Médios

| Tamanho | SelectionSort (ms) | InsertionSort (ms) | QuickSort (ms) |
|--------:|-------------------:|-------------------:|---------------:|
|   1.000 |               0,43 |               0,44 |           0,21 |
|   2.000 |               0,97 |               1,36 |           0,11 |
|   3.000 |               2,26 |               2,34 |           0,18 |
|   4.000 |               4,08 |               4,10 |           0,24 |
|   5.000 |               6,46 |               6,74 |           0,32 |
|   6.000 |               9,58 |              10,36 |           0,39 |
|   7.000 |              13,20 |              13,51 |           0,46 |
|   8.000 |              17,42 |              18,28 |           0,55 |
|   9.000 |              21,96 |              22,61 |           0,60 |
|  10.000 |              26,54 |              27,88 |           0,68 |

### Dataset 2 — Vetores Médios a Grandes

| Tamanho  | SelectionSort (ms) | InsertionSort (ms) | QuickSort (ms) |
|---------:|-------------------:|-------------------:|---------------:|
|   10.000 |              26,57 |              28,03 |           0,69 |
|   20.000 |             118,33 |             118,23 |           1,49 |
|   30.000 |             274,34 |             281,85 |           2,40 |
|   40.000 |             495,44 |             534,71 |           3,27 |
|   50.000 |             809,49 |           1.048,51 |           4,42 |
|   60.000 |           1.226,83 |           1.452,68 |           5,74 |
|   70.000 |           1.692,83 |           2.022,09 |           6,53 |
|   80.000 |           2.260,96 |           2.889,09 |           7,88 |
|   90.000 |           2.887,63 |           3.701,08 |           8,54 |
|  100.000 |           3.413,24 |           3.862,38 |           9,96 |

---

## Análise dos Resultados

### Crescimento observado vs. complexidade teórica

**SelectionSort e InsertionSort** apresentam crescimento quadrático (O(n²)), confirmado empiricamente: ao dobrar o tamanho de 10.000 para 20.000 elementos, o tempo aproximadamente quadruplica (26,5 ms → 118 ms ≈ 4,5×). Para 100.000 elementos, ambos ultrapassam os **3 segundos**, tornando-se inviáveis para entradas grandes.

**QuickSort** demonstra crescimento próximo de O(n log n): dobrando de 10.000 para 20.000 elementos, o tempo apenas dobra (0,69 ms → 1,49 ms ≈ 2,2×). Para 100.000 elementos, executa em menos de **10 ms** — cerca de **340× mais rápido** que o SelectionSort na mesma entrada.

### Comparação entre SelectionSort e InsertionSort

Nos datasets menores (até ~20.000 elementos), os dois algoritmos têm desempenho similar. A partir de 50.000 elementos, o InsertionSort começa a ser superado pelo SelectionSort em termos absolutos, pois o custo adicional de deslocar elementos na memória se acumula em entradas maiores.

### Ponto de inflexão do QuickSort

A superioridade do QuickSort já é visível nos primeiros tamanhos testados (1.000 elementos). Não existe um "ponto de virada" nestes dados — o QuickSort domina em toda a faixa testada. Isso ocorre porque os dados são aleatórios, que é exatamente o cenário favorável ao QuickSort.

### Considerações sobre o pior caso do QuickSort

A implementação utiliza o **primeiro elemento como pivô**. Com dados aleatórios, o risco de pior caso (O(n²)) é estatisticamente baixo. Uma melhoria seria adotar a estratégia de **pivô mediano de três** para maior robustez em dados parcialmente ordenados.

---

## Saída Gerada

O arquivo `resultados.csv` segue o formato:

```
Dataset,Tamanho,SelectionSort(ms),InsertionSort(ms),QuickSort(ms)
Dataset1,1000,0.43,0.44,0.21
Dataset1,2000,0.97,1.36,0.11
...
```

---

## Observações de Implementação

- **Cópia do vetor antes de cada execução:** garante que o vetor original não seja modificado entre repetições, de modo que todos os 100 testes ordenam exatamente os mesmos dados desordenados.
- **Semente fixa por dataset:** assegura reprodutibilidade dos resultados em qualquer máquina.
- **Verificação de ordenação:** na primeira das 100 execuções, cada algoritmo tem seu resultado validado pelo método `estaOrdenado()`.
- **Genéricos Java:** os algoritmos em `Ordena.java` utilizam `<T extends Comparable<T>>`, tornando o código reutilizável para qualquer tipo comparável além de `Item`.