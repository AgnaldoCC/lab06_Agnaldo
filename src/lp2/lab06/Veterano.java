package lp2.lab06;

public class Veterano extends Usuario {

	public Veterano(String nome, String nomeLogin) throws Exception {
		super(nome, nomeLogin, 1000);
		super.desconto = 0.2;

	}

	public void compraJogo(Jogo jogo) throws Exception {
		if (jogo == null) {
			throw new Exception("Jogo nao pode ser nulo");
		}

		if (this.dinheiro < (jogo.getPreco() - (jogo.getPreco() * getDesconto()))) {
			throw new Exception("Dinheiro insuficiente para comprar esse jogo");
		}

		this.jogos.add(jogo);

		int qntX2p = (int) jogo.getPreco() * 15;

		this.adicionaX2p(qntX2p);
		
		setDinheiro(getDinheiro() - (jogo.getPreco() - (jogo.getPreco() * desconto)));


	}

	public String toString() {
		String veterano = getNomeLogin() + "\n" + getNome() + " - Jogador Veterano\n" + "Lista de jogos:\n";
		for (Jogo jogo : jogos) {
			veterano += jogo.toString() + "\n";
		}
		veterano += "\nTotal de preco dos jogos: R$ " + String.format("%.2f", getPrecoTotal())
				+ "\n\n--------------------------------------------\n\n";
		return veterano;
	}
	
	
}
