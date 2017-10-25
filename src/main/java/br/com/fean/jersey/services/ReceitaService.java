package br.com.fean.jersey.services;

import java.util.ArrayList;
import java.util.List;

import br.com.fean.jersey.model.Receita;
import br.com.fean.jersey.model.Receita;

public class ReceitaService {
	private static List<Receita> receitas = new ArrayList<Receita>();
	
	public static List<Receita> getTodasReceitas() {
		if(receitas == null) {
			return new ArrayList<Receita>();
		}
		return receitas;
	}
	
	public boolean cadastrarReceita(Receita receitaInserir) {
		if(receitas != null && !receitas.isEmpty()) {
			for (Receita receita : receitas) {
				if(receitaInserir.getDescricao().equals(receita.getDescricao())) {
					return false;
				}
			}
			defineIdReceita(receitaInserir);
		}else{
			receitaInserir.setId(1);
		}
		
		receitas.add(receitaInserir);
		return true;
	}
	
	private void defineIdReceita(Receita receitaInserir) {
		Receita ultimaReceita = null;
		for (Receita receita : receitas) {
			ultimaReceita = receita;
		}
		receitaInserir.setId(ultimaReceita.getId()+1);
	}
	
	
	public Receita buscarReceitaId(Integer idReceita) {
		for(Receita user : receitas){
			if(user.getId() == idReceita){
				return user;
			}
		}
		return new Receita();
	}

	public boolean alterarReceita(Receita receitaUpdate) {
		for (Receita receita : receitas) {
			if(receita.getId() == receitaUpdate.getId()) {
				receita.setData(receitaUpdate.getData());
				receita.setDescricao(receitaUpdate.getDescricao());
				receita.setValor(receitaUpdate.getValor());
				return true;
			}
		}
		return false;
	}
	
	public void deletarReceita(Integer idReceita) {
		Receita receita = buscarReceitaId(idReceita);
		receitas.remove(receita);
	}
}
