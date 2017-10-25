package br.com.fean.jersey.services;

import java.util.ArrayList;
import java.util.List;

import br.com.fean.jersey.model.Usuario;

public class UsuarioService {
	private static List<Usuario> usuarios = new ArrayList<Usuario>();
	
	public static List<Usuario> getTodosUsuarios() {
		if(usuarios == null) {
			return new ArrayList<Usuario>();
		}
		return usuarios;
	}
	
	public boolean cadastrarUsuario(Usuario usuarioInserir) {
		if(usuarios != null && !usuarios.isEmpty()) {
			for (Usuario usuario : usuarios) {
				if(usuarioInserir.getEmail().equals(usuario.getEmail())) {
					return false;
				}
			}
			defineIdUsuario(usuarioInserir);
		}else{
			usuarioInserir.setId(1);
		}
		
		usuarios.add(usuarioInserir);
		return true;
	}
	
	private void defineIdUsuario(Usuario usuarioInserir) {
		Usuario ultimoUsuario = null;
		for (Usuario usuario : usuarios) {
			ultimoUsuario = usuario;
		}
		usuarioInserir.setId(ultimoUsuario.getId()+1);
	}
	
	
	public Usuario buscarUsuarioId(Integer idUser) {
		for(Usuario user : usuarios){
			if(user.getId() == idUser){
				return user;
			}
		}
		return new Usuario();
	}

	public boolean alterarUsuario(Usuario usuarioUpdate) {
		for (Usuario usuario : usuarios) {
			if(usuario.getId() == usuarioUpdate.getId()) {
				usuario.setNome(usuarioUpdate.getNome());
				usuario.setEndereco(usuarioUpdate.getEndereco());
				usuario.setEmail(usuarioUpdate.getEmail());
				usuario.setTelefone(usuarioUpdate.getTelefone());
				usuario.setSenha(usuarioUpdate.getSenha());
				return true;
			}
		}
		return false;
	}
	
	public void deletarUsuario(Integer idUser) {
		Usuario usuario = buscarUsuarioId(idUser);
		usuarios.remove(usuario);
	}
}
