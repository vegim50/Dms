/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BL.Category;
import BL.Data;
import BL.Departament;
import BL.User;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author vega
 */
public class DmsRepository extends EntMngClass implements DmsInterface{

   
    public void create(Data data) throws DmsException {
        try{
            em.getTransaction().begin();
            em.persist(data);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            
            if(thro.getMessage().contains("2627")){   //smundesh me bo update ni primary key
            
                    throw new DmsException("E dhëna egziston !");
            }
        else{
                throw new DmsException("Create : "+thro.getClass()+" - "+thro.getMessage());
                }
        }//To change body of generated methods, choose Tools | Templates.
    }

    
    public void edit(Data data) throws DmsException {
        try{
            em.getTransaction().begin();
            em.merge(data);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            if(thro.getMessage().contains("2627")){
                    throw new DmsException("E dhëna egziston");
            }
            else{
                throw new DmsException("Update: "+thro.getClass()+" - "+thro.getMessage());
            }
                
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Data data) throws DmsException {
        try{
            em.getTransaction().begin();
            em.remove(data);
            em.getTransaction().commit();
        }catch(Throwable thro){
            if(thro.getMessage().contains("547")){ //kur don me fshi ni te dhene qe eshte e lidhur me nje te dhene tjeter me ane te foreign keys
                throw new DmsException("E dhëna është përdorur, nuk mund ta fshini!!"); 
            }
            else{
                 throw new DmsException("Remove: "+thro.getClass()+" - "+thro.getMessage());
            }
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Data> findAll() {
        return em.createNamedQuery("Data.findAll").getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

//    @Override
//    public Data findById(Data id) throws DmsException {
//        Query query = em.createQuery("SELECT d FROM Data d WHERE d.id = :id");
//        query.setParameter("id", id);
//        try{
//            return (Data)query.getSingleResult();
//        } catch (NoResultException nre) {
//              throw new DmsException("E dhëna nuk egziston!");
//        } //To change body of generated methods, choose Tools | Templates.
//    }
    
    public List<Data> findByStatus() {
        Query query = em.createQuery("SELECT d FROM Data d WHERE d.status = true and d.isDeleted = false");
            return query.getResultList();
        //To change body of generated methods, choose Tools | Templates
    }
    
    public List<Data> findByStatusReview() {
        Query query = em.createQuery("SELECT d FROM Data d WHERE d.status = null and d.isDeleted = false");
            return query.getResultList();
        //To change body of generated methods, choose Tools | Templates
    }
    
    public List<Data> findByStatusRejected() {
        Query query = em.createQuery("SELECT d FROM Data d WHERE d.status = false and d.isDeleted = false");
            return query.getResultList();
        //To change body of generated methods, choose Tools | Templates
    }
    
    public List<Data> findByIsDeleted(){
        Query query = em.createQuery("SELECT d FROM Data d WHERE d.isDeleted = true");
            return query.getResultList();
    }
    
    public long countRows(){ // numri te review
        return (long) em.createQuery("SELECT COUNT(d.id) FROM Data d Where d.status is null").getSingleResult();
    }
    
    
    public List<Data> searchDoc(Departament d,User u, Category c, String s, boolean exact) throws DmsException{
        StringBuilder sb = new StringBuilder("SELECT d FROM Data d WHERE 1=1 AND d.status = true and d.isDeleted = false AND ");


        if (s != null && !s.isEmpty()){
            String comparator =  exact ? "= :" : "LIKE :";
            sb.append("(d.realname ")
                .append(comparator)
                .append("search OR d.description ")
                .append(comparator)
                .append("search) AND ");
        }
        else if(s == null || s.isEmpty()){
            sb = new StringBuilder("SELECT d FROM Data d WHERE 1=1 AND d.status = true and d.isDeleted = false AND ");
        }
        
        if (d != null) sb.append("d.department = :department AND ");
        if (c != null) sb.append("d.category = :category AND ");
        if (u != null) sb.append("d.owner = :owner AND ");
        
//        if (sb.toString().endsWith(" d WHERE ")) {
//            return findAll();
//        }
//        
        String queryString = sb.toString();
        
        if (queryString.endsWith("AND ")) {
            queryString = queryString.substring(0, queryString.lastIndexOf("AND"));
        }
        
        Query query = em.createQuery(queryString);
        
        if (s != null && !s.isEmpty()) {
            query.setParameter("search", exact ? s : "%" + s + "%");
        }
        if (d != null) query.setParameter("department", d); 
        if (c != null) query.setParameter("category", c);
        if (u != null) query.setParameter("owner", u);
        
        try{
            return (List<Data>) query.getResultList();
        } catch (NoResultException nre) {
            throw new DmsException("E dhëna nuk egziston!");
        }
    }
}
