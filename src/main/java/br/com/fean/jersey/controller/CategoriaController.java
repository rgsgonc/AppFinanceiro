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
import br.com.fean.jersey.services.CategoriaService;

@Path("/categoria")
public class CategoriaController {
	
	private CategoriaService categoriaService = new CategoriaService();
	
	@POST
	@Path("/cadastro")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Categoria cadastrarCategoria(Categoria categoria){
		if(categoria != null){
			categoriaService.persiste(categoria);
		}
		return categoria;
	}
	
	@GET
	@Path("/buscar/{idCategoria}")
	@Produces(MediaType.APPLICATION_JSON)
	public Categoria buscarCategoria(@PathParam("idCategoria") Integer idCategoria) {	
		return categoriaService.findById(idCategoria);
	}
	
	@PUT
	@Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
	public String editarCategoria(Categoria categoriaAlterada) {
		if(categoriaService.merge(categoriaAlterada)) {
			return "Categoria alterada!";
		}
		return "Erro ao alterar Categoria!";
	}
	
	@DELETE
	@Path("/delete/{idCategoria}")
	public String deletarCategoria(@PathParam("idCategoria") Integer idCategoria) {
		categoriaService.delete(idCategoria);
		return "Categoria excluida!";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/list")
	public List<Categoria> listarCategoria(){
		return categoriaService.findAll();
	}
}
