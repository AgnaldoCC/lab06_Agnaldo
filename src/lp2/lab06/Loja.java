package lp2.lab06;

import java.util.HashSet;

import exception.StringNulaOuVaziaException;
import exception.UsuarioInvalidoException;

/**
 * 
 * @author Agnaldo Junior
 *
 */

public class Loja {

	private HashSet<Usuario> usuarios;

	public Loja() {
		usuarios = new HashSet<Usuario>();

	}
	
	/**
	 * Busca um usuario na lista de usuários.
	 * 
	 * @param nomeLogin
	 *    	Nome unico de Usuario
	 * @return Usuario
	 * @throws Exception
	 */
	
	public Usuario getUsuarioPorLogin(String nomeLogin) throws Exception {
		if (nomeLogin == null || nomeLogin.trim().isEmpty()) {
			throw new StringNulaOuVaziaException("Login invalido");
		}
		for (Usuario usuario : usuarios) {
			if (usuario.getNomeLogin().equals(nomeLogin)) {
				return usuario;
			}
		}
		System.out.println("Usuario nao existe");
		throw new UsuarioInvalidoException("Usuario nao existe");
	}
	
	/**
	 * Adiciona usuário
	 * 
	 * @param usuario
	 * @throws Exception
	 */

	public void adicionaUsuario(Usuario usuario) throws UsuarioInvalidoException {
		if (usuario == null) {
			throw new UsuarioInvalidoException("Usuario nao pode ser nulo");
		}
		if (!(usuarios.contains(usuario))) {
			usuarios.add(usuario);
		}
		System.out.println("Usuario ja existe");
		throw new UsuarioInvalidoException("Usuario ja existe");
	}

	public void addDinheiro(String nomeLogin, double dinheiro) {
		try {
			Usuario usuario = getUsuarioPorLogin(nomeLogin);
			usuario.adicionaDinheiro(dinheiro);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Vende jogo
	 * 
	 * @param nomeLogin
	 * @param jogo
	 */
	
	public void vendeJogo(String nomeLogin, Jogo jogo) {
		try {
			Usuario usuario = getUsuarioPorLogin(nomeLogin);
			usuario.compraJogo(jogo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String toString() {
		String loja = "=== Central P2-CG ===\n\n";
		for (Usuario usuario : usuarios) {
			loja += usuario.toString() + "\n";
		}
		return loja;
	}
	
	/**
	 * Promove um usuario de Noob para Veterano.
	 * @param usuario
	 * @throws Exception
	 */
	
	public void upUsuarioNoobtoVeterano(String nomeLogin) throws Exception {
		Usuario usuario = getUsuarioPorLogin(nomeLogin);
		Veterano novoUsuario = new Veterano(usuario.getNome(), usuario.getNomeLogin());
		novoUsuario.setJogosComprados(usuario.getJogosComprados());
		novoUsuario.setDinheiro(usuario.getDinheiro());
		novoUsuario.setX2p(usuario.getX2p());
		novoUsuario.setPontoJogoLuta(usuario.getPontoJogoLuta());
		usuarios.remove(usuario);
		usuarios.add(novoUsuario);
	}
}
