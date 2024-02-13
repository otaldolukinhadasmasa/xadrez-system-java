package aplication;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.PartidaDXadrez;

public class Program{
    public static void main(String[] args) throws Exception {
        
        PartidaDXadrez partidaDXadrez = new PartidaDXadrez();
        UI.printTabuleiro(partidaDXadrez.getPecas());
    }
}
