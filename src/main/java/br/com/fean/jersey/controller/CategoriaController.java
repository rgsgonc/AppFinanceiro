package br.com.fean.jersey.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.fean.jersey.model.Categoria;
import br.com.fean.jersey.services.CategoriaService;

@Path("/categoria")
public class CategoriaController {
	@POST
	@Path("/cadastro")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String cadastrarCategoria(Categoria categoria) {
		CategoriaService cs = new CategoriaService();
		cs.cadastrarCategoria(categoria);
		return "Categoria salva com sucesso";
	}
	
	@GET
	@Path("/listarCategorias")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Categoria> getCategorias() {
		List<Categoria> categorias = CategoriaService.getTodasCategorias();
		return categorias;
	}
}
