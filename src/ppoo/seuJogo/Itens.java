package ppoo.seuJogo;

import java.util.ArrayList;

public class Itens {
    private String nome;
    private String descricao;
    private ArrayList<String> listaItens = new ArrayList<String>();

    public Itens(String nome, String descricao) {
        this.descricao = descricao;
        this.nome = nome;
        listaItens.add(nome);
    }

    public String getDescricao() {
        return descricao;
    }

    public String getNome() {
        return nome;
    }

    public String descricaoCompleta() {
        return "Nome: " + nome + " Descrição: " + descricao;
    }

    public boolean existeItem(String nome) {
        for (String iten : listaItens) {
            if (iten.equals(nome)) {
                return true;
            }
        }
        System.out.println("Iten não existe");
        return false;
    }

}
