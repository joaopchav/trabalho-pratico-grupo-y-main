package ppoo.seuJogo;

public class AmbientePerigoso extends Ambiente {
    private Inimigo inimigo;
    private Analisador analisador;
    

    public AmbientePerigoso(String descricao, Inimigo inimigo) {
        super(descricao);
        this.inimigo = inimigo;
        analisador = new Analisador();
    }

    public boolean ataqueInimigo(Mochila mochila) {
        boolean continuaLuta = true;

        System.out.println("Essa não! Você foi atacado!");
        System.out.println(inimigo.descricaoCompleta());
        System.out.println( "O que deseja fazer agora?");
        System.out.println("Escolha lutar ou desistir.");

        while (continuaLuta) {
            

            Comando comando = analisador.pegarComando();
            PalavraDeComando palavraDeComando = comando.getPalavraDeComando();
            String nomeArma = comando.getSegundaPalavra();

            if (palavraDeComando == PalavraDeComando.DESISTIR) {
                return desistir();
            } else if (palavraDeComando == PalavraDeComando.LUTAR) {
                if (nomeArma == null) {
                    System.out.println("Lutar com o quê?");
                } else {
                    return lutar(mochila, nomeArma); // Se a luta terminar, continuaLuta será false
                }
            } else {
                System.out.println("Escolha inválida.");
                // Continua o loop para solicitar um comando válido
            }
        }

        return !continuaLuta; // Retorna true se a luta foi vencida, false se desistiu
    }

    private boolean desistir() {
        return true;
    }

    private boolean lutar(Mochila mochila, String nomeArma) {
        
        if (mochila.verificarSePossuiItem(nomeArma)) {
            if (mochila.getIten(nomeArma) instanceof Armas) {
                Armas armaEscolhida = (Armas) mochila.getIten(nomeArma);
                if (armaEscolhida.getDano() > inimigo.getForca()) {
                    System.out.println("Você ganhou a luta!");
                    return false; // Indica que a luta foi vencida
                } else {
                    return true; // Indica que a luta foi perdida
                }
            } else {
                System.out.println("Este item não é uma arma.");
                ataqueInimigo(mochila);// Indica que o combate não pôde ser realizado
            }
        } else {
            System.out.println("Você não possui este item no inventário.");
            ataqueInimigo(mochila); // Indica que o combate não pôde ser realizado
        }

        return false;
    }
}
