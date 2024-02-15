package pecasdxadrez;

import tabuleiro.Posicao;
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
        
        Posicao p = new Posicao(0, 0);

        //cima
        p.setValue(posicao.getRow() - 1, posicao.getColumn());
        while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().thereIsPeca(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow() - 1);
        }
        if (getTabuleiro().posicaoExiste(p) && isHaUmaPecaInimiga(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
        
        //esquerda
        p.setValue(posicao.getRow(), posicao.getColumn() - 1);
        while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().thereIsPeca(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setColumn((p.getColumn() - 1));
        }
        if (getTabuleiro().posicaoExiste(p) && isHaUmaPecaInimiga(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //direita
        p.setValue(posicao.getRow(), posicao.getColumn() + 1);
        while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().thereIsPeca(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setColumn((p.getColumn() + 1));
        }
        if (getTabuleiro().posicaoExiste(p) && isHaUmaPecaInimiga(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //baixo
        p.setValue(posicao.getRow() + 1, posicao.getColumn());
        while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().thereIsPeca(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow() + 1);
        }
        if (getTabuleiro().posicaoExiste(p) && isHaUmaPecaInimiga(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
        
        return mat;
    }
}
