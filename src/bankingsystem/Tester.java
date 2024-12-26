/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankingsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
/**
 *
 * @author enesi
 */
public class Tester {
    public static void main(String[] args) {
          SwingUtilities.invokeLater(BankingSystemGUI::new);
    }
}
     
   
 class BankingSystemGUI {
    private JFrame frame;
    private JPanel panel;
    private Customer customer;

    public BankingSystemGUI() {
        frame = new JFrame("Banking System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 450);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);  // Disable resizing

        // Set dark theme background color
        frame.getContentPane().setBackground(new Color(40, 40, 40)); // Dark gray background color

        showRegistrationScreen();
        frame.setVisible(true);
    }

    private void showRegistrationScreen() {
    panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    panel.setBackground(new Color(255, 255, 255));  // Beyaz arka plan rengi

    // Başlık etiketini daha çekici hale getirme
    JLabel titleLabel = new JLabel("Welcome to the Banking System", SwingConstants.CENTER);
    titleLabel.setFont(new Font("Verdana", Font.BOLD, 28));  // Modern font ve büyük başlık
    titleLabel.setForeground(new Color(30, 30, 30));  // Koyu gri renk
    titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    titleLabel.setPreferredSize(new Dimension(400, 60));
    titleLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 20, 0));  // Başlık etrafına boşluk

    // Giriş alanları için panel
    JPanel inputPanel = new JPanel(new GridLayout(3, 2, 20, 20));
    inputPanel.setOpaque(false);

    // First name label ve text field
    JLabel firstNameLabel = new JLabel("First Name:");
    firstNameLabel.setFont(new Font("Arial", Font.PLAIN, 18));  // Yazı tipi
    firstNameLabel.setForeground(new Color(60, 60, 60));  // Koyu gri renk
    JTextField firstNameField = new JTextField();
    firstNameField.setFont(new Font("Arial", Font.PLAIN, 16));
    firstNameField.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180), 1));
    firstNameField.setBackground(new Color(245, 245, 245));  // Açık gri arka plan
    firstNameField.setForeground(Color.BLACK);

    // Last name label ve text field
    JLabel lastNameLabel = new JLabel("Last Name:");
    lastNameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
    lastNameLabel.setForeground(new Color(60, 60, 60));
    JTextField lastNameField = new JTextField();
    lastNameField.setFont(new Font("Arial", Font.PLAIN, 16));
    lastNameField.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180), 1));
    lastNameField.setBackground(new Color(245, 245, 245));
    lastNameField.setForeground(Color.BLACK);

    // TCID label ve text field
    JLabel tcidLabel = new JLabel("TCID:");
    tcidLabel.setFont(new Font("Arial", Font.PLAIN, 18));
    tcidLabel.setForeground(new Color(60, 60, 60));
    JTextField tcidField = new JTextField();
    tcidField.setFont(new Font("Arial", Font.PLAIN, 16));
    tcidField.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180), 1));
    tcidField.setBackground(new Color(245, 245, 245));
    tcidField.setForeground(Color.BLACK);

    // Panel'e input alanlarını ekleyelim
    inputPanel.add(firstNameLabel);
    inputPanel.add(firstNameField);
    inputPanel.add(lastNameLabel);
    inputPanel.add(lastNameField);
    inputPanel.add(tcidLabel);
    inputPanel.add(tcidField);

    // Kayıt butonunu daha şık yapma
    JButton registerButton = new JButton("Register");
    registerButton.setFont(new Font("Arial", Font.BOLD, 18));
    registerButton.setBackground(new Color(53, 160, 204)); // Mavi renk
    registerButton.setForeground(Color.WHITE);
    registerButton.setFocusPainted(false);
    registerButton.setPreferredSize(new Dimension(200, 50));
    registerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    registerButton.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
    registerButton.addActionListener(e -> {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String tcid = tcidField.getText();
        customer = new Customer(firstName, lastName, tcid);
        showAccountCreationScreen();
    });

    // Panel'e bileşenleri ekleyelim
    panel.add(titleLabel);
    panel.add(inputPanel);
    panel.add(registerButton);

    // Ekranda görsellik için paneli güncelleme
    frame.setContentPane(panel);
    frame.revalidate();
    frame.repaint();
}

    private void showAccountCreationScreen() {
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(40, 40, 40));  // Dark background for panel

        JLabel titleLabel = new JLabel("Select Account Type to Create", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(Color.WHITE);  // White text for contrast
        titleLabel.setPreferredSize(new Dimension(400, 40));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton checkingButton = new JButton("Checking Account");
        customizeButton(checkingButton);
        checkingButton.addActionListener(e -> {
            CheckingAccount account = new CheckingAccount(customer);
            customer.accounts.add(account);
            JOptionPane.showMessageDialog(frame, "Checking Account Created!");
        });

        JButton finishButton = new JButton("Finish Account Creation");
        customizeButton(finishButton);
        finishButton.addActionListener(e -> showAccountSelectionScreen());

        panel.add(titleLabel);
        panel.add(checkingButton);
        panel.add(finishButton);

        frame.setContentPane(panel);
        frame.revalidate();
        frame.repaint();
    }

    private void showAccountSelectionScreen() {
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(40, 40, 40));  // Dark background for panel

        JLabel titleLabel = new JLabel("Select an Account to Perform Actions", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(Color.WHITE);  // White text for contrast
        titleLabel.setPreferredSize(new Dimension(400, 40));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        for (int i = 0; i < customer.accounts.size(); i++) {
            CheckingAccount account = customer.accounts.get(i);
            JButton accountButton = new JButton(account.accountType + " | " + account.getIBAN());
            customizeButton(accountButton);
            int index = i;
            accountButton.addActionListener(e -> showAccountActionsScreen(customer.accounts.get(index)));
            panel.add(accountButton);
        }

        JButton exitButton = new JButton("Exit");
        customizeButton(exitButton);
        exitButton.addActionListener(e -> System.exit(0));

        panel.add(exitButton);

        frame.setContentPane(panel);
        frame.revalidate();
        frame.repaint();
    }

    private void showAccountActionsScreen(Account account) {
    panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    panel.setBackground(new Color(40, 40, 40));  // Dark background for panel

    // JTextArea kullanarak uzun bilgiyi çok satırlı şekilde göstermek
    JTextArea infoArea = new JTextArea(account.displayAccountInfo());
    infoArea.setFont(new Font("Arial", Font.PLAIN, 14));
    infoArea.setForeground(Color.WHITE);  // White text for contrast
    infoArea.setBackground(new Color(60, 60, 60)); // Dark background for text area
    infoArea.setEditable(false); // Kullanıcı düzenlemeyi engelle
    infoArea.setLineWrap(true);  // Satırları kırmak için
    infoArea.setWrapStyleWord(true);  // Kelime kesilmesini engellemek için
    infoArea.setCaretPosition(0); // Başlangıçta en üst satıra gelmesi için

    JScrollPane scrollPane = new JScrollPane(infoArea);
    scrollPane.setPreferredSize(new Dimension(400, 200)); // Scrollable area for account info
    panel.add(scrollPane);

    JButton withdrawButton = new JButton("Withdraw");
    customizeButton(withdrawButton);
    withdrawButton.addActionListener(e -> {
        String amountStr = JOptionPane.showInputDialog(frame, "Enter amount to withdraw:");
        try {
            double amount = Double.parseDouble(amountStr);
            account.withdraw(amount);
            JOptionPane.showMessageDialog(frame, "Withdraw successful! New balance: " + account.getBalance());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
        }
    });

    JButton depositButton = new JButton("Deposit");
    customizeButton(depositButton);
    depositButton.addActionListener(e -> {
        String amountStr = JOptionPane.showInputDialog(frame, "Enter amount to deposit:");
        try {
            double amount = Double.parseDouble(amountStr);
            account.deposit(amount);
            JOptionPane.showMessageDialog(frame, "Deposit successful! New balance: " + account.getBalance());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
        }
    });

    JButton backButton = new JButton("Back");
    customizeButton(backButton);
    backButton.addActionListener(e -> showAccountSelectionScreen());

    panel.add(withdrawButton);
    panel.add(depositButton);
    panel.add(backButton);

    frame.setContentPane(panel);
    frame.revalidate();
    frame.repaint();
}

    // Method to customize buttons with dark theme
    private void customizeButton(JButton button) {
        button.setFont(new Font("Arial", Font.PLAIN, 16));
        button.setBackground(new Color(53, 160, 204)); // Blue color for button
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(200, 40));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }
}
