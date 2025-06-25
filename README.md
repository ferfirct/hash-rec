# Análise de Desempenho: Tabelas Hash com Listas Encadeadas em Java

## Objetivo

Implementar e comparar o desempenho de três variações de funções hash utilizando tratamento de colisões por listas encadeadas. Foram analisados:

- Tempo de inserção
- Número de colisões
- Tempo de busca
- Média de comparações de busca

## Estrutura dos Testes

Cada função hash foi testada com:

- Tamanhos de tabela: 1.000, 10.000 e 100.000
- Tamanhos de dados: 10.000, 100.000 e 1.000.000
- Funções hash:
  - HashResto
  - HashMultiplicacao
  - HashDobramento

Resultados foram obtidos para cada combinação:

- Tempo de inserção (ms)
- Colisões totais
- Média de comparações em 5 buscas
- Tempo médio de busca (ms)

---

## 📈 Gráficos

### Tabela com tamanho 1000

![1000tempo](https://github.com/user-attachments/assets/f0f3d34d-0379-4f5b-819c-2b12596dd439)


📷 Inserir gráfico aqui

#### Número de Colisões

📷 Inserir gráfico aqui

#### Média de Comparações de Busca

📷 Inserir gráfico aqui

#### Tempo de Busca

📷 Inserir gráfico aqui

---

### Tabela com tamanho 10000

#### Tempo de Inserção

📷 Inserir gráfico aqui

#### Número de Colisões

📷 Inserir gráfico aqui

#### Média de Comparações de Busca

📷 Inserir gráfico aqui

#### Tempo de Busca

📷 Inserir gráfico aqui

---

### Tabela com tamanho 100000

#### Tempo de Inserção

📷 Inserir gráfico aqui

#### Número de Colisões

📷 Inserir gráfico aqui

#### Média de Comparações de Busca

📷 Inserir gráfico aqui

#### Tempo de Busca

📷 Inserir gráfico aqui

---

## Análise dos Resultados

- Tabelas pequenas (tamanho 1.000) resultaram em altíssimas colisões (próximo de 99%).
- Tabelas maiores (10.000 e 100.000) reduziram drasticamente as colisões e melhoraram os tempos.
- A função HashMultiplicacao apresentou o desempenho mais consistente em todas as métricas.
- HashDobramento teve desempenho aceitável com dados pequenos, mas degradou significativamente com 1 milhão de dados.
- HashResto foi estável, mas superado por HashMultiplicacao em escalabilidade.

## Conclusão

- O aumento do tamanho da tabela hash melhora diretamente a eficiência.
- Para grandes volumes, o uso de HashMultiplicacao com tabelas ≥ 100.000 é recomendado.
- Colisões influenciam diretamente o tempo de busca e a quantidade de comparações.
- Todas as métricas reforçam a importância de um bom dimensionamento da tabela.


