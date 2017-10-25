package br.com.fean.jersey.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Categoria {
	private int id;
	private String nomeCategoria;

	public Categoria(){}

	public Categoria(int id, String nomeCategoria) {
		super();
		this.id = id;
		this.nomeCategoria = nomeCategoria;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
	
	
	
}
