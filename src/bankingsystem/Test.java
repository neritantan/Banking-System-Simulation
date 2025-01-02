package bankingsystem;

import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import javax.swing.border.EmptyBorder;

public class Test extends JFrame {
    private final Color DARK_GRAY = new Color(60, 63, 65);
    private final Color MEDIUM_GRAY = new Color(44, 44, 44);
    private final Color LIGHT_GRAY = new Color(30, 30, 30);
    
    private JPanel mainPanel;
    private CardLayout cardLayout;
    private Customer currentCustomer;
    private Account selectedAccount;
    
    private JTextField tcidField;
    private JPasswordField passwordField;
    private JTextArea outputArea;
    
    public Test() {
        setupLookAndFeel();
        setupFrame();
        initializeComponents();
        showMainMenu();
    }
    
    private void setupLookAndFeel() {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
            UIManager.put("Panel.background", DARK_GRAY);
            UIManager.put("Button.background", MEDIUM_GRAY);
            UIManager.put("TextField.background", LIGHT_GRAY);
            UIManager.put("TextArea.background", LIGHT_GRAY);
            UIManager.put("PasswordField.background", LIGHT_GRAY);
            UIManager.put("ComboBox.background", LIGHT_GRAY);
            UIManager.put("Button.foreground", Color.WHITE);
            UIManager.put("Label.foreground", Color.WHITE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void setupFrame() {
        setTitle("Banking System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        add(mainPanel);
        
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        outputArea.setMargin(new Insets(10, 10, 10, 10));
    }
    
    private void initializeComponents() {
        // Main Menu Panel
        JPanel mainMenuPanel = new JPanel(new GridBagLayout());
        mainMenuPanel.setBackground(DARK_GRAY);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        JLabel titleLabel = new JLabel("Banking System");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        
        JButton loginButton = createStyledButton("Login");
        JButton registerButton = createStyledButton("Register");
        JButton exitButton = createStyledButton("Exit");
        
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        mainMenuPanel.add(titleLabel, gbc);
        gbc.gridy = 1; gbc.gridwidth = 1;
        mainMenuPanel.add(loginButton, gbc);
        gbc.gridy = 2;
        mainMenuPanel.add(registerButton, gbc);
        gbc.gridy = 3;
        mainMenuPanel.add(exitButton, gbc);
        
        mainPanel.add(mainMenuPanel, "mainMenu");
        
        // Login Panel
        JPanel loginPanel = createLoginPanel();
        mainPanel.add(loginPanel, "login");
        
        // Register Panel
        JPanel registerPanel = createRegisterPanel();
        mainPanel.add(registerPanel, "register");
        
        // Account Selection Panel
        JPanel accountSelectionPanel = createAccountSelectionPanel();
        mainPanel.add(accountSelectionPanel, "accountSelection");
        
        // Transaction Panel
        JPanel transactionPanel = createTransactionPanel();
        mainPanel.add(transactionPanel, "transaction");
        
        // Button Actions
        loginButton.addActionListener(e -> showLoginPanel());
        registerButton.addActionListener(e -> showRegisterPanel());
        exitButton.addActionListener(e -> System.exit(0));
    }
    
    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(MEDIUM_GRAY);
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setFocusPainted(false);
        return button;
    }
    
    private JTextField createStyledTextField() {
        JTextField textField = new JTextField(20);
        textField.setBackground(LIGHT_GRAY);
        textField.setForeground(Color.WHITE);
        textField.setBorder(BorderFactory.createCompoundBorder(
            textField.getBorder(),
            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        return textField;
    }
    
    private JPanel createLoginPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(DARK_GRAY);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        tcidField = createStyledTextField();
        passwordField = new JPasswordField(20);
        passwordField.setBackground(LIGHT_GRAY);
        passwordField.setForeground(Color.WHITE);
        
        JButton loginButton = createStyledButton("Login");
        JButton backButton = createStyledButton("Back");
        
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("TCID:"), gbc);
        gbc.gridx = 1;
        panel.add(tcidField, gbc);
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("Password:"), gbc);
        gbc.gridx = 1;
        panel.add(passwordField, gbc);
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        panel.add(loginButton, gbc);
        gbc.gridy = 3;
        panel.add(backButton, gbc);
        
        loginButton.addActionListener(e -> handleLogin());
        backButton.addActionListener(e -> showMainMenu());
        
        return panel;
    }
    
    private JPanel createRegisterPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(DARK_GRAY);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        JTextField firstNameField = createStyledTextField();
        JTextField lastNameField = createStyledTextField();
        JTextField tcidRegField = createStyledTextField();
        JPasswordField passwordRegField = new JPasswordField(20);
        passwordRegField.setBackground(LIGHT_GRAY);
        
        JButton registerButton = createStyledButton("Register");
        JButton backButton = createStyledButton("Back");
        
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("First Name:"), gbc);
        gbc.gridx = 1;
        panel.add(firstNameField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("Last Name:"), gbc);
        gbc.gridx = 1;
        panel.add(lastNameField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(new JLabel("TCID:"), gbc);
        gbc.gridx = 1;
        panel.add(tcidRegField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(new JLabel("Password:"), gbc);
        gbc.gridx = 1;
        panel.add(passwordRegField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        panel.add(registerButton, gbc);
        gbc.gridy = 5;
        panel.add(backButton, gbc);
        
        registerButton.addActionListener(e -> {
            try {
                String tcid = tcidRegField.getText();
                if (tcid.length() != 11 || !tcid.matches("\\d+")) {
                    throw new InvalidTCIDException(tcid);
                }
                
                currentCustomer = new Customer(
                    firstNameField.getText(),
                    lastNameField.getText(),
                    tcid,
                    new String(passwordRegField.getPassword())
                );
                showAccountCreationDialog();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        backButton.addActionListener(e -> showMainMenu());
        
        return panel;
    }
    
    private JPanel createAccountSelectionPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(DARK_GRAY);
        
        DefaultListModel<String> accountListModel = new DefaultListModel<>();
        JList<String> accountList = new JList<>(accountListModel);
        accountList.setBackground(LIGHT_GRAY);
        accountList.setForeground(Color.WHITE);
        
        JScrollPane scrollPane = new JScrollPane(accountList);
        scrollPane.setBackground(DARK_GRAY);
        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(DARK_GRAY);
        
        JButton selectButton = createStyledButton("Select");
        JButton backButton = createStyledButton("Back");
        
        buttonPanel.add(selectButton);
        buttonPanel.add(backButton);
        
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        
        selectButton.addActionListener(e -> {
            int selectedIndex = accountList.getSelectedIndex();
            if (selectedIndex != -1 && currentCustomer != null) {
                selectedAccount = currentCustomer.accounts.get(selectedIndex);
                showTransactionPanel();
            }
        });
        
        backButton.addActionListener(e -> showMainMenu());
        
        return panel;
    }
    
    private JPanel createTransactionPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(DARK_GRAY);
        
        JPanel buttonPanel = new JPanel(new GridLayout(0, 1, 5, 5));
        buttonPanel.setBackground(DARK_GRAY);
        buttonPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        JButton withdrawButton = createStyledButton("Withdraw");
        JButton depositButton = createStyledButton("Deposit");
        JButton eftButton = createStyledButton("EFT");
        JButton historyButton = createStyledButton("Transaction History");
        JButton investButton = createStyledButton("Invest");
        JButton withdrawInvestButton = createStyledButton("Withdraw Investment");
        JButton backButton = createStyledButton("Back");
        
        buttonPanel.add(withdrawButton);
        buttonPanel.add(depositButton);
        buttonPanel.add(eftButton);
        buttonPanel.add(historyButton);
        buttonPanel.add(investButton);
        buttonPanel.add(withdrawInvestButton);
        buttonPanel.add(backButton);
        
        JTextArea infoArea = new JTextArea();
        infoArea.setEditable(false);
        infoArea.setBackground(LIGHT_GRAY);
        infoArea.setForeground(Color.WHITE);
        
        panel.add(new JScrollPane(infoArea), BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.EAST);
        
        // Button Actions
        withdrawButton.addActionListener(e -> handleWithdraw());
        depositButton.addActionListener(e -> handleDeposit());
        eftButton.addActionListener(e -> handleEFT());
        historyButton.addActionListener(e -> {
            if (selectedAccount != null) {
                selectedAccount.printTransactionLog();
                updateAccountInfo();
            }
        });
        
        investButton.addActionListener(e -> {
            if (selectedAccount instanceof SavingsAccount) {
                handleInvest();
            } else {
                JOptionPane.showMessageDialog(this, 
                    "This feature is only available for Savings Accounts",
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        withdrawInvestButton.addActionListener(e -> {
            if (selectedAccount instanceof SavingsAccount) {
                handleWithdrawInvestment();
            } else {
                JOptionPane.showMessageDialog(this, 
                    "This feature is only available for Savings Accounts",
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        backButton.addActionListener(e -> showAccountSelection());
        
        return panel;
    }
    
    private void showMainMenu() {
        cardLayout.show(mainPanel, "mainMenu");
    }
    
    private void showLoginPanel() {
        cardLayout.show(mainPanel, "login");
    }
    
    private void showRegisterPanel() {
        cardLayout.show(mainPanel, "register");
    }
    
    private void showAccountSelection() {
        if (currentCustomer != null) {
            JList<String> accountList = getAccountList();
            DefaultListModel<String> model = (DefaultListModel<String>)accountList.getModel();
            model.clear();
            
            for (CheckingAccount account : currentCustomer.accounts) {
                model.addElement(account.getaccountType() + " | " + account.getIBAN());
            }
        }
        cardLayout.show(mainPanel, "accountSelection");
    }
    
    private void showTransactionPanel() {
        updateAccountInfo();
        cardLayout.show(mainPanel, "transaction");
    }
    
    private JList<String> getAccountList() {
        JPanel accountPanel = (JPanel)mainPanel.getComponent(3); // account selection panel
        JScrollPane scrollPane = (JScrollPane)accountPanel.getComponent(0);
        return (JList<String>)scrollPane.getViewport().getView();
    }
    
private void updateAccountInfo() {
        if (selectedAccount != null) {
            JPanel transactionPanel = (JPanel)mainPanel.getComponent(4);
            JScrollPane scrollPane = (JScrollPane)transactionPanel.getComponent(0);
            JTextArea infoArea = (JTextArea)scrollPane.getViewport().getView();
            infoArea.setText(selectedAccount.displayAccountInfo());
        }
    }
    
    private void handleLogin() {
        try {
            String tcid = tcidField.getText();
            String password = new String(passwordField.getPassword());
            
            Login login = new Login(tcid, password);
            currentCustomer = login.getLoggedCustomer();
            
            showAccountSelection();
            
        } catch (CustomerNotFoundException | PasswordNotCorrectException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Login Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void handleWithdraw() {
        try {
            String amount = JOptionPane.showInputDialog(this, "Enter amount to withdraw:");
            if (amount != null && !amount.isEmpty()) {
                double withdrawAmount = Double.parseDouble(amount);
                selectedAccount.withdraw(withdrawAmount);
                updateAccountInfo();
                JOptionPane.showMessageDialog(this, "Withdrawal successful!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (InsufficientFundsException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void handleDeposit() {
        try {
            String amount = JOptionPane.showInputDialog(this, "Enter amount to deposit:");
            if (amount != null && !amount.isEmpty()) {
                double depositAmount = Double.parseDouble(amount);
                selectedAccount.deposit(depositAmount);
                updateAccountInfo();
                JOptionPane.showMessageDialog(this, "Deposit successful!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (InvalidDepositAmountException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void handleEFT() {
        try {
            String receiverIBAN = JOptionPane.showInputDialog(this, "Enter receiver's IBAN:");
            if (receiverIBAN != null && !receiverIBAN.isEmpty()) {
                String amount = JOptionPane.showInputDialog(this, "Enter amount to transfer:");
                if (amount != null && !amount.isEmpty()) {
                    double transferAmount = Double.parseDouble(amount);
                    EFT.transfer(selectedAccount.getIBAN(), receiverIBAN, transferAmount);
                    updateAccountInfo();
                    JOptionPane.showMessageDialog(this, "Transfer successful!");
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void handleInvest() {
        try {
            String amount = JOptionPane.showInputDialog(this, "Enter amount to invest:");
            if (amount != null && !amount.isEmpty()) {
                double investAmount = Double.parseDouble(amount);
                LocalDate today = LocalDate.now();
                ((SavingsAccount) selectedAccount).invest(investAmount, today);
                updateAccountInfo();
                JOptionPane.showMessageDialog(this, "Investment successful!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void handleWithdrawInvestment() {
        try {
            ((SavingsAccount) selectedAccount).withdrawInvestment();
            updateAccountInfo();
            JOptionPane.showMessageDialog(this, "Investment withdrawal successful!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void showAccountCreationDialog() {
        String[] options = {"Checking Account", "Overdraft Account", "Savings Account"};
        int choice = JOptionPane.showOptionDialog(this,
            "Which type of account do you want to create?",
            "Create Account",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[0]);
            
        if (choice != -1) {
            switch (choice) {
                case 0:
                    currentCustomer.accounts.add(new CheckingAccount(currentCustomer));
                    break;
                case 1:
                    currentCustomer.accounts.add(new OverdraftAccount(currentCustomer));
                    break;
                case 2:
                    currentCustomer.accounts.add(new SavingsAccount(currentCustomer));
                    break;
            }
            
            int createAnother = JOptionPane.showConfirmDialog(this,
                "Do you want to create another account?",
                "Create Another Account",
                JOptionPane.YES_NO_OPTION);
                
            if (createAnother == JOptionPane.YES_OPTION) {
                showAccountCreationDialog();
            } else {
                showAccountSelection();
            }
        }
    }
    
    public static void main(String[] args) {
        EFT.setupDataBase();
        SwingUtilities.invokeLater(() -> {
            Test bankingSystem = new Test();
            bankingSystem.setVisible(true);
        });
    }
}