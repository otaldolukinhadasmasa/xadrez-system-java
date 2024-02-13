package xadrez;

import tabuleiro.Peca;
import tabuleiro.Tabuleiro;

public class PecaDXadrez extends Peca {
    private Color color;

    public PecaDXadrez(Tabuleiro tabuleiro, Color color) {
        super(tabuleiro);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

}
