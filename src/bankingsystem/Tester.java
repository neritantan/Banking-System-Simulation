package bankingsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tester {
    private JFrame frame;
    private JPanel panel;
    private Customer customer;

    public Tester() {
        frame = new JFrame("Banking System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);

        showRegistrationScreen();
        frame.setVisible(true);
    }

    private void showRegistrationScreen() {
        panel = new JPanel(new GridLayout(5, 2, 10, 10));
        JLabel firstNameLabel = new JLabel("First Name:");
        JTextField firstNameField = new JTextField();
        JLabel lastNameLabel = new JLabel("Last Name:");
        JTextField lastNameField = new JTextField();
        JLabel tcidLabel = new JLabel("TCID:");
        JTextField tcidField = new JTextField();
        JButton registerButton = new JButton("Register");

        panel.add(firstNameLabel);
        panel.add(firstNameField);
        panel.add(lastNameLabel);
        panel.add(lastNameField);
        panel.add(tcidLabel);
        panel.add(tcidField);
        panel.add(new JLabel()); // Empty space
        panel.add(registerButton);

        registerButton.addActionListener(e -> {
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String tcid = tcidField.getText();
            customer = new Customer(firstName, lastName, tcid);
            showAccountCreationScreen();
        });

        frame.setContentPane(panel);
        frame.revalidate();
        frame.repaint();
    }

    private void showAccountCreationScreen() {
        panel = new JPanel(new GridLayout(5, 1, 10, 10));
        JLabel titleLabel = new JLabel("Select Account Type to Create:", SwingConstants.CENTER);
        JButton checkingButton = new JButton("Checking Account");
        JButton finishButton = new JButton("Finish Account Creation");

        panel.add(titleLabel);
        panel.add(checkingButton);
        panel.add(finishButton);

        checkingButton.addActionListener(e -> {
            CheckingAccount account = new CheckingAccount(customer);
            customer.accounts.add(account);
            JOptionPane.showMessageDialog(frame, "Checking Account Created!");
        });

        finishButton.addActionListener(e -> showAccountSelectionScreen());

        frame.setContentPane(panel);
        frame.revalidate();
        frame.repaint();
    }

    private void showAccountSelectionScreen() {
        panel = new JPanel(new GridLayout(customer.accounts.size() + 2, 1, 10, 10));
        JLabel titleLabel = new JLabel("Select an Account to Perform Actions:", SwingConstants.CENTER);
        panel.add(titleLabel);

        for (int i = 0; i < customer.accounts.size(); i++) {
            CheckingAccount account = customer.accounts.get(i);
            JButton accountButton = new JButton(account.accountType + " | " + account.getIBAN());
            int index = i;
            accountButton.addActionListener(e -> showAccountActionsScreen(customer.accounts.get(index)));
            panel.add(accountButton);
        }

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> System.exit(0));
        panel.add(exitButton);

        frame.setContentPane(panel);
        frame.revalidate();
        frame.repaint();
    }

    private void showAccountActionsScreen(Account account) {
        panel = new JPanel(new GridLayout(5, 1, 10, 10));
        JLabel infoLabel = new JLabel("Account Info: " + account.displayAccountInfo(), SwingConstants.CENTER);
        JButton withdrawButton = new JButton("Withdraw");
        JButton depositButton = new JButton("Deposit");
        JButton backButton = new JButton("Back");

        panel.add(infoLabel);
        panel.add(withdrawButton);
        panel.add(depositButton);
        panel.add(backButton);

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

        backButton.addActionListener(e -> showAccountSelectionScreen());

        frame.setContentPane(panel);
        frame.revalidate();
        frame.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Tester::new);
    }
}
