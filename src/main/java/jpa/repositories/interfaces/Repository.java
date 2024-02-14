package jpa.repositories.interfaces;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jpa.EntityManagerHelper;

public class Repository<T> {

    EntityManager manager;
    String tableName;

    public Repository(String table){
        this.manager =  EntityManagerHelper.getEntityManager();
        this.tableName = table;
    }
    
    /**
     * Close entity manager
     */
    public void closeManager(){
        this.manager.close();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    /**
     * Get Transaction
     * @return
     */
    public EntityTransaction transactionRepository(){
        EntityTransaction tx = this.manager.getTransaction();
        return tx;
    }

    // public <T> String tableName(T obj){
    //     return obj.getClass().getName()+"s";
    // }
    
    /**
     * Get all records from table
     * @param table
     * @return List<T>
     */
    public List<T> selectAll(){
        transactionRepository().begin();
        System.err.println("********* START ****************");

        try {
            // Query query = this.manager.createQuery("select t from "+ tableName +" t");
            Query query = this.manager.createQuery("select u from "+tableName+" u");
            System.out.println(query.getResultList().getFirst());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        transactionRepository().commit();
        closeManager();
        System.err.println("********* END ****************");

        return null;
    }

    /**
     * Find one records by our id
     * @param id
     * @return T
     */
    public T findById(Long id){
        try {

        } catch (Exception e) {
            // TODO: handle exception
        }

        closeManager();
        return null;
    }

}
