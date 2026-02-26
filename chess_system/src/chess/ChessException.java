package chess;
import boardgame.BoardException;
//	72- Criamos a classe ChessException herdando de BoardException 
public class ChessException extends BoardException{
	//	73-	Numero de serial padrão
	private static final long serialVersionUID = 1L;
	//	74-	Metodo para repassar a mensagem da classe herdada para a SuperClasse
	public ChessException(String msg) {
		//	75- Esse super(msg) é o responsável por levar os dados dessa classe herdada para a classe principal
		super(msg);
	}
}
