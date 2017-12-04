/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.Departament;

import BL.Departament;
import java.util.List;

/**
 *
 * @author vega
 */
public interface DepInterface {
    void create(Departament departament) throws DepException;
    void edit (Departament departament) throws DepException;
    void remove(Departament departament) throws DepException;
    List<Departament> findAll();
    Departament findById(int id) throws DepException;
}
