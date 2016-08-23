package lp2.lab06;

/**
 * 
 * @author Agnaldo Junior
 *
 */

public class Plataforma extends Jogo {

	public final int TAXA_X2P_PLATAFORMA = 20;
	
	/**
	 * Subclasse de Jogo, do tipo Plataforma.
	 * 
	 * @param nome
	 *            Nome do jogo.
	 * @param preco
	 *            Preço do jogo.
	 * @throws Exception
	 */

	public Plataforma(String nome, double preco) throws Exception {
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
