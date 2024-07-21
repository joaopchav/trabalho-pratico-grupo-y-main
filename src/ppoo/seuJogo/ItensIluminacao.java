package ppoo.seuJogo;

public class ItensIluminacao extends Itens {
    private boolean iluminacao;

    public ItensIluminacao(String nome, String descricao, boolean iluminacao) {
        super(nome, descricao);
        this.iluminacao = iluminacao;
    }

    public boolean isIluminacao() {
        return iluminacao;
    }

}
