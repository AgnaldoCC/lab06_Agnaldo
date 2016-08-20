package lp2.lab06;

public class Veterano extends Usuario {

	public Veterano(String nome, String nomeLogin, int x2p) throws Exception {
		super(nome, nomeLogin, 0, 1000);

	}

	public void compraJogo(Jogo jogo) throws Exception {
		if (jogo == null) {
			throw new Exception("Jogo nao pode ser nulo");
		}

		if (this.dinheiro < (jogo.getPreco() - (jogo.getPreco() * 0.2))) {
			throw new Exception("Dinheiro insuficiente para comprar esse jogo");
		}

		this.jogos.add(jogo);

		int qntX2p = (int) jogo.getPreco() * 15;

		this.adicionaX2p(qntX2p);

	}

	public String toString() {
		return nomeLogin + "\n" + nome + " - Jogador Veterano";
	}
	
	
}
