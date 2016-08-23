package lp2.lab06;

import java.util.ArrayList;

import exception.StringNulaOuVaziaException;
import exception.UsuarioInvalidoException;

/**
 * 
 * @author Agnaldo Junior
 *
 */

public class Loja {

	private ArrayList<Usuario> usuarios;

	public Loja() {
		usuarios = new ArrayList<Usuario>();

	}
	
	/**
	 * Busca um usuario na lista de usuários.
	 * 
	 * @param nomeLogin
	 *    			Nome unico de Usuario
	 * @return
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
	 */

	public void adicionaUsuario(Usuario usuario) throws Exception {
		if (usuario == null) {
			throw new Exception("Usuario nao pode ser nulo");
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
	
	public void upUsuarioNoobtoVeterano(Noob noob) throws Exception {
		Veterano veterano = new Veterano(noob.getNome(), noob.getNomeLogin());
		veterano.setDesconto(noob.getDesconto());
		veterano.setDinheiro(noob.getDinheiro());
		veterano.setJogosComprados(noob.getJogosComprados());
		veterano.setX2p(noob.getX2p());
		usuarios.remove(noob);
		usuarios.add(veterano);
	}
}
