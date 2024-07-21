package ppoo.seuJogo;

public class Inimigo {
    private String nome;
    private String descricao;
    private int forca;

    // Construtor
    public Inimigo(String nome, String descricao, int forca) {
        this.nome = nome;
        this.descricao = descricao;
        this.forca = forca;
    }

    // Métodos getter
    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getForca() {
        return forca;
    }

    // Método para exibir a descrição completa do inimigo
    public String descricaoCompleta() {
        return "Nome: " + nome + "\nDescrição: " + descricao + "\nForça: " + forca ;
    }
}
