package lp2.lab06;

public class Veterano extends Usuario {

	public Veterano(String nome, String nomeLogin, int x2p) throws Exception {
		super(nome, nomeLogin, 0, 1000);
		this.desconto = 0.2;
	}

	public void compraJogo(Jogo jogo) throws Exception {
		super.compraJogo(jogo);
		int qntX2p = (int)jogo.getPreco() * 15;
		this.setX2p(this.x2p + qntX2p);
	}
}
