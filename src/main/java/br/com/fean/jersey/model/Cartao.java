package br.com.fean.jersey.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Cartao {
	private int id;
	private String numero;
	private String dataValidade;
	private String codigoSeguranca;
	private String nomeTitular;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getDataValidade() {
		return dataValidade;
	}
	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}
	public String getCodigoSeguranca() {
		return codigoSeguranca;
	}
	public void setCodigoSeguranca(String codigoSeguranca) {
		this.codigoSeguranca = codigoSeguranca;
	}
	public String getNomeTitular() {
		return nomeTitular;
	}
	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}
	public Cartao(int id, String numero, String dataValidade, String codigoSeguranca, String nomeTitular) {
		super();
		this.id = id;
		this.numero = numero;
		this.dataValidade = dataValidade;
		this.codigoSeguranca = codigoSeguranca;
		this.nomeTitular = nomeTitular;
	}

	public Cartao(){}
}
