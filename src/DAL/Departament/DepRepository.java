/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.Departament;

import DAL.*;
import BL.Departament;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author vega
 */
public class DepRepository extends EntMngClass implements DepInterface{

    @Override
    public void create(Departament departament) throws DepException {
        try{
            em.getTransaction().begin();
            em.persist(departament);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            
            if(thro.getMessage().contains("2627")){
            
                    throw new DepException("E dhëna egziston !");
            }
        else{
                throw new DepException("Create : "+thro.getClass()+" - "+thro.getMessage());
                }
        }//To change body of generated methods, choose Tools | Templates.//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(Departament departament) throws DepException {
        try{
            em.getTransaction().begin();
            em.merge(departament);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            if(thro.getMessage().contains("2627")){
                    throw new DepException("E dhëna egziston");
            }
            else{
                throw new DepException("Update: "+thro.getClass()+" - "+thro.getMessage());
            }
                
        } //To change body of generated methods, choose Tools | Templates. //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Departament departament) throws DepException {
        try{
            em.getTransaction().begin();
            em.remove(departament);
            em.getTransaction().commit();
        }catch(Throwable thro){
            if(thro.getMessage().contains("547")){
                throw new DepException("E dhëna është përdorur, nuk mund ta fshini!!");
            }
            else{
                 throw new DepException("Remove: "+thro.getClass()+" - "+thro.getMessage());
            }
        } //To change body of generated methods, choose Tools | Templates. //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Departament> findAll() {
        return em.createNamedQuery("Departament.findAll").getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    public Departament findById(int id) throws DepException {
        Query query = em.createQuery("SELECT d FROM Departament d WHERE d.id = :id");
        query.setParameter("id", id);
        try{
            return (Departament)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new DepException("E dhëna nuk egziston!");
        } //To change body of generated methods, choose Tools | Templates. //To change body of generated methods, choose Tools | Templates.
    }
    
}
