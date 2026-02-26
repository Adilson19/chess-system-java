package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
//	20- Criamos uma Subclasse de Piece e vai ter a Cor e outros elementos, ela herda as peças do tabuleiro
//	146- Transformamos a Subclasse de Piece em uma Subclasse abstract porque o Piece tambem o eh e a Class ChessPiece é muito genérica para assumir os metodos abstratos também
public abstract class ChessPiece extends Piece {
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
	//	155- Essa operação será reaproveitada em todas as outras peças.
	//protected - mesmo pacote e subclasses que são as peças
	protected boolean isThereOpponentPiece(Position position) {
		//	Verificando se existe uma peça adversária na posição
		//	156- Pegando a peça que está em determinada posição
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		//	157- Testando se o P é diferente de null e se a cor é diferente da cor da peça, uma peça adversária nesse caso
		return p != null && p.getColor() != color;		
	}
}
