package lp2.lab06;

import java.util.ArrayList;

public class Loja {

	private ArrayList<Usuario> usuarios;

	public Loja() {
		usuarios = new ArrayList<Usuario>();
	}

	public void addUsuario(Usuario usuario) {
		usuarios.add(usuario);
	}

	public void addDinheiro(String nomeLogin, double dinheiro) throws Exception {
		for (Usuario usuario : usuarios) {
			if (usuario.getNomeLogin().equalsIgnoreCase(nomeLogin)) {
				usuario.adicionaDinheiro(dinheiro);
			}
		}
		throw new Exception("Usuario nao encontrado");
	}

	public void vendeJogo(String nomeLogin, Jogo jogo) throws Exception {
		for (Usuario usuario : usuarios) {
			if (usuario.getNomeLogin().equalsIgnoreCase(nomeLogin)) {
				usuario.compraJogo(jogo);
			}
		}
	}
}
