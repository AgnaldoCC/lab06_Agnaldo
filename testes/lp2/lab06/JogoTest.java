package lp2.lab06;

import static org.junit.Assert.*;

import org.junit.Test;

import enums.Estilos;

public class JogoTest {

	private Jogo jogo;

	@Test
	public void testJogo() throws Exception {
		jogo = new RPG("World of Warcraft", 50);
		Jogo jogo1 = new Luta("Injustice", 60);
		Jogo jogo2 = new Plataforma("Mario", 40);
		assertEquals("World of Warcraft", jogo.getNome());
		assertNotEquals("World Of Warcraft", jogo.getNome());
		assertEquals("Injustice", jogo1.getNome());
		assertNotEquals("injustice", jogo1.getNome());
		assertEquals("Mario", jogo2.getNome());
		assertNotEquals("mario", jogo2.getNome());
	}

	@Test(expected = Exception.class)
	public void testJogoNomeNulo() throws Exception {
		jogo = new RPG(null, 50);
	}

	@Test(expected = Exception.class)
	public void testJogoNomeVazio() throws Exception {
		jogo = new RPG("", 50);
	}

	@Test(expected = Exception.class)
	public void testJogoPrecoNegativo() throws Exception {
		jogo = new RPG("Skyrim", -5);
	}

	@Test
	public void testAdicionaEstilo() throws Exception {
		jogo = new RPG("Skyrim", 50);
		jogo.adicionaEstilo(Estilos.MULTIPLAYER);
		assertEquals(1, jogo.estilos.size());
		jogo.adicionaEstilo(Estilos.ONLINE);
		assertEquals(2, jogo.estilos.size());
	}

	@Test
	public void testRegistraJogada() throws Exception {
		Jogo jogoRPG = new RPG("World of Warcraft", 50);

		jogoRPG.registraJogada(200, true);
		equals(200 == jogoRPG.getMaiorScore());
		equals(1 == jogoRPG.getZerouJogo());
		equals(1 == jogoRPG.getQtdJogada());

	}
	
	@Test
	public void testToString() throws Exception{
		Jogo jogoRPG = new RPG("World of Warcraft", 50);
		Jogo jogoLuta = new Luta("Injustice", 70);
		Jogo jogoPlataforma = new Plataforma("Mario", 40);
		jogoRPG.registraJogada(200, true);
		jogoLuta.registraJogada(300, true);
		jogoPlataforma.registraJogada(400, true);
		assertEquals("+ Injustice - Luta:\n==> Jogou 1 vez(es)\n==> Zerou 1 vez(es)\n==> Maior score: 300", jogoLuta.toString());
		assertEquals("+ World of Warcraft - RPG:\n==> Jogou 1 vez(es)\n==> Zerou 1 vez(es)\n==> Maior score: 200", jogoRPG.toString());
		assertEquals("+ Mario - Plataforma:\n==> Jogou 1 vez(es)\n==> Zerou 1 vez(es)\n==> Maior score: 400", jogoPlataforma.toString());
	}
}
