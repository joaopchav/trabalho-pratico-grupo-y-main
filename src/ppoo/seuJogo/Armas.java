package ppoo.seuJogo;

public class Armas extends Itens {
    private int dano;
    public Armas(String nome, String descricao, int dano) {
        super(nome, descricao);
        this.dano = dano;
    }

    public int getDano(){
        return dano;
    }

    

    

    

    
}
