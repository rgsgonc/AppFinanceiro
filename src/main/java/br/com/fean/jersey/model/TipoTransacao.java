package br.com.fean.jersey.model;

public enum TipoTransacao {
	
	DESPESA, RECEITA;
	
	private String nomeTransacao;

	public String getNomeTransacao() {
		return nomeTransacao;
	}

	public void setNomeTransacao(String nomeTransacao) {
		this.nomeTransacao = nomeTransacao;
	}
	
}
