package lp2.lab06;

import java.util.HashSet;

import exception.JogoInvalidoException;
import exception.StringNulaOuVaziaException;
import exception.ValorException;

public abstract class Usuario {
	protected String nome;
	protected String nomeLogin;
	protected HashSet<Jogo> jogos;
	protected double dinheiro;
	protected int x2p;
	protected double desconto = 0;

	public Usuario(String nome, String nomeLogin, int x2p) throws Exception {
		if (nome == null || nome.trim().isEmpty()) {
			throw new StringNulaOuVaziaException("Nome nao pode ser nulo ou vazio");
		}

		if (nomeLogin == null || nomeLogin.trim().isEmpty()) {
			throw new StringNulaOuVaziaException("Nome de login nao pode ser nulo ou vazio");
		}

		if (dinheiro < 0) {
			throw new ValorException("Saldo em dinheiro nao pode ser negativo");
		}
		this.nomeLogin = nomeLogin;
		this.nome = nome;
		jogos = new HashSet<Jogo>();
		this.dinheiro = 0;
		this.x2p = 0;

	}
	
	public HashSet<Jogo> getJogosComprados(){
		return jogos;
	}
	
	public void setJogosComprados(HashSet<Jogo> novosJogos){
		jogos = novosJogos;
	}

	public double getPrecoTotal() {
		double total = 0;
		for (Jogo jogo : jogos) {
			total += jogo.getPreco();
		}
		return total;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public double getDesconto(){
		return this.desconto;
	}
	
	public void setDesconto(double novoDesconto){
		this.desconto = novoDesconto;
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

	public void adicionaX2p(int x2p) {
		this.setX2p(this.x2p + x2p);
	}

	public void adicionaDinheiro(double novo) {
		dinheiro += novo;
	}

	public boolean adicionaJogo(Jogo jogo) throws Exception {
		if (jogos.contains(jogo)) {
			throw new JogoInvalidoException("O usuario ja possui esse jogo.");
		}
		return jogos.add(jogo);
	}

	public Jogo getJogo(String nome) throws Exception {
		for (Jogo jogo : jogos) {
			if (jogo.getNome().equals(nome)) {
				return jogo;
			}
		}
		throw new JogoInvalidoException("Jogo nao encontrado");
	}

	public boolean temJogo(Jogo jogo) {
		return jogos.contains(jogo);
	}

	public void registraJogada(String nomeJogo, int score, boolean zerou) throws Exception {
		if (nome.trim().isEmpty()) {
			throw new StringNulaOuVaziaException("Nome do jogo nao pode ser vazio");
		}
		if (score < 0) {
			throw new ValorException("Score nao pode ser negativo");
		}
		
		Jogo jogo = getJogo(nomeJogo);
		x2p += jogo.registraJogada(score, zerou);
		

	}

	public abstract void compraJogo(Jogo jogo) throws Exception;

	public abstract String toString();

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeLogin == null) ? 0 : nomeLogin.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Usuario)) {
			return false;
		}
		Usuario usuario = (Usuario) obj;
		if (getNomeLogin().equals(usuario.getNomeLogin())) {
			return true;
		}
		return false;
	}

}