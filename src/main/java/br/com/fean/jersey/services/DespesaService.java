package br.com.fean.jersey.services;

import java.util.ArrayList;
import java.util.List;

import br.com.fean.jersey.model.Despesa;
import br.com.fean.jersey.model.Despesa;

public class DespesaService {
	private static List<Despesa> despesas = new ArrayList<Despesa>();
	
	public static List<Despesa> getTodasDespesas() {
		if(despesas == null) {
			return new ArrayList<Despesa>();
		}
		return despesas;
	}
	
	public boolean cadastrarDespesa(Despesa despesaInserir) {
		if(despesas != null && !despesas.isEmpty()) {
			for (Despesa despesa : despesas) {
				if(despesaInserir.getDescricao().equals(despesa.getDescricao())) {
					return false;
				}
			}
			defineIdDespesa(despesaInserir);
		}else{
			despesaInserir.setId(1);
		}
		
		despesas.add(despesaInserir);
		return true;
	}
	
	private void defineIdDespesa(Despesa despesaInserir) {
		Despesa ultimaDespesa = null;
		for (Despesa despesa : despesas) {
			ultimaDespesa = despesa;
		}
		despesaInserir.setId(ultimaDespesa.getId()+1);
	}
	
	
	public Despesa buscarDespesaId(Integer idDespesa) {
		for(Despesa despesa : despesas){
			if(despesa.getId() == idDespesa){
				return despesa;
			}
		}
		return new Despesa();
	}

	public boolean alterarDespesa(Despesa despesaUpdate) {
		for (Despesa despesa : despesas) {
			if(despesa.getId() == despesaUpdate.getId()) {
				despesa.setData(despesaUpdate.getData());
				despesa.setDescricao(despesaUpdate.getDescricao());
				despesa.setValor(despesaUpdate.getValor());
				return true;
			}
		}
		return false;
	}
	
	public void deletarDespesa(Integer idDespesa) {
		Despesa despesa = buscarDespesaId(idDespesa);
		despesas.remove(despesa);
	}
}
