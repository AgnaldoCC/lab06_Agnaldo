package lp2.lab06;

import exception.ValorException;

/**
 * 
 * @author Agnaldo Junior
 *
 */

public class Luta extends Jogo {

	private final int SCORE_MAX = 100000;
	
	/**
	 * Subclasse de Jogo, do tipo Luta.
	 * 
	 * @param nome
	 *            Nome do jogo.
	 * @param preco
	 *            Preço do jogo.
	 * @throws Exception
	 */


	public Luta(String nome, double preco) throws Exception {
		super(nome, preco);
	}
	
	 /**
	 * Registra a jogada do jogo, verifica se ha um novo recorde de score, se o
	 * usuario zerou o jogo e aumenta quantas vezes o usuario jogou.
	 * 
	 * @param score
	 * 		Score conseguido com a jogada.
	 * @param zerou
	 * 		Indica se zerou o jogo ou não.
	 * @return
	 * 		Retorna a quantidade de X2P adequada.
	 */
	
	@Override
	public int registraJogada(int score, boolean zerou) throws ValorException {
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
