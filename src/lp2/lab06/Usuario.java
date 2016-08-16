package lp2.lab06;

import java.util.HashSet;

public class Usuario {
	private String nome;
	private String nomeLogin;
	private HashSet<Jogo> jogos;
	private double dinheiro;
	protected int x2p;
	protected double desconto;

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

	public void registraJogada(String nomeJogo, int score, boolean zerou) throws Exception {
		for (Jogo jogo : jogos) {
			if (jogo.getNome().equalsIgnoreCase(nomeJogo)) {
				jogo.registraJogada(score, zerou);
			}
		}
		throw new Exception("Jogo não encontrado");

	}
	
	public void compraJogo(Jogo jogo) throws Exception{
		if (jogo == null){
			throw new Exception("Jogo não pode ser nulo");
		}
		
		if (dinheiro < jogo.getPreco()){
			throw new Exception("Dinheiro insuficiente para comprar esse jogo");
		}
		
		this.setDinheiro(this.dinheiro - (jogo.getPreco() * desconto));
		this.adicionaJogo(jogo);
		
	}

}