package ppoo.seuJogo;

/**
 * Essa é a classe principal da aplicacao "World of Zull". "World of Zuul" é um
 * jogo de aventura muito simples, baseado em texto.
 * 
 * Usuários podem caminhar em um cenário. E é tudo! Ele realmente precisa ser
 * estendido para fazer algo interessante!
 * 
 * Para jogar esse jogo, crie uma instancia dessa classe e chame o método
 * "jogar".
 * 
 * Essa classe principal cria e inicializa todas as outras: ela cria os
 * ambientes, cria o analisador e começa o jogo. Ela também avalia e executa os
 * comandos que o analisador retorna.
 * 
 * @author Michael Kölling and David J. Barnes (traduzido e adaptado por Julio
 *         César Alves)
 */

public class Jogo {
    // analisador de comandos do jogo
    private Analisador analisador;
    private Mochila mochila;
    // ambiente onde se encontra o jogador
    private Ambiente ambienteAtual;
    private boolean terminado;

    /**
     * Cria o jogo e incializa seu mapa interno.
     */
    public Jogo() {

        criarAmbientes();
        analisador = new Analisador();
        mochila = new Mochila();
        terminado = false;
    }

    /**
     * Cria todos os ambientes e liga as saidas deles
     */

    private void criarAmbientes() {
        Armas faca = new Armas("faca", "uma lâmina pequena e afiada, ideal para cortes rápidos e furtivos", 10);
        Armas espingarda = new Armas("espingarda",
                "uma arma de fogo de longo alcance, potente e eficaz em combate à distância", 30);
        Armas bazuca = new Armas("bazuca", "um lançador de foguetes, causando grandes explosões e danos significativos",
                70);
        Armas facao = new Armas("facao",
                "uma lâmina larga e robusta, ideal para cortes pesados e combate corpo a corpo", 35);
        Armas pa = new Armas("pa", "uma ferramenta resistente que também pode ser usada para golpes contundentes", 15);
        Armas espadaEncantada = new Armas("espada", "uma lâmina mágica que brilha e oferece poder extra em combate",
                55);

        ItensIluminacao tocha = new ItensIluminacao("tocha",
                "uma ferramenta média com um grande chama capaz de iluminar grandes ambientes", true);
        ItensIluminacao lanterna = new ItensIluminacao("lanterna",
                "uma ferramenta mais tecnologica, capaz de trazer luz a escuridao", true);
        ItensIluminacao isqueiro = new ItensIluminacao("isqueiro", "um objeto pequeno capaz de iluminar seus passos",
                true);

        Alimento maca = new Alimento("Maçã", "fruta crocante e suculenta, com uma casca geralmente vermelha ou verde",
                false);
        Alimento laranja = new Alimento("Laranja",
                "fruta cítrica, vibrante e suculenta, conhecida por seu sabor ácido e refrescante", true);
        Alimento melancia = new Alimento("Melancia",
                "fruta grande e suculenta, com polpa doce e vermelha, ideal para refrescar", true);
        Alimento banana = new Alimento("Banana",
                "fruta alongada e doce, com casca amarela quando madura, fácil de descascar", false);
        Alimento jabuticaba = new Alimento("Jabuticaba",
                "fruta pequena e redonda, com casca escura e polpa doce, típica de regiões tropicais", false);
        Alimento mexerica = new Alimento("Mexerica",
                "fruta cítrica pequena, com casca fácil de descascar e polpa doce e suculenta", true);

        Inimigo anão = new Inimigo("Anão", "um ser pequeno e robusto, com força e determinação notáveis", 20);
        Inimigo gigante = new Inimigo("Gigante", "uma criatura colossal e musculosa, imponente e poderosa", 50);
        Inimigo urso = new Inimigo("Urso", "um animal grande e forte, com pelagem espessa e olhar feroz", 25);
        Inimigo dragão = new Inimigo("Dragão",
                "uma criatura imensa com escamas brilhantes e asas poderosas, capaz de lançar fogo", 60);

        // Instâncias da classe Ambiente
        Ambiente jardimSecreto = new Ambiente("Jardim Secreto: Um oásis escondido, repleto de beleza e maravilhas");
        Ambiente jardim = new Ambiente(
                "Jardim: Um espaço verdejante e encantador, que esconde uma entrada secreta para um jardim especial");
        Ambiente florestaEncantada = new Ambiente(
                "Floresta Encantada: Um reino mágico e deslumbrante, onde a ajuda de seres sobrenaturais pode ser a chave para a jornada");
        Ambiente vulcao = new Ambiente(
                "Vulcão: Um cenário imponente e tumultuado, onde o calor e a força estão em plena exibição");
        Ambiente lagoaAzul = new Ambiente(
                "Lagoa Azul: Uma lagoa serena com águas cristalinas e uma atmosfera tranquila");

        // Instâncias da classe AmbientePerigoso
        AmbientePerigoso florestaSombria = new AmbientePerigoso(
                "Floresta Sombria: Um lugar envolto em mistério e sombras, onde o perigo espreita a cada passo", anão);
        AmbientePerigoso topoDasMontanhas = new AmbientePerigoso(
                "Topo das Montanhas: Um cenário majestoso e imponente, onde a vista se estende até onde a vista alcança",
                gigante);
        AmbientePerigoso caverna = new AmbientePerigoso(
                "Caverna: Um ambiente subterrâneo misterioso e fascinante, onde os brilhos cintilantes revelam pistas valiosas",
                urso);
        AmbientePerigoso minaDeOuro = new AmbientePerigoso(
                "Mina de Ouro: Um local áspero e desafiador, onde as riquezas e perigos estão lado a lado", dragão);

        // Instancias da classe AmbienteEscuro
        Ambiente salaSecretaDeMagia = new AmbienteEscuro(
                "Sala Secreta de Magia: Um espaço oculto e enigmático, repleto de antigos segredos e mistérios",
                "O cheiro da magia paira sobre o ar, você sente uma energia diferente no local, porêm o ambiente está escuro demais, para prosseguir você precisa de um item pra iluminar!");
        Ambiente pantano = new AmbienteEscuro(
                "Pântano: Uma área úmida e lamacenta, cheia de vegetação densa e perigos ocultos",
                "As arvóres e a vegetação densa fazem com que você não consiga ver nada, para prosseguir você precisa de um item pra iluminar!");
        Ambiente bar = new AmbienteEscuro(
                "Bar: Oque costumava ser um local vibrante e animado, agora é um local completamente destruido e repleto de corpos dos frequentadores, aparentemento o bruxo sombrio esteve por lá",
                "Você esbarra em destroços e aparentemente corpos, o ambiente está escuro demais, para prosseguir você precisa de um item pra iluminar!");
        // inicializa as saidas dos ambientes
        pantano.ajustarSaida(Direcao.NORTE, jardim);
        pantano.ajustarSaida(Direcao.LESTE, lagoaAzul);
        pantano.ajustarSaida(Direcao.OESTE, florestaEncantada);
        pantano.addItenAmbiente(mexerica);
        pantano.addItenAmbiente(pa);

        lagoaAzul.ajustarSaida(Direcao.OESTE, pantano);
        lagoaAzul.ajustarSaida(Direcao.LESTE, vulcao);
        lagoaAzul.ajustarSaida(Direcao.NORTE, caverna);
        lagoaAzul.addItenAmbiente(espadaEncantada);

        vulcao.ajustarSaida(Direcao.NOROESTE, caverna);
        vulcao.ajustarSaida(Direcao.OESTE, lagoaAzul);
        vulcao.addItenAmbiente(tocha);

        florestaEncantada.ajustarSaida(Direcao.LESTE, pantano);
        florestaEncantada.addItenAmbiente(jabuticaba);

        jardimSecreto.ajustarSaida(Direcao.NORTE, florestaSombria);
        jardimSecreto.ajustarSaida(Direcao.NORDESTE, topoDasMontanhas);
        jardimSecreto.ajustarSaida(Direcao.SUL, florestaEncantada);
        jardimSecreto.ajustarSaida(Direcao.SULDESTE, pantano);

        jardim.ajustarSaida(Direcao.OESTE, jardimSecreto);
        jardim.ajustarSaida(Direcao.LESTE, caverna);
        jardim.ajustarSaida(Direcao.SUL, pantano);
        jardim.ajustarSaida(Direcao.NORDESTE, salaSecretaDeMagia);
        jardim.addItenAmbiente(bazuca);
        jardim.addItenAmbiente(jabuticaba);
        jardim.addItenAmbiente(melancia);

        caverna.ajustarSaida(Direcao.OESTE, jardim);
        caverna.ajustarSaida(Direcao.LESTE, minaDeOuro);
        caverna.ajustarSaida(Direcao.SUL, lagoaAzul);
        caverna.addItenAmbiente(banana);

        minaDeOuro.ajustarSaida(Direcao.OESTE, minaDeOuro);
        minaDeOuro.ajustarSaida(Direcao.NORTE, bar);
        minaDeOuro.ajustarSaida(Direcao.SULDOESTE, lagoaAzul);
        minaDeOuro.addItenAmbiente(facao);
        minaDeOuro.addItenAmbiente(lanterna);

        bar.ajustarSaida(Direcao.OESTE, salaSecretaDeMagia);
        bar.ajustarSaida(Direcao.SUL, minaDeOuro);
        bar.addItenAmbiente(espingarda);
        bar.addItenAmbiente(laranja);
        bar.addItenAmbiente(isqueiro);

        salaSecretaDeMagia.ajustarSaida(Direcao.LESTE, bar);
        salaSecretaDeMagia.ajustarSaida(Direcao.SUL, caverna);
        salaSecretaDeMagia.ajustarSaida(Direcao.OESTE, topoDasMontanhas);

        topoDasMontanhas.ajustarSaida(Direcao.LESTE, salaSecretaDeMagia);
        topoDasMontanhas.ajustarSaida(Direcao.SUL, jardim);
        topoDasMontanhas.ajustarSaida(Direcao.SULDESTE, caverna);
        topoDasMontanhas.addItenAmbiente(faca);

        florestaSombria.ajustarSaida(Direcao.LESTE, topoDasMontanhas);
        florestaSombria.ajustarSaida(Direcao.SULDESTE, jardim);
        florestaSombria.addItenAmbiente(maca);

        ambienteAtual = lagoaAzul; // o jogo comeca em frente a uma grande lagoa azul
    }

    /**
     * Rotina principal do jogo. Fica em loop ate terminar o jogo.
     */
    public void jogar() {
        imprimirBoasVindas();

        // Entra no loop de comando principal. Aqui nós repetidamente lemos comandos e
        // os executamos até o jogo terminar.

        while (!terminado) {
            Comando comando = analisador.pegarComando();
            terminado = processarComando(comando);
        }
        System.out.println("Obrigado por jogar. Até mais!");
    }

    /**
     * Imprime a mensagem de abertura para o jogador.
     */
    private void imprimirBoasVindas() {
        System.out.println();
        System.out.println("Bem-vindo ao World of Zuul!");
        System.out.println("World of Zuul é um novo jogo de aventura, incrivelmente chato.");
        System.out.println("Digite 'ajuda' se você precisar de ajuda.");
        System.out.println();

        imprimirLocalizacaoAtual();
    }

    /**
     * Dado um comando, processa-o (ou seja, executa-o)
     * 
     * @param comando O Comando a ser processado.
     * @return true se o comando finaliza o jogo.
     */
    private boolean processarComando(Comando comando) {
        boolean querSair = false;

        if (comando.ehDesconhecido()) {
            System.out.println("Eu não entendi o que voce disse...");
            return false;
        }

        PalavraDeComando palavraDeComando = comando.getPalavraDeComando();

        if (palavraDeComando == PalavraDeComando.AJUDA) {
            imprimirAjuda();
        } else if (palavraDeComando == PalavraDeComando.IR) {
            querSair = irParaAmbiente(comando);
        } else if (palavraDeComando == PalavraDeComando.OBSERVAR) {
            observar(comando);
        } else if (palavraDeComando == PalavraDeComando.PEGAR) {
            pegar(comando);
        } else if (palavraDeComando == PalavraDeComando.INVENTARIO) {
            inventario(comando);
        } else if (palavraDeComando == PalavraDeComando.DESCARTAR) {
            descartar(comando);
        } else if (palavraDeComando == PalavraDeComando.COMER) {
            comer(comando);
        } else if (palavraDeComando == PalavraDeComando.USAR) {
            usar(comando);
        } else if (palavraDeComando == PalavraDeComando.SAIR) {
            querSair = sair(comando);
        } else if (palavraDeComando == PalavraDeComando.DERROTA) {
            System.out.println("lalala");
            return true;
        }

        return querSair;
    }

    private void PerdeuJogo() {
        System.out.println("Você foi derrotado");

    }

    /**
     * Exibe informações de ajuda. Aqui nós imprimimos algo bobo e enigmático e a
     * lista de palavras de comando
     */
    private void imprimirAjuda() {
        System.out.println("Você está perdido. Você está sozinho. Você caminha");
        System.out.println("pela universidade.");
        System.out.println();
        System.out.println("Suas palavras de comando são:");
        System.out.println("   " + analisador.getComandosValidos());
    }

    /**
     * Trata o comando "observar", exibindo as informações da localização atual do
     * jogador
     * 
     * @param comando Objeto comando a ser tratado
     */
    private void observar(Comando comando) {
        // se há segunda palavra, explica para o usuário que não pode...
        if (comando.temSegundaPalavra()) {
            System.out.println("Não é possível observar detalhes de alguma coisa");
            return;
        }

        imprimirItensAmbienteAtual();
        imprimirLocalizacaoAtual();
    }

    /**
     * Tenta ir em uma direcao. Se existe uma saída para lá entra no novo ambiente,
     * caso contrário imprime mensagem de erro.
     */
    private boolean irParaAmbiente(Comando comando) {
        // se não há segunda palavra, não sabemos pra onde ir...
        if (!comando.temSegundaPalavra()) {
            System.out.println("Ir pra onde?");
            return false;
        }

        Direcao direcao = Direcao.pelaString(comando.getSegundaPalavra());
        // Tenta sair do ambiente atual
        Ambiente proximoAmbiente = ambienteAtual.getSaida(direcao);
        boolean resultado;

        if (proximoAmbiente instanceof AmbientePerigoso) {
            resultado = ((AmbientePerigoso) proximoAmbiente).ataqueInimigo(mochila);
            if (resultado) {
                PerdeuJogo();
                return true;
            }

        }

        if (proximoAmbiente instanceof AmbienteEscuro) {
            AmbienteEscuro ambienteEscuro = (AmbienteEscuro) proximoAmbiente;

            // Verifica se o jogador possui algum item de iluminação na mochila
            if (!possuiItemIluminacao(mochila)) {
                System.out.println("Você não possui um item de iluminação necessário para entrar neste ambiente.");
                imprimirLocalizacaoAtual();
                return false;
                // Retorna false para bloquear a continuidade até que o jogador tenha um item de
                // iluminação
            }

            // Bloqueia qualquer ação até que o ambiente seja iluminado
            if (ambienteEscuro.estaEscuro(mochila)) {
                return true; // Retorna true para bloquear a continuidade até que o ambiente seja iluminado
            }
        }

        if (proximoAmbiente == null) {
            System.out.println("Não há passagem!");
        } else {
            ambienteAtual = proximoAmbiente;
            imprimirLocalizacaoAtual();
        }
        return false;
    }

    private boolean possuiItemIluminacao(Mochila mochila) {
        // Lista dos nomes dos itens de iluminação possíveis
        String[] itensIluminacao = { "tocha", "lanterna", "isqueiro" };

        // Verifica se a mochila possui algum dos itens de iluminação
        for (String nomeItem : itensIluminacao) {
            if (mochila.verificarSePossuiItem(nomeItem)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Exibe as informações da localização atual para o jogador
     */
    private void imprimirLocalizacaoAtual() {
        System.out.println(ambienteAtual.getDescricaoLonga());
        System.out.println();
    }

    private void imprimirItensAmbienteAtual() {
        System.out.println(ambienteAtual.listarItens());
        System.out.println();
    }

    /**
     * "Sair" foi digitado. Verifica o resto do comando pra ver se nós queremos
     * realmente sair do jogo.
     * 
     * @return true, se este comando sai do jogo, false, caso contrário.
     */
    private boolean sair(Comando comando) {
        if (comando.temSegundaPalavra()) {
            System.out.println("Sair o que?");
            return false;
        } else {
            return true; // sinaliza que nós realmente queremos sair
        }
    }

    private void pegar(Comando comando) {

        if (!comando.temSegundaPalavra()) {
            System.out.println("Pegar o que?");
            return;
        } else if (ambienteAtual.existeItemAmbiente(comando.getSegundaPalavra())) {
            Itens item = ambienteAtual.getIten(comando.getSegundaPalavra());
            mochila.adicionarItem(item);
            ambienteAtual.removerItemAmbiente(item);
        } else {
            System.out.println("Item não existe no ambiente");
        }

        imprimirLocalizacaoAtual();
    }

    private void usar(Comando comando) {
        if (!comando.temSegundaPalavra()) {
            System.out.println("Usar o que?");
            return;
        }

        String nomeItem = comando.getSegundaPalavra();

        if (mochila.verificarSePossuiItem(nomeItem)) {
            Itens item = mochila.getIten(nomeItem);

            // Verifica se é um item de iluminação
            if (item instanceof ItensIluminacao) {
                ItensIluminacao itemIluminacao = (ItensIluminacao) item;
                if (itemIluminacao.isIluminacao()) {
                    System.out.println(item.getNome() + " foi usado.");
                } else {
                    System.out.println("Este item não pode ser usado para iluminar o ambiente.");
                }
            } else {
                System.out.println("Este item não pode ser usado.");
            }
        } else {
            System.out.println("Item não encontrado na mochila.");
        }

        imprimirLocalizacaoAtual();
    }

    private void descartar(Comando comando) {

        if (!comando.temSegundaPalavra()) {
            System.out.println("Descartar  o que?");
            return;
        } else if (mochila.verificarSePossuiItem(comando.getSegundaPalavra())) {
            Itens item = mochila.getIten(comando.getSegundaPalavra());
            mochila.removerItem(item);
            ambienteAtual.addItenAmbiente(item);
            System.out.println(item.getNome() + " retirado do inventario");
        } else {
            System.out.println("Item não encontrado na mochila");
        }

        imprimirLocalizacaoAtual();
    }

    private void comer(Comando comando) {

        if (!comando.temSegundaPalavra()) {
            System.out.println("Comer o que?");
            return;
        } else if (mochila.verificarSePossuiItem(comando.getSegundaPalavra())) {
            if (mochila.getIten(comando.getSegundaPalavra()) instanceof Alimento) {
                Alimento alimento = (Alimento) mochila.getIten(comando.getSegundaPalavra());
                System.out.println(alimento.comer());
                mochila.removerItem(alimento);
            } else {
                System.out.println("Esse item não é um alimento");
            }
        } else {
            System.out.println("Item não encontrado na mochila");
        }

        imprimirLocalizacaoAtual();
    }

    private void inventario(Comando comando) {
        System.out.println(mochila.listarItens());
        imprimirLocalizacaoAtual();
    }

}
