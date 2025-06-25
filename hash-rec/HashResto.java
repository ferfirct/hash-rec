public class HashResto implements FuncaoHash {
    public int hash(int chave, int tamanho) {
        return (chave & 0x7FFFFFFF) % tamanho;
    }
}