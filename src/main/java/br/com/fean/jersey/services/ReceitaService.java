package br.com.fean.jersey.services;

import java.util.ArrayList;
import java.util.List;

import br.com.fean.jersey.model.Receita;

public class ReceitaService {
	private static List<Receita> receitas = new ArrayList<Receita>();
	
	public static List<Receita> getTodasReceitas(){
		return receitas;
	}
	
	public boolean cadastrarReceitas(Receita receitaInserir){
		receitas.add(receitaInserir);
		return true;
	}
}
