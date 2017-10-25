package br.com.fean.jersey.services;

import java.util.ArrayList;
import java.util.List;

import br.com.fean.jersey.model.Categoria;
import br.com.fean.jersey.model.Usuario;

public class CategoriaService {
	private static List<Categoria> categorias = new ArrayList<Categoria>();
	
	public static List<Categoria> getTodasCategorias() {
		if(categorias == null) {
			return new ArrayList<Categoria>();
		}
		return categorias;
	}
	
	public boolean cadastrarCategoria(Categoria categoriaInserir) {
		if(categorias != null && !categorias.isEmpty()) {
			for (Categoria categoria : categorias) {
				if(categoriaInserir.getNomeCategoria().equals(categoria.getNomeCategoria())) {
					return false;
				}
			}
			defineIdCategoria(categoriaInserir);
		}else{
			categoriaInserir.setId(1);
		}
		
		categorias.add(categoriaInserir);
		return true;
	}
	
	private void defineIdCategoria(Categoria categoriaInserir) {
		Categoria ultimaCategoria = null;
		for (Categoria categoria : categorias) {
			ultimaCategoria = categoria;
		}
		categoriaInserir.setId(ultimaCategoria.getId()+1);
	}
	
	public Categoria buscarCategoriaId(Integer idCategoria) {
		for(Categoria categoria : categorias){
			if(categoria.getId() == idCategoria){
				return categoria;
			}
		}
		return new Categoria();
	}
	
	public boolean alterarCategoria(Categoria categoriaUpdate) {
		for (Categoria categoria : categorias) {
			if(categoria.getId() == categoriaUpdate.getId()) {
				categoria.setNomeCategoria(categoriaUpdate.getNomeCategoria());
				return true;
			}
		}
		return false;
	}
	
	public void deletarCategoria(Integer idCategoria) {
		Categoria categoria = buscarCategoriaId(idCategoria);
		categorias.remove(categoria);
	}
}
