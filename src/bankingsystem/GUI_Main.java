/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package bankingsystem;

import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.Color;
import javax.swing.SwingUtilities;

/**
 *
 * @author enesi
 */
public class GUI_Main extends javax.swing.JFrame {

    private GUI_Login login;
    private GUI_Register register;
    private GUI_StartPage startpage;
    private GUI_AccountPanel accountPanel;
    
    
    public void setLogin(){
        if(login == null){
            login = new GUI_Login();
        }
        jPanel_right.removeAll();
        jPanel_right.add(login);
        SwingUtilities.updateComponentTreeUI(jPanel_right);
                
    }
    
    public void setRegister(){
        if(register == null){
            register = new GUI_Register();
        }
        jPanel_right.removeAll();
        jPanel_right.add(register);
        SwingUtilities.updateComponentTreeUI(jPanel_right);
    }
    
    public void setStartPage(){
        startpage = new GUI_StartPage();
        jPanel_right.removeAll();
         jPanel_right.add(startpage);
        SwingUtilities.updateComponentTreeUI(jPanel_right);
    }
    
    public void setAccountPanel(){
        accountPanel = new GUI_AccountPanel("Checking Account", "John Doe", 5236.21, "TR50 0001 5000 3200 4258 5862");

        jPanel_right.removeAll();
        jPanel_right.add(accountPanel);
        SwingUtilities.updateComponentTreeUI(jPanel_right);

    }
    
    
    
    public GUI_Main() {
        initComponents();
        //setStartPage();
        setAccountPanel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_left = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton_Login = new javax.swing.JButton();
        jButton_Register = new javax.swing.JButton();
        jPanel_right = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(960, 540));

        jPanel_left.setBackground(new java.awt.Color(43, 43, 43));

        jLabel1.setBackground(new java.awt.Color(64, 64, 64));
        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Welcome");
        jLabel1.setOpaque(true);

        jButton_Login.setBackground(new java.awt.Color(77, 120, 204));
        jButton_Login.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton_Login.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Login.setText("Login");
        jButton_Login.setBorderPainted(false);
        jButton_Login.setPreferredSize(new java.awt.Dimension(0, 35));
        jButton_Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_LoginActionPerformed(evt);
            }
        });

        jButton_Register.setBackground(new java.awt.Color(44, 44, 44));
        jButton_Register.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton_Register.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Register.setText("Register");
        jButton_Register.setBorderPainted(false);
        jButton_Register.setPreferredSize(new java.awt.Dimension(0, 35));
        jButton_Register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RegisterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_leftLayout = new javax.swing.GroupLayout(jPanel_left);
        jPanel_left.setLayout(jPanel_leftLayout);
        jPanel_leftLayout.setHorizontalGroup(
            jPanel_leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_leftLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel_leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton_Register, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(jButton_Login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );
        jPanel_leftLayout.setVerticalGroup(
            jPanel_leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_leftLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(154, 154, 154)
                .addComponent(jButton_Login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton_Register, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel_right.setPreferredSize(new java.awt.Dimension(700, 540));
        jPanel_right.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel_left, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_right, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_left, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel_right, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_LoginActionPerformed
        jButton_Register.setBackground(new Color(44,44,44));
        jButton_Login.setBackground(new Color(77,120,204));
        setLogin();
    }//GEN-LAST:event_jButton_LoginActionPerformed

    private void jButton_RegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RegisterActionPerformed
        jButton_Login.setBackground(new Color(44,44,44));
        jButton_Register.setBackground(new Color(77,120,204));
        setRegister();
    }//GEN-LAST:event_jButton_RegisterActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FlatDarkLaf.setup();
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Login;
    private javax.swing.JButton jButton_Register;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel_left;
    private javax.swing.JPanel jPanel_right;
    // End of variables declaration//GEN-END:variables
}
