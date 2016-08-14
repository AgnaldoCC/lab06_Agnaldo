package lp2.lab06;

import java.util.ArrayList;

public class Usuario {
	protected String nome;
	protected String nomeLogin;
	private ArrayList<Jogo> jogos;
	protected double dinheiro;
	protected int x2p;

	public Usuario(String nome, String nomeLogin, double dinheiro, int x2p) {
		this.nomeLogin = nomeLogin;
		this.nome = nome;
		jogos = new ArrayList<Jogo>();
		this.dinheiro = dinheiro;
		this.x2p = x2p;

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

	public void adicionaDinheiro(double novo) {
		dinheiro += novo;
	}

	public void adicionaJogo(Jogo jogo) {
		jogos.add(jogo);
	}

}