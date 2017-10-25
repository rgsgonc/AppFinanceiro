package br.com.fean.jersey.services;

import java.util.ArrayList;
import java.util.List;

import br.com.fean.jersey.model.Cartao;
import br.com.fean.jersey.model.Usuario;

public class CartaoService {
	private static List<Cartao> cartoes = new ArrayList<Cartao>();
	

	public boolean cadastrarCartao(Cartao cartaoInserir) {
		if(cartoes != null && !cartoes.isEmpty()) {
			for (Cartao cartao : cartoes) {
				if(cartaoInserir.getNumero().equals(cartao.getNumero())) {
					return false;
				}
			}
			defineIdCartao(cartaoInserir);
		}else{
			cartaoInserir.setId(1);
		}
		
		cartoes.add(cartaoInserir);
		return true;
	}
	
	private void defineIdCartao(Cartao usuarioInserir) {
		Cartao ultimoCartao = null;
		for (Cartao cartao : cartoes) {
			ultimoCartao = cartao;
		}
		usuarioInserir.setId(ultimoCartao.getId()+1);
	}
	
	
	public static List<Cartao> getTodosCartoes() {
		if(cartoes == null) {
			return new ArrayList<Cartao>();
		}
		return cartoes;
	}

	
	public Cartao buscarCartaoId(Integer idCartao) {
		for(Cartao cartao : cartoes){
			if(cartao.getId() == idCartao){
				return cartao;
			}
		}
		return new Cartao();
	}
	
	public boolean alterarCartao(Cartao cartaoUpdate) {
		for (Cartao cartao : cartoes) {
			if(cartao.getId() == cartaoUpdate.getId()) {
				cartao.setNumero(cartaoUpdate.getNumero());
				cartao.setDataValidade(cartaoUpdate.getDataValidade());
				cartao.setCodigoSeguranca(cartaoUpdate.getCodigoSeguranca());
				cartao.setNomeTitular(cartaoUpdate.getNomeTitular());
				return true;
			}
		}
		return false;
	}
	
	public void deletarCartao(Integer idCartao) {
		Cartao cartao = buscarCartaoId(idCartao);
		cartoes.remove(cartao);
	}
}
