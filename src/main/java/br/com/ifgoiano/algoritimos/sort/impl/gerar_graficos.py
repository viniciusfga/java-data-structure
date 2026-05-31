"""
Autores: Vinicius Franco Gonçalves Araújo
         Rafael Belem Torres
         Rafael Henrico Gonçalves Justino

Disciplina: Estrutura de Dados I
Data: 26/05/2026

Objetivo: Script para gerar gráficos de análise dos resultados
dos testes de desempenho dos algoritmos de ordenação.
"""

import pandas as pd
import matplotlib.pyplot as plt
import numpy as np

def carregar_dados(arquivo_csv='resultados.csv'):
    """Carrega os dados do arquivo CSV"""
    return pd.read_csv(arquivo_csv)

def gerar_graficos(df):
    """Gera todos os gráficos de análise"""

    # Configuração de estilo
    plt.style.use('seaborn-v0_8-darkgrid')
    cores = ['#FF6B6B', '#4ECDC4', '#45B7D1']

    # 1. Gráfico comparativo geral (todos os algoritmos)
    plt.figure(figsize=(14, 6))

    plt.plot(df['Tamanho'], df['SelectionSort(ms)'],
             marker='o', linewidth=2, markersize=6,
             label='SelectionSort', color=cores[0])
    plt.plot(df['Tamanho'], df['InsertionSort(ms)'],
             marker='s', linewidth=2, markersize=6,
             label='InsertionSort', color=cores[1])
    plt.plot(df['Tamanho'], df['QuickSort(ms)'],
             marker='^', linewidth=2, markersize=6,
             label='QuickSort', color=cores[2])

    plt.xlabel('Tamanho do Vetor (n)', fontsize=12, fontweight='bold')
    plt.ylabel('Tempo Médio (ms)', fontsize=12, fontweight='bold')
    plt.title('Comparação de Desempenho: Algoritmos de Ordenação',
              fontsize=14, fontweight='bold')
    plt.legend(fontsize=11)
    plt.grid(True, alpha=0.3)
    plt.tight_layout()
    plt.savefig('grafico_comparacao_geral.png', dpi=300)
    print("✓ Gráfico 1 salvo: grafico_comparacao_geral.png")

    # 2. Gráfico separado para Dataset1 (escala menor)
    plt.figure(figsize=(14, 6))
    df_dataset1 = df[df['Dataset'] == 'Dataset1']

    plt.plot(df_dataset1['Tamanho'], df_dataset1['SelectionSort(ms)'],
             marker='o', linewidth=2, markersize=8,
             label='SelectionSort', color=cores[0])
    plt.plot(df_dataset1['Tamanho'], df_dataset1['InsertionSort(ms)'],
             marker='s', linewidth=2, markersize=8,
             label='InsertionSort', color=cores[1])
    plt.plot(df_dataset1['Tamanho'], df_dataset1['QuickSort(ms)'],
             marker='^', linewidth=2, markersize=8,
             label='QuickSort', color=cores[2])

    plt.xlabel('Tamanho do Vetor (n)', fontsize=12, fontweight='bold')
    plt.ylabel('Tempo Médio (ms)', fontsize=12, fontweight='bold')
    plt.title('Dataset 1: Vetores de 1.000 a 10.000 elementos',
              fontsize=14, fontweight='bold')
    plt.legend(fontsize=11)
    plt.grid(True, alpha=0.3)
    plt.tight_layout()
    plt.savefig('grafico_dataset1.png', dpi=300)
    print("✓ Gráfico 2 salvo: grafico_dataset1.png")

    # 3. Gráfico separado para Dataset2 (escala maior)
    plt.figure(figsize=(14, 6))
    df_dataset2 = df[df['Dataset'] == 'Dataset2']

    plt.plot(df_dataset2['Tamanho'], df_dataset2['SelectionSort(ms)'],
             marker='o', linewidth=2, markersize=8,
             label='SelectionSort', color=cores[0])
    plt.plot(df_dataset2['Tamanho'], df_dataset2['InsertionSort(ms)'],
             marker='s', linewidth=2, markersize=8,
             label='InsertionSort', color=cores[1])
    plt.plot(df_dataset2['Tamanho'], df_dataset2['QuickSort(ms)'],
             marker='^', linewidth=2, markersize=8,
             label='QuickSort', color=cores[2])

    plt.xlabel('Tamanho do Vetor (n)', fontsize=12, fontweight='bold')
    plt.ylabel('Tempo Médio (ms)', fontsize=12, fontweight='bold')
    plt.title('Dataset 2: Vetores de 10.000 a 100.000 elementos',
              fontsize=14, fontweight='bold')
    plt.legend(fontsize=11)
    plt.grid(True, alpha=0.3)
    plt.tight_layout()
    plt.savefig('grafico_dataset2.png', dpi=300)
    print("✓ Gráfico 3 salvo: grafico_dataset2.png")

    # 4. Gráfico de barras para comparação em tamanhos específicos
    plt.figure(figsize=(14, 6))
    tamanhos_selecionados = [5000, 10000, 50000, 100000]
    df_selecionado = df[df['Tamanho'].isin(tamanhos_selecionados)]

    x = np.arange(len(tamanhos_selecionados))
    width = 0.25

    plt.bar(x - width, df_selecionado['SelectionSort(ms)'],
            width, label='SelectionSort', color=cores[0], alpha=0.8)
    plt.bar(x, df_selecionado['InsertionSort(ms)'],
            width, label='InsertionSort', color=cores[1], alpha=0.8)
    plt.bar(x + width, df_selecionado['QuickSort(ms)'],
            width, label='QuickSort', color=cores[2], alpha=0.8)

    plt.xlabel('Tamanho do Vetor', fontsize=12, fontweight='bold')
    plt.ylabel('Tempo Médio (ms)', fontsize=12, fontweight='bold')
    plt.title('Comparação em Tamanhos Específicos', fontsize=14, fontweight='bold')
    plt.xticks(x, tamanhos_selecionados)
    plt.legend(fontsize=11)
    plt.grid(True, alpha=0.3, axis='y')
    plt.tight_layout()
    plt.savefig('grafico_barras_comparacao.png', dpi=300)
    print("✓ Gráfico 4 salvo: grafico_barras_comparacao.png")

    # 5. Gráfico de escala logarítmica
    plt.figure(figsize=(14, 6))

    plt.semilogy(df['Tamanho'], df['SelectionSort(ms)'],
                 marker='o', linewidth=2, markersize=6,
                 label='SelectionSort', color=cores[0])
    plt.semilogy(df['Tamanho'], df['InsertionSort(ms)'],
                 marker='s', linewidth=2, markersize=6,
                 label='InsertionSort', color=cores[1])
    plt.semilogy(df['Tamanho'], df['QuickSort(ms)'],
                 marker='^', linewidth=2, markersize=6,
                 label='QuickSort', color=cores[2])

    plt.xlabel('Tamanho do Vetor (n)', fontsize=12, fontweight='bold')
    plt.ylabel('Tempo Médio (ms) - Escala Log', fontsize=12, fontweight='bold')
    plt.title('Comparação com Escala Logarítmica', fontsize=14, fontweight='bold')
    plt.legend(fontsize=11)
    plt.grid(True, alpha=0.3, which='both')
    plt.tight_layout()
    plt.savefig('grafico_escala_log.png', dpi=300)
    print("✓ Gráfico 5 salvo: grafico_escala_log.png")

def gerar_tabela_analise(df):
    """Gera uma tabela de análise comparativa"""
    print("\n" + "="*80)
    print("ANÁLISE COMPARATIVA DOS ALGORITMOS")
    print("="*80)

    # Speedup do QuickSort em relação aos outros
    print("\n📊 SPEEDUP DO QUICKSORT:")
    print("-"*80)

    for _, row in df.iterrows():
        if row['Tamanho'] in [10000, 50000, 100000]:
            speedup_selection = row['SelectionSort(ms)'] / row['QuickSort(ms)']
            speedup_insertion = row['InsertionSort(ms)'] / row['QuickSort(ms)']

            print(f"\nTamanho {row['Tamanho']:>6}:")
            print(f"  QuickSort é {speedup_selection:>6.2f}x mais rápido que SelectionSort")
            print(f"  QuickSort é {speedup_insertion:>6.2f}x mais rápido que InsertionSort")

def main():
    """Função principal"""
    print("\n" + "="*80)
    print("GERADOR DE GRÁFICOS - ANÁLISE DE ALGORITMOS DE ORDENAÇÃO")
    print("="*80 + "\n")

    try:
        # Carrega dados
        df = carregar_dados()
        print(f"✓ Dados carregados: {len(df)} registros\n")

        # Gera gráficos
        print("Gerando gráficos...")
        gerar_graficos(df)

        # Gera análise
        gerar_tabela_analise(df)

        print("\n" + "="*80)
        print("✓ PROCESSAMENTO CONCLUÍDO COM SUCESSO!")
        print("="*80 + "\n")

    except FileNotFoundError:
        print("❌ ERRO: Arquivo 'resultados.csv' não encontrado!")
        print("Execute primeiro: javac *.java && java TesteOrdena")
    except Exception as e:
        print(f"❌ ERRO: {e}")

if __name__ == "__main__":
    main()