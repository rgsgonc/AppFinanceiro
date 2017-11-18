package br.com.fean.jersey.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.fean.jersey.model.Login;
import br.com.fean.jersey.services.UsuarioService;

@Path("/login")
public class LoginController {
	
	private UsuarioService usuarioService = new UsuarioService();
	
	@POST
	@Path("/autenticacao")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean efetuarLogin(Login login) {
		
		boolean estaAutenticado = false;
		
		if(usuarioService.valideLogin(login)){
			estaAutenticado = true;
		} else {
			estaAutenticado = false;
		}
		
		return estaAutenticado;
	}
}
