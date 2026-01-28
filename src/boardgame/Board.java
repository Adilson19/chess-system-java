package boardgame;

public class Board {
	// 10- Um tabuleiro tem a quantidade de linhas e colunas
	private int rows;
	private int columns;
	// 11- Matriz de peças
	private Piece[][] pieces;
	//	12- O construtor vai apenas receber a quantidade de linhas e colunas
	public Board(int rows, int columns) {
		if(rows < 1 || columns < 1) {
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
		}
		this.rows = rows;
		this.columns = columns;
		//	13- Instanciando a matriz
		pieces = new Piece[rows][columns];
	}
	//	14 - A classe Board não vai retornar a Matriz inteira mas sim uma peça por vez
	public int getRows() {
		return rows;
	}
	
	public int getColumns() {
		return columns;
	}
	//	15- Metodo para retornar a peça dada uma linha e uma coluna	
	public Piece piece(int row, int column) {
		if(!positionExists(row, column)) {
			throw new BoardException("Position not on the board");
		}
		//	16- Vai retornar a matriz piece na linha row e na coluna column
		return pieces[row][column];
	}
	//	17- Sobrecarga do método Piece - só que dessa vez Position position e vai retornar a peça pela posição
	public Piece piece(Position position) {
		//	18- Vai retornar a matriz piece na posição
		return pieces[position.getRow()][position.getColumn()];
	}
	//	42- Criamos o metodo placePiece que é o responsável por colocar a peça na posição indicada no tabuleiro
	public void placePiece(Piece piece, Position position) {
		//	
		if(thereIsAPiece(position)) {
			throw new BoardException("There is already a piece on position " + position);
		}
		//	43- Vai pegar na matriz de peças na posição dada e colocar os valores que vieram no metodo como argumento
		pieces[position.getRow()][position.getColumn()] = piece;
		//	44- Vai pegar na posição que é nula e vai atribuir o valor da posição que nos foi dada como argumento
		piece.position = position;
	}
	
	public Piece removePiece(Position position) {
		//	Programacao defensiva lancando uma excessao
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		if(piece(position) == null) {
			return null;
		}
		Piece aux = piece(position);
		aux.position = null;
		pieces[position.getRow()][position.getColumn()] = null;
		return aux;
	}
	//	58- positionExists
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());		
	}
	
	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return piece(position) != null;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
