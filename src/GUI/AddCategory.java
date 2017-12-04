package GUI;

import BL.Category;
import DAL.Categories.CatException;
import DAL.Categories.CatRepository;
import Model.CategoryTableModel;
import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import static java.lang.Character.isAlphabetic;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vega
 */
public class AddCategory extends javax.swing.JInternalFrame {

        CategoryTableModel catTableModel = new CategoryTableModel();
        CatRepository catRepository = new CatRepository();
    
    /**
     * Creates new form AddCategory
     */
    public AddCategory() {
        initComponents();
        getContentPane().setBackground(Color.white);
        tabelaLoad();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtKategoria = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        emptyButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        deleteButton = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Category Options", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 2, 12)))); // NOI18N
        setClosable(true);
        setIconifiable(true);
        setPreferredSize(new java.awt.Dimension(902, 462));

        jLabel2.setText("Category");

        txtKategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKategoriaKeyPressed(evt);
            }
        });

        addButton.setText("Add ");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        emptyButton.setText("Cancel");
        emptyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emptyButtonActionPerformed(evt);
            }
        });

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabela);

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 277, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtKategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emptyButton)
                .addGap(193, 193, 193))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtKategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(addButton)
                        .addComponent(deleteButton)
                        .addComponent(emptyButton))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(163, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void emptyObject() {
       tabela.clearSelection();
        txtKategoria.setText("");
    }
    
    private void tabelaLoad() {
        List<Category> lista = catRepository.findAll();
        catTableModel.add(lista);
        tabela.setModel(catTableModel);
        catTableModel.fireTableDataChanged(); // notifikon listeners qe struktura ka ndryshuar dhe ndoshta duhet te rindertohet tabela
        tabelaSelectedIndexChange(); // e ngjajshme me refresh

    }
    
     private void tabelaSelectedIndexChange() {
        final ListSelectionModel rowSM = tabela.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent Ise) {
                if (Ise.getValueIsAdjusting()) {   // kthen boolean
                    return;
                }
                ListSelectionModel rowSM = (ListSelectionModel) Ise.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if (selectedIndex > -1) {
                    Category cat = catTableModel.getCategory(selectedIndex);

                    txtKategoria.setText(cat.getName()); 
                }
            }
        });
    }
    
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
         try{
            int row = tabela.getSelectedRow();
            if(row > -1){
                Object [] ob = {"Yes","No"};
                int i = javax.swing.JOptionPane.showOptionDialog(this, "Do you want to delete it?", "Delete:", JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
                if(i==0){
                    Category cat = this.catTableModel.getCategory(row);
                    catRepository.remove(cat);
                    tabelaLoad();
                    emptyObject();
                    JOptionPane.showMessageDialog(this, "Document has been deleted succesfully!");
                }
            }
            else{
                JOptionPane.showMessageDialog(this,"You haven't selected nothing to delete!");
            }
        }catch(CatException pe){
            JOptionPane.showMessageDialog(this, pe.getMessage());
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
          try {
            int row = tabela.getSelectedRow();
            if (txtKategoria.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please write Category:", "Category:", JOptionPane.ERROR_MESSAGE);
            }
            else {
                if (row == -1) {
                    Category cat = new Category();
                     cat.setName(txtKategoria.getText());
                    catRepository.create(cat);
                    JOptionPane.showMessageDialog(this, "Category has been saved!");
                } else {
                    Category cat = this.catTableModel.getCategory(row);
                     cat.setName(txtKategoria.getText());
                    catRepository.edit(cat);
                    JOptionPane.showMessageDialog(this, "Category has been edited!");
                }
                emptyObject();
                tabelaLoad();
            };

        } catch (CatException pe) {
            JOptionPane.showMessageDialog(this, pe.getMessage());
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void emptyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emptyButtonActionPerformed
        // TODO add your handling code here:
        emptyObject();
    }//GEN-LAST:event_emptyButtonActionPerformed

    private void txtKategoriaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKategoriaKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        
        if(isAlphabetic(c) || c == KeyEvent.VK_BACKSPACE){
            txtKategoria.setEditable(true);
        }
        else{
            txtKategoria.setEditable(false);
        }
    }//GEN-LAST:event_txtKategoriaKeyPressed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton emptyButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtKategoria;
    // End of variables declaration//GEN-END:variables
}
