/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parking.management;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JComboBox;



/**
 *
 * @author aditya
 */
public class vehicle extends java.awt.Frame {
    DateFormat dateformat=new SimpleDateFormat("MM/dd/YY");
    Date date = new Date();
    
   Calendar cal=Calendar.getInstance();
    
    int p= cal.get(Calendar.HOUR_OF_DAY);
    int  m= cal.get(Calendar.MINUTE);
     
 
   
    int i=0;
    
    
    
             /**
     * Creates new form vehicle
     */
    public vehicle() {
        initComponents();
        datetf.setText(" " + dateformat.format(date));
        
        timetf.setText(" "+p);
         timetf1.setText(" "+ m);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        plateno = new javax.swing.JTextField();
        namex = new javax.swing.JTextField();
        paymentx = new javax.swing.JTextField();
        amountx = new javax.swing.JTextField();
        datetf = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        backB = new javax.swing.JButton();
        fillB = new javax.swing.JButton();
        timetf = new javax.swing.JTextField();
        viewB = new javax.swing.JButton();
        hrsT = new javax.swing.JTextField();
        emailx = new javax.swing.JTextField();
        timetf1 = new javax.swing.JTextField();
        minT = new javax.swing.JTextField();
        zoneno = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("NAME:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 60, 40));

        jLabel2.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PLATE NO.");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 80, 40));

        jLabel3.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ARRIVAL\n TIME:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 240, 100, 40));

        jLabel4.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("EMAIL:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 50, 40));

        jLabel5.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("DEPARTURE TIME:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 280, 140, 30));

        jLabel6.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("PAYMENT TYPE:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, 120, 30));

        jLabel7.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("AMOUNT:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, 70, 30));

        plateno.setBackground(new java.awt.Color(0, 0, 0));
        plateno.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        plateno.setForeground(new java.awt.Color(255, 255, 255));
        plateno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        plateno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                platenoActionPerformed(evt);
            }
        });
        jPanel1.add(plateno, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 220, -1));

        namex.setBackground(new java.awt.Color(0, 0, 0));
        namex.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        namex.setForeground(new java.awt.Color(255, 255, 255));
        namex.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(namex, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 220, -1));

        paymentx.setBackground(new java.awt.Color(0, 0, 0));
        paymentx.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        paymentx.setForeground(new java.awt.Color(255, 255, 255));
        paymentx.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(paymentx, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, 220, -1));

        amountx.setBackground(new java.awt.Color(0, 0, 0));
        amountx.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        amountx.setForeground(new java.awt.Color(255, 255, 255));
        amountx.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        amountx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amountxActionPerformed(evt);
            }
        });
        jPanel1.add(amountx, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 220, -1));

        datetf.setEditable(false);
        datetf.setBackground(new java.awt.Color(0, 0, 0));
        datetf.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        datetf.setForeground(new java.awt.Color(255, 255, 255));
        datetf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        datetf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datetfActionPerformed(evt);
            }
        });
        jPanel1.add(datetf, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 200, 190, -1));

        jLabel8.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("DATE:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 200, 60, 30));

        backB.setBackground(new java.awt.Color(0, 0, 0));
        backB.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        backB.setForeground(new java.awt.Color(255, 255, 255));
        backB.setText("BACK");
        backB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBActionPerformed(evt);
            }
        });
        jPanel1.add(backB, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 410, 132, -1));

        fillB.setBackground(new java.awt.Color(0, 0, 0));
        fillB.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        fillB.setForeground(new java.awt.Color(255, 255, 255));
        fillB.setText("FILL");
        fillB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillBActionPerformed(evt);
            }
        });
        jPanel1.add(fillB, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 360, 260, -1));

        timetf.setEditable(false);
        timetf.setBackground(new java.awt.Color(0, 0, 0));
        timetf.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        timetf.setForeground(new java.awt.Color(255, 255, 255));
        timetf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        timetf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timetfActionPerformed(evt);
            }
        });
        jPanel1.add(timetf, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 240, 30, -1));

        viewB.setBackground(new java.awt.Color(0, 0, 0));
        viewB.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        viewB.setForeground(new java.awt.Color(255, 255, 255));
        viewB.setText("VIEW");
        viewB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewBActionPerformed(evt);
            }
        });
        jPanel1.add(viewB, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 320, 260, -1));

        hrsT.setBackground(new java.awt.Color(0, 0, 0));
        hrsT.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        hrsT.setForeground(new java.awt.Color(255, 255, 255));
        hrsT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(hrsT, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 280, 30, -1));

        emailx.setBackground(new java.awt.Color(0, 0, 0));
        emailx.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        emailx.setForeground(new java.awt.Color(255, 255, 255));
        emailx.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(emailx, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 220, -1));

        timetf1.setEditable(false);
        timetf1.setBackground(new java.awt.Color(0, 0, 0));
        timetf1.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        timetf1.setForeground(new java.awt.Color(255, 255, 255));
        timetf1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(timetf1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 240, 30, -1));

        minT.setBackground(new java.awt.Color(0, 0, 0));
        minT.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        minT.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(minT, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 280, 30, -1));

        zoneno.setBackground(new java.awt.Color(0, 0, 0));
        zoneno.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        zoneno.setForeground(new java.awt.Color(255, 255, 255));
        zoneno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        zoneno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zonenoActionPerformed(evt);
            }
        });
        jPanel1.add(zoneno, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 220, -1));

        jLabel9.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("ZONE NO.");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, 20));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(838, 264, 50, 10));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText(":");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 280, 10, 20));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText(":");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 240, 10, 20));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/parking/management/parking lot system.jpg"))); // NOI18N
        jLabel10.setAutoscrolls(true);
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 460));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 440, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 837, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Exit the Application
     */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    private void fillBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillBActionPerformed

        // TODO add your handling code here:
        String  nam =  namex.getText();
        String n =  (plateno.getText());
        String t=timetf.getText();
        String m=timetf1.getText();
        String etime =  t+":"+m;
        String  emaili =  emailx.getText();
        String dater= datetf.getText();
        int dtime = Integer.parseInt( hrsT.getText())*60+Integer.parseInt( minT.getText());
        String pay =  paymentx.getText();
        int ammoun = Integer.parseInt( amountx.getText());
        int p=Integer.parseInt(zoneno.getText());
        
       vacant.update(p);
        priority.enqueue(nam,n, emaili, etime, dtime, pay, ammoun,dater,p);
        SaveFile.saveFile(nam, n, emaili, etime, dtime, pay, ammoun, dater, p);
        
        
        if(i==0){
          
        Timer a=new Timer();
    
        a.start();
        
        }

    }//GEN-LAST:event_fillBActionPerformed

    private void viewBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewBActionPerformed
        // TODO add your handling code here:
        new parkview().setVisible(true);
        this.setVisible(false);
       
        
    }//GEN-LAST:event_viewBActionPerformed

    private void zonenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zonenoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_zonenoActionPerformed

    private void backBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBActionPerformed
 
        new vacant().setVisible(true);
        this.setVisible(false);

        // TODO add your handling code here:
    }//GEN-LAST:event_backBActionPerformed

    private void timetfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timetfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_timetfActionPerformed

    private void amountxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amountxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amountxActionPerformed

    private void platenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_platenoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_platenoActionPerformed

    private void datetfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datetfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_datetfActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vehicle().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amountx;
    private javax.swing.JButton backB;
    private javax.swing.JTextField datetf;
    private javax.swing.JTextField emailx;
    private javax.swing.JButton fillB;
    private javax.swing.JTextField hrsT;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField minT;
    private javax.swing.JTextField namex;
    private javax.swing.JTextField paymentx;
    private javax.swing.JTextField plateno;
    private javax.swing.JTextField timetf;
    private javax.swing.JTextField timetf1;
    private javax.swing.JButton viewB;
    private javax.swing.JTextField zoneno;
    // End of variables declaration//GEN-END:variables

    private void priority(String nam, String n, String emaili, String etime, int dtime, String pay, String ammoun, String dater, int p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
