public class TabelaHash {
    private ListaEncadeada[] tabela;
    private FuncaoHash funcaoHash;
    private int colisoes;

    public TabelaHash(int tamanho, FuncaoHash funcaoHash) {
        this.tabela = new ListaEncadeada[tamanho];
        for (int i = 0; i < tamanho; i++) {
            tabela[i] = new ListaEncadeada();
        }
        this.funcaoHash = funcaoHash;
    }

    public void inserir(Registro registro) {
        int pos = funcaoHash.hash(registro.getCodigo(), tabela.length);
        if (tabela[pos].inicio != null) colisoes++;
        tabela[pos].inserir(registro);
    }

    public int buscar(int codigo) {
        int pos = funcaoHash.hash(codigo, tabela.length);
        return tabela[pos].buscar(codigo);
    }

    public int getColisoes() {
        return colisoes;
    }
}
