package chess;

import boardgame.Position;
//	76-	classe que vai receber a posição da peça no tabuleiro através das linhas e colunas
public class ChessPosition {
	//	77-	Argumentos, sistema de coordenadas
	private char column;
	private int row;
	//	78- Criando um construtor de coluna e linha
	public ChessPosition(char column, int row) {
		//	80-	Programação defensiva - nesse caso vamos comparar se a peça está entre os limites que são de A à H e de 1 à 8
		if(column < 'a' || column > 'h' || row < 1 || row > 8) {
			//	81-	Se acontecer alguma das coisas mencionadas na linha anterior, então deve alertar sobre a existência de uma peça fora do taboleiro
			throw new ChessException("Error instantiating ChessPosition. Valid values are from a1 to h8.");
		}
		//	79- Colocando os atributos pronto para serem utilizados
		this.column = column;
		this.row = row;
	}
	//	82- Colocamos simplesmente os Getters porque com o Set o sistema seria muito fácil de haquear
	public char getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}
	//	83- Colocando o position a retornar os valores. Ele será o responsável por converter a ChessPosition em Position normal
	protected Position toPosition() {
 		//	84-	Colocando esses dados na matriz em que a linha da matriz é 8 menos a linha do xadrez
		return new Position(8 - row, column - 'a');
	}
	//	85- Criando a operação inversa que deve ser protected e estatic - 
	protected static ChessPosition fromPosition(Position position) {
		//	86- vamos colocar um cast para retornar a coluna inversa
		return new ChessPosition((char)('a' - position.getColumn()), 8 - position.getRow());
	};
	//	87-	Criamos o toString para imprimir a posição do xadrez
	@Override
	public String toString() {
		return "" + column + row;// "" -> usamos para forcar o compilador para concatenar
	}
}
