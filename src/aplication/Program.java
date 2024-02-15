package aplication;

import java.util.Scanner;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.PartidaDXadrez;
import xadrez.PecaDXadrez;
import xadrez.PosicaoXadrez;

public class Program{
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        PartidaDXadrez partidaDXadrez = new PartidaDXadrez();
        
        while (true) {
            UI.printTabuleiro(partidaDXadrez.getPecas());
            System.out.println();
            System.out.println("Escolhe essa bosta");
            PosicaoXadrez source = UI.readPosicaoXadrez(sc);

            System.out.println();
            System.out.println("Destino");
            PosicaoXadrez target = UI.readPosicaoXadrez(sc);

            PecaDXadrez pecaCapturada = partidaDXadrez.performMoveDXadrez(source, target);
        }
    }
}
