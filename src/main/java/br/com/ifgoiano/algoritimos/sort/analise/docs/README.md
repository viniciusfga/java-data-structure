# Projeto de Análise de Algoritmos de Ordenação

**Autores:**
- Vinicius Franco Gonçalves Araújo

**Disciplina:** Estrutura de Dados I  
**Data:** 26/05/2026

---

## 📋 Descrição do Problema

Este projeto tem como objetivo implementar e comparar o desempenho de três algoritmos clássicos de ordenação:
- **SelectionSort** (Ordenação por Seleção)
- **InsertionSort** (Ordenação por Inserção)
- **QuickSort** (Ordenação Rápida)

A análise é realizada utilizando dois conjuntos de dados (datasets) com vetores de tamanhos variados, contendo valores aleatórios.

---

## 🎯 Objetivos

1. Implementar corretamente os três algoritmos de ordenação
2. Gerar datasets com valores aleatórios em tamanhos específicos
3. Medir o tempo de execução de cada algoritmo (média de 100 execuções)
4. Comparar o desempenho dos algoritmos
5. Visualizar os resultados através de gráficos

---

## 📊 Datasets

### Dataset 1 (Vetores Pequenos a Médios)
Tamanhos: 1.000, 2.000, 3.000, 4.000, 5.000, 6.000, 7.000, 8.000, 9.000, 10.000

### Dataset 2 (Vetores Médios a Grandes)
Tamanhos: 10.000, 20.000, 30.000, 40.000, 50.000, 60.000, 70.000, 80.000, 90.000, 100.000

**Total:** 20 vetores diferentes

---

## 🏗️ Arquitetura do Projeto

### Estrutura de Classes

```
📦 Projeto
├── Implementacoes.pdf     # Lista de implementações que cada grupo deve fazer
├── Item.java              # Classe que representa o objeto a ser ordenado
├── Ordena.java            # Implementações dos algoritmos de ordenação
├── Utilidades.java        # Geração de vetores e operações auxiliares
└── TesteOrdena.java       # Testes e medição de desempenho
```

### Descrição das Classes

#### 1. **Item.java**
- Representa um item a ser ordenado
- Contém um valor inteiro
- Implementa `Comparable<Item>` para permitir comparações

#### 2. **Ordena.java**
- Contém as implementações dos três algoritmos:
    - `selectionSort(Item[] vetor)` - O(n²)
    - `insertionSort(Item[] vetor)` - O(n²)
    - `quickSort(Item[] vetor)` - O(n log n) em média

#### 3. **Utilidades.java**
- Geração de vetores aleatórios
- Cópia de vetores
- Salvamento/carregamento de arquivos
- Formatação de resultados

#### 4. **TesteOrdena.java**
- Executa 100 testes para cada algoritmo
- Calcula médias de tempo
- Gera arquivo CSV com resultados

---

## 🚀 Como Executar

### Pré-requisitos
- Java JDK 8 ou superior
- Python 3.6+ (para gráficos)
- Bibliotecas Python: pandas, matplotlib, numpy

### Instalação das Dependências Python
```bash
pip install pandas matplotlib numpy
```

### Compilação e Execução

#### 1. Compilar os arquivos Java
```bash
javac *.java
```

#### 2. Executar teste rápido (verificação)
```bash
java TesteOrdena --rapido
```

#### 3. Executar testes completos (100 execuções cada)
```bash
java TesteOrdena
```

Este comando irá:
- Gerar todos os 20 datasets
- Executar cada algoritmo 100 vezes para cada dataset
- Salvar os resultados em `resultados.csv`
- **⚠️ ATENÇÃO:** Este processo pode levar vários minutos!

#### 4. Gerar gráficos de análise
```bash
python3 gerar_graficos.ipynb
```

---

## 📈 Análise dos Resultados

### Complexidade Teórica

| Algoritmo      | Melhor Caso | Caso Médio  | Pior Caso   | Estável? |
|----------------|-------------|-------------|-------------|----------|
| SelectionSort  | O(n²)       | O(n²)       | O(n²)       | Não      |
| InsertionSort  | O(n)        | O(n²)       | O(n²)       | Sim      |
| QuickSort      | O(n log n)  | O(n log n)  | O(n²)       | Não      |

### Resultados Esperados

#### 🔴 **SelectionSort**
- **Comportamento:** Desempenho constante independente da distribuição dos dados
- **Características:**
    - Sempre faz n² comparações
    - Mínimo de trocas (n trocas no máximo)
    - Previsível mas lento
- **Quando usar:** Quando o número de trocas precisa ser minimizado

#### 🟢 **InsertionSort**
- **Comportamento:** Desempenho varia com a ordenação inicial
- **Características:**
    - Eficiente para vetores quase ordenados: O(n)
    - Ineficiente para vetores aleatórios: O(n²)
    - Estável (mantém ordem relativa de elementos iguais)
- **Quando usar:** Vetores pequenos ou quase ordenados

#### 🔵 **QuickSort**
- **Comportamento:** Significativamente mais rápido em vetores grandes
- **Características:**
    - Divide e conquista
    - Desempenho médio: O(n log n)
    - Pior caso raro com pivô aleatório: O(n²)
- **Quando usar:** Vetores grandes e médios (padrão na maioria dos casos)

### Comparação Prática

Para um vetor de **100.000 elementos**:

| Algoritmo      | Tempo Esperado | Speedup vs QuickSort |
|----------------|----------------|----------------------|
| SelectionSort  | ~20-30 segundos| 1000x mais lento     |
| InsertionSort  | ~15-25 segundos| 800x mais lento      |
| QuickSort      | ~20-30 ms      | Baseline (1x)        |

**Speedup** = Quanto mais rápido o QuickSort é em relação ao outro algoritmo

---

## 📊 Gráficos Gerados

O script Python gera 5 gráficos diferentes:

1. **grafico_comparacao_geral.png**
    - Comparação de todos os algoritmos
    - Todos os tamanhos de vetores

2. **grafico_dataset1.png**
    - Foco no Dataset 1 (1k-10k elementos)
    - Escala apropriada para vetores menores

3. **grafico_dataset2.png**
    - Foco no Dataset 2 (10k-100k elementos)
    - Mostra a diferença dramática em grandes volumes

4. **grafico_barras_comparacao.png**
    - Gráfico de barras para tamanhos específicos
    - Comparação lado a lado

5. **grafico_escala_log.png**
    - Escala logarítmica
    - Melhor visualização das diferenças relativas

---

## 💡 Dicas de Comparação

### O que analisar nos resultados:

#### 1. **Crescimento do Tempo**
- Como o tempo cresce quando o tamanho dobra?
- SelectionSort/InsertionSort: tempo quadruplica (n²)
- QuickSort: tempo pouco mais que dobra (n log n)

#### 2. **Ponto de Virada**
- Em que tamanho o QuickSort começa a dominar?
- Geralmente a partir de ~1000 elementos

#### 3. **Escalabilidade**
- SelectionSort/InsertionSort: inviáveis para n > 50.000
- QuickSort: eficiente até milhões de elementos

#### 4. **Estabilidade**
- InsertionSort preserva ordem de elementos iguais
- SelectionSort e QuickSort não garantem

#### 5. **Uso de Memória**
- SelectionSort/InsertionSort: O(1) - in-place
- QuickSort: O(log n) - pilha de recursão

---

## 🎓 Conceitos Importantes

### Por que 100 execuções?
- **Reduz variações** causadas por outros processos do sistema
- **Média estatística** mais confiável
- **Elimina outliers** (valores extremos)

### Por que valores aleatórios?
- **Simula caso médio** (mais realista)
- **Evita otimizações específicas** do compilador
- **Teste imparcial** de desempenho

### Por que datasets diferentes?
- **Dataset 1:** Mostra comportamento inicial
- **Dataset 2:** Evidencia diferenças de complexidade
- **Progressão gradual:** Identifica ponto de inflexão

---

## 📝 Saídas Geradas

### 1. resultados.csv
```csv
Dataset,Tamanho,SelectionSort(ms),InsertionSort(ms),QuickSort(ms)
Dataset1,1000,12.45,8.32,0.45
Dataset1,2000,49.87,33.21,1.02
...
```

### 2. Gráficos PNG
- 5 gráficos de análise
- Alta resolução (300 DPI)
- Prontos para apresentação

### 3. Console Output
- Progresso em tempo real
- Verificação de ordenação
- Resumo final

---

## ⚠️ Observações Importantes

1. **Tempo de Execução Total:** O teste completo pode levar de 10 a 30 minutos dependendo do hardware

2. **Uso de Memória:** Vetores grandes (100k elementos) consomem memória significativa

3. **Cópia de Vetores:** Cada teste usa uma cópia para não afetar os dados originais

4. **Seed Fixo:** Garante reprodutibilidade dos resultados

5. **Verificação de Ordenação:** Cada execução verifica se o vetor está corretamente ordenado





**Última atualização:** 31/05/2026