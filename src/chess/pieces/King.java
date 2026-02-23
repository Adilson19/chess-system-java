package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;
//	49- Criando uma classe King para a torre como subpacote, vai herdar de ChessPiece
public class King extends ChessPiece {
	//	50- Criamos um construtor que vai receber o tabuleiro e a cor
	public King(Board board, Color color) {
		//	51- Criamos uma chamada para a super classe
		super(board, color);
	}

	//	52- Criamos um toString para imprimir o K
	@Override
	public String toString() {
		return "K";
	}
	
	//	201- Metodo para saber se o rei pode mover para uma posicao
	private boolean canMove(Position position) {
		//	202- Pegando a peca que esta na posicao
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		//	203- Verificando se a peca nao eh nula e nao eh adversario
		return p == null || p.getColor() != getColor();
	}
	
	//	147- implementamos os metodos abstract como Sobreposição de métodos
	@Override
	public boolean[][] possibleMoves() {
		//	148- Criando as possiveis movimentações do Rei - criamos uma matriz de Booleanos da mesma dimensão do tabuleiro
		boolean[][] mat= new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		//	204- Movimentos possiveis de um rei - Posicao inicial
		Position p = new Position(0,0);
		
		//	205- Acima
		p.setValues(position.getRow() - 1, position.getColumn());
		//	206- Testando
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//	207- Abaixo
		p.setValues(position.getRow() + 1, position.getColumn());
		//	208- Testando
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//	207- Esquerda
		p.setValues(position.getRow(), position.getColumn() - 1);
		//	208- Testando
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//	209- Direita
		p.setValues(position.getRow(), position.getColumn() + 1);
		//	210- Testando
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//	211- Noroeste
		p.setValues(position.getRow() - 1, position.getColumn() - 1);
		//	212- Testando
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//	213- Nordeste
		p.setValues(position.getRow() - 1, position.getColumn() + 1);
		//	214- Testando
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
			
		//	215- sudoeste
		p.setValues(position.getRow() + 1, position.getColumn() - 1);
		//	216- Testando
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//	217- Sudeste
		p.setValues(position.getRow() + 1, position.getColumn() + 1);
		//	218- Testando
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
	
		//	149- Retornando a matriz
		return mat;
	}
}
