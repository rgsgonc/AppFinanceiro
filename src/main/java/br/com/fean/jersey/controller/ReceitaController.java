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

import br.com.fean.jersey.model.Receita;
import br.com.fean.jersey.services.ReceitaService;

@Path("/receita")
public class ReceitaController {
	private ReceitaService receitaService = new ReceitaService();
	
	@POST
	@Path("/cadastro")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String cadastrarReceita(Receita receita){
		if(receitaService.cadastrarReceita(receita)){
			return "Receita cadastrada!";
		}
		return "Receita já cadastrada!";
	}
	
	@GET
	@Path("/buscar/{idReceita}")
	@Produces(MediaType.APPLICATION_JSON)
	public Receita buscarReceita(@PathParam("idReceita") Integer idReceita) {	
		return receitaService.buscarReceitaId(idReceita);
	}
	
	@PUT
	@Path("/editar")
    @Consumes(MediaType.APPLICATION_JSON)
	public String editarReceita(Receita receita) {
		if(receitaService.alterarReceita(receita)) {
			return "Receita alterada!";
		}
		
		return "Erro ao alterar receita!";
		
	}
	
	@DELETE
	@Path("/delete/{idReceita}")
	public String deletarReceita(@PathParam("idReceita") Integer idReceita) {
		receitaService.deletarReceita(idReceita);
		return "Receita excluida!";
	}
}
