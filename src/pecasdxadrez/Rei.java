package pecasdxadrez;

import tabuleiro.Tabuleiro;
import xadrez.Color;
import xadrez.PecaDXadrez;

public class Rei extends PecaDXadrez{
    
    public Rei(Tabuleiro tabuleiro, Color color) {
        super(tabuleiro, color);
    }

    @Override
    public String toString() {
        return "R";
    }
}
