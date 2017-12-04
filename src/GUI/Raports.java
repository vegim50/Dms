/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;


/**
 *
 * @author vega
 */
public class Raports extends javax.swing.JInternalFrame {



    public Raports() {
        initComponents();
        getContentPane().setBackground(Color.white);
    }
    
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        deletedButton = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        Generate = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Raports", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 2, 12))); // NOI18N
        setClosable(true);
        setIconifiable(true);

        deletedButton.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        deletedButton.setForeground(new java.awt.Color(25, 80, 62));
        deletedButton.setText("Generate raports");
        deletedButton.setMaximumSize(new java.awt.Dimension(80, 23));
        deletedButton.setMinimumSize(new java.awt.Dimension(80, 23));
        deletedButton.setPreferredSize(new java.awt.Dimension(80, 23));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Documents", "Users", "Departments" }));

        jLabel1.setText("Select raport:");

        Generate.setText("Generate");
        Generate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(291, Short.MAX_VALUE)
                        .addComponent(deletedButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Generate)))
                .addContainerGap(377, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(deletedButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Generate))
                .addContainerGap(245, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerateActionPerformed
        // TODO add your handling code here:
        try{  
            String report = null;
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dmsd3?zeroDateTimeBehavior=convertToNull&user=root&password=");
            if(jComboBox1.getSelectedItem().toString().equals("Documents")){
                 report="C:\\Users\\vegim\\Desktop\\Dmsd\\dms\\dms\\src\\raports\\report.jrxml";
            }else if(jComboBox1.getSelectedItem().toString().equals("Users")){
                 report="C:\\Users\\vegim\\Desktop\\Dmsd\\dms\\dms\\src\\raports\\report1.jrxml";
            }else{
                 report="C:\\Users\\vegim\\Desktop\\Dmsd\\dms\\dms\\src\\raports\\report2.jrxml";
            }
           
            JasperReport jr=JasperCompileManager.compileReport(report);
            JasperPrint jp=JasperFillManager.fillReport(jr, null,con);
            
            JFrame frame = new JFrame("Raporti");
            frame.setExtendedState(Frame.MAXIMIZED_BOTH); 
            frame.getContentPane().add(new JRViewer(jp));
            frame.pack();
            frame.setVisible(true);
        }catch(ClassNotFoundException | SQLException | JRException e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_GenerateActionPerformed

               


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Generate;
    private javax.swing.JLabel deletedButton;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
