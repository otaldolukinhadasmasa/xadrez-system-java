package aplication;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import xadrez.Color;
import xadrez.PartidaDXadrez;
import xadrez.PecaDXadrez;
import xadrez.PosicaoXadrez;

public class UI {

    // https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
       }

    public static PosicaoXadrez readPosicaoXadrez(Scanner sc){
    try {
        String s = sc.nextLine();
        char column = s.charAt(0);
        int row = Integer.parseInt(s.substring(1));
        return new PosicaoXadrez(column, row);
    }
    catch (RuntimeException e){
        throw new InputMismatchException(
            "Erro ao ler a posicao de xadrez, Valores validos sao de a1 ate h8.");
    } 
}

    public static void printPartida(PartidaDXadrez partidaDXadrez, List<PecaDXadrez> capturada){
        printTabuleiro(partidaDXadrez.getPecas());
        System.out.println();
        printPecaCapturada(capturada);
        System.out.println();
        System.out.println("Turno : " + partidaDXadrez.getTurn());
        System.out.println("Aguardando o jogador : " + partidaDXadrez.getCurrentPlayer());
        if (partidaDXadrez.getCheck()) {
            System.out.println("CHECK!");
        }
    }

    public static void printTabuleiro(PecaDXadrez[][] pecas) {
        for (int i = 0; i < pecas.length; i++) {
            System.out.print(8 - i + " ");
            for (int j = 0; j < pecas.length; j++) {
                printPeca(pecas[i][j], false);
            }
            System.out.println();
            }
        System.out.println("  a b c d e f g h");
    }

    public static void printTabuleiro(PecaDXadrez[][] pecas, boolean[][] posiveisMoves) {
        for (int i = 0; i < pecas.length; i++) {
            System.out.print(8 - i + " ");
            for (int j = 0; j < pecas.length; j++) {
                printPeca(pecas[i][j], posiveisMoves[i][j]);
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }

    private static void printPeca(PecaDXadrez peca, boolean background){
        if (background) {
            System.out.print(ANSI_BLUE_BACKGROUND);
        }
        if (peca == null) {
            System.out.print("-" + ANSI_RESET);
        }
        else {
            if (peca.getColor() == Color.WHITE) {
                System.out.print(ANSI_WHITE + peca + ANSI_RESET);
            }
            else {
                System.out.print(ANSI_YELLOW + peca + ANSI_RESET);
            }
        }
        System.out.print(" ");
    }

    private static void printPecaCapturada(List<PecaDXadrez> capturada){
        List <PecaDXadrez> white = capturada.stream().filter(x -> x.getColor() == Color.WHITE).collect(Collectors.toList());
        List <PecaDXadrez> black = capturada.stream().filter(x -> x.getColor() == Color.BLACK).collect(Collectors.toList());  
        System.out.println("Pecas capturadas:");
        System.out.print("Brancas: ");
        System.out.print(ANSI_WHITE);
        System.out.println(Arrays.toString(white.toArray()));
        System.out.print(ANSI_RESET);
        System.out.print("Pretas: ");
        System.out.print(ANSI_YELLOW);
        System.out.println(Arrays.toString(black.toArray()));
        System.out.print(ANSI_RESET);
    }
}
