package br.com.fean.jersey.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.fean.jersey.model.Receita;
import br.com.fean.jersey.services.ReceitaService;

@Path("/receita")
public class ReceitaController {
	@POST
	@Path("/cadastro")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String receitaDespesa(Receita receita) {
		ReceitaService rs = new ReceitaService();
		rs.cadastrarReceitas(receita);
		return "Receita salva com sucesso";
	}
	
	@GET
	@Path("/listarReceitas")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Receita> getReceitas() {
		List<Receita> receitas = ReceitaService.getTodasReceitas();
		return receitas;
	}
}
