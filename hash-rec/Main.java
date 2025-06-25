import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] tamanhosTabela = {1000, 10000, 100000};
        FuncaoHash[] funcoes = {new HashResto(), new HashMultiplicacao(), new HashDobramento()};
        int[] tamanhosDados = {10000, 100000, 1000000};
        final long SEED = 12345L;

        try (FileWriter writer = new FileWriter("resultados.csv")) {
            writer.write("TamanhoTabela,FuncaoHash,QtdDados,TempoInsercao(ms),Colisoes,MediaComparacoesBusca,TempoBusca(ms)\n");

            int totalTestes = tamanhosTabela.length * funcoes.length * tamanhosDados.length;
            int testeAtual = 0;

            for (int tamanho : tamanhosTabela) {
                for (FuncaoHash funcao : funcoes) {
                    for (int qtdDados : tamanhosDados) {
                        testeAtual++;
                        atualizarProgresso(testeAtual, totalTestes);

                        GeradorDados gerador = new GeradorDados(SEED);
                        Registro[] dados = gerador.gerarDados(qtdDados);

                        TabelaHash tabela = new TabelaHash(tamanho, funcao);

                        long inicioInsercao = System.nanoTime();
                        for (Registro r : dados) tabela.inserir(r);
                        double tempoInsercaoMs = (System.nanoTime() - inicioInsercao) / 1_000_000.0;

                        Random rand = new Random(SEED);
                        int totalComparacoes = 0;
                        long inicioBusca = System.nanoTime();
                        for (int i = 0; i < 5; i++) {
                            int index = rand.nextInt(dados.length);
                            int comparacoes = tabela.buscar(dados[index].getCodigo());
                            totalComparacoes += comparacoes >= 0 ? comparacoes : -comparacoes;
                        }
                        long fimBusca = System.nanoTime();
                        double tempoBuscaMs = (fimBusca - inicioBusca) / 1_000_000.0;
                        double mediaComparacoes = totalComparacoes / 5.0;

                        writer.write(String.format("%d,%s,%d,%.2f,%d,%.2f,%.2f\n",
                            tamanho,
                            funcao.getClass().getSimpleName(),
                            qtdDados,
                            tempoInsercaoMs,
                            tabela.getColisoes(),
                            mediaComparacoes,
                            tempoBuscaMs));
                    }
                }
            }
            System.out.println("\nExecução concluída! Resultados salvos em 'resultados2.csv'");
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
        }
    }

    private static void atualizarProgresso(int atual, int total) {
        float progresso = (float)atual / total * 100;
        String barra = "[" + "=".repeat((int)(progresso / 5)) + " ".repeat(20 - (int)(progresso / 5)) + "]";
        System.out.printf("\r%s %.1f%% (%d/%d)", barra, progresso, atual, total);
    }
}
