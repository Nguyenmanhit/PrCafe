/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nguyenmanh.frame;

import com.nguyenmanh.model.Invoice;
import com.nguyenmanh.model.Table;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;


/**
 * @author Nguyen Manh
 */
public class ListTable extends javax.swing.JInternalFrame {
    
    private JDesktopPane desktopPane;
    private ArrayList<Invoice> arrInvoice;

    /**
     * Creates new form listban
     */
    public ListTable() {
        initComponents();

    }

    public JDesktopPane getDesktopPane() {
        return desktopPane;
    }

    public void setDesktopPane(JDesktopPane desktopPane) {
        this.desktopPane = desktopPane;
    }

    public ArrayList<Invoice> getArrInvoice() {
        return arrInvoice;
    }

    public void setArrInvoice(ArrayList<Invoice> arrInvoice) {
        this.arrInvoice = arrInvoice;
        viewTable(arrInvoice);
    }
  
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách Bàn", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 973, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 442, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    private void viewTable(ArrayList<Invoice> arrInvoice) {
        jPanel2.setLayout(new GridLayout(arrInvoice.size()/3, 3, 50, 50));
        for(final Invoice object : arrInvoice){
            final Table table = object.getTable();
            JButton btn = new JButton(table.getTable_name());
            if (table.isTable_status() == true)btn.setBackground(Color.RED); 
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(table.isTable_status() == true){
                        InvoiceT it = new InvoiceT();
                        it.setInvoice(object);
                        dispose();
                        it.setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Bạn chưa chọn bàn này!");
                    }
                }
            });
            jPanel2.add(btn);
        }
    }
}
