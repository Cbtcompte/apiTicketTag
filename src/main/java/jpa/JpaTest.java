package jpa;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jpa.builders.CollaborateurBuilder;
import jpa.models.Collaborateur;

public class JpaTest {


	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		EntityManager manager = EntityManagerHelper.getEntityManager();
		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			Collaborateur equipe = new CollaborateurBuilder().setName("Pythagore").build();
			manager.persist(equipe);

			Query query = manager.createQuery("select e from Equipes e");
            System.err.println(query.getResultList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

			
   	    manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		System.out.println(".. done");
	}




}
