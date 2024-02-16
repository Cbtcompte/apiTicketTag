package jpa.repositories.subClasses;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jpa.EntityManagerHelper;
import jpa.models.Equipes;

public class Repository<T> {

    EntityManager manager;
    String tableName;

    public Repository(String table){
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
     * Permet de récupérer l'entity manager
     */
    public void getManager(){
        if( this.manager == null || !this.manager.isOpen()){
            this.manager = EntityManagerHelper.getEntityManager();
        }
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
        List<T> result = null;
        System.err.println("********* START ****************");
        try {
            System.err.println(this.manager.isOpen());
            Query query = this.manager.createQuery("select u from "+tableName+" u");
            result = (List<T>) query.getResultList();
        } catch (Exception e) {
            System.err.println("=> "+e.getMessage());
        }
        System.err.println("********* END ****************");

        return result;
    }

    /**
     * Find one records by our id
     * @param id
     * @return T
     */
    public T findById(Long id){
        T result = null;
        try {
            Query query = this.manager.createQuery("select u from "+tableName+" u where id = :idElement");
            query.setParameter("idElement", id);
            result = (T) query.getSingleResult();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return result;
    }
    
    /**
     * Permet de créer un objet de type T dans la base de donnée
     * @param t
     */
    public void create(T t){
        transactionRepository().begin();
        System.err.println("********* START ****************");
        try {
            manager.persist(t);
            System.out.println("Insertion fait....");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        transactionRepository().commit();
        System.err.println("********* END ****************");
    }

    // /**
    //  * 
    //  * @param t
    //  * @return
    //  */
    // public T createForTableWithForeignKey(T t){
    //     System.err.println("********* START ****************");
    //     try {
    //         manager.persist(t);
    //     } catch (Exception e) {
    //         System.err.println(e.getMessage());
    //     }
    //     closeManager();
    //     System.err.println("********* END ****************");
        
    //     return null;
    // }

}
