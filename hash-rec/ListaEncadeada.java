public class ListaEncadeada {
    public Node inicio;

    public void inserir(Registro registro) {
        Node novo = new Node(registro);
        novo.proximo = inicio;
        inicio = novo;
    }

    public int buscar(int codigo) {
        int comparacoes = 0;
        Node atual = inicio;
        while (atual != null) {
            comparacoes++;
            if (atual.registro.getCodigo() == codigo) return comparacoes;
            atual = atual.proximo;
        }
        return -comparacoes;
    }
}
