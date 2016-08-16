package lp2.lab06;

public class Luta extends Jogo{
	public Luta(String nome, double preco) throws Exception{
		super(nome, preco);
		if (nome == null || nome.isEmpty()) {
			throw new Exception("Nome do jogo não pode ser nulo ou vazio");
		}

		if (preco < 0) {
			throw new Exception("Preco do jogo não pode ser negativo");
		}
	}

}
