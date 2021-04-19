package br.com.fiap.tds.checkpoint.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.tds.checkpoint.model.Usuario;
import br.com.fiap.tds.checkpoint.util.EntityManagerFacade;

public class UsuarioDao {
	
	private EntityManager entityManager = EntityManagerFacade.get();

	public void save(Usuario usuario) {
		try {
			entityManager.getTransaction().begin();	
			entityManager.persist(usuario);
			entityManager.getTransaction().commit();
			
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
		}
		
		entityManager.close();
	}
	
	public List<Usuario> getAll() {
		String jpql = "SELECT s FROM Usuario s";
		TypedQuery<Usuario> query = entityManager.createQuery(jpql, Usuario.class);
			
		return query.getResultList();
	}
}
