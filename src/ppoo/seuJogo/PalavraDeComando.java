package ppoo.seuJogo;

/**
 * Representações de todas as palavras de comandos válidas para o jogo.
 *
 * @author Adaptado de Michael Kölling and David J. Barnes
 */

public enum PalavraDeComando {
    // Um valor de cada palavra de comando
    // juntamente com sua string correspondente na interface com o usuário.
    PEGAR("pegar"),
    LUTAR("lutar"),
    DESISTIR("desistir"),
    DERROTA("derrotar"),
    DESCARTAR("descartar"),
    COMER("comer"),
    INVENTARIO("inventario"),
    IR("ir"),
    SAIR("sair"),
    AJUDA("ajuda"),
    DESCONHECIDA("?"),
    OBSERVAR("observar"),
    USAR("usar");

    // Palavra de comando
    private String palavraDeComando;

    /**
     * Inicializa com a palavra de comando correspondente
     * 
     * @param palavraDeComando a palavra de comando
     */
    private PalavraDeComando(String palavraDeComando) {
        this.palavraDeComando = palavraDeComando;
    }

    /**
     * @return A palavra de comando como uma string
     */
    public String toString() {
        return palavraDeComando;
    }
}
