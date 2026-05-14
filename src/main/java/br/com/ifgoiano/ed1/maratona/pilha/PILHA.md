# 🏗️ Guia Rápido de Pilhas (Stack) em Java

> Resumo rápido para revisão antes de exercícios e maratona.

---

# 📚 Conceito Fundamental

## 🎯 O que é uma Pilha?

Uma **Pilha (Stack)** é uma estrutura de dados linear que segue o princípio:

## LIFO

```text
Last In, First Out
Último a Entrar, Primeiro a Sair
```

Imagine uma pilha de pratos:

```text
Topo
 ┌───┐
 │ 3 │ ← sai primeiro
 ├───┤
 │ 2 │
 ├───┤
 │ 1 │
 └───┘
```

---

# ⚙️ Operações Fundamentais

| Operação | Descrição |
|---|---|
| `push()` | Empilha elemento |
| `pop()` | Remove topo |
| `peek()` | Consulta topo |
| `isEmpty()` | Verifica vazia |
| `size()` | Quantidade de elementos |

---

# 🚀 Criando uma Pilha em Java

```java
Stack<Integer> pilha = new Stack<>();
```

---

