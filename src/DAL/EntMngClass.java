/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author vega
 */
public class EntMngClass {
    public EntityManager em = Persistence.createEntityManagerFactory("DMSPU").createEntityManager();
}
