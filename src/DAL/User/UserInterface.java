/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.User;

import DAL.*;
import BL.User;
import java.util.List;

/**
 *
 * @author vegim
 */
public interface UserInterface {
    void create(User user) throws UserException;
    void edit (User user) throws UserException;
    void remove(User user) throws UserException;
    List<User> findAll();
//    User findById(User id) throws UserException;
}
