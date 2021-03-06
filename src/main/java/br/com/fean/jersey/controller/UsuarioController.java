package br.com.fean.jersey.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.fean.jersey.model.Categoria;
import br.com.fean.jersey.model.Usuario;

import br.com.fean.jersey.services.UsuarioService;

@Path("/usuario")
public class UsuarioController {

	private UsuarioService usuarioService = new UsuarioService();

	@POST
	@Path("/cadastro")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Usuario cadastrarUsuario(Usuario usuario) {
		if(usuario != null){
			usuarioService.persiste(usuario);
		}
		return usuario;
	}

	@GET
	@Path("/buscar/{idUser}")
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario buscarUsuario(@PathParam("idUser") Integer idUser) {
		return usuarioService.findById(idUser);
	}

	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Usuario editarUsuario(Usuario usuario) {
		if (usuarioService.merge(usuario)) {
			return usuario;
		}
		return usuario;
	}
	
	@DELETE
	@Path("/delete/{idUsuario}")
	public String deletarUsuario(@PathParam("idUsuario") Integer idUsuario) {
		usuarioService.delete(idUsuario);
		return "Usuario excluido!";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/list")
	public List<Usuario> listarUsuario(){
		return usuarioService.findAll();
	}
	
}
