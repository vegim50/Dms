/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import BL.User;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author vega
 */
public class UserTableModel extends AbstractTableModel{
    private final String [] columnNames = {"First Name","Last Name","Username","Phone Nr","Email Address","Departament","isAdmin","Can Add Doc","Can Check-In"};
    
    private List <User> user;
    
    public UserTableModel(List<User>user){
        this.user = user;
    }
    public UserTableModel() {
   
    }
    public void add(List<User>user){
        this.user = user;
    }
    
    @Override
    public int getRowCount() {
        return user.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    
    public String getColumnName(int col){
        return columnNames[col];
    }
    public void remove(int row){
        user.remove(row);
    }
    
    public User getUser(int index){
        return user.get(index);
    }
    
   public Object getValueAt(int rowIndex, int columnIndex) {
        User u = (User)user.get(rowIndex);
        switch(columnIndex){
            
            case 0:
                return u.getFirstName();
            case 1:
                return u.getLastName();
            case 2:
                return u.getUsername();  
             case 3: 
                 return u.getPhone();    
             case 4:
                 return u.getEmail();
             
             case 5:
                return u.getDepartment().toString();
             case 6:
                 return u.getIsAdmin();
             case 7:
                 return u.getCanAdd();
             case 8:
                 return u.getCanCheckin();
                 
            default:
                return null;
        }
    }
     
}
