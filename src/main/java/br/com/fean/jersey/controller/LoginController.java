package br.com.fean.jersey.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.fean.jersey.model.Login;

@Path("/login")
public class LoginController {
	@POST
	@Path("/autenticacao")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean efetuarLogin(Login login) {
		if (login.getUsuario().equals("rafael") && login.getSenha().equals("123456")) {
			return true;
		} else {
			return false;
		}
	}
}
