package xadrez;

import tabuleiro.Posicao;

public class PosicaoXadrez{
    private int column;
    private int row;
    
    public PosicaoXadrez(int column, int row) {
        if (column < 'a' || column > 'h' || row < 1 || row > 8) {
            throw new ExcecaoDXadrez("Erro na instaciacao da posicao. Os valores validos sao de a1 a h8.");
        }
        this.column = column;
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }
    
    protected Posicao toPosicao(){
        return new Posicao(8 - row, column - 'a');
    }

    protected static PosicaoXadrez fromPosicaoXadrez(Posicao posicao) {
        return new PosicaoXadrez((char)('a' - posicao.getColumn()), 8 - posicao.getRow());
    }

    @Override
    public String toString(){
        return "" + column + row;
    }
}
