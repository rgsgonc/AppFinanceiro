package br.com.fean.jersey.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import br.com.fean.jersey.model.Usuario;

public class UsuarioDAO implements GenericDAO<Usuario>{

	private Session sessaoAtual;
	
	private Transaction atualTransacao;

	public UsuarioDAO(){
		
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
     
     public void persist(Usuario entity) {
         getCurrentSession().save(entity);
     }
  
     public Boolean update(Usuario usuarioAlterado) {
    	 getCurrentSession().update(usuarioAlterado);
    	 return true;
     }
	
     public Usuario findById(Integer id) {
    	 Usuario usuario = (Usuario) getCurrentSession().get(Usuario.class, id);
         return usuario;
     }
     
     public void delete(Usuario entity) {
         getCurrentSession().delete(entity);
     }
  
     @SuppressWarnings("unchecked")
     public List<Usuario> findAll() {
         List<Usuario> usuarios = (List<Usuario>) getCurrentSession().createQuery("from Usuario").list();
         return usuarios;
     }
  
     public void deleteAll() {
         List<Usuario> entityList = findAll();
         for (Usuario entity : entityList) {
             delete(entity);
         }
     }
     
}
