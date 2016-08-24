package lp2.lab06;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import exception.UsuarioInvalidoException;
import exception.ValorException;


public class LojaTest {
	
	@Test
	public void testAddUsuario() {
		try {
			Loja loja = new Loja();
			Noob user = new Noob("Agnaldo", "agnaldo.junior");
			loja.adicionaUsuario(user);
		} catch (Exception e) {
			fail("Não deveria lançar exception");
		}
	}

	@Test(expected = ValorException.class)
	public void testAddUsuarioNulo() throws ValorException, UsuarioInvalidoException {
		Loja loja = new Loja();
		loja.adicionaUsuario(null);
	}

	@Test(expected = UsuarioInvalidoException.class)
	public void testAddUsuarioExistente() throws Exception {
		Loja loja = new Loja();
		Usuario user = new Noob("Agnaldo", "agnaldo.junior");
		loja.adicionaUsuario(user);
		loja.adicionaUsuario(user);
	}

	@Test
	public void testGetUsuario() {
		try {
			Loja loja = new Loja();
			Usuario user = new Noob("Agnaldo", "agnaldo.junior");
			loja.adicionaUsuario(user);
			assertEquals(loja.getUsuarioPorLogin("agnaldo.junior"), user);
		} catch (Exception e) {
			fail("Não deveria lançar exception");
		}
	}

	@Test
	public void testVendeJogo() {
		try {
			Loja loja = new Loja();
			Usuario user = new Noob("Agnaldo", "agnaldo.junior");
			RPG jogo = new RPG("WOW", 10);
			user.adicionaDinheiro(100.0);
			loja.adicionaUsuario(user);
			loja.vendeJogo("agnaldo.junior", jogo);
			assertEquals(user.getDinheiro(), 91.0, 0);
		} catch (Exception e) {
			fail("Não deveria lançar exception");
		}
	}

	@Test
	public void testPromoveUsuario() {
		try {
			Noob usuarioNoob = new Noob("Agnaldo", "agnaldo.junior");
			Loja loja = new Loja();
			loja.adicionaUsuario(usuarioNoob);
			loja.upUsuarioNoobtoVeterano("agnaldo.junior");
			Usuario usuarioVeterano = loja.getUsuarioPorLogin("MatheusMelo");
			assertTrue(usuarioVeterano instanceof Veterano);
			assertEquals(usuarioVeterano.getNome(), usuarioNoob.getNome());
			assertEquals(usuarioVeterano.getX2p(), usuarioNoob.getX2p());
			assertEquals(usuarioVeterano.getNomeLogin(), usuarioNoob.getNomeLogin());
			assertEquals(usuarioVeterano.getPontoJogoLuta(), usuarioNoob.getPontoJogoLuta());
			assertEquals(usuarioVeterano.getPrecoTotal(), usuarioNoob.getPrecoTotal(), 0);
		} catch (Exception e) {
			fail("Não deveria lançar exception");
		}
	}

}