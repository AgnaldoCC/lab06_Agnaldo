package lp2.lab06;

public class RPG extends Jogo {

	public RPG(String nome, double preco) throws Exception {
		super(nome, preco);
		if (nome == null || nome.isEmpty()) {
			throw new Exception("Nome do jogo não pode ser nulo ou vazio");

		}
		if (preco < 0) {
			throw new Exception("Preco do jogo não pode ser negativo");
		}
	}

	public int pegaX2p(Usuario usuario) {
		int vezesJogadas = this.getQtdJogada();
		int x2p = vezesJogadas * 10;
		return x2p;
	}
	
	public void registraJogada(int score, boolean zerou){
		
	}

}