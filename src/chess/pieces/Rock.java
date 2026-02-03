package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;
//	45- Criando uma classe Rock para a torre como subpacote, vai herdar de ChessPiece
public class Rock extends ChessPiece{
	//	46- Criamos um construtor que vai receber o tabuleiro e a cor
	public Rock(Board board, Color color) {
		//	47- Criamos uma chamada para a super classe
		super(board, color);
	}
	//	48- Criamos um toString para imprimir o R
	@Override
	public String toString() {
		return "R";
	}
	
	//	150- implementamos os metodos abstract como Sobreposição de métodos
	@Override
	public boolean[][] possibleMoves() {
		//	151- Criando as possiveis movimentações do Rei - criamos uma matriz de Booleanos da mesma dimensão do tabuleiro
		boolean[][] mat= new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		//	Implementando os movimentos possiveis da torre
		//	158- Testando os pontos ou casas livres		
		Position p = new Position(0,0);
		//	159- Verificando acima da peça
		p.setValues(position.getRow() - 1, position.getColumn());
		//	161- Enquanto a posição P existir e não tiver uma peça nessa posição
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			//	162- Enquanto a posição estiver vaga marca a posição como verdardeira
			mat[p.getRow()][p.getColumn()] = true;
			//	163-  Fazendo a linha dessa posição andar mais para cima
			p.setRow(p.getRow() - 1);
		}
		//	164- Testando se temos que marcar mais a peça adversária - caso tenha uma peça adversária
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			//	165- Se for verdade vai marcar a peça novamente
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//	166- Verificando a esquerda da peça
		p.setValues(position.getRow(), position.getColumn() - 1);
		//	167- Enquanto a posição P existir e não tiver uma peça nessa posição
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			//	168- Enquanto a posição estiver vaga marca a posição como verdardeira
			mat[p.getRow()][p.getColumn()] = true;
			//	169-  Fazendo a linha dessa posição andar mais para cima
			p.setColumn(p.getColumn() - 1);
		}
		//	170- Testando se temos que marcar mais a peça adversária - caso tenha uma peça adversária
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			//	171- Se for verdade vai marcar a peça novamente
			mat[p.getRow()][p.getColumn()] = true;
		}
			
		//	172- Verificando a direita da peça
		p.setValues(position.getRow(), position.getColumn() + 1);
		//	173- Enquanto a posição P existir e não tiver uma peça nessa posição
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			//	174- Enquanto a posição estiver vaga marca a posição como verdardeira
			mat[p.getRow()][p.getColumn()] = true;
			//	175-  Fazendo a linha dessa posição andar mais para cima
			p.setColumn(p.getColumn() + 1);
		}
		//	176- Testando se temos que marcar mais a peça adversária - caso tenha uma peça adversária
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			//	177- Se for verdade vai marcar a peça novamente
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//	178- Verificando abaixo da peça
		p.setValues(position.getRow() + 1, position.getColumn());
		//	179- Enquanto a posição P existir e não tiver uma peça nessa posição
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			//	180- Enquanto a posição estiver vaga marca a posição como verdardeira
			mat[p.getRow()][p.getColumn()] = true;
			//	181-  Fazendo a linha dessa posição andar mais para cima
			p.setRow(p.getRow() + 1);
		}
		//	182- Testando se temos que marcar mais a peça adversária - caso tenha uma peça adversária
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			//	183- Se for verdade vai marcar a peça novamente
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//	152- Retornando a matriz
		return mat;
	}
}
