/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.FileType;

import DAL.Departament.*;
import BL.Departament;
import BL.Filetypes;
import java.util.List;

/**
 *
 * @author vegim
 */
public interface FtInterface {
    void create(Filetypes filetypes) throws FtException;
    void edit (Filetypes filetypes) throws FtException;
    void remove(Filetypes filetypes) throws FtException;
    List<Filetypes> findAll();
}
