/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import BL.Filetypes;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author vega
 */
public class FileTypeTableModel extends AbstractTableModel{
    private final String [] columnNames = {"Type","Active"};
    
    private List <Filetypes> filetypes;
    
    public FileTypeTableModel(List<Filetypes>filetypes){
        this.filetypes = filetypes;
    }
    public FileTypeTableModel() {
   
    }
    public void add(List<Filetypes>filetypes){
        this.filetypes = filetypes;
    }

    @Override
    public int getRowCount() {
        return filetypes.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    
    public String getColumnName(int col){
        return columnNames[col];
    }
    public void remove(int row){
        filetypes.remove(row);
    }

    public Filetypes getFiletypes(int index){
        return filetypes.get(index);
    }
     public String getDate (Date date){
        DateFormat da = new SimpleDateFormat("dd/MM/yyyy");
        return da.format(date);
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Filetypes s = (Filetypes)filetypes.get(rowIndex);
        switch(columnIndex){
            
            case 0:
                return s.getType();
            case 1: 
                return s.getActive();
            
            default:
                return null;
        }
    }
        
    }


 