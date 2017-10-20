package br.com.fean.jersey.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.fean.jersey.model.Despesa;
import br.com.fean.jersey.services.DespesaService;

@Path("/despesa")
public class DespesaController {
	@POST
	@Path("/cadastro")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String despesa(Despesa despesa) {
		DespesaService ds = new DespesaService();
		ds.cadastrarDespesa(despesa);
		return "Despesa salva com sucesso";
	}
	
	@GET
	@Path("/listarDespesas")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Despesa> getDespesas() {
		List<Despesa> despesas = DespesaService.getTodasDespesas();
		return despesas;
	}
}
