package xadrez;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import pecasdxadrez.Rei;
import pecasdxadrez.Torre;
import tabuleiro.Peca;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;

public class PartidaDXadrez {
    
    private int turn;
    private Color currentPlayer;
    private Tabuleiro tabuleiro;
    private boolean check;

    private List<Peca> pecasNoTabuleiro = new ArrayList<>();
    private List<Peca> pecasCapturadas = new ArrayList<>();

    public PartidaDXadrez(){
        tabuleiro = new Tabuleiro(8, 8);
        turn = 1;
        currentPlayer = Color.WHITE;
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
    
    public int getTurn(){
        return turn;
    }

    public Color getCurrentPlayer(){
        return currentPlayer;
    }

    public boolean getCheck(){
        return check;
    }
    
    public boolean[][] posiveisMove(PosicaoXadrez sourcePosicao){
        Posicao posicao = sourcePosicao.toPosicao();
        validacaoSourcePosicao(posicao);
        return tabuleiro.peca(posicao).posiveisMoves();
    }

    public PecaDXadrez performMoveDXadrez(PosicaoXadrez sourcePosicao, PosicaoXadrez targetPosicao){
        Posicao source = sourcePosicao.toPosicao();
        Posicao target = targetPosicao.toPosicao();
        validacaoSourcePosicao(source);
        validacaoTargetPosicao(source, target);
        Peca pecaCapturada = makeMove(source, target);
        
        if (testeCheck(currentPlayer)) {
            desfazerMove(source, target, pecaCapturada);
            throw new ExcecaoDXadrez("Voce nao pode se colocar em Check");
        }

        check = (testeCheck(oponete(currentPlayer))) ? true : false;

        nextTurn();
        return (PecaDXadrez)pecaCapturada;
    }

    private Peca makeMove(Posicao source, Posicao target){
        Peca p = tabuleiro.removePeca(source);
        Peca pecaCapturada = tabuleiro.removePeca(target);
        tabuleiro.placePeca(p, target);

        if (pecaCapturada != null) {
            pecasNoTabuleiro.remove(pecaCapturada);
            pecasCapturadas.add(pecaCapturada);
        }
        return pecaCapturada;
    }
    
    private void desfazerMove(Posicao source, Posicao target, Peca pecaCapturada){
        Peca p = tabuleiro.removePeca(target);
        tabuleiro.placePeca(p, source);
        
        if (pecaCapturada != null) {
            tabuleiro.placePeca(pecaCapturada, target);
            pecasCapturadas.remove(pecaCapturada);
            pecasNoTabuleiro.add(pecaCapturada);
        }
    }

    private void validacaoSourcePosicao(Posicao posicao){
        if(!tabuleiro.thereIsPeca(posicao)){
            throw new ExcecaoDXadrez("Nao ha uma peca na posicao de origem");
        }
        if (currentPlayer != ((PecaDXadrez)tabuleiro.peca(posicao)).getColor()) {
            throw new ExcecaoDXadrez("A peca escolhida nao e sua!");
        }
        if (!tabuleiro.peca(posicao).isMovimentoPosivel()) {
            throw new ExcecaoDXadrez("Nao existe movimentos possiveis para a peca escolhida");
        }
    }

    private void validacaoTargetPosicao(Posicao source, Posicao target){
        if (!tabuleiro.peca(source).posiveisMove(target)) {
            throw new ExcecaoDXadrez("A peca escolhida nao pode se mover para a cposicao escolhida.");
        }
    }

    private void nextTurn(){
        turn++;
        currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
    }

    private Color oponete(Color color){
        return (color == Color.WHITE ? Color.BLACK : Color.WHITE);
    }

    private PecaDXadrez Rei(Color color){
        List<Peca> list = pecasNoTabuleiro.stream().filter(x -> ((PecaDXadrez)x).getColor() == color).collect(Collectors.toList());
        for (Peca p : list) {
            if (p instanceof Rei) {
            return (PecaDXadrez)p;        
            }
        }
        throw new IllegalStateException("Nao exite um Rei " + color + " no tabuleiro.");
    }

    private boolean testeCheck(Color color){
        Posicao posicaoDoRei = Rei(color).getPosicaoXadrez().toPosicao();
        List<Peca> pecaOponente = pecasNoTabuleiro.stream().filter(x -> ((PecaDXadrez)x).getColor() == oponete(color)).collect(Collectors.toList());
        for (Peca p : pecaOponente){
            boolean[][] mat = p.posiveisMoves();
            if (mat[posicaoDoRei.getRow()][posicaoDoRei.getColumn()]) {
                return true;
            }
        }
        return false;
    }

    private void placeNovaPeca(char column, int row, PecaDXadrez peca) {
        tabuleiro.placePeca(peca, new PosicaoXadrez(column, row).toPosicao());
        pecasNoTabuleiro.add(peca);
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