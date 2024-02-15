package pecasdxadrez;

import tabuleiro.Tabuleiro;
import xadrez.Color;
import xadrez.PecaDXadrez;

public class Torre extends PecaDXadrez{

    public Torre(Tabuleiro tabuleiro, Color color) {
        super(tabuleiro, color);
    }
    
    @Override
    public String toString() {
        return "T";
    }
    
    @Override
    public boolean[][] posiveisMoves() {
        boolean[][] mat = new boolean[getTabuleiro().getRows()][getTabuleiro().getColumns()];
        return mat;
    }
}
