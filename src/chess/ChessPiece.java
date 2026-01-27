package chess;

import boardgame.Board;
import boardgame.Piece;
//	20- Criamos uma Subclasse de Piece e vai ter a Cor e outros elementos, ela herda as peças do tabuleiro
public class ChessPiece extends Piece {
	private Color color;
	//	21- Criando um construtor porque a classe ChessPiece é uma Subclasse e na classe mãe ela já usa o construtor
	public ChessPiece(Board board, Color color) {
		//	22- Repassa o super(board) para a superclasse uma vez que ele herdou
		super(board);
		//	Colocamos o this, dizendo que ele recebe o color
		this.color = color;
	}
	//	23 - Colocamos simplesmente o getColor para que a cor não seja modificada mas simplesmente acessada
	public Color getColor() {
		return color;
	}
	
	
}
