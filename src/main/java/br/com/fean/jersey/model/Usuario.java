package br.com.fean.jersey.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Usuario {
	private int id;
	private String nome;
	private String endereco;
	private String email;
	private String telefone;
	private String senha;
	private String confirmaSenha;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfirmaSenha() {
		return confirmaSenha;
	}

	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}

	public Usuario(){}
	
	
	public Usuario(int id, String nome, String endereco, String email, String telefone, String senha,
			String confirmaSenha) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
		this.confirmaSenha = confirmaSenha;
	}

	@Override
	public String toString() {
		return "Nome - "+this.nome+",idade - "+this.senha;
		
	}
	
}
