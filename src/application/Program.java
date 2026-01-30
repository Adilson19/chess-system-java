package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//	33- Instanciando uma partida de xadrez e imprimindo ela
		ChessMatch chessMatch = new ChessMatch();
		//	122- Vai repetir indefinidamente enquanto não haver uma lógica para CheckMate
		while(true) {
			//	130- Colocando o try para testar se há alguma exceção
			try {
				//	129- Chamamos o método clearScreen de UI para limpar a tela
				UI.clearScreen();
				//	34- método para imprimir as peças da partida
				UI.printBoard(chessMatch.getPieces());
				//	123- Para pular uma linha
				System.out.println();
				//	124- Para digitar a Origem
				System.out.print("Source: ");
				//	125- Para ler o valor digitado
				ChessPosition source = UI.readChessPosition(sc);

				System.out.println();
				//	126- Para digitar o Destino
				System.out.print("Target: ");
				//	127- Para ler o valor digitado
				ChessPosition target = UI.readChessPosition(sc);
								
				//	128- Movendo da Origem para o Destino
				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
			}
			//	131- Condidicional para o jogo
			catch(ChessException e){
				//	132- Vai imprimir na tela 
				System.out.println(e.getMessage());
				//	133- Vai aguardar o usuário primir qualquer tela
				sc.nextLine();
			}
			//	134- Condicional
			catch(InputMismatchException e) {
				//	135- Vai imprimir na tela
				System.out.println(e.getMessage());
				//	136- Vai aguardar o usuário primir qualquer tela
				sc.nextLine();
			}
		}		
	}

}
