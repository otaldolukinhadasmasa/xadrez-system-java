package aplication;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.ExcecaoDXadrez;
import xadrez.PartidaDXadrez;
import xadrez.PecaDXadrez;
import xadrez.PosicaoXadrez;

public class Program{
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        PartidaDXadrez partidaDXadrez = new PartidaDXadrez();
        List<PecaDXadrez> capturada = new ArrayList<>();


        while (true) {
            try{
                UI.clearScreen();
                UI.printPartida(partidaDXadrez, capturada);
                System.out.println();
                System.out.println("Escolhe essa bosta");
                PosicaoXadrez source = UI.readPosicaoXadrez(sc);

                boolean[][] possiveisMoves = partidaDXadrez.posiveisMove(source);
                UI.clearScreen();
                UI.printTabuleiro(partidaDXadrez.getPecas(), possiveisMoves);
                System.out.println();
                System.out.println("Destino");
                PosicaoXadrez target = UI.readPosicaoXadrez(sc);

                PecaDXadrez pecaCapturada = partidaDXadrez.performMoveDXadrez(source, target);
            
                if (pecaCapturada != null) {
                    capturada.add(pecaCapturada);
                }
            }
            catch(ExcecaoDXadrez e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }
            catch(InputMismatchException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
    }
}
