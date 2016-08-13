package lp2.lab06;

import java.util.ArrayList;

public class Usuario {
	protected String nome;
	protected String nomeLogin;
	private ArrayList<Jogo> jogos;
	protected double dinheiro;

	public Usuario(String nome, String nomeLogin, double dinheiro) {
		this.nomeLogin = nomeLogin;
		this.nome = nome;
		jogos = new ArrayList<Jogo>();
		this.dinheiro = dinheiro;

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

	public void adicionaDinheiro(double novo) {
		dinheiro += novo;
	}
	
	public void adicionaJogo(Jogo jogo){
		jogos.add(jogo);
	}

}