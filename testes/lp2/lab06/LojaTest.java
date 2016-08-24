package lp2.lab06;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

public class LojaTest {
	
	private HashSet<Usuario> usuarios;
	private Usuario usuario;
	
	@Before
	public void criaLoja() throws Exception{
		usuarios = new HashSet<Usuario>();
		usuario = new Noob("Agnaldo", "agnaldo.junior");
	}
	
	@Test
	public void testGetUsuarioPorLogin() {
		
	}
	
	@Test(expected = Exception.class)
	public void testGetUsuarioPorLoginNull() {
		String nomeLogin = null;
	}

	@Test
	public void testAdicionaUsuario() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddDinheiro() {
		fail("Not yet implemented");
	}

	@Test
	public void testVendeJogo() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpUsuarioNoobtoVeterano() {
		fail("Not yet implemented");
	}

}
