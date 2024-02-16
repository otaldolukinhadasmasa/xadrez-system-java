package pecasdxadrez;

import tabuleiro.Posicao;
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

    private boolean canMove(Posicao posicao){
        PecaDXadrez p = (PecaDXadrez)getTabuleiro().peca(posicao);
        return p == null || p.getColor() != getColor();
    }

    @Override
    public boolean[][] posiveisMoves() {
        boolean[][] mat = new boolean[getTabuleiro().getRows()][getTabuleiro().getColumns()];
       
        Posicao p = new Posicao(0, 0);

        //cima
        p.setValue(posicao.getRow() - 1, posicao.getColumn());
        if (getTabuleiro().posicaoExiste(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //baixo
        p.setValue(posicao.getRow() + 1, posicao.getColumn());
        if (getTabuleiro().posicaoExiste(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //esquerda
        p.setValue(posicao.getRow(), posicao.getColumn() - 1);
        if (getTabuleiro().posicaoExiste(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //direita
        p.setValue(posicao.getRow(), posicao.getColumn() + 1);
        if (getTabuleiro().posicaoExiste(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //nw
        p.setValue(posicao.getRow() - 1, posicao.getColumn() - 1);
        if (getTabuleiro().posicaoExiste(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //ne
        p.setValue(posicao.getRow() - 1, posicao.getColumn() + 1);
        if (getTabuleiro().posicaoExiste(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //sw
        p.setValue(posicao.getRow() + 1, posicao.getColumn() - 1);
        if (getTabuleiro().posicaoExiste(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //se
        p.setValue(posicao.getRow() + 1, posicao.getColumn() + 1);
        if (getTabuleiro().posicaoExiste(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        return mat;
    }
}
