package boardgame;

public abstract class Piece {
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
	
	//	137- criação de uma classe abstrata para descrever os possiveis movimentos
	public abstract boolean[][] possibleMoves();
	//	138- Chamando um metodo que irah dizer se é posiivel mover uma determinada peçade uma posição para outra, para tal usamos o metodo possibleMoves
	public boolean possibleMove(Position position) {
		//	139- Retornando possibleMove que é um metodo retornando em uma matriz colocando a posição da coluna e da linha, método concreto que está usando um método abstracto
		return possibleMoves()[position.getRow()][position.getColumn()];
	}
	
	//	140- Vai contar se existe pelo menos um movimento possível para uma determinada peça
	public boolean isThereAnyPossibleMove() {
		//	141- Vamos chamar novamente o método abstract possibleMoves, declarando uma variavel do tipo boolean contendo uma matriz
		boolean [][] mat = possibleMoves();
		//	142- Vamos percorrer essa matriz para verificar se existe pelo menos uma posição da matriz que seja verdadeira 
		for(int i=0; i<mat.length; i++) {
			for(int j=0; j<mat.length; j++) {
		//	143- Testando os valores percorridos para saber o resultado				
				if(mat[i][j]) {
					//	144- Caso o resultado seja verdadeiro
					return true;
				}
			}
		}
		//	145- Caso o resultado seja falso
		return false;
	}
}
