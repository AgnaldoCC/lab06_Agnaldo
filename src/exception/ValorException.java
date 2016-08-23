package exception;

public class ValorException extends Exception{
	
	private String mensagem;
	
	public ValorException(String mensagem){
		this.mensagem = mensagem;
	}
	
	public String getMensagem(){
		return this.mensagem;
	}
	
}
