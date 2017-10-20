package br.com.fean.jersey.services;

import java.util.ArrayList;
import java.util.List;

import br.com.fean.jersey.model.Categoria;

public class CategoriaService {
	private static List<Categoria> categorias = new ArrayList<Categoria>();
	
	public static List<Categoria> getTodasCategorias(){
		return categorias;
	}
	
	public boolean cadastrarCategoria(Categoria categoriaInserir){
		categorias.add(categoriaInserir);
		return true;
	}
}
