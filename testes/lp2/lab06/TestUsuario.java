package lp2.lab06;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestUsuario {

	private Usuario usuarioNoob;
	private Usuario usuarioVeterano;

	@Before
	public void CriaUsuario() throws Exception {
		usuarioNoob = new Noob("Agnaldo", "agnaldo.junior");
		usuarioVeterano = new Veterano("Matheus", "matheus.melo");
	}

	@Test
	public void testUsuario() throws Exception {
		assertEquals("Agnaldo", usuarioNoob.getNome());
		assertEquals("Matheus", usuarioVeterano.getNome());
		assertEquals("agnaldo.junior", usuarioNoob.getNomeLogin());
		assertEquals("matheus.melo", usuarioVeterano.getNomeLogin());
	}

	@Test(expected = Exception.class)
	public void testUsuarioComNomeNulo() throws Exception {
		Usuario usuarioNoobNull = new Noob(null, "agnaldo.junior");
	}

	@Test(expected = Exception.class)
	public void testUsuarioComLoginNulo() throws Exception {
		Usuario usuarioNoobNull = new Noob("Agnaldo", null);
	}

	@Test
	public void testAdicionaX2p() throws Exception {
		usuarioNoob.adicionaX2p(500);
		assert (500 == usuarioNoob.getX2p());
		usuarioNoob.adicionaX2p(200);
		assert (700 == usuarioNoob.getX2p());
	}

	@Test
	public void testAdicionaDinheiro() throws Exception {
		usuarioNoob.adicionaDinheiro(900);
		assert (900 == usuarioNoob.getDinheiro());
		usuarioNoob.adicionaX2p(200);
		assert (1100 == usuarioNoob.getDinheiro());
	}

	@Test
	public void testAdicionaJogo() throws Exception {
		Jogo jogo1 = new RPG("WOW", 50);
		Jogo jogo2 = new Luta("Injustice", 60);
		Jogo jogo3 = new RPG("Mario", 70);
		
	}

	@Test
	public void testGetJogo() {
		fail("Not yet implemented");
	}

	@Test
	public void testTemJogo() {
		fail("Not yet implemented");
	}

	@Test
	public void testRegistraJogada() {
		fail("Not yet implemented");
	}

	@Test
	public void testCompraJogo() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}
