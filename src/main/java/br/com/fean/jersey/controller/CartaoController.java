package br.com.fean.jersey.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.fean.jersey.model.Cartao;
import br.com.fean.jersey.services.CartaoService;

@Path("/cartao")
public class CartaoController {
	@POST
	@Path("/cadastro")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String cadastrarCartao(Cartao cartao) {
		CartaoService cs = new CartaoService();
		cs.cadastrarCartao(cartao);
		return "Cartão salvo com sucesso";
	}
	
	@GET
	@Path("/listarCartoes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cartao> getListarCartoes() {
		List<Cartao> cartoes = CartaoService.getTodosCartoes();
		return cartoes;
	}
}
