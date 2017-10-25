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

import br.com.fean.jersey.model.Cartao;
import br.com.fean.jersey.model.Usuario;
import br.com.fean.jersey.services.CartaoService;
import br.com.fean.jersey.services.UsuarioService;

@Path("/cartao")
public class CartaoController {
	
	private CartaoService cartaoService = new CartaoService();
	
	@POST
	@Path("/cadastro")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String cadastrarCartao(Cartao cartao){
		if(cartaoService.cadastrarCartao(cartao)){
			return "Cartão cadastrado!";
		}
		return "Cartão já cadastrado!";
	}
	
	@GET
	@Path("/buscar/{idCartao}")
	@Produces(MediaType.APPLICATION_JSON)
	public Cartao buscarCartao(@PathParam("idCartao") Integer idCartao) {	
		return cartaoService.buscarCartaoId(idCartao);
	}
	
	@PUT
	@Path("/editar")
    @Consumes(MediaType.APPLICATION_JSON)
	public String editarCartao(Cartao cartao) {
		if(cartaoService.alterarCartao(cartao)) {
			return "Cartao alterado!";
		}
		
		return "Erro ao alterar cartão!";
		
	}
	
	@DELETE
	@Path("/delete/{idCartao}")
	public String deletarCartao(@PathParam("idCartao") Integer idCartao) {
		cartaoService.deletarCartao(idCartao);
		return "Cartão excluido!";
	}
}
