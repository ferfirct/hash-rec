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

## Tabela Hash com tamanho 1.000

### Tempo de Inserção

![1000tempo](https://github.com/user-attachments/assets/d9890c71-86bb-4242-aa10-dcb98d080ca1)


### Número de Colisões

![1000coli](https://github.com/user-attachments/assets/20dfe08f-cc95-4881-8a49-d84f1c8e259a)


### Média de Comparações de Busca

![1000comp](https://github.com/user-attachments/assets/aba8562b-bc5a-4d47-b1ed-01bd603a550c)


### Tempo de Busca

![busca1k](https://github.com/user-attachments/assets/d6b48df8-86ee-47e4-92ff-e34db6c42489)


### Análise

- Todas as funções apresentaram altíssimo número de colisões (~90%).
- HashDobramento teve o menor tempo de inserção com 1 milhão de dados.
- Em buscas, HashDobramento se destacou com menor média de comparações em dados menores.
- Com 1 milhão de dados, todas as funções tiveram tempo de busca superior a 0.3 ms.

---

## Tabela Hash com tamanho 10.000

### Tempo de Inserção

![10ktempo](https://github.com/user-attachments/assets/dde4ac7d-00fd-4f7b-9f1d-ea2a86c5d39d)

### Número de Colisões

![10kcoli](https://github.com/user-attachments/assets/5724e493-933e-4819-a96e-4b155a2274e1)


### Média de Comparações de Busca

![10kcomp](https://github.com/user-attachments/assets/18822815-eea3-4b3c-8373-52cb96860abb)

### Tempo de Busca

![busca10k](https://github.com/user-attachments/assets/d5c5debd-e022-4cb4-844f-02a79ce340c4)


### Análise

- HashDobramento ainda apresentou alta colisão com dados maiores.
- Tempos de inserção continuam baixos em geral (menos de 21 ms até 1M dados).
- HashMultiplicacao obteve as melhores médias de comparação (menores que 6).
- Tempo de busca se manteve em torno de 0.01–0.1 ms para todas as funções, exceto HashDobramento (0.44 ms com 1M).

---

## Tabela Hash com tamanho 100.000

### Tempo de Inserção

![100ktempo](https://github.com/user-attachments/assets/92d1318f-cf4f-4dcb-84a2-4edebfb321ff)


### Número de Colisões

![100kcoli](https://github.com/user-attachments/assets/d54749a9-bdeb-4898-81d9-e39ee4772311)


### Média de Comparações de Busca

![100kcomp](https://github.com/user-attachments/assets/1cc9b2c1-e155-4a5f-a4cb-aadf13cf0e12)


### Tempo de Busca

![busca100k](https://github.com/user-attachments/assets/3b03401d-86a4-484b-b3dc-158e148556fb)



### Análise

- HashResto e HashMultiplicacao apresentaram excelente desempenho com poucos conflitos.
- HashDobramento continuou com número excessivo de colisões e comparações mesmo com a tabela grande.
- Em todos os cenários, HashMultiplicacao foi a função mais estável.
- Tempo de busca se manteve abaixo de 0.05 ms, exceto para HashDobramento com 1 milhão (0.47 ms).

---

## Conclusão

- A escolha do tamanho da tabela impacta diretamente o desempenho.
- Funções hash como Multiplicação e Resto são mais consistentes e eficientes.
- HashDobramento apresentou desempenho inconsistente e escalabilidade inferior.
