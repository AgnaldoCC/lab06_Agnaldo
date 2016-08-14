package lp2.lab06;

public class Noob extends Usuario {

	public Noob(String nome, String nomeLogin, double dinheiro, int x2p) {
		super(nome, nomeLogin, dinheiro, 0);

	}

	public void compraJogo(Usuario noob, Jogo jogo) throws Exception {
		double atual = noob.getDinheiro();
		double precoNoob = jogo.getPreco() - (jogo.getPreco() * 0.1);
		if (atual >= precoNoob) {
			noob.adicionaJogo(jogo);
			noob.setDinheiro(atual - precoNoob);
		}

		else {
			throw new Exception("Dinheiro insuficiente");
		}
	}

	public void adicionaX2P(Usuario noob, Jogo jogo) {
		int atual = noob.getX2p();
		int precoJogo = (int) jogo.getPreco();
		int x2pNoob = precoJogo * 10;
		noob.setX2p(atual + x2pNoob);
	}
}