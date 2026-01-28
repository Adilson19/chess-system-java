package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;
//	49- Criando uma classe King para a torre como subpacote, vai herdar de ChessPiece
public class King extends ChessPiece {
	//	50- Criamos um construtor que vai receber o tabuleiro e a cor
	public King(Board board, Color color) {
		//	51- Criamos uma chamada para a super classe
		super(board, color);
	}

	//	52- Criamos um toString para imprimir o K
	@Override
	public String toString() {
		return "K";
	}
}
