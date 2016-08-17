package lp2.lab06;

public class RPG extends Jogo {

	public final int TAXAX2P = 10;

	public RPG(String nome, double preco) throws Exception {
		super(nome, preco);
	}

	@Override
	public int registraJogada(int score, boolean zerou) {
		return TAXAX2P;
	}

}