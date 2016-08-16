package lp2.lab06;

public class Noob extends Usuario {

	public Noob(String nome, String nomeLogin, int x2p) throws Exception {
		super(nome, nomeLogin, 0, 0);
		this.desconto = 0.1;

	}

	public void compraJogo(Jogo jogo) throws Exception {
		super.compraJogo(jogo);
		int qntX2p = (int)jogo.getPreco() * 10;
		this.setX2p(this.x2p + qntX2p);

	}
}