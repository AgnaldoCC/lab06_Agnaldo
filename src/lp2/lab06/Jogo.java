package lp2.lab06;

public class Jogo {
	private String nome;
	private double preco;
	private String tipo;
	private int maiorScore;
	private int qtdJogada;
	private int zerouJogo;

	public Jogo(String nome, double preco, String tipo) {
		this.nome = nome;
		this.preco = preco;
		this.tipo = tipo;
	}

	public void registraJogada(int score, boolean zerou) {
		if (zerou == true) {
			zerouJogo += 1;
		}
		qtdJogada += 1;
		if (score > maiorScore) {
			maiorScore = score;
		}
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
