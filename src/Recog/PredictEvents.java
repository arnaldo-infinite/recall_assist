/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class PredictEvents extends javax.swing.JFrame {

    /**
     * Creates new form ViewEvents
     */
    public PredictEvents() {
        initComponents();
        model2=(DefaultTableModel)tbl_events.getModel();
    }
    
    DefaultTableModel model2;
    String [] RID;
    String [] Time;
    String [] Contents;
    Connection con;
    ConnectionClass objcon= new ConnectionClass();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_events = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cmb_year = new javax.swing.JComboBox();
        cmb_month = new javax.swing.JComboBox();
        cmb_date = new javax.swing.JComboBox();
        but_search = new javax.swing.JButton();
        txt_RID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        but_predict = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        but_back = new javax.swing.JButton();

        jButton3.setText("< -- Back to Main Panel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(765, 500));

        tbl_events.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RID", "Content", "Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_events);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Date :");

        cmb_year.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmb_year.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2012", "2011", "2010", "2009", "2008", "2007" }));

        cmb_month.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmb_month.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        cmb_date.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmb_date.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", " " }));

        but_search.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        but_search.setText("Search");
        but_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_searchActionPerformed(evt);
            }
        });

        txt_RID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("RID :");

        but_predict.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        but_predict.setText("Predict");
        but_predict.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_predictActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tekton Pro", 1, 24)); // NOI18N
        jLabel3.setText("Predit Event For Today");

        but_back.setText("< -- Back to Main Panel");
        but_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(26, 26, 26)
                        .addComponent(cmb_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmb_month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmb_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(but_search)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txt_RID, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(but_predict))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(but_back)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(but_back, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmb_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(but_search)
                    .addComponent(txt_RID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(but_predict))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void but_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_searchActionPerformed
        clearrows();
        try {
            String DayPassed = cmb_year.getSelectedItem().toString()+"-"+cmb_month.getSelectedItem().toString()+"-"+cmb_date.getSelectedItem().toString();
            JOptionPane.showMessageDialog(null, DayPassed);
            
            DateManager dmanager = new DateManager();
            String Tomorrow = dmanager.genTomorrow(DayPassed);
            fillTable(Tomorrow, DayPassed);
        } catch (ParseException ex) {
            Logger.getLogger(PredictEvents.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_but_searchActionPerformed

    private void but_predictActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_predictActionPerformed
        String RID = txt_RID.getText();
        if (RID.trim().length()>0)
        {
            try {
                predict();
            } catch (ParseException ex) {
                Logger.getLogger(PredictEvents.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Enter a RID to predict !");
        }
    }//GEN-LAST:event_but_predictActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    }//GEN-LAST:event_jButton3ActionPerformed

    private void but_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_backActionPerformed
        callMain();
    }//GEN-LAST:event_but_backActionPerformed

    private void callMain()
    {
        Main obj = new Main();
        obj.show();
        this.dispose();
    }
    
    private void clearrows()
    {
        int rowCount = model2.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) 
        {
        model2.removeRow(i);  
        }
    }
    
    private void fillTable(String Tomorrow,String Today)
     {
         int temp=0;
         
         con=objcon.getConnection();
         try
         {
            PreparedStatement stat1=con.prepareStatement("select RID,Content,RDate from recording where RDATE between '"+Today+"' AND '"+Tomorrow+"'");
            ResultSet rst1=stat1.executeQuery();
            
            while (rst1.next())
            {
                temp ++;
            }
            stat1.close();
            JOptionPane.showMessageDialog(null, temp);
        }
         catch (Exception e1)
         {
             JOptionPane.showMessageDialog(null,"Error Generating Table 1 "+e1.toString());
         }
         finally
         {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
         
        RID = new String [temp]; 
        Time = new String[temp];
        Contents = new String[temp];
        filltable2(Today, Tomorrow);
     }
     
     private void filltable2(String Today, String Tomorrow)
     {
         int count=0;
         con=objcon.getConnection();
         try
         {
                PreparedStatement stat2=con.prepareStatement("select RID,Content,RDate from recording where RDATE between '"+Today+"' AND '"+Tomorrow+"'");
                ResultSet rst2=stat2.executeQuery();
                while (rst2.next())
            {
                RID[count]=rst2.getString("RID");
                Contents[count]=rst2.getString("Content");
                Time[count]=rst2.getString("RDate");
                count++;
            }
         }
         catch (Exception e1)
         {
             JOptionPane.showMessageDialog(null,"Error Generating Table 2 "+e1);
         }
         finally
         {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
        for(int i =0 ; i<count;i++)
        {
        model2.addRow(new Object[]{RID[i],Time[i],Contents[i]});
        }
        
     }
    
     
     private void predict () throws ParseException
     {
        String RIDEntered = txt_RID.getText();
         
        ByDayy byday = new ByDayy(RIDEntered);
        String [] Occurence=byday.getOccureDates();
        int Occurance=byday.getOccurance();
        String [] OccurArray = byday.getOccureDates();
        float DayPredict = (float)Occurance*100/6;

        
        ByOneDay byoneday = new ByOneDay(RIDEntered, OccurArray);
        
        double [] data1 =  byoneday.gettWS();
        double [] data2 =  byoneday.gettWC();
        double [] data3 =  byoneday.getOutputs();
        
        NNetwork net = new NNetwork(data1, data2, data3);
        
        double [] input1 = {870,588,678,1193};
        double [] input2 = {3,2,2,3};
        double predict1 = net.setPrediction(input1, input2);
        
        
        
        ByTwoDay bytwoday = new ByTwoDay("2017-09-04-2", OccurArray);
        
        double [] data11 =  bytwoday.gettWS();
        double [] data22 =  bytwoday.gettWC();
        double [] data33 =  bytwoday.getOutputs();
        
        NNetwork net2 = new NNetwork(data11, data22, data33);
        
        double predict2 = net2.setPrediction(input1, input2);
     
        DecimalFormat df=new DecimalFormat("0.00");
        double totalpercentage = Math.round((DayPredict+predict1+predict2)/3)*100/100;
        
        JOptionPane.showMessageDialog(null, "There is a probability of "+totalpercentage+"% for you to do this event today !");
        
     }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PredictEvents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PredictEvents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PredictEvents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PredictEvents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PredictEvents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton but_back;
    private javax.swing.JButton but_predict;
    private javax.swing.JButton but_search;
    private javax.swing.JComboBox cmb_date;
    private javax.swing.JComboBox cmb_month;
    private javax.swing.JComboBox cmb_year;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_events;
    private javax.swing.JTextField txt_RID;
    // End of variables declaration//GEN-END:variables
}
