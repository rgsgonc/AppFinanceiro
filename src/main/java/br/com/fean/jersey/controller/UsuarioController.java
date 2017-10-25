package br.com.fean.jersey.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import br.com.fean.jersey.model.Usuario;

import br.com.fean.jersey.services.UsuarioService;

@Path("/usuario")
public class UsuarioController {
	
	private UsuarioService usuarioService = new UsuarioService();
	
	@POST
	@Path("/cadastro")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String cadastrarUsuario(Usuario usuario){
		if(usuarioService.cadastrarUsuario(usuario)){
			return "Usuario cadastrado!";
		}
		return "E-mail já cadastrado!";
	}
	
	@GET
	@Path("/buscar/{idUser}")
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario buscarUsuario(@PathParam("idUser") Integer idUser) {	
		return usuarioService.buscarUsuarioId(idUser);
	}
	
	@PUT
	@Path("/editar")
    @Consumes(MediaType.APPLICATION_JSON)
	public String editarUsuario(Usuario usuario) {
		if(usuarioService.alterarUsuario(usuario)) {
			return "Usuario alterado!";
		}
		
		return "Erro ao alterar usuario!";
		
	}
	
	@DELETE
	@Path("/delete/{idUser}")
	public String deletarUsuario(@PathParam("idUser") Integer idUser) {
		usuarioService.deletarUsuario(idUser);
		return "Usuario excluido!";
	}
	
	
}


	
