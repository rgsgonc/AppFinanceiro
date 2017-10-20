package br.com.fean.jersey.services;

import java.util.ArrayList;
import java.util.List;

import br.com.fean.jersey.model.Cartao;

public class CartaoService {
	private static List<Cartao> cartoes = new ArrayList<Cartao>();
	
	public static List<Cartao> getTodosCartoes(){
		return cartoes;
	}
	
	public boolean cadastrarCartao(Cartao cartaoInserir){
		cartoes.add(cartaoInserir);
		return true;
	}
}
