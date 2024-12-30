/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package bankingsystem;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author enesi
 */
public class GUI_Register extends javax.swing.JPanel {

    private String firstName;
    private String lastName;
    private String TCID;
    private String password1;
    private String password2;
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }
    
    
    
    public GUI_Register() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_Background = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jfirstName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jlastName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTCID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPassword = new javax.swing.JPasswordField();
        jPasswordConfirm = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jRegisterButton_R = new javax.swing.JButton();
        jLoginButton_R = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(700, 540));

        jPanel_Background.setBackground(new java.awt.Color(30, 30, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(253, 253, 253));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("First Name");

        jfirstName.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jfirstName.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jfirstName.setAlignmentX(0.0F);
        jfirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jfirstNameActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(253, 253, 253));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Last Name");

        jlastName.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jlastName.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jlastName.setAlignmentX(0.0F);
        jlastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jlastNameActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(253, 253, 253));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("TCID/SSN");

        jTCID.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jTCID.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTCID.setAlignmentX(0.0F);
        jTCID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTCIDActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(253, 253, 253));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Password");

        jPassword.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jPassword.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jPassword.setAlignmentX(0.0F);
        jPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordActionPerformed(evt);
            }
        });

        jPasswordConfirm.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jPasswordConfirm.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jPasswordConfirm.setAlignmentX(0.0F);
        jPasswordConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordConfirmActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(253, 253, 253));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Confirm Password");

        jRegisterButton_R.setBackground(new java.awt.Color(204, 102, 0));
        jRegisterButton_R.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jRegisterButton_R.setForeground(new java.awt.Color(253, 253, 253));
        jRegisterButton_R.setText("Register");
        jRegisterButton_R.setPreferredSize(new java.awt.Dimension(75, 25));
        jRegisterButton_R.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRegisterButton_RActionPerformed(evt);
            }
        });

        jLoginButton_R.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLoginButton_R.setForeground(new java.awt.Color(253, 253, 253));
        jLoginButton_R.setText("Already have an account? Login");
        jLoginButton_R.setPreferredSize(new java.awt.Dimension(75, 25));

        javax.swing.GroupLayout jPanel_BackgroundLayout = new javax.swing.GroupLayout(jPanel_Background);
        jPanel_Background.setLayout(jPanel_BackgroundLayout);
        jPanel_BackgroundLayout.setHorizontalGroup(
            jPanel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_BackgroundLayout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addGroup(jPanel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLoginButton_R, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRegisterButton_R, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jfirstName)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlastName)
                    .addComponent(jTCID)
                    .addComponent(jPassword)
                    .addComponent(jPasswordConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(180, Short.MAX_VALUE))
        );
        jPanel_BackgroundLayout.setVerticalGroup(
            jPanel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_BackgroundLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jfirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTCID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jRegisterButton_R, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLoginButton_R, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jfirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jfirstNameActionPerformed
       
    }//GEN-LAST:event_jfirstNameActionPerformed

    private void jlastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jlastNameActionPerformed
     
    }//GEN-LAST:event_jlastNameActionPerformed

    private void jTCIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTCIDActionPerformed
        
    }//GEN-LAST:event_jTCIDActionPerformed

    private void jPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordActionPerformed
       
    }//GEN-LAST:event_jPasswordActionPerformed

    private void jPasswordConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordConfirmActionPerformed
       
        if(password1 != password2){
            //Probably need to throw an exception here which triggers something idk...
        }
    }//GEN-LAST:event_jPasswordConfirmActionPerformed

    private void jRegisterButton_RActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRegisterButton_RActionPerformed
        firstName = jfirstName.getText();
        lastName = jlastName.getText();
        TCID = jTCID.getText();
        password1 = new String(jPassword.getPassword());
        password2 = new String(jPasswordConfirm.getPassword());
        
        if(!password1.equals(password2)){
            //Probably need to throw an exception here which triggers something idk...
            JOptionPane.showMessageDialog(null, "Passwords do not match!", "Error", JOptionPane.WARNING_MESSAGE);
        }
        else{
            customer = new Customer(firstName, lastName, TCID, password1);// This also needs to take pass info
            JOptionPane.showMessageDialog(null, "Registered Succesfully. ");
        }
        
    }//GEN-LAST:event_jRegisterButton_RActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton jLoginButton_R;
    private javax.swing.JPanel jPanel_Background;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JPasswordField jPasswordConfirm;
    private javax.swing.JButton jRegisterButton_R;
    private javax.swing.JTextField jTCID;
    private javax.swing.JTextField jfirstName;
    private javax.swing.JTextField jlastName;
    // End of variables declaration//GEN-END:variables
}
