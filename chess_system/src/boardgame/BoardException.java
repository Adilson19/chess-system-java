package boardgame;
//	55- É uma classe que herda de RuntimeException que indica que pode ser rodada opcionalmente
public class BoardException extends RuntimeException{
	//	56- Default
	private static final long serialVersionUID = 1L;
	//	57- Temos um simples construtor que repassa a mensagem para a Super classe RuntimeException
	public BoardException(String msg) {
		super(msg);
	}
}
