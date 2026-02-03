package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;

public class UI {
	
	//	91- Códigos especiais para imprimir com cor
	
	// https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
	//	Cores do texto
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	//	Cores do fundo
	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
	
	//	Codigo para limpar a tela
	// https://stackoverflow.com/questions/2979383/java-clear-the-console
	// Source - https://stackoverflow.com/a/32295974
	// Posted by satish, modified by community. See post 'Timeline' for change history
	// Retrieved 2026-01-30, License - CC BY-SA 4.0
	//	129- Implementando um código para limpar a tela
	public static void clearScreen() {  
	    System.out.print("\033[H\033[2J");
	    System.out.flush();
	}  

	//	101- Método para ler a posição do usuário, faremos esse método receber o Scanner como parâmetro
	public static ChessPosition readChessPosition(Scanner sc) {
		//	106- Colocamos uma condição para caso ocorra uma exceção
		try {	
			//	102- vai receber primeiro um caracter
			String s = sc.nextLine();
			//	103- depois vai simplesmente converter essa string em um simples caracter
			char column = s.charAt(0);
			//	104- Recortando a linha apartir da posição 1 e converter para inteiro
			int row = Integer.parseInt(s.substring(1));
			//	105- Vai retornar o metodo com os valores da coluna e da linha
			return new ChessPosition(column, row);
		}
		//	107- Caso ocorrer vai retornar o seguinte
		catch(RuntimeException e) {
			//	108- Quer dizer que houve um erro ao digitar os dados
			throw new InputMismatchException("Error reading ChessPosition. Valid values are from a1 to h8.");
		}
	}
	//	35- Metodo estatico, vai receber como parámetro o ChessPiece para  impressão
	public static void printBoard(ChessPiece[][] pieces) {
		for(int i = 0; i<pieces.length; i++) {
			System.out.print((8 - i) + " ");
			for(int j = 0; j<pieces.length; j++) {
				//	40- Imprimindo a peça
				//	199- Colocamos o false para indicar que nenhuma peça é para ter o fundo colorido
				printPiece(pieces[i][j], false);
			}
			System.out.println();
		}
		//	41- Linha Especial para imprimir as letras
		System.out.println("  a b c d e f g h");
	}
	//	195- Outra versão do PrintBoard
	public static void printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves) {
		for(int i = 0; i<pieces.length; i++) {
			System.out.print((8 - i) + " ");
			for(int j = 0; j<pieces.length; j++) {
				// 40- Imprimindo a peça
				//	200- Colocamos o possibleMoves nas respectivas posições quando é para passar a cor também
				printPiece(pieces[i][j], possibleMoves[i][j]);
			}
			System.out.println();
		}
		//	41- Linha Especial para imprimir as letras
		System.out.println("  a b c d e f g h");
	}
	//	36- Método usado para imprimir as peças
	//	196- Atualizando os parametros colocando o boolean background
	private static void printPiece(ChessPiece piece, boolean background) {
		//	197- Testando se a variavel background é verdadeira
		if(background) {
			//	198- Colocando a cor de fundo de azul
			System.out.print(ANSI_BLUE_BACKGROUND);
		}
		//	37- Se as peças for igual a null então vai preencher com (-)
    	if (piece == null) {
            System.out.print("-");
        }//	38- Caso contrário vai imprimir a peça
        else {
        	//	92- Colocamos um código específico para imprimir as cores condicionalmente
            if (piece.getColor() == Color.WHITE) {
                System.out.print(ANSI_WHITE + piece + ANSI_RESET);
            }
            //	93- Caso não seja branca então será a amarela e no final dará um reset
            else {
                System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
            }
        }
    	//	39-	Para que as peças não fiquem muito juntas
        System.out.print(" ");
	}
}
