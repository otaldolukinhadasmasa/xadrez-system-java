package tabuleiro;

public class Peca {
    protected Posicao posicao;
    protected Tabuleiro tabuleiro;
    
    public Peca(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    protected Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

}
