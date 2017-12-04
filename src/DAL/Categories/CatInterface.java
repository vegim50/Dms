/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.Categories;

import BL.Category;
import java.util.List;

/**
 *
 * @author vega
 */
public interface CatInterface {
    void create(Category category) throws CatException;
    void edit (Category category) throws CatException;
    void remove(Category category) throws CatException;
    List<Category> findAll();
//    Category findById(Category id) throws CatException;
}
