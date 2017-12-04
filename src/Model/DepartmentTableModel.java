/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import BL.Departament;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author vega
 */
public class DepartmentTableModel extends AbstractTableModel{
    private final String [] columnNames = {"Id","Name"};
    
    private List <Departament> dep;
    
    public DepartmentTableModel(List<Departament>dep){
        this.dep = dep;
    }
    public DepartmentTableModel() {
   
    }
    public void add(List<Departament>dep){
        this.dep = dep;
    }
    
    @Override
    public int getRowCount() {
        return dep.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    
    public String getColumnName(int col){
        return columnNames[col];
    }
    public void remove(int row){
        dep.remove(row);
    }
    
    public Departament getDepartment(int index){
        return dep.get(index);
    }
    
   public Object getValueAt(int rowIndex, int columnIndex) {
        Departament d = (Departament)dep.get(rowIndex);
        switch(columnIndex){
            
            case 0:
                return d.getId();
            case 1:
                return d.getName();
            default:
                return null;
        }
    }
     
}
