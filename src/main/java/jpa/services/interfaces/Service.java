package jpa.services.interfaces;

import java.util.List;

/**
 * Service
 */
public interface Service<T> {
    /**
    * This method return all project from database
    *
    * @return List<T>
    */
    public List<T> getAll();

    /**
    * This method return one project from database. This project is identify by its id
    *
    * @return T
    */
    public T get(Long id);

    /*
     * This method allow to add new row
     */
    public T add(T t) throws Exception;


    public T update(T t, Long id) throws Exception;

    /*
     * This method allow to delete the row of id
     */
    public void delete(Long id);
}