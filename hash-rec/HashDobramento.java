public class HashDobramento implements FuncaoHash {
    public int hash(int chave, int tamanho) {
        chave = chave & 0x7FFFFFFF;
        int soma = 0;
        for (int i = 0; i < 3; i++) {
            soma += chave % 1000;
            chave /= 1000;
        }
        return soma % tamanho;
    }
}