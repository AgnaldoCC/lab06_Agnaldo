package lp2.lab06;

import java.util.HashSet;

import exception.JogoInvalidoException;
import exception.StringNulaOuVaziaException;
import exception.ValorException;

/**
 * 
 * @author Agnaldo Junior
 *
 */


public abstract class Usuario {
	protected String nome;
	protected String nomeLogin;
	protected HashSet<Jogo> jogos;
	protected double dinheiro;
	protected int x2p;
	protected double desconto = 0;
	protected int pontoJogoLuta;
	
	/**
	 * Classe Usuário
	 * 
	 * @param nome
	 *            Nome do usuário.
	 * @param nomeLogin
	 *            Login do usuário, usado como identificador único.
	 * @param x2p
	 *            Quantidade de X2P inicial, UsuárioNoob começa com 0 e
	 *            UsuarioVeterano começa com 1000.
	 * @throws Exception
	 */
	
	public Usuario(String nome, String nomeLogin, int x2p) throws StringNulaOuVaziaException, ValorException{
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
		this.pontoJogoLuta = 0;

	}
	
	public HashSet<Jogo> getJogosComprados(){
		return jogos;
	}
	
	public void setJogosComprados(HashSet<Jogo> novosJogos){
		jogos = novosJogos;
	}
	
	/**
	 * Calcula o preço total de todos os jogos do usuario.
	 * 
	 * @return Preço total
	 */
	
	public double getPrecoTotal() {
		double total = 0;
		for (Jogo jogo : jogos) {
			total += jogo.getPreco();
		}
		return total;
	}
	
	public int getPontoJogoLuta() {
		return pontoJogoLuta;
	}

	public void setPontoJogoLuta(int pontoJogoLuta) {
		this.pontoJogoLuta = pontoJogoLuta;
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
	
	/**
	 * Adiciona X2p
	 * 
	 * @param qnt
	 *            Quantidade a ser adicionada
	 */
	
	public void adicionaX2p(int x2p) {
		this.setX2p(this.x2p + x2p);
	}

	public void adicionaDinheiro(double novo) {
		dinheiro += novo;
	}
	
	/**
	 * Adiciona um jogo na lista de jogos do usuário.
	 * 
	 * @param jogo
	 *            Jogo a ser adicionado
	 * @throws Exception
	 */
	
	public void adicionaJogo(Jogo jogo) throws JogoInvalidoException {
		if (jogos.contains(jogo)) {
			throw new JogoInvalidoException("O usuario ja possui esse jogo.");
		}
		jogos.add(jogo);
	}
	
	/**
	 * Retorna um jogo especifico da lista de jogos.
	 * 
	 * @param nomeJogo
	 *            Nome do jogo a ser pesquisado.
	 * @return
	 * @throws Exception
	 */
	
	public Jogo getJogo(String nome) throws JogoInvalidoException {
		for (Jogo jogo : jogos) {
			if (jogo.getNome().equals(nome)) {
				return jogo;
			}
		}
		throw new JogoInvalidoException("Jogo nao encontrado");
	}
	
	/**
	 * Checa se o usuário ja possui um jogo.
	 * 
	 * @param jogo
	 *            Jogo a ser checado
	 * @return
	 */
	
	public boolean temJogo(Jogo jogo) {
		return jogos.contains(jogo);
	}
	
	/**
	 * Registra a jogada de um jogo.
	 * 
	 * @param nomeJogo
	 *            Nome do jogo
	 * @param score
	 *            Score obtido
	 * @param zerou
	 *            Se o usuário zerou o jogo
	 * @throws Exception
	 */
	
	public void registraJogada(String nomeJogo, int score, boolean zerou) throws Exception {
		if (nome.trim().isEmpty()) {
			throw new StringNulaOuVaziaException("Nome do jogo nao pode ser vazio");
		}
		if (score < 0) {
			throw new ValorException("Score nao pode ser negativo");
		}
		
		Jogo jogo = getJogo(nomeJogo);
		x2p += jogo.registraJogada(score, zerou);
		adicionaX2p(x2p);
		

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