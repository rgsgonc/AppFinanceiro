package br.com.fean.jersey.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import br.com.fean.jersey.model.Usuario;

import br.com.fean.jersey.services.UsuarioService;

@Path("/usuario")
public class UsuarioController {
	@POST
	@Path("/cadastro")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String cadastrarUsuario(Usuario usuario){
		UsuarioService s = new UsuarioService();
		s.cadastrarUsuario(usuario);
		return "Usuario salvo com sucesso!";
	}
	
	@GET
	@Path("/listarUsuario")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> listarUsuario() {
		List<Usuario> usuarios = UsuarioService.getTodosUsuarios();
		return usuarios;
		
	}
	}
	
