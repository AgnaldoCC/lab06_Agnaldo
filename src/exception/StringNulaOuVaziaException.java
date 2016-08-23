package exception;

public class StringNulaOuVaziaException extends Exception{
	private String mensagem;
	
	public StringNulaOuVaziaException(String mensagem){
		this.mensagem = mensagem;
	}
	
	public String getMensagem(){
		return this.mensagem;
	}
}
