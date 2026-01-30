package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rock;
//	24- Criamos a classe ChessMatch que é o coração do nosso sistema, aqui é onde vamos colocar as regras do Xadrez
public class ChessMatch {
	//	25- Declaramos o atributo board da Classe Board, porque a partida tem que ter um tabuleiro
	private Board board;
	//	26- Criamos o construtor ChessMatch para mostrar em quais condições deve começar um jogo
	public ChessMatch() {
		//	27- Deve começar com 8 - row por 8 - column
		board = new Board(8, 8);
		initialSetup();
	}
	//	28- O método ChessPiece deve retornar uma matriz de Xadrez correspondente a partida
	public ChessPiece[][] getPieces(){
		//	29- Criando uma variavel temporária - vai ter a quantidade de linhas e colunas do tabuleiro
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		//	30-	Percorrendo a matriz de piece e para cada fazemos um DownCast
		for(int i = 0; i<board.getRows(); i++) {
			for(int j = 0; j<board.getColumns(); j++) {
				//	31-	Fazendo um Downcast para (ChessPiece)
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		//	32- Retornando a matriz de peças
		return mat;
	}
	//	109- Metodo para mover a peça, recebe a origem e o destino
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		//	110- Convertendo as posições das peças para posições da matriz
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		//	111- Validando a posição de origem
		validateSourcePosition(source);
		//	112- Declaramos uma variavel do tipo Piece e ela vai receber o metodo para realizar um movimento de um ponto para outro
		Piece capturedPiece = makeMove(source, target);
		//	113- Retorna a peça capturada e fazemos um downcast porque o capturedPiece era do tipo Piece e ele agora vai retornar um tipo ChessPiece
		return (ChessPiece) capturedPiece;
	}
	//	117- Metodo para fazer um movimento
	private Piece makeMove(Position source, Position target) {
		//	118- Criamos uma varivel p do tipo Piece que vai chamar o método removePiece com o argumento source(Origem)
		Piece p = board.removePiece(source);
		//	119- Criamos o capturedPiece que vai chamar o metodo removePiece da Class board(tabuleiro) com o argumento target(Destino)
		Piece capturedPiece = board.removePiece(target);
		//	120- colocando a peça da posição de Origem (que havia sido capturada) para a posição de Destino (Target)
		board.placePiece(p, target);
		//	121- retornando o capturedPiece
		return capturedPiece;
	}
	//	114- Criamos um metodo para validar a origem 
	private void validateSourcePosition(Position position) {
		//	115- Testando se não existe uma peça nessa posição
		if(!board.thereIsAPiece(position)) {
			//	116- Caso não exista
			throw new ChessException("There is no piece on source position");
		}
	}
	//	88- Criamos o método placeNewPiece para receber as coordenadas do xadrez e a peça
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		//		89- Pegamos o metodo que sabe o local da peça, criamos uma nova posição e convertemos para posição de matriz(toString)
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	//	53- Criamos um metodo responsável por criar as peças no tabuleiro
	private void initialSetup() {
		
		//	Nova maneira de percorrer...
		//	90- Colocando as peças na devida posição
		placeNewPiece('c', 1, new Rock(board, Color.WHITE));
        placeNewPiece('c', 2, new Rock(board, Color.WHITE));
        placeNewPiece('d', 2, new Rock(board, Color.WHITE));
        placeNewPiece('e', 2, new Rock(board, Color.WHITE));
        placeNewPiece('e', 1, new Rock(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rock(board, Color.BLACK));
        placeNewPiece('c', 8, new Rock(board, Color.BLACK));
        placeNewPiece('d', 7, new Rock(board, Color.BLACK));
        placeNewPiece('e', 7, new Rock(board, Color.BLACK));
        placeNewPiece('e', 8, new Rock(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
		
		//	Antiga maneira de percorrer....
		//	54- Colocando as peças na devida posição
		//board.placePiece(new King(board, Color.WHITE), new Position(7, 4));
	}
}
