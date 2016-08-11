package lp2.lab06;

import java.util.ArrayList;

public class Usuario {
	private String nome;
	private ArrayList<Jogo> jogos;
	private double dinheiro;
	private String tipo;

	public Usuario(String nome, double dinheiro, String tipo) {
		this.nome = nome;
		jogos = new ArrayList<Jogo>();
		this.dinheiro = dinheiro;

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getDinheiro() {
		return dinheiro;
	}

	public void setDinheiro(double dinheiro) {
		this.dinheiro = dinheiro;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void adicionaDinheiro(double novo) {
		dinheiro += novo;
	}

	public void compraJogo(Jogo jogo) throws Exception{
		double atual = dinheiro;
		if (tipo.equalsIgnoreCase("Noob")) {
			double precoNoob = jogo.getPreco() - (jogo.getPreco() * 0.1);
			if (dinheiro >= precoNoob) {
				jogos.add(jogo);
				setDinheiro(atual - precoNoob);
				
			}
			else{
				throw new Exception("Dinheiro insuficiente"); 
			}
		}
		
		else if (tipo.equalsIgnoreCase("Veterano")){
			double precoVeterano = jogo.getPreco() - (jogo.getPreco() * 0.2);
			if (dinheiro >= precoVeterano) {
				jogos.add(jogo);
			}
			else{
				throw new Exception("Dinheiro insuficiente"); 
			}
		}

	}
}