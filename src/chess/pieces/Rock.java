package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;
//	45- Criando uma classe Rock para a torre como subpacote, vai herdar de ChessPiece
public class Rock extends ChessPiece{
	//	46- Criamos um construtor que vai receber o tabuleiro e a cor
	public Rock(Board board, Color color) {
		//	47- Criamos uma chamada para a super classe
		super(board, color);
	}
	//	48- Criamos um toString para imprimir o R
	@Override
	public String toString() {
		return "R";
	}
	
	//	150- implementamos os metodos abstract como Sobreposição de métodos
	@Override
	public boolean[][] possibleMoves() {
		//	151- Criando as possiveis movimentações do Rei - criamos uma matriz de Booleanos da mesma dimensão do tabuleiro
		boolean[][] mat= new boolean[getBoard().getRows()][getBoard().getColumns()];
		//	152- Retornando a matriz
		return mat;
	}
}
