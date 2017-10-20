package br.com.fean.jersey.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Categoria {
	private String nomeCategoria;

	public Categoria(){}
	
	public Categoria(String nomeCategoria) {
		super();
		this.nomeCategoria = nomeCategoria;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
	
	
}
