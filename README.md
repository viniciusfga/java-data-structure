# 📊 Estrutura de Dados

Projeto acadêmico desenvolvido no curso de **Sistemas de Informação – IF Goiano (Campus Urutaí)**, com foco na implementação prática de estruturas de dados e algoritmos fundamentais.

---

## 🎯 Objetivo

Organizar e implementar estruturas de dados clássicas utilizando Java, com foco em:

- Compreensão prática dos conceitos
- Reutilização de código
- Preparação para avaliações e maratonas
- Base para projetos maiores

---

## 🧠 Conteúdos abordados

### 📦 Estruturas de Dados

- Listas:
    - Lista Estática (array)
    - Lista Encadeada
    - Lista Duplamente Encadeada
    - Lista Circular
- Fila
- Pilha

---

### ⚙️ Algoritmos

- Ordenação
- Busca
- Problemas clássicos
---

### 🧪 Exercícios

- Listas de exercícios da disciplina
- Problemas práticos
- Implementações para fixação

---

## 🗂 Estrutura do Projeto

```plaintext
java-data-structure/
├── pom.xml                        # Arquivo de configuração na raiz
├── docs/                          # PDFs e documentação acadêmica
│   
├── src/
│   ├── main/
│   │   └── java/           
│   │       └── br/com/ifgoiano/
│   │           │
│   │           ├── ed1/            # Estruturas e exercícios de ED1
│   │           │   ├── estruturas/
│   │           │   │   ├── base/
│   │           │   │   ├── lista/
│   │           │   │   ├── fila/
│   │           │   │   └── pilha/
│   │           │   ├── exercicios/
│   │           │   └── desafios/
│   │           │
│   │           └── ed2/            # Estruturas e exercícios de ED2
│   │    
│   └ test/                         # Classes de teste JUnit
│       └── java/          
│           └── br/com/ifgoiano/ed1/
│               └── estruturas/
│                   └── PilhaTest.java
└── README.md