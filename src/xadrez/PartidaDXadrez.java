package xadrez;

import pecasdxadrez.Rei;
import pecasdxadrez.Torre;
import tabuleiro.Peca;
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
    
    public PecaDXadrez performMoveDXadrez(PosicaoXadrez sourcePosicao, PosicaoXadrez targetPosicao){
        Posicao source = sourcePosicao.toPosicao();
        Posicao target = targetPosicao.toPosicao();
        validacaoSourcePosicao(source);
        Peca pecaCapturada = makeMove(source, target);
        return (PecaDXadrez)pecaCapturada;
    }

    private Peca makeMove(Posicao source, Posicao target){
        Peca p = tabuleiro.removePeca(source);
        Peca pecaCapturada = tabuleiro.removePeca(target);
        tabuleiro.placePeca(p, target);
        return pecaCapturada;
    }
    
    private void validacaoSourcePosicao(Posicao posicao){
        if(!tabuleiro.thereIsPeca(posicao)){
            throw new ExcecaoDXadrez("Nao ha uma peca na posicao de origem");
        }
    }

    private void placeNovaPeca(char column, int row, PecaDXadrez peca) {
        tabuleiro.placePeca(peca, new PosicaoXadrez(column, row).toPosicao());
    }

    private void setupInicial(){
		placeNovaPeca('c', 1, new Torre(tabuleiro, Color.WHITE));
        placeNovaPeca('c', 2, new Torre(tabuleiro, Color.WHITE));
        placeNovaPeca('d', 2, new Torre(tabuleiro, Color.WHITE));
        placeNovaPeca('e', 2, new Torre(tabuleiro, Color.WHITE));
        placeNovaPeca('e', 1, new Torre(tabuleiro, Color.WHITE));
        placeNovaPeca('d', 1, new Rei(tabuleiro, Color.WHITE)); 

        placeNovaPeca('c', 7, new Torre(tabuleiro, Color.BLACK));
        placeNovaPeca('c', 8, new Torre(tabuleiro, Color.BLACK));
        placeNovaPeca('d', 7, new Torre(tabuleiro, Color.BLACK));
        placeNovaPeca('e', 7, new Torre(tabuleiro, Color.BLACK));
        placeNovaPeca('e', 8, new Torre(tabuleiro, Color.BLACK));
        placeNovaPeca('d', 8, new Rei(tabuleiro, Color.BLACK));
	}

}