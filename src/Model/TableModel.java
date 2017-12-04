/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import BL.Data;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author vega
 */
public class TableModel extends AbstractTableModel{
    private final String [] columnNames = {"Path","Realname","Description","Category","Date Created","Owner","Department","Status"};
    
    private List <Data> data;
    
    public TableModel(List<Data>data){
        this.data = data;
    }
    public TableModel() {
   
    }
    public void add(List<Data>data){
        this.data = data;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    
    public String getColumnName(int col){
        return columnNames[col];
    }
    public void remove(int row){
        data.remove(row);
    }

    public Data getData(int index){
        return data.get(index);
    }
     public String getDate (Date date){
        DateFormat da = new SimpleDateFormat("dd/MM/yyyy");
        return da.format(date);
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Data s = (Data)data.get(rowIndex);
        switch(columnIndex){
            
            case 0:
                return s.getPath();
            case 1:
                return s.getRealname();
            case 2: 
                return s.getDescription();
            case 3:
                return s.getCategory();
            case 4: 
                return s.getCreated();
            case 5: 
                return s.getOwner();
            case 6: 
                return s.getDepartment();
            case 7: 
                if(s.getStatus()==null){
                    return "Pending";
                }else if(s.getStatus()==true){
                    return "Approved";
                }else{
                    return "Rejected";
                }
            
            default:
                return null;
        }
    }
        
    }


 