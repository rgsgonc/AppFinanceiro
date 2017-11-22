package br.com.fean.jersey.services;

import java.util.List;

import br.com.fean.jersey.dao.UsuarioDAO;
import br.com.fean.jersey.model.Login;
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

	public Boolean merge (Usuario usuarioAlterado) {
		usuarioDAO.openCurrentSessionwithTransaction();
		usuarioDAO.update(usuarioAlterado);
		usuarioDAO.closeCurrentSessionwithTransaction();
		
		return true;
	}
	
	public Usuario findById(Integer id) {
		usuarioDAO.abrirSessaoAtual();
		Usuario usuario = usuarioDAO.findById(id);
		usuarioDAO.encerrarSessaoAtual();
		return usuario;
	}

	public void delete(Integer id) {
		usuarioDAO.openCurrentSessionwithTransaction();
		Usuario usuario = usuarioDAO.findById(id);
		usuarioDAO.delete(usuario);
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
	
	public Boolean login (String email, String senha){
		usuarioDAO.openCurrentSessionwithTransaction();
		boolean existeUsuario = usuarioDAO.findByEmailESenha(email, senha);
		usuarioDAO.closeCurrentSessionwithTransaction();
		
		return existeUsuario;
	}
	
	public Boolean valideLogin(Login login){
		boolean usuarioExiste = false;
		
		if(login.getUsuario() != "" && login.getSenha() != ""){
			usuarioExiste = login(login.getUsuario(), login.getSenha());
		}
		
		return usuarioExiste;
	}
	
}
