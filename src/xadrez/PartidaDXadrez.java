package xadrez;

import tabuleiro.Tabuleiro;

public class PartidaDXadrez {
    
    private Tabuleiro tabuleiro;
    
    public PartidaDXadrez(){
        tabuleiro = new Tabuleiro(8, 8);
    }

    public PecaDXadrez[][] getPecas() {
        PecaDXadrez[][] mat = new PecaDXadrez[tabuleiro.getRows()][tabuleiro.getColumns()];
        for (int i = 0; i < tabuleiro.getRows(); i++) {
            for (int j = 0; j < tabuleiro.getColumns(); j++) {
                mat[i][j] = (PecaDXadrez) tabuleiro.peca(i, j); 
            }
        }
        return mat;
    }
    
}