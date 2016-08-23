package lp2.lab06;

import java.util.HashSet;

import enums.Estilos;
import exception.StringNulaOuVaziaException;
import exception.ValorException;

public abstract class Jogo {
	private String nome;
	private double preco;
	private int maiorScore;
	protected int qtdJogada;
	protected int zerouJogo;
	protected HashSet<Estilos> estilos;

	public Jogo(String nome, double preco) throws Exception {
		if (nome == null || nome.trim().isEmpty()) {
			throw new StringNulaOuVaziaException("Nome do jogo nao pode ser nulo ou vazio");
		}

		if (preco < 0) {
			throw new ValorException("Preco do jogo nao pode ser negativo");
		}
		this.nome = nome;
		this.preco = preco;
		this.maiorScore = 0;
		this.qtdJogada = 0;
		this.zerouJogo = 0;
		estilos = new HashSet<Estilos>();
	}

	public void adicionaEstilo(Estilos novoEstilo) {
		estilos.add(novoEstilo);
	}

	public String getNome() {
		return nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getMaiorScore() {
		return maiorScore;
	}

	public void setMaiorScore(int maiorScore) {
		this.maiorScore = maiorScore;
	}

	public int getQtdJogada() {
		return qtdJogada;
	}

	public int getZerouJogo() {
		return zerouJogo;
	}

	public abstract int registraJogada(int score, boolean zerou) throws Exception;

	public abstract String toString();

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(preco);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof Jogo)) {
			return false;
		}
		Jogo jogo = (Jogo) obj;
		if (getNome().equals(jogo.getNome())) {
			return true;
		}
		return false;
	}

}
