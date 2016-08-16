package lp2.lab06;

import java.util.HashSet;

public class Jogo {
	private String nome;
	private double preco;
	private int maiorScore;
	private int qtdJogada;
	private int zerouJogo;
	private HashSet<String> estilos;

	public Jogo(String nome, double preco) throws Exception {
		if (nome == null || nome.isEmpty()) {
			throw new Exception("Nome do jogo não pode ser nulo ou vazio");
		}

		if (preco < 0) {
			throw new Exception("Preco do jogo não pode ser negativo");
		}
		this.nome = nome;
		this.preco = preco;
		this.maiorScore = 0;
		this.qtdJogada = 0;
		this.zerouJogo = 0;
		estilos = new HashSet<String>();
	}

	public void adicionaEstilo(String novoEstilo) {
		estilos.add(novoEstilo);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public void setQtdJogada(int qtdJogada) {
		this.qtdJogada = qtdJogada;
	}

	public int getZerouJogo() {
		return zerouJogo;
	}

	public void setZerouJogo(int zerouJogo) {
		this.zerouJogo = zerouJogo;
	}

	public void registraJogada(int score, boolean zerou) {
		if (zerou == true) {
			zerouJogo += 1;
		}

		qtdJogada += 1;

		if (score > maiorScore) {
			setMaiorScore(score);
		}
	}

}
