/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BL.Data;
import java.util.List;

/**
 *
 * @author vega
 */
public interface DmsInterface {
    void create(Data data) throws DmsException;
    void edit (Data data) throws DmsException;
    void remove(Data data) throws DmsException;
    List<Data> findAll();
//    Data findById(Data id) throws DmsException;
}
