package com.game.store.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Games {
	private int id;
	
	@NotEmpty(message = "O campo titulo é obrigatório")
	private String titulo;
	
	@NotEmpty(message = "O campo imagem é obrigatório")
	private String imagem;
	
	@NotNull(message = "O campo preco é obrigatório")
	private double preco;
	
	private int numeroDeVendas;
	
	public Games(int id, String titulo, String imagem, double preco, int numeroDeVendas) {
		this.id = id;
		this.titulo = titulo;
		this.imagem = imagem;
		this.preco = preco;
		this.numeroDeVendas = numeroDeVendas;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}
	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	/**
	 * @return the imagem
	 */
	public String getImagem() {
		return imagem;
	}
	/**
	 * @param imagem the imagem to set
	 */
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	/**
	 * @return the preco
	 */
	public double getPreco() {
		return preco;
	}
	/**
	 * @param preco the preco to set
	 */
	public void setPreco(double preco) {
		this.preco = preco;
	}
	/**
	 * @return the numeroDeVendas
	 */
	public int getNumeroDeVendas() {
		return numeroDeVendas;
	}
	/**
	 * @param numeroDeVendas the numeroDeVendas to set
	 */
	public void setNumeroDeVendas(int numeroDeVendas) {
		this.numeroDeVendas = numeroDeVendas;
	}
	
	

}
