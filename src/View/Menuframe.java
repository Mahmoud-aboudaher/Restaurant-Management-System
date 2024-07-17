/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controll.controller;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class Menuframe extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    controller c= new controller();
    public Menuframe() {
        initComponents();
        setExtendedState(Menuframe.NORMAL);
        food.setText(c.fillMenuByfood());
        drink.setText(c.fillMenuByDrink());
       setDefaultCloseOperation(Menuframe.DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        food = new javax.swing.JLabel();
        drink = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        food.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        food.setForeground(new java.awt.Color(255, 255, 0));
        food.setText("jLabel4");
        getContentPane().add(food, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 540));

        drink.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        drink.setForeground(new java.awt.Color(255, 255, 0));
        drink.setText("jLabel5");
        getContentPane().add(drink, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 280, 540));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/menu 3.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 540));

        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, -1, -1));

        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

   /* private void addimage(){
        ImageIcon ia = new ImageIcon("C:\\Users\\HP\\Desktop\\ODY47L0.jpg");
        Image i = ia.getImage();
        
        Image s = i.getScaledInstance(imagelabel2.getWidth(),imagelabel2.getHeight() , Image.SCALE_SMOOTH);
        ImageIcon newimage= new ImageIcon(s);
        imagelabel2.setIcon(newimage);
        
    }
    */
    
    
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
            java.util.logging.Logger.getLogger(Menuframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menuframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menuframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menuframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menuframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel drink;
    private javax.swing.JLabel food;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}