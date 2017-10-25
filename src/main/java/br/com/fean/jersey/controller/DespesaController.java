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

import br.com.fean.jersey.model.Despesa;
import br.com.fean.jersey.services.DespesaService;

@Path("/despesa")
public class DespesaController {
	
	private DespesaService despesaService = new DespesaService();
	
	@POST
	@Path("/cadastro")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String cadastrarDespesa(Despesa despesa){
		if(despesaService.cadastrarDespesa(despesa)){
			return "Despesa cadastrada!";
		}
		return "Despesa já cadastrada!";
	}
	
	@GET
	@Path("/buscar/{idDespesa}")
	@Produces(MediaType.APPLICATION_JSON)
	public Despesa buscarDespesa(@PathParam("idDespesa") Integer idDespesa) {	
		return despesaService.buscarDespesaId(idDespesa);
	}
	
	@PUT
	@Path("/editar")
    @Consumes(MediaType.APPLICATION_JSON)
	public String editarDespesa(Despesa despesa) {
		if(despesaService.alterarDespesa(despesa)) {
			return "Despesa alterada!";
		}
		
		return "Erro ao alterar despesa!";
		
	}
	
	@DELETE
	@Path("/delete/{idDespesa}")
	public String deletarDespesa(@PathParam("idDespesa") Integer idDespesa) {
		despesaService.deletarDespesa(idDespesa);
		return "Despesa excluida!";
	}
}
