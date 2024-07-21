package ppoo.seuJogo;

import java.util.ArrayList;
import java.util.List;

public class Mochila {
 private int capacidadeAtual;
    private int capacidadeMax;
    private List<Itens> itensMochila;

    public Mochila() {
        this.capacidadeMax = 2;
        this.capacidadeAtual = 0;
        this.itensMochila = new ArrayList<>();
    }

    public void adicionarItem(Itens item) {
        if (item.existeItem(item.getNome())) {
            if (capacidadeAtual < capacidadeMax) {
                itensMochila.add(item);
                capacidadeAtual++;
                System.out.println(item.getNome() + " adicionado na mochila");
            } else {
                System.out.println("Mochila está cheia! Não foi possível adicionar o item " + item.getNome() + ".");
            }
        }
    }

    public void removerItem(Itens item) {
        if (itensMochila.remove(item)) {
            capacidadeAtual--;
        } else {
            System.out.println("Item " + item.getNome() + " não encontrado na mochila.");
        }
    }

    public void esvaziarTudo() {
        itensMochila.clear();
        capacidadeAtual = 0;
        System.out.println("Todos os itens foram removidos da mochila.");
    }

    public String listarItens() {
        String lista = "Itens na mochila: \n";
        for (Itens item : itensMochila) {
           lista += item.descricaoCompleta() + "\n";
        }
        return lista;
    }

    public int getCapacidadeAtual() {
        return capacidadeAtual;
    }

    public int getCapacidadeMax() {
        return capacidadeMax;
    }

    public int capacidadeDisponivel(){
        return capacidadeMax - capacidadeAtual;
    }

    public boolean verificarSePossuiItem(String nomeItem) {
        for (Itens item : itensMochila) {
            if (item.getNome().equals(nomeItem)) {
                return true;
            }
        }
        return false;
    }

    public Itens getIten(String nomeItem){
        for (Itens item : itensMochila) {
            if (item.getNome().equals(nomeItem)) {
                return item;
            }
        }
        return null;
    }

    public Armas getArma(String segundaPalavra) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getArma'");
    }

 
}

