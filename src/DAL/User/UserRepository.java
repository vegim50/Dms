/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.User;

import DAL.*;
import BL.User;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author vegim
 */
public class UserRepository extends EntMngClass implements UserInterface{

    @Override
    public void create(User user) throws UserException {
        try{
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            
            if(thro.getMessage().contains("2627")){
            
                    throw new UserException("E dhëna egziston !");
            }
        else{
                throw new UserException("Create : "+thro.getClass()+" - "+thro.getMessage());
                }
        }//To change body of generated methods, choose Tools | Templates.//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(User user) throws UserException {
        try{
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            if(thro.getMessage().contains("2627")){
                    throw new UserException("E dhëna egziston");
            }
            else{
                throw new UserException("Update: "+thro.getClass()+" - "+thro.getMessage());
            }
                
        } //To change body of generated methods, choose Tools | Templates. //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(User user) throws UserException {
        try{
            em.getTransaction().begin();
            em.remove(user);
            em.getTransaction().commit();
        }catch(Throwable thro){
            if(thro.getMessage().contains("547")){
                throw new UserException("E dhëna është përdorur, nuk mund ta fshini!!");
            }
            else{
                 throw new UserException("Remove: "+thro.getClass()+" - "+thro.getMessage());
            }
        } //To change body of generated methods, choose Tools | Templates. //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> findAll() {
        return em.createNamedQuery("User.findAll").getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

//    /**
//     *
//     * @param id
//     * @return
//     * @throws UserException
//     */
//    @Override
//    public User findById(User id) throws UserException {
//        Query query = em.createQuery("SELECT u FROM User u WHERE u.id = :id");
//        query.setParameter("id", id);
//        try{
//            return (User)query.getSingleResult();
//        } catch (NoResultException nre) {
//              throw new UserException("E dhëna nuk egziston!");
//        } //To change body of generated methods, choose Tools | Templates. //To change body of generated methods, choose Tools | Templates.
//    }
    
    public User findByUserNameAndPassword(String username,String password) throws UserException {
        Query query = em.createQuery("SELECT c FROM User c WHERE c.username = :username and c.password = :password");
        query.setParameter("username", username);
        query.setParameter("password", password);
        try{
            return (User)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new UserException("E dhëna nuk egziston!");
        } //To change body of generated methods, choose Tools | Templates. //To change body of generated methods, choose Tools | Templates.
    }
    
   
    
}
