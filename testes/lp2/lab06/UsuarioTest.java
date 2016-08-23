package lp2.lab06;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {

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
	public void testAdicionaX2p() {
		usuarioNoob.adicionaX2p(500);
		assert (500 == usuarioNoob.getX2p());
		usuarioNoob.adicionaX2p(200);
		assert (700 == usuarioNoob.getX2p());
	}

	@Test
	public void testAdicionaDinheiro() {
		usuarioNoob.adicionaDinheiro(900);
		assert (900 == usuarioNoob.getDinheiro());
		usuarioNoob.adicionaDinheiro(200);
		assert (1100 == usuarioNoob.getDinheiro());
	}

	@Test
	public void testAdicionaJogo() throws Exception {
		Jogo jogo1 = new RPG("WOW", 50);
		usuarioNoob.adicionaJogo(jogo1);
		assert (1 == usuarioNoob.getJogosComprados().size());

	}

	@Test
	public void testTemJogo() throws Exception {
		Jogo jogo = new RPG("WOW", 50);
		usuarioNoob.adicionaJogo(jogo);
		assertTrue(usuarioNoob.getJogosComprados().contains(jogo));
	}

	@Test(expected = Exception.class)
	public void testRegistraJogadaComNomeVazio() throws Exception {
		usuarioNoob = new Noob("Matheus Melo", "matheus.almeida");
		usuarioNoob.registraJogada("", 100, true);
	}
	
	@Test(expected = Exception.class)
	public void testRegistraJogadaScoreNegativo() throws Exception {
		usuarioNoob = new Noob("Matheus Melo", "matheus.almeida");
		usuarioNoob.registraJogada("WOW", -5, true);
	}
	
	@Test
	public void testRegistraJogada() throws Exception {
		usuarioNoob = new Noob("Matheus Melo", "matheus.almeida");
		Jogo jogo = new RPG("WOW", 50);
		usuarioNoob.adicionaJogo(jogo);
		usuarioNoob.registraJogada("WOW", 100, true);
		assert(1 == jogo.getZerouJogo());
		assert(1 == jogo.getQtdJogada());
		assert(100 == jogo.getMaiorScore());
	}

	@Test(expected = Exception.class)
	public void testCompraJogoSemDinheiro() throws Exception {
		Jogo jogo = new Luta("Injustice", 70);
		usuarioNoob.compraJogo(jogo);
	}
	
	@Test
	public void testCompraJogo() throws Exception{
		Jogo jogo = new Luta("Injustice", 70);
		usuarioNoob.adicionaDinheiro(150);
		usuarioNoob.compraJogo(jogo);
	}

}
