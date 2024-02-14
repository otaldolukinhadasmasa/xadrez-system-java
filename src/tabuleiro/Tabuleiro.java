package tabuleiro;

public class Tabuleiro {
    private int rows;
    private int columns;
    private Peca[][] pecas;
    
    public Tabuleiro(int rows, int columns) {
        if (rows < 1 || columns < 1) {
            throw new ExcecaoDTabuleiro(
                "Erro ao criar o Tabuleiro: E necessario pelo menos 1 linha e 1 coluna");
        }
        this.rows = rows;
        this.columns = columns;
        pecas = new Peca[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Peca peca(int row, int column){
        if (!posicaoExiste(row, column)) {
            throw new ExcecaoDTabuleiro("null");
        }
        return pecas[row][column];
    }

    public Peca peca(Posicao posicao){
        if (!posicaoExiste(posicao)) {
            throw new ExcecaoDTabuleiro("Nao ha essa peca no tabuleiro");
        }
        return pecas[posicao.getRow()][posicao.getColumn()];
    }

    public void placePeca(Peca peca, Posicao posicao){
        if (thereIsPeca(posicao)) {
            throw new ExcecaoDTabuleiro("Ja ha uma peca nesta posicao " + posicao);
        }
        pecas[posicao.getRow()][posicao.getColumn()] = peca;
        peca.posicao = posicao;
    }

    public Peca removePeca(Posicao posicao){
        if (!posicaoExiste(posicao)) {
            throw new ExcecaoDTabuleiro("Nao ha essa peca no tabuleiro");
        }
        if (peca(posicao) == null) {
            return null;
        }
        Peca aux = peca(posicao);
        aux.posicao = null;
        pecas[posicao.getRow()][posicao.getColumn()] = null;
        return aux;
    }
    
    private boolean posicaoExiste(int row, int column){
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public boolean posicaoExiste(Posicao posicao){
        return posicaoExiste(posicao.getRow(), posicao.getColumn());
    }

    public boolean thereIsPeca(Posicao posicao){
        if (!posicaoExiste(posicao)) {
            throw new ExcecaoDTabuleiro("Nao ha essa posicao no tabuleiro");
        }
        return peca(posicao) != null;
    }
}
