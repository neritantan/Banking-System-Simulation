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
        panel.setBackground(new Color(40, 40, 40));  // Dark background for panel

        JLabel titleLabel = new JLabel("Welcome to the Banking System", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.WHITE);  // White text for contrast
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setPreferredSize(new Dimension(400, 40));

        // Create input fields with custom style
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        inputPanel.setOpaque(false);

        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setForeground(Color.WHITE);  // White text for contrast
        JTextField firstNameField = new JTextField();
        firstNameField.setBorder(BorderFactory.createLineBorder(new Color(150, 150, 150), 1));
        firstNameField.setBackground(new Color(60, 60, 60)); // Dark background for input fields
        firstNameField.setForeground(Color.WHITE);  // White text

        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setForeground(Color.WHITE);  // White text for contrast
        JTextField lastNameField = new JTextField();
        lastNameField.setBorder(BorderFactory.createLineBorder(new Color(150, 150, 150), 1));
        lastNameField.setBackground(new Color(60, 60, 60)); // Dark background for input fields
        lastNameField.setForeground(Color.WHITE);  // White text

        JLabel tcidLabel = new JLabel("TCID:");
        tcidLabel.setForeground(Color.WHITE);  // White text for contrast
        JTextField tcidField = new JTextField();
        tcidField.setBorder(BorderFactory.createLineBorder(new Color(150, 150, 150), 1));
        tcidField.setBackground(new Color(60, 60, 60)); // Dark background for input fields
        tcidField.setForeground(Color.WHITE);  // White text

        inputPanel.add(firstNameLabel);
        inputPanel.add(firstNameField);
        inputPanel.add(lastNameLabel);
        inputPanel.add(lastNameField);
        inputPanel.add(tcidLabel);
        inputPanel.add(tcidField);

        // Register button with modern style
        JButton registerButton = new JButton("Register");
        registerButton.setFont(new Font("Arial", Font.BOLD, 16));
        registerButton.setBackground(new Color(53, 160, 204)); // Blue color for button
        registerButton.setForeground(Color.WHITE);
        registerButton.setFocusPainted(false);
        registerButton.setPreferredSize(new Dimension(150, 40));
        registerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        registerButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        registerButton.addActionListener(e -> {
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String tcid = tcidField.getText();
            customer = new Customer(firstName, lastName, tcid);
            showAccountCreationScreen();
        });

        panel.add(titleLabel);
        panel.add(inputPanel);
        panel.add(registerButton);

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

        JLabel infoLabel = new JLabel("Account Info: " + account.displayAccountInfo(), SwingConstants.CENTER);
        infoLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        infoLabel.setForeground(Color.WHITE);  // White text for contrast
        infoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

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

        panel.add(infoLabel);
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
