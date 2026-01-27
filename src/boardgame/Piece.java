package boardgame;

public class Piece {
	//	5- Position está protected, não é uma posição de xadrez mas sim uma posição simples da matriz, não estará visível na camada de xadrez
	protected Position position;
	// 6- Criamos a classe tabuleiro(board) porque o position tem uma associocao com as peças(piece)
	private Board board;
	//	7- Construtor da peça(piece)
	public Piece(Board board) {
		this.board = board;
		//	8- Posição de uma peça recém criada é nula
		position = null;
	}
	//	9- Para retornar o Board - ele é protected, somete classe do mesmo pacote e subclasses é que poderão aceder a esse método.
	protected Board getBoard() {
		return board;
	}		
}
