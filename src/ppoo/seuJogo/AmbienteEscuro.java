package ppoo.seuJogo;

public class AmbienteEscuro extends Ambiente {

    private Analisador analisador;
    private String descricaoEscuro;
    ItensIluminacao itensIluminacao;

    public AmbienteEscuro(String descricao, String descricaoEscuro) {
        super(descricao);
        this.descricaoEscuro = descricaoEscuro;
        analisador = new Analisador();
    }

    public String getDescricaoEscuro() {
        return descricaoEscuro;
    }

    public boolean estaEscuro(Mochila mochila) {
        boolean precisaDeIluminacao = true;

        System.out.println(getDescricaoEscuro());

        while (precisaDeIluminacao) {
            Comando comando = analisador.pegarComando();
            PalavraDeComando palavraDeComando = comando.getPalavraDeComando();
            String nomeItem = comando.getSegundaPalavra();

            if (palavraDeComando == PalavraDeComando.DESISTIR) {
                return desistir();
            } else if (palavraDeComando == PalavraDeComando.USAR) {
                if (nomeItem == null) {
                    System.out.println("Usar o quê?");
                } else {
                    return usarItemDeIluminacao(mochila, nomeItem);
                }
            } else {
                System.out.println("Escolha inválida.");
                // Continua o loop para solicitar um comando válido
            }
        }

        // Se saiu do loop, significa que já não precisa mais de iluminação para
        // prosseguir
        return !precisaDeIluminacao; // Retorna true se conseguiu prosseguir, false se desistiu
    }

    private boolean desistir() {
        return true;
    }

    private boolean usarItemDeIluminacao(Mochila mochila, String nomeItem) {
        if (mochila.verificarSePossuiItem(nomeItem)) {
            Itens item = mochila.getIten(nomeItem);
            if (item instanceof ItensIluminacao) {
                ItensIluminacao itemIluminacao = (ItensIluminacao) item;
                if (itemIluminacao.isIluminacao()) {
                    System.out.println("Você usou " + item.getDescricao() + " para iluminar o ambiente.");
                    return false; // Indica que conseguiu prosseguir, pois o ambiente está iluminado
                } else {
                    System.out.println("Este item não pode ser usado para iluminar o ambiente.");
                    continuaEscuro(); // Continua no escuro, solicita novo comando
                }
            } else {
                System.out.println("Este item não pode ser usado para iluminar o ambiente.");
                continuaEscuro(); // Continua no escuro, solicita novo comando
            }
        } else {
            System.out.println("Você não possui " + nomeItem + " na mochila.");
            continuaEscuro(); // Continua no escuro, solicita novo comando
        }

        return true; // Indica que ainda precisa de um item de iluminação para prosseguir
    }

    private void continuaEscuro() {
        System.out.println("O ambiente ainda está escuro. Escolha outro item ou desista.");
    }

    // Outros métodos e atributos da classe AmbienteEscuro podem estar aqui

}
