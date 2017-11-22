package br.com.fean.jersey.services;

import java.util.List;

import br.com.fean.jersey.dao.CategoriaDAO;
import br.com.fean.jersey.model.Categoria;

public class CategoriaService {
	
	public CategoriaDAO categoriaDAO() {
		return categoriaDAO;
	}
	
	private static CategoriaDAO categoriaDAO;
	
	public CategoriaService (){
		categoriaDAO = new CategoriaDAO();
	}
	
	public void persiste(Categoria entity) {
		categoriaDAO.openCurrentSessionwithTransaction();
		categoriaDAO.persist(entity);
		categoriaDAO.closeCurrentSessionwithTransaction();
	}

	public Boolean merge (Categoria categoriaAlterada) {
		categoriaDAO.openCurrentSessionwithTransaction();
		categoriaDAO.update(categoriaAlterada);
		categoriaDAO.closeCurrentSessionwithTransaction();
		return true;
	}
	
	public Categoria findById(Integer id) {
		categoriaDAO.abrirSessaoAtual();
		Categoria categoria = categoriaDAO.findById(id);
		categoriaDAO.encerrarSessaoAtual();
		return categoria;
	}

	public void delete(Integer id) {
		categoriaDAO.openCurrentSessionwithTransaction();
		Categoria categoria = categoriaDAO.findById(id);
		categoriaDAO.delete(categoria);
		categoriaDAO.closeCurrentSessionwithTransaction();
	}

	public List<Categoria> findAll() {
		categoriaDAO.abrirSessaoAtual();
		List<Categoria> categorias = categoriaDAO.findAll();
		categoriaDAO.encerrarSessaoAtual();
		return categorias;
	}

	public void deleteAll() {
		categoriaDAO.openCurrentSessionwithTransaction();
		categoriaDAO.deleteAll();
		categoriaDAO.closeCurrentSessionwithTransaction();
	}

}
