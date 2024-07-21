package ppoo.seuJogo;

public class App {
    public static void main(String[] args) throws Exception {
      PalavrasComando c = new PalavrasComando();
        System.out.println(c.getComandosValidos());
        Jogo jogo = new Jogo();
        jogo.jogar();
    }
}
