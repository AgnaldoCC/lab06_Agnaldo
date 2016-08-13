package lp2.lab06;

public class Noob extends Usuario {

	public Noob(String nome, String nomeLogin, double dinheiro) {
		super(nome, nomeLogin, dinheiro);

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
}