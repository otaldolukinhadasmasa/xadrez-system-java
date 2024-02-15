package tabuleiro;

public abstract class Peca {
    protected Posicao posicao;
    protected Tabuleiro tabuleiro;
    
    public Peca(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    protected Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public abstract boolean[][] posiveisMoves();

    public boolean posiveisMove(Posicao posicao){
        return posiveisMoves()[posicao.getRow()][posicao.getColumn()];
    }

    public boolean isMovimentoPosivel(){
        boolean[][] mat = posiveisMoves();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (mat[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
