package lp2.lab06;

/**
 * 
 * @author Agnaldo Junior
 *
 */

public class RPG extends Jogo {
	
	public final int TAXAX2P = 10;
	
	/**
	 * Subclasse de Jogo, do tipo RPG.
	 * 
	 * @param nome
	 *            Nome do jogo.
	 * @param preco
	 *            Preço do jogo.
	 * @throws Exception
	 */

	public RPG(String nome, double preco) throws Exception {
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
		if(score > getMaiorScore()){
			setMaiorScore(score);
		}
		
		if (zerou){
			zerouJogo += 1;
		}
		
		qtdJogada += 1;		
		return TAXAX2P;
	}
	
	public String toString() {
		return "+ " + getNome() + " - " + "RPG:\n" + "==> Jogou " + getQtdJogada() + " vez(es)\n" + "==> Zerou "
				+ getZerouJogo() + " vez(es)\n" + "==> Maior score: " + getMaiorScore();
	}

}