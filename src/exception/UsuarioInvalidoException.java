package exception;

public class UsuarioInvalidoException extends Exception{
	
	private String mensagem;
	
	public UsuarioInvalidoException(String mensagem){
		this.mensagem = mensagem;
	}
	
	public String getMensagem(){
		return this.mensagem;
	}
}
