public class GeradorDados {
    private long seed;
    
    public GeradorDados(long seed) {
        this.seed = seed;
    }
    
    public Registro[] gerarDados(int quantidade) {
        Registro[] dados = new Registro[quantidade];
        long atual = seed;
        
        for (int i = 0; i < quantidade; i++) {
            atual = (atual * 1103515245L + 12345L) & Long.MAX_VALUE;
            dados[i] = new Registro(100000000 + (int)(atual % 900000000L));
        }
        return dados;
    }
}