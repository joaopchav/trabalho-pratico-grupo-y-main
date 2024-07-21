package ppoo.seuJogo;

public class Alimento extends Itens {
    private boolean envenenado;
    public Alimento(String nome, String descricao, boolean envenenado) {
        super(nome, descricao);
        this.envenenado = envenenado;
    }

    public boolean envenenado(){
        return envenenado;
    }

    public String comer(){
        if (envenenado) {
            return" Você perdeu 10 pontos";
        }else
        return "voce ganhou 5 pontos";
    }

}
