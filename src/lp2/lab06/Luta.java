package lp2.lab06;

import exception.ValorException;

public class Luta extends Jogo {

	private final int SCORE_MAX = 100000;

	public Luta(String nome, double preco) throws Exception {
		super(nome, preco);
	}

	@Override
	public int registraJogada(int score, boolean zerou) throws Exception {
		if (score > SCORE_MAX) {
			throw new ValorException("Score ultrapassou o maximo");
		}
		int X2P = 0;
		if (score > getMaiorScore()) {
			setMaiorScore(score);
			X2P += (score / 1000) * 1;
		}
		if (zerou) {
			zerouJogo += 1;
		}
		qtdJogada += 1;
		return X2P;
	}

	public String toString() {
		return "+ " + getNome() + " - " + "Luta:\n" + "==> Jogou " + getQtdJogada() + " vez(es)\n" + "==> Zerou "
				+ getZerouJogo() + " vez(es)\n" + "==> Maior score: " + getMaiorScore();
	}
}
