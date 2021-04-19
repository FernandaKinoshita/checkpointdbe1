package br.com.fiap.tds.checkpoint.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type;

import br.com.fiap.tds.checkpoint.model.Setup;
import br.com.fiap.tds.checkpoint.util.EntityManagerFacade;

public class SetupDao {
	
	private EntityManager entityManager = EntityManagerFacade.get();

	public void save(Setup setup) {
		try {
			entityManager.getTransaction().begin();	
			entityManager.persist(setup);
			entityManager.getTransaction().commit();
			
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
		}
		
		entityManager.close();
	}

	public List<Setup> getAll() {
		String jpql = "SELECT s FROM Setup s";
		TypedQuery<Setup> query = entityManager.createQuery(jpql, Setup.class);
			
		return query.getResultList();
	}
}
