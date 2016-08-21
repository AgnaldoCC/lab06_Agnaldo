package lp2.lab06;

import java.util.ArrayList;

public class Loja {

	private final int X2P_NECESSARIO;

	private ArrayList<Usuario> usuarios;

	public Loja() {
		usuarios = new ArrayList<Usuario>();
		X2P_NECESSARIO = 1000;
	}

	public Usuario getUsuarioPorLogin(String nomeLogin) throws Exception {
		if (nomeLogin == null || nomeLogin.trim().isEmpty()) {
			throw new Exception("Login invalido");
		}
		for (Usuario usuario : usuarios) {
			if (usuario.getNomeLogin().equals(nomeLogin))
				;
			return usuario;
		}
		throw new Exception("Usuario nao existe");
	}

	public void adicionaUsuario(Usuario usuario) throws Exception {
		if (usuario == null) {
			throw new Exception("Usuario nao pode ser nulo");
		}
		if (!(usuarios.contains(usuario))) {
			usuarios.add(usuario);
		}
		throw new Exception("Usuario ja existe");
	}

	public void addDinheiro(String nomeLogin, double dinheiro)  {
		try{
			Usuario usuario = getUsuarioPorLogin(nomeLogin);
			usuario.adicionaDinheiro(dinheiro);
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
	}

	public void vendeJogo(String nomeLogin, Jogo jogo) {
		try{
			Usuario usuario = getUsuarioPorLogin(nomeLogin);
			usuario.compraJogo(jogo);
		}catch (Exception e){
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
	
	public void upUsuarioNoobtoVeretano(Noob noob) throws Exception{
		Veterano veterano = new Veterano(noob.getNome(),noob.getNomeLogin(), noob.getX2p());
		veterano.setDesconto(noob.getDesconto());
		veterano.setDinheiro(noob.getDinheiro());
		veterano.setJogosComprados(noob.getJogosComprados());
		veterano.setX2p(noob.getX2p());
		usuarios.remove(noob);
		usuarios.add(veterano);
	}
}
