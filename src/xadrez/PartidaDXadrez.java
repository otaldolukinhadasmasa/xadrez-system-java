package xadrez;

import pecasdxadrez.Rei;
import pecasdxadrez.Torre;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;

public class PartidaDXadrez {
    
    private Tabuleiro tabuleiro;
    
    public PartidaDXadrez(){
        tabuleiro = new Tabuleiro(8, 8);
        setupInicial();
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
    
    private void setupInicial(){
        tabuleiro.placePeca(new Torre(tabuleiro, Color.WHITE), new Posicao(2, 1));
        tabuleiro.placePeca(new Rei(tabuleiro, Color.BLACK), new Posicao(0, 4));
        tabuleiro.placePeca(new Rei(tabuleiro, Color.WHITE), new Posicao(7, 4));
    }
}