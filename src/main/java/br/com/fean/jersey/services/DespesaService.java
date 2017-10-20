package br.com.fean.jersey.services;

import java.util.ArrayList;
import java.util.List;

import br.com.fean.jersey.model.Despesa;

public class DespesaService {
	private static List<Despesa> despesas = new ArrayList<Despesa>();
	
	public static List<Despesa> getTodasDespesas(){
		return despesas;
	}
	
	public boolean cadastrarDespesa(Despesa despesaInserir){
		despesas.add(despesaInserir);
		return true;
	}
}
