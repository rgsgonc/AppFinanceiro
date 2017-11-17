package br.com.fean.jersey.services;

import java.util.List;

import br.com.fean.jersey.dao.UsuarioDAO;
import br.com.fean.jersey.model.Usuario;

public class UsuarioService {
	public UsuarioDAO usuarioDAO() {
		return usuarioDAO;
	}
	
	private static UsuarioDAO usuarioDAO;
	
	public UsuarioService (){
		usuarioDAO = new UsuarioDAO();
	}
	
	public void persiste(Usuario entity) {
		usuarioDAO.openCurrentSessionwithTransaction();
		usuarioDAO.persist(entity);
		usuarioDAO.closeCurrentSessionwithTransaction();
	}

	public Boolean merge (Usuario categoriaAlterada) {
		usuarioDAO.openCurrentSessionwithTransaction();
		usuarioDAO.update(categoriaAlterada);
		usuarioDAO.closeCurrentSessionwithTransaction();
		
		return true;
	}
	
	public Usuario findById(Integer id) {
		usuarioDAO.abrirSessaoAtual();
		Usuario categoria = usuarioDAO.findById(id);
		usuarioDAO.encerrarSessaoAtual();
		return categoria;
	}

	public void delete(Integer id) {
		usuarioDAO.openCurrentSessionwithTransaction();
		Usuario categoria = usuarioDAO.findById(id);
		usuarioDAO.delete(categoria);
		usuarioDAO.closeCurrentSessionwithTransaction();
	}

	public List<Usuario> findAll() {
		usuarioDAO.abrirSessaoAtual();
		List<Usuario> usuarios = usuarioDAO.findAll();
		usuarioDAO.encerrarSessaoAtual();
		return usuarios;
	}

	public void deleteAll() {
		usuarioDAO.openCurrentSessionwithTransaction();
		usuarioDAO.deleteAll();
		usuarioDAO.closeCurrentSessionwithTransaction();
	}
}
