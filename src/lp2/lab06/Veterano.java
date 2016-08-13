package lp2.lab06;

public class Veterano extends Usuario {
	
	public Veterano(String nome, String nomeLogin, double dinheiro){
		super(nome, nomeLogin, dinheiro);
	}
	
	public void compraJogo(Usuario veterano, Jogo jogo) throws Exception {
		double atual = veterano.getDinheiro();
		double precoVeterano = jogo.getPreco() - (jogo.getPreco() * 0.2);
		if (atual >= precoVeterano) {
			veterano.adicionaJogo(jogo);
			veterano.setDinheiro(atual - precoVeterano);
		}

		else {
			throw new Exception("Dinheiro insuficiente");
		}
	}
}
