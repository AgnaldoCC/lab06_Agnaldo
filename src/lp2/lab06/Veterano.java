package lp2.lab06;

public class Veterano extends Usuario {

	public Veterano(String nome, String nomeLogin, double dinheiro, int x2p) {
		super(nome, nomeLogin, dinheiro, 1000);
	}

	public void compraJogo(Usuario veterano, Jogo jogo) throws Exception {
		double atual = veterano.getDinheiro();
		double precoVeterano = jogo.getPreco() - (jogo.getPreco() * 0.2);
		if (atual >= precoVeterano) {
			veterano.adicionaJogo(jogo);
			veterano.setDinheiro(atual - precoVeterano);
		}

		else {
			throw new Exception("Dinheiro insuficiente");
		}
	}

	public void adicionaX2P(Usuario veterano, Jogo jogo) {
		int atual = veterano.getX2p();
		int precoJogo = (int) jogo.getPreco();
		int x2pVeterano = precoJogo * 15;
		veterano.setX2p(atual + x2pVeterano);
	}
}
