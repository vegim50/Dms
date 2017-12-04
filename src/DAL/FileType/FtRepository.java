/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.FileType;

import DAL.*;
import BL.Filetypes;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author vegim
 */
public class FtRepository extends EntMngClass implements FtInterface{

    @Override
    public void create(Filetypes filetypes) throws FtException {
        try{
            em.getTransaction().begin();
            em.persist(filetypes);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            
            if(thro.getMessage().contains("2627")){
            
                    throw new FtException("E dhëna egziston !");
            }
        else{
                throw new FtException("Create : "+thro.getClass()+" - "+thro.getMessage());
                }
        }//To change body of generated methods, choose Tools | Templates.//To change body of generated methods, choose Tools | Templates.//To change body of generated methods, choose Tools | Templates.//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(Filetypes filetypes) throws FtException {
        try{
            em.getTransaction().begin();
            em.merge(filetypes);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            if(thro.getMessage().contains("2627")){
                    throw new FtException("E dhëna egziston");
            }
            else{
                throw new FtException("Update: "+thro.getClass()+" - "+thro.getMessage());
            }
                
        } //To change body of generated methods, choose Tools | Templates. //To change body of generated methods, choose Tools | Templates. //To change body of generated methods, choose Tools | Templates. //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Filetypes filetypes) throws FtException {
        try{
            em.getTransaction().begin();
            em.remove(filetypes);
            em.getTransaction().commit();
        }catch(Throwable thro){
            if(thro.getMessage().contains("547")){
                throw new FtException("E dhëna është përdorur, nuk mund ta fshini!!");
            }
            else{
                 throw new FtException("Remove: "+thro.getClass()+" - "+thro.getMessage());
            }
        } //To change body of generated methods, choose Tools | Templates. //To change body of generated methods, choose Tools | Templates. //To change body of generated methods, choose Tools | Templates. //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<String> fileTypes(){
        Query query = em.createQuery("SELECT f.type FROM Filetypes f Where f.active = true");
            return query.getResultList();
    }

//    @Override
//    public Filetypes findById(Filetypes id) throws FtException {
//        Query query = em.createQuery("SELECT d FROM Filetypes d WHERE d.id = :id");
//        query.setParameter("id", id);
//        try{
//            return (Filetypes)query.getSingleResult();
//        } catch (NoResultException nre) {
//              throw new FtException("E dhëna nuk egziston!");
//        } //To change body of generated methods, choose Tools | Templates. //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public List<Filetypes> findAll() {
          return em.createNamedQuery("Filetypes.findAll").getResultList(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
