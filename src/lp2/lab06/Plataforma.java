package lp2.lab06;

public class Plataforma extends Jogo {

	public final int TAXA_X2P_PLATAFORMA = 20;

	public Plataforma(String nome, double preco) throws Exception {
		super(nome, preco);
	}

	@Override
	public int registraJogada(int score, boolean zerou) {
		if (zerou) {
			return TAXA_X2P_PLATAFORMA;
		}
		return 0;
	}
}
