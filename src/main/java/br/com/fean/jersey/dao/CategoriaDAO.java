package br.com.fean.jersey.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import br.com.fean.jersey.model.Categoria;

public class CategoriaDAO implements GenericDAO<Categoria>{

	private Session sessaoAtual;
	
	private Transaction atualTransacao;

	public CategoriaDAO(){
		
	}
	
	public Session abrirSessaoAtual() {
		sessaoAtual = getSessionFactory().openSession();
		return sessaoAtual;
	}
    
	public Session openCurrentSessionwithTransaction() {
		sessaoAtual = getSessionFactory().openSession();
		atualTransacao = sessaoAtual.beginTransaction();
		return sessaoAtual;

	}
    public void encerrarSessaoAtual() {
    	sessaoAtual.close();
	}

    
	 public void closeCurrentSessionwithTransaction() {
		 atualTransacao.commit();
		         sessaoAtual.close();
     }
      
     private static SessionFactory getSessionFactory() {
         Configuration configuration = new Configuration().configure();
         StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                 .applySettings(configuration.getProperties());
         SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
         return sessionFactory;
     }
     
     public Session getCurrentSession() {
         return sessaoAtual;
     }
  
     public void setCurrentSession(Session currentSession) {
         this.sessaoAtual = currentSession;
     }
     
     public Transaction getCurrentTransaction() {
         return atualTransacao;
     }
  
     public void setCurrentTransaction(Transaction currentTransaction) {
         this.atualTransacao = currentTransaction;
     }
     
     public void persist(Categoria entity) {
         getCurrentSession().save(entity);
     }
  
     public Boolean update(Categoria usuarioAlterado) {
    	 getCurrentSession().update(usuarioAlterado);
    	 return true;
     }
	
     public Categoria findById(Integer id) {
    	 Categoria usuario = (Categoria) getCurrentSession().get(Categoria.class, id);
         return usuario;
     }
     
     public void delete(Categoria entity) {
         getCurrentSession().delete(entity);
     }
  
     @SuppressWarnings("unchecked")
     public List<Categoria> findAll() {
         List<Categoria> categorias = (List<Categoria>) getCurrentSession().createQuery("from Categoria").list();
         return categorias;
     }
  
     public void deleteAll() {
         List<Categoria> entityList = findAll();
         for (Categoria entity : entityList) {
             delete(entity);
         }
     }
     
}
