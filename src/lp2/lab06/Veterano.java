package lp2.lab06;

import exception.JogoInvalidoException;
import exception.ValorException;

/**
 * 
 * @author Agnaldo Junior
 *
 */


public class Veterano extends Usuario {
	
	/**
	 * Define o X2P em 1000 e o desconto em 20%.
	 * 
	 * @param nome
	 *            Nome do usuario.
	 * @param nomeLogin
	 *            Nome unico do usuario.
	 * @throws Exception
	 */
	
	public Veterano(String nome, String nomeLogin) throws Exception {
		super(nome, nomeLogin, 1000);
		super.desconto = 0.2;

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

		int qntX2p = (int) jogo.getPreco() * 15;

		this.adicionaX2p(qntX2p);
		
		setDinheiro(getDinheiro() - (jogo.getPreco() - (jogo.getPreco() * desconto)));


	}

	public String toString() {
		String veterano = getNomeLogin() + "\n" + getNome() + " - Jogador Veterano\n" + "Lista de jogos:\n";
		for (Jogo jogo : jogos) {
			veterano += jogo.toString() + "\n";
		}
		veterano += "\nTotal de preco dos jogos: R$ " + String.format("%.2f", getPrecoTotal())
				+ "\n\n--------------------------------------------\n\n";
		return veterano;
	}
	
	
}
