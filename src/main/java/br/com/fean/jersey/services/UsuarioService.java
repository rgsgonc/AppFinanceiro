package br.com.fean.jersey.services;

import java.util.ArrayList;
import java.util.List;

import br.com.fean.jersey.model.Usuario;

public class UsuarioService {
	private static List<Usuario> usuarios = new ArrayList<Usuario>();
	
	
	public static List<Usuario> getTodosUsuarios() {
		return usuarios;
	}
	
	public boolean cadastrarUsuario(Usuario usuarioInserir) {
		usuarios.add(usuarioInserir);
		return true;
	}
}
