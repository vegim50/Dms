/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import BL.Category;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author vega
 */
public class CategoryTableModel extends AbstractTableModel {
     private final String [] columnNames = {"Id","Name"};
    
    private List <Category> cat;
    
    public CategoryTableModel(List<Category>cat){
        this.cat = cat;
    }
    public CategoryTableModel() {
   
    }
    public void add(List<Category>cat){
        this.cat = cat;
    }
    
   
    public int getRowCount() {
        return cat.size();
    }

  
    public int getColumnCount() {
        return columnNames.length;
    }
    
    public String getColumnName(int col){
        return columnNames[col];
    }
    public void remove(int row){
        cat.remove(row);
    }
    
    public Category getCategory(int index){
        return cat.get(index);
    }
    
   public Object getValueAt(int rowIndex, int columnIndex) {
        Category c = (Category)cat.get(rowIndex);
        switch(columnIndex){
            
            case 0:
                return c.getId();
            case 1:
                return c.getName();
            default:
                return null;
        }
    }
    
}
