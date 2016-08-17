package lp2.lab06;

import java.util.HashSet;

public abstract class Usuario {
	private String nome;
	private String nomeLogin;
	protected HashSet<Jogo> jogos;
	protected double dinheiro;
	protected int x2p;

	public Usuario(String nome, String nomeLogin, double dinheiro, int x2p) throws Exception {
		if (nome == null || nome.isEmpty()) {
			throw new Exception("Nome não pode ser nulo ou vazio");
		}

		if (nomeLogin == null || nomeLogin.isEmpty()) {
			throw new Exception("Nome de login não pode ser nulo ou vazio");
		}

		if (dinheiro < 0) {
			throw new Exception("Saldo em dinheiro não pode ser negativo");
		}
		this.nomeLogin = nomeLogin;
		this.nome = nome;
		jogos = new HashSet<Jogo>();
		this.dinheiro = 0;
		this.x2p = 0;

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeLogin() {
		return nomeLogin;
	}

	public void setNomeLogin(String nomeLogin) {
		this.nomeLogin = nomeLogin;
	}

	public double getDinheiro() {
		return dinheiro;
	}

	public void setDinheiro(double dinheiro) {
		this.dinheiro = dinheiro;
	}

	public int getX2p() {
		return x2p;
	}

	public void setX2p(int x2p) {
		this.x2p = x2p;
	}
	
	public void adicionaX2p(int x2p){
		this.setX2p(this.x2p + x2p);
	}

	public void adicionaDinheiro(double novo) {
		dinheiro += novo;
	}

	public void adicionaJogo(Jogo jogo) {
		jogos.add(jogo);
	}

	public void registraJogada(String nomeJogo, int score, boolean zerou) throws Exception {
		for (Jogo jogo : jogos) {
			if (jogo.getNome().equalsIgnoreCase(nomeJogo)) {
				jogo.registraJogada(score, zerou);
			}
		}
		throw new Exception("Jogo não encontrado");

	}

	public abstract void compraJogo(Jogo jogo) throws Exception;

}
