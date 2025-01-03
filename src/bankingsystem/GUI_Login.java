/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package bankingsystem;

import javax.swing.JOptionPane;

/**
 *
 * @author enesi
 */
public class GUI_Login extends javax.swing.JPanel {

    private String TCID;
    private String password;
    private Customer customer;
    public boolean isLogged;
    
    
    public GUI_Login() {
        initComponents();
        jLoginButton_L.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            handleLoginButtonClick(evt);
        }
    });

    }
    
    private void handleLoginButtonClick(java.awt.event.ActionEvent evt) {
    Customer customer = null;
    Login login = null;
    boolean error;
    GUI_AccountSelection accountSelection = null;
    do {
        error = false;
        try {
            // Login işlemini gerçekleştiriyoruz
            login = new Login(jTCID_L.getText(), jPassword_L.getText());
            // Eğer login başarılıysa, müşteri bilgisi alınabilir
            customer = login.getLoggedCustomer();
            JOptionPane.showMessageDialog(this, "Login successful! Welcome, " + customer.getFirstName());
            accountSelection = new GUI_AccountSelection(customer);
        } catch (CustomerNotFoundException e) {
            // Kullanıcı bulunamadığında hata mesajı göster
            JOptionPane.showMessageDialog(this, "Customer not found: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            error = true;
        } catch (PasswordNotCorrectException e) {
            // Şifre hatalıysa hata mesajı göster
            JOptionPane.showMessageDialog(this, "Incorrect password: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            error = true;
        }
    } while (error);
    
    
        //accountSelection.showAccountSelectionScreen(customer);
        if(customer != null)
            isLogged = true;
        JOptionPane.showMessageDialog(this, "Kanka showAccountSelectionScreen çalıştı btw", "Error", JOptionPane.ERROR_MESSAGE);
    
    }
    
    public Customer getCustomer() {
        return customer;
    }

    
    public String getTCID() {
        return TCID;
    }

    public String getPassword() {
        return password;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTCID_L = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPassword_L = new javax.swing.JPasswordField();
        jLoginButton_L = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        setPreferredSize(new java.awt.Dimension(700, 540));

        jPanel1.setBackground(new java.awt.Color(30, 30, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(253, 253, 253));
        jLabel1.setText("TCID/SSN");

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(253, 253, 253));
        jLabel2.setText("Password");

        jLoginButton_L.setBackground(new java.awt.Color(204, 102, 0));
        jLoginButton_L.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLoginButton_L.setForeground(new java.awt.Color(253, 253, 253));
        jLoginButton_L.setText("Login");
        jLoginButton_L.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLoginButton_LActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\enesi\\Desktop\\Module Project\\Banking System Simulation\\src\\usericon.png")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLoginButton_L, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                    .addComponent(jPassword_L)
                    .addComponent(jTCID_L)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(195, 195, 195))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(231, 231, 231)
                .addComponent(jLabel3)
                .addContainerGap(230, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTCID_L, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPassword_L, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLoginButton_L, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLoginButton_LActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLoginButton_LActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLoginButton_LActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jLoginButton_L;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPassword_L;
    private javax.swing.JTextField jTCID_L;
    // End of variables declaration//GEN-END:variables
}
