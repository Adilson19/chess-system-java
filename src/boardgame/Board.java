package boardgame;

public class Board {
	// 10- Um tabuleiro tem a quantidade de linhas e colunas
	private int rows;
	private int columns;
	// 11- Matriz de peças
	private Piece[][] pieces;
	//	12- O construtor vai apenas receber a quantidade de linhas e colunas
	public Board(int rows, int columns) {
		//	64- Colocando condições para lançar uma exeção
		if(rows < 1 || columns < 1) {
			//	65- Exceção para mostrar que há erro ao criar tabuleiro dizendo que é necessário uma linha ou uma coluna
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
		//	66- Testando: se a posição na linha e coluna indicada não existe então vai lançar uma exceção
		if(!positionExists(row, column)) {
			//	67- Lançando uma nova BoardException contendo a informação de que a posição não está no tabuleiro
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
		//	68- Testando novamente mas dessa vez de acordo a posição
		if(thereIsAPiece(position)) {
			//	69- Se há na verdade uma posição então ela vai imprimir
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
	//	59- positionExists pela linha e pela coluna
	private boolean positionExists(int row, int column) {
		//	60- Verificando se a posição está correta de acordo a linha e a coluna
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	//	58- positionExists pela posição das peças
	public boolean positionExists(Position position) {
		//	61- reaproveitamos o método de cima para testar se a posição existe baseando-se na posição apartir da linha e da coluna
		return positionExists(position.getRow(), position.getColumn());		
	}
	//	62- Metodo que irá receber uma posição, vamos testar se tem uma peça nessa posição
	public boolean thereIsAPiece(Position position) {
		//	70- Faz o teste se realmente existe uma peça na posição
		if(!positionExists(position)) {
			//	71- Testamos se há peça no tabuleiro de acordo a posição
			throw new BoardException("Position not on the board");
		}
		//	63- Se tiver uma peça diferente de nula, vai retornar a posição dessa peça
		return piece(position) != null;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
