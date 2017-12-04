/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 * @author vega
 */
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.MutableComboBoxModel;

public class CustomComboBoxModel<T> extends AbstractListModel<T> implements MutableComboBoxModel<T> {

    private T sItem;

    private List<T> data;

    public CustomComboBoxModel(List<T> arrayList) {
        data = arrayList;
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public T getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        sItem = (T) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return sItem;
    }

    @Override
    public void addElement(T item) {
        data.add(item);
    }

    @Override
    public void removeElement(Object obj) {
        data.remove(obj);
    }

    @Override
    public void insertElementAt(T item, int index) {
        data.add(index, item);
    }

    @Override
    public void removeElementAt(int index) {
        data.remove(index);
    }

}
