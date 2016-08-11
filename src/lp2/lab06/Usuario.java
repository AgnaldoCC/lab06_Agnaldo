package lp2.lab06;

import java.util.ArrayList;

public class Usuario {
	private String nome;
	private ArrayList<Jogo> jogos;
	private double dinheiro;
	private String tipo;
	
	public Usuario(String nome, ArrayList<Jogo> jogos, double dinheiro, String tipo){
		this.nome = nome;
		this.jogos = jogos;
		
	}
	
}
