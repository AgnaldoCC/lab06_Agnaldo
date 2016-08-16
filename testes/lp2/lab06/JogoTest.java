package lp2.lab06;

import static org.junit.Assert.*;

import org.junit.Test;

public class JogoTest {
	
	private Jogo jogo;
	
	@Test
	public void testJogo() throws Exception {
		jogo = new Jogo("No Man's Sky", 50);
		assertEquals("No Man's Sky", jogo.getNome());
	}

	@Test
	public void testAdicionaEstilo() {
		fail("Not yet implemented");
	}


	@Test
	public void testRegistraJogada() {
		fail("Not yet implemented");
	}

}
