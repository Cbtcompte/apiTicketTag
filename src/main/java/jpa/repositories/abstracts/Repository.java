package jpa.repositories.abstracts;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jpa.EntityManagerHelper;

public abstract class Repository<T> {

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
    
    /**
     * Get all records from table
     * @param table
     * @return List<T>
     */
    public List<T> selectAll(){
        List<T> result = new ArrayList<>();
        System.err.println("********* START ****************");
        try {
            getManager();
            Query query = this.manager.createQuery("select u from "+tableName+" u");
            result = (List<T>) query.getResultList();
        } catch (Exception e) {
            System.err.println("=> "+e.getMessage());
        }
        System.err.println("********* END ****************");

        return result;
    }

    /**
     * Get all records from table with where clauses
     * @param champ is String. This parameter represent the name of field for this table. For foreign key we use only the name without "_id"
     * @see Ex for "equipe_id" we use "equipe" only. It is the name of getter used when you declare your relation
     * @param Object this parameter is value of champ that you want to make your research. If is foreign key value, we use the objet of model associate
     * @see Exp For previous example the value will be the objet of equipe
     * @return List<T>
     */
    public List<T> selectWithWhereClause(String champ, Object value){
        List<T> result = new ArrayList<>();
        System.err.println("********* START ****************");
        try {
            getManager();
            Query query = this.manager.createQuery("select u from "+tableName+" u where "+champ+"= :value", tableName.getClass());
            query.setParameter("value", value);
            result = (List<T>) query.getResultList();
        } catch (Exception e) {
            System.err.println("=> "+e.getMessage());
        }
        System.err.println("********* END ****************");

        return result;
    }

    /**
     * This function enable to make create a query with a clause where contained many condition.
     * @param champ same as "selectWithWhereClause" function. But it's a List of String
     * @param value same as "selectWithWhereClause" function. But it's a List of Object
     * @param condition it's list of condition like ['or', 'and', '=', etc.]
     * @return
     */
    public List<T> selectWithMultipleWhereClause(List<String> champ, List<Object> value, List<String> condition){
        // TODO::Intruction
        return null;
    }

    /**
     * Get all records from table with all data related with him
     * @param tableAssociate is the name of relation model with this table. This name must to be lowercase
     * @see Exp For table "project" we use like tableAssociate "listes". It is the name of getter used when you declare your relation
     * @return List<T>
     */
    public List<T> selectWithJoinFetch(String tableAssociate){
        List<T> result = new ArrayList<>();
        System.err.println("********* START ****************");
        try {
            getManager();
            Query query = this.manager.createQuery("select u from "+tableName+" u join fetch u."+tableAssociate+" s", tableName.getClass());
            result = (List<T>) query.getResultList();
        } catch (Exception e) {
            System.err.println("=> "+e.getMessage());
        }
        System.err.println("********* END ****************");

        return result;
    }


    /**
     * Get all records from table with all data related with him
     * @param tableAssociate is the name of relation model with this table. This name must to be lowercase
     * @see Exp For table "project" we use like tableAssociate "listes". It is the name of getter used when you declare your relation
     * @return List<T>
     */
    public List<T> selectWithLeftJoinFetch(String tableAssociate){
        List<T> result = new ArrayList<>();
        System.err.println("********* START ****************");
        try {
            getManager();
            Query query = this.manager.createQuery("select u from "+tableName+" u left join fetch u."+tableAssociate+" s", tableName.getClass());
            result = (List<T>) query.getResultList();
        } catch (Exception e) {
            System.err.println("=> "+e.getMessage());
        }
        System.err.println("********* END ****************");

        return result;
    }


    /**
     * Get all records from table with all data related with him
     * @param tableAssociate is the name of relation model with this table. This name must to be lowercase
     * @param champ is String. This parameter represent the name of field for this table. For foreign key we use only the name without "_id"
     * @param value is value of where clause
     * @see Exp For table "project" we use like tableAssociate "listes". It is the name of getter used when you declare your relation
     * @return List<T>
     */
    public T findByIdWithJoinFetch(String tableAssociate, Object value){
        T result = null;
        System.err.println("********* START ****************");
        try {
            getManager();
            Query query = this.manager.createQuery("select u from "+tableName+" u left join fetch u."+tableAssociate+" s where u.id = :value", tableName.getClass());
            query.setParameter("value", value);
            result = (T) query.getSingleResult();
        } catch (Exception e) {
            System.err.println("=> "+e.getMessage());
        }
        System.err.println("********* END ****************");

        return result;
    }


    /**
     * Get all records from table with all data related with him
     * @param tableAssociate is the name of relation model with this table. This name must to be lowercase
     * @param champ is String. This parameter represent the name of field for this table. For foreign key we use only the name without "_id"
     * @param value is value of where clause
     * @see Exp For table "project" we use like tableAssociate "listes". It is the name of getter used when you declare your relation
     * @return List<T>
     */
    public T selectWithJoinFetchAndWhereClause(String champ, String tableAssociate, Object value){
        T result = null;
        System.err.println("********* START ****************");
        try {
            getManager();
            Query query = this.manager.createQuery("select u from "+tableName+" u left join fetch u."+tableAssociate+" s where u."+champ+"= :value", tableName.getClass());
            query.setParameter("value", value);
            result = (T) query.getResultList();
        } catch (Exception e) {
            System.err.println("=> "+e.getMessage());
        }
        System.err.println("********* END ****************");

        return result;
    }

    /**
     * Find one records by its id
     * @param id is id of objet
     * @return T
     */
    public T findById(Long id){
        T result = null;
        try {
            getManager();
            Query query = this.manager.createQuery("select u from "+tableName+" u where u.id = :idElement");
            query.setParameter("idElement", id);
            result = (T) query.getSingleResult();
        } catch (Exception e) {
            System.err.println("=> "+e.getMessage());
        }
        return result;
    }
    
    /**
     * Permet de créer un objet de type T dans la base de donnée
     * @param t
     * @throws Exception 
     */
    public void create(T t) throws Exception {
        getManager();
        transactionRepository().begin();
        System.err.println("********* START ****************");
        try {
            manager.persist(t);
            System.out.println("Insertion fait....");
        } catch (Exception e) {
           throw new Exception(e.getMessage());
        }
        transactionRepository().commit();
        System.err.println("********* END ****************");
    }

    public void delete (Long id){
        try {
            Query query = this.manager.createQuery("delete from "+tableName+" u where u.id = :idElement");
            query.setParameter("idElement", id);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
