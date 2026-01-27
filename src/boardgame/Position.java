//	Pacote correspondente a camada de tabuleiro
package boardgame;
//	1- Primeira classe do nosso sistema, ela terá linha e coluna
public class Position {
	private int row;
	private int column;
	//2-	Construtor de row e column
	public Position(int row, int column) {
		this.row = row;
		this.column = column;
	}
	//3- Getters and Setters
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}	
	//	4- Criamos um toString para imprimir os valores na tela
	@Override
	public String toString() {
		return row  + ", " + column;
	}
}
