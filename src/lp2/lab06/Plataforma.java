package lp2.lab06;

public class Plataforma extends Jogo {

	public final int TAXA_X2P_PLATAFORMA = 20;

	public Plataforma(String nome, double preco) throws Exception {
		super(nome, preco);
	}

	@Override
	public int registraJogada(int score, boolean zerou) {
		if (score > getMaiorScore()) {
			setMaiorScore(score);
		}
		qtdJogada += 1;
		if (zerou) {
			zerouJogo += 1;
			return TAXA_X2P_PLATAFORMA;
		}
		return 0;
	}

	public String toString() {
		return "+ " + getNome() + " - " + "Plataforma:\n" + "==> Jogou " + getQtdJogada() + " vez(es)\n" + "==> Zerou "
				+ getZerouJogo() + " vez(es)\n" + "==> Maior score: " + getMaiorScore();
	}
}
