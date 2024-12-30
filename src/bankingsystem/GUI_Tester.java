//package bankingsystem;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.ArrayList;
//import java.util.List;
//
//public class GUI_Tester {
//    private JFrame frame;
//    private JPanel panel;
//    private Customer customer;
//    private List<Customer> customers = new ArrayList<>(); // List of registered customers
//
//    public GUI_Tester() {
//        frame = new JFrame("Banking System");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(500, 400);
//        frame.setLocationRelativeTo(null);
//
//        showLoginScreen();
//        frame.setVisible(true);
//    }
//
//    private void showLoginScreen() {
//        panel = new JPanel(new GridLayout(4, 2, 10, 10));
//        JLabel usernameLabel = new JLabel("TCID:");
//        JTextField usernameField = new JTextField();
//        JLabel passwordLabel = new JLabel("Password:");
//        JPasswordField passwordField = new JPasswordField();
//        JButton loginButton = new JButton("Login");
//        JButton registerButton = new JButton("Register");
//
//        panel.add(usernameLabel);
//        panel.add(usernameField);
//        panel.add(passwordLabel);
//        panel.add(passwordField);
//        panel.add(new JLabel()); // Empty space
//        panel.add(loginButton);
//        panel.add(registerButton);
//
//        loginButton.addActionListener(e -> {
//            String tcid = usernameField.getText();
//            String password = new String(passwordField.getPassword());
//            customer = login(tcid, password);
//            if (customer != null) {
//                showAccountSelectionScreen();
//            } else {
//                JOptionPane.showMessageDialog(frame, "Invalid TCID or Password!");
//            }
//        });
//
//        registerButton.addActionListener(e -> showRegistrationScreen());
//
//        frame.setContentPane(panel);
//        frame.revalidate();
//        frame.repaint();
//    }
//
//    private Customer login(String tcid, String password) {
//        // Validate login with the list of customers
//        for (Customer c : customers) {
//            if (c.getTcid().equals(tcid) && c.getPassword().equals(password)) {
//                return c;
//            }
//        }
//        return null;
//    }
//
//    private void showRegistrationScreen() {
//        panel = new JPanel(new GridLayout(5, 2, 10, 10));
//        JLabel firstNameLabel = new JLabel("First Name:");
//        JTextField firstNameField = new JTextField();
//        JLabel lastNameLabel = new JLabel("Last Name:");
//        JTextField lastNameField = new JTextField();
//        JLabel tcidLabel = new JLabel("TCID:");
//        JTextField tcidField = new JTextField();
//        JLabel passwordLabel = new JLabel("Password:");
//        JPasswordField passwordField = new JPasswordField();
//        JButton registerButton = new JButton("Register");
//
//        panel.add(firstNameLabel);
//        panel.add(firstNameField);
//        panel.add(lastNameLabel);
//        panel.add(lastNameField);
//        panel.add(tcidLabel);
//        panel.add(tcidField);
//        panel.add(passwordLabel);
//        panel.add(passwordField);
//        panel.add(new JLabel()); // Empty space
//        panel.add(registerButton);
//
//        registerButton.addActionListener(e -> {
//            String firstName = firstNameField.getText();
//            String lastName = lastNameField.getText();
//            String tcid = tcidField.getText();
//            String password = new String(passwordField.getPassword());
//            customer = new Customer(firstName, lastName, tcid, password);
//            customers.add(customer);
//            JOptionPane.showMessageDialog(frame, "Registration Successful!");
//            showLoginScreen();
//        });
//
//        frame.setContentPane(panel);
//        frame.revalidate();
//        frame.repaint();
//    }
//
//    private void showAccountSelectionScreen() {
//        panel = new JPanel(new GridLayout(customer.accounts.size() + 2, 1, 10, 10));
//        JLabel titleLabel = new JLabel("Select an Account to Perform Actions:", SwingConstants.CENTER);
//        panel.add(titleLabel);
//
//        for (int i = 0; i < customer.accounts.size(); i++) {
//            CheckingAccount account = customer.accounts.get(i);
//            JButton accountButton = new JButton(account.accountType + " | " + account.getIBAN());
//            int index = i;
//            accountButton.addActionListener(e -> showAccountActionsScreen(customer.accounts.get(index)));
//            panel.add(accountButton);
//        }
//
//        JButton exitButton = new JButton("Exit");
//        exitButton.addActionListener(e -> System.exit(0));
//        panel.add(exitButton);
//
//        frame.setContentPane(panel);
//        frame.revalidate();
//        frame.repaint();
//    }
//
//    private void showAccountActionsScreen(Account account) {
//        panel = new JPanel(new GridLayout(5, 1, 10, 10));
//        JLabel infoLabel = new JLabel("Account Info: " + account.displayAccountInfo(), SwingConstants.CENTER);
//        JButton withdrawButton = new JButton("Withdraw");
//        JButton depositButton = new JButton("Deposit");
//        JButton backButton = new JButton("Back");
//
//        panel.add(infoLabel);
//        panel.add(withdrawButton);
//        panel.add(depositButton);
//        panel.add(backButton);
//
//        withdrawButton.addActionListener(e -> {
//            String amountStr = JOptionPane.showInputDialog(frame, "Enter amount to withdraw:");
//            try {
//                double amount = Double.parseDouble(amountStr);
//                account.withdraw(amount);
//                JOptionPane.showMessageDialog(frame, "Withdraw successful! New balance: " + account.getBalance());
//            } catch (InsufficientFundsException ex) {
//                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
//            } catch (Exception ex) {
//                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
//            }
//        });
//
//        depositButton.addActionListener(e -> {
//            String amountStr = JOptionPane.showInputDialog(frame, "Enter amount to deposit:");
//            try {
//                double amount = Double.parseDouble(amountStr);
//                account.deposit(amount);
//                JOptionPane.showMessageDialog(frame, "Deposit successful! New balance: " + account.getBalance());
//            } catch (Exception ex) {
//                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
//            }
//        });
//
//        backButton.addActionListener(e -> showAccountSelectionScreen());
//
//        frame.setContentPane(panel);
//        frame.revalidate();
//        frame.repaint();
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(GUI_Tester::new);
//    }
//}
//
//class Customer {
//    private String firstName;
//    private String lastName;
//    private String tcid;
//    private String password;
//    public List<CheckingAccount> accounts = new ArrayList<>();
//
//    public Customer(String firstName, String lastName, String tcid, String password) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.tcid = tcid;
//        this.password = password;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public String getTcid() {
//        return tcid;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//}
//
//class Account {
//    private double balance;
//    private String IBAN;
//    private Customer customer;
//
//    public Account(Customer customer) {
//        this.customer = customer;
//        this.balance = 0;
//        this.IBAN = "IBAN" + Math.random(); // Simple random IBAN generation
//    }
//
//    public void withdraw(double amount) throws InsufficientFundsException {
//        if (amount > balance) {
//            throw new InsufficientFundsException(balance, amount);
//        }
//        balance -= amount;
//    }
//
//    public void deposit(double amount) {
//        balance += amount;
//    }
//
//    public double getBalance() {
//        return balance;
//    }
//
//    public String getIBAN() {
//        return IBAN;
//    }
//
//    public String displayAccountInfo() {
//        return "IBAN: " + getIBAN() + " | Balance: $" + getBalance();
//    }
//}
//
//class CheckingAccount extends Account {
//    public String accountType = "Checking";
//
//    public CheckingAccount(Customer customer) {
//        super(customer);
//    }
//}
//
//class InsufficientFundsException extends Exception {
//    double balance;
//    double amount;
//
//    public InsufficientFundsException(double balance, double amount) {
//        this.balance = balance;
//        this.amount = amount;
//    }
//
//    @Override
//    public String toString() {
//        return "Insufficient Funds!! You are trying to withdraw $" + amount + " yet you have $" + balance + " in your account.";
//    }
//}
