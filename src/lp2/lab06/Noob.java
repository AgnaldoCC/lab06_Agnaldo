package lp2.lab06;

import exception.JogoInvalidoException;
import exception.ValorException;

/**
 * 
 * @author Agnaldo Junior
 *
 */


public class Noob extends Usuario {

	public Noob(String nome, String nomeLogin) throws Exception {
		super(nome, nomeLogin, 0);
		super.desconto = 0.1;
	}
	
	/**
	 * Recebe um jogo e se o usuário possuir saldo suficiente, compra.
	 * 
	 * @param jogo
	 *            Jogo a ser comprado
	 * @throws Exception
	 */
	
	public void compraJogo(Jogo jogo) throws Exception {
		if (jogo == null) {
			throw new JogoInvalidoException("Jogo nao pode ser nulo");
		}

		if (this.dinheiro < (jogo.getPreco() - (jogo.getPreco() * getDesconto()))) {
			throw new ValorException("Dinheiro insuficiente para comprar esse jogo");
		}

		this.jogos.add(jogo);

		int qntX2p = (int) jogo.getPreco() * 10;

		this.adicionaX2p(qntX2p);
		
		setDinheiro(getDinheiro() - (jogo.getPreco() - (jogo.getPreco() * desconto)));


	}

	public String toString() {
		String noob = getNomeLogin() + "\n" + getNome() + " - Jogador Noob\n" + "Lista de jogos:\n";
		for (Jogo jogo : jogos) {
			noob += jogo.toString() + "\n";
		}
		noob += "\nTotal de preco dos jogos: R$ " + String.format("%.2f", getPrecoTotal())
				+ "\n\n--------------------------------------------\n\n";
		return noob;
	}

}
