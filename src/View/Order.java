
package View;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Order extends javax.swing.JFrame {

    /**
     * Creates new form Order
     */
    
    private int orderid;
    public Order() {
        initComponents();
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
        Timer timer = new Timer(1000, e -> {
            String currentTime = timeFormat.format(new Date());
            timelabel.setText(currentTime);
        });
        timer.start();
        String initialTime = timeFormat.format(new Date());
        tabnum.setText("Table "+System.num);
        timelabel.setText(initialTime);
        foodcombo.setModel(new DefaultComboBoxModel(System.ro.fillComboBoxByFood()));
        drinkcombo.setModel(new DefaultComboBoxModel(System.ro.fillComboBoxByDrink()));
        if(!System.ro.checkOrderItemList()){
            output.setText(System.ro.printOrderItems(System.num));
             amount.setText(System.ro.getTotalAmount(System.num)+"$");
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        timelabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        output = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        foodcombo = new javax.swing.JComboBox<>();
        drinkcombo = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        quantity = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        amount = new javax.swing.JLabel();
        tabnum = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        timelabel.setBackground(new java.awt.Color(0, 0, 0));
        timelabel.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        timelabel.setText("4:00:35 pm");
        getContentPane().add(timelabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 170, -1));

        output.setColumns(20);
        output.setRows(5);
        jScrollPane1.setViewportView(output);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(464, 0, 310, 200));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("choose item to order:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        foodcombo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        foodcombo.setForeground(new java.awt.Color(255, 0, 0));
        foodcombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        foodcombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                foodcomboActionPerformed(evt);
            }
        });
        getContentPane().add(foodcombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 90, 120, -1));

        drinkcombo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        drinkcombo.setForeground(new java.awt.Color(255, 0, 0));
        drinkcombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        drinkcombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drinkcomboActionPerformed(evt);
            }
        });
        getContentPane().add(drinkcombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, 120, -1));

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 0, 0));
        jButton2.setText("Remove item");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 140, 40));

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 0, 0));
        jButton3.setText("Submit order");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 140, 40));

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 0, 0));
        jButton4.setText("Print Check");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 140, 40));

        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 0, 0));
        jButton5.setText("Pay");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 130, 40));

        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 0, 0));
        jButton6.setText("Back");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 460, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Enter the quantity:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        quantity.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        quantity.setBorder(new javax.swing.border.MatteBorder(null));
        getContentPane().add(quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 90, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Total Amount:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 210, -1, -1));

        amount.setBackground(new java.awt.Color(255, 255, 255));
        amount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        amount.setForeground(new java.awt.Color(255, 0, 0));
        amount.setText("0$");
        getContentPane().add(amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 210, -1, -1));

        tabnum.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tabnum.setText("Tablenumber");
        getContentPane().add(tabnum, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/orderimage2.jpg"))); // NOI18N
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 0, 1030, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void foodcomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_foodcomboActionPerformed
         Object o= foodcombo.getSelectedItem();
        int q=Integer.parseInt(quantity.getValue().toString());
          if(!System.ro.checkIfOrderIsSubmited(System.ro.GetResId(System.num))){
        if(o!=null){
          if(q>0){
              
             if(!System.ro.findItem(o.toString())){
                  System.ro.addOrder(System.num, o.toString(),q );
                 output.setText(System.ro.printOrderItems(System.num));
                 amount.setText(System.ro.getTotalAmount(System.num)+"$");
              
              }else{
                System.ro.changeQuantity(o.toString(), q);
                output.setText(System.ro.printOrderItems(System.num));
                 amount.setText(System.ro.getTotalAmount(System.num)+"$");
              }
              }else{
             JOptionPane.showMessageDialog(null, "Quantity must be greater than 0"); 
            }
        }else{
            JOptionPane.showMessageDialog(null, "please selected item");
          }
          }else{
              JOptionPane.showMessageDialog(null, "You cannot add more item this order is submited"); 
          }

        
    }//GEN-LAST:event_foodcomboActionPerformed

    private void drinkcomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drinkcomboActionPerformed
        
        Object s= drinkcombo.getSelectedItem();
        int q=Integer.parseInt(quantity.getValue().toString());
         if(!System.ro.checkIfOrderIsSubmited(System.ro.GetResId(System.num))){
        if(s!=null){
          if(q>0){
              if(!System.ro.findItem(s.toString())){
                  System.ro.addOrder(System.num, s.toString(),q );
                 output.setText(System.ro.printOrderItems(System.num));
                 amount.setText(System.ro.getTotalAmount(System.num)+"$");
              
              }else{
                System.ro.changeQuantity(s.toString(), q);
                output.setText(System.ro.printOrderItems(System.num));
                 amount.setText(System.ro.getTotalAmount(System.num)+"$");
              }
              }else{
              JOptionPane.showMessageDialog(null, "Quantity must be greater than 0");
          }
        }else{
            JOptionPane.showMessageDialog(null, "please selected item");
          }
         }else{
            JOptionPane.showMessageDialog(null, "You cannot add more item this order is submited"); 
         }
        
    }//GEN-LAST:event_drinkcomboActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      
     
      if(output==null){
          JOptionPane.showMessageDialog(null, "please select item"); 
      }else{
          String s=output.getSelectedText();
           String []a=s.split("\t");
           if(!System.ro.checkIfOrderIsSubmited(System.ro.GetResId(System.num))){
               System.ro.removeOrderitem(output.getSelectedText(),System.num);
              output.setText(System.ro.printOrderItems(System.num));
             amount.setText(System.ro.getTotalAmount(System.num)+"$");
             
          }else{
            JOptionPane.showMessageDialog(null, "Once your order is submitted, orders cannot be removed", "",JOptionPane.WARNING_MESSAGE );  
        }
      }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         String orderid=JOptionPane.showInputDialog(null,"Enter an order id:", "",JOptionPane.PLAIN_MESSAGE);
         if(isalldigit(orderid)){
             int oi=Integer.parseInt(orderid);
             if(System.ro.checkOrderID(oi)){
                 System.ro.submitReservation(System.num);
                 System.ro.SubmitOrder(oi, System.ro.GetResId(System.num), System.num);
                   System.ro.insertOrderItem(oi, System.num);
                  JOptionPane.showMessageDialog(null, "Order is successfully submited");
                }else{
                   JOptionPane.showMessageDialog(null, "Use another order id", "",JOptionPane.WARNING_MESSAGE ); 
                }
                
         }else{
             JOptionPane.showMessageDialog(null, "The order id must be a number", "",JOptionPane.WARNING_MESSAGE ); 
         }
        
             
         
      
    }//GEN-LAST:event_jButton3ActionPerformed
public boolean isalldigit(String orderid){
    for (int i = 0; i < orderid.length(); i++) {
        if(!Character.isDigit( orderid.charAt(i))){
            return false;
        }
    }
    return true;
}
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(System.ro.checkIfOrderIsSubmited(System.ro.GetResId(System.num))){
             Payment p=new Payment();
          p.setVisible(true); 
        }else{
            JOptionPane.showMessageDialog(null, "The order is not submited we cannot print the check", "",JOptionPane.WARNING_MESSAGE );  
        }
          
        
            
        
            
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
      if(System.ro.checkIfOrderIsSubmited(System.ro.GetResId(System.num))){
        int res= JOptionPane.showConfirmDialog(null, "Your total amount is "+System.ro.getTotalAmount(System.num)+"$", "",  JOptionPane.OK_CANCEL_OPTION);
        if(res== JOptionPane.OK_OPTION){
            System.ro.reduceQuantityInStore(System.num);
            System.ro.removeOrder(System.num);
            System.ro.removeReservationWhenPay(System.num);
            System.c.setTableunReserved(System.num);
            this.dispose();
            System s = new System();
            s.setVisible(true);
        }
      }else{
           JOptionPane.showMessageDialog(null, "Once your order is submitted,you can pay", "",JOptionPane.WARNING_MESSAGE );  
        }
           
        
    }//GEN-LAST:event_jButton5ActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Order().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amount;
    private javax.swing.JComboBox<String> drinkcombo;
    private javax.swing.JComboBox<String> foodcombo;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextArea output;
    private javax.swing.JSpinner quantity;
    private javax.swing.JLabel tabnum;
    private javax.swing.JLabel timelabel;
    // End of variables declaration//GEN-END:variables
}