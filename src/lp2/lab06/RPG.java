package lp2.lab06;

public class RPG extends Jogo {

	public final int TAXAX2P = 10;

	public RPG(String nome, double preco) throws Exception {
		super(nome, preco);
	}

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