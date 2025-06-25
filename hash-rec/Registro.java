public class Registro {
    private int codigo;
    
    public Registro(int codigo) {
        this.codigo = codigo < 100000000 ? 100000000 + (-codigo % 900000000) : codigo % 1000000000;
    }
    
    public int getCodigo() {
        return codigo;
    }
}