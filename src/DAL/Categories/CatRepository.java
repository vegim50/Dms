/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.Categories;

import DAL.*;
import BL.Category;
import java.util.List;

/**
 *
 * @author vega
 */
public class CatRepository extends EntMngClass implements CatInterface{

    @Override
    public void create(Category category) throws CatException {
        try{
            em.getTransaction().begin();
            em.persist(category);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            
            if(thro.getMessage().contains("2627")){
            
                    throw new CatException("E dhëna egziston !");
            }
        else{
                throw new CatException("Create : "+thro.getClass()+" - "+thro.getMessage());
                }
        }//To change body of generated methods, choose Tools | Templates.//To change body of generated methods, choose Tools | Templates.//To change body of generated methods, choose Tools | Templates.//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(Category category) throws CatException {
        try{
            em.getTransaction().begin();
            em.merge(category);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            if(thro.getMessage().contains("2627")){
                    throw new CatException("E dhëna egziston");
            }
            else{
                throw new CatException("Update: "+thro.getClass()+" - "+thro.getMessage());
            }
                
        } //To change body of generated methods, choose Tools | Templates. //To change body of generated methods, choose Tools | Templates. //To change body of generated methods, choose Tools | Templates. //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Category category) throws CatException {
        try{
            em.getTransaction().begin();
            em.remove(category);
            em.getTransaction().commit();
        }catch(Throwable thro){
            if(thro.getMessage().contains("547")){
                throw new CatException("E dhëna është përdorur, nuk mund ta fshini!!");
            }
            else{
                 throw new CatException("Remove: "+thro.getClass()+" - "+thro.getMessage());
            }
        } //To change body of generated methods, choose Tools | Templates. //To change body of generated methods, choose Tools | Templates. //To change body of generated methods, choose Tools | Templates. //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Category> findAll() {
        return em.createNamedQuery("Category.findAll").getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

}
