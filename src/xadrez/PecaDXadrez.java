package xadrez;

import tabuleiro.Peca;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;

public abstract class PecaDXadrez extends Peca {
    private Color color;

    public PecaDXadrez(Tabuleiro tabuleiro, Color color) {
        super(tabuleiro);
        this.color = color;
    }

    public PosicaoXadrez getPosicaoXadrez(){
        return PosicaoXadrez.fromPosicaoXadrez(posicao);
    }
    
    public Color getColor() {
        return color;
    }
    protected boolean isHaUmaPecaInimiga(Posicao posicao){
        PecaDXadrez p = (PecaDXadrez)getTabuleiro().peca(posicao);
        return p != null && p.getColor() != color;
    }

}
