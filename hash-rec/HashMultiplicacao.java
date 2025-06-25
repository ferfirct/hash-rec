public class HashMultiplicacao implements FuncaoHash {
    private static final double A = 0.6180339887498949;
    
    public int hash(int chave, int tamanho) {
        double valor = (chave & 0x7FFFFFFF) * A;
        return (int)(tamanho * (valor - (int)valor));
    }
}