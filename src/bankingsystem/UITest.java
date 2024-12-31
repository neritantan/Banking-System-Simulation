package bankingsystem;

import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UITest {

    private static JFrame frame;
    private static JPanel mainPanel, loginPanel, registerPanel, accountPanel;
    private static CardLayout cardLayout;

    public static void main(String[] args) {
        FlatDarkLaf.setup();

        frame = new JFrame("Banking System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        initializeMainMenu();
        initializeLoginPanel();
        initializeRegisterPanel();
        initializeAccountPanel();

        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private static void initializeMainMenu() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(60, 63, 65));
        
        JLabel welcomeLabel = new JLabel("Welcome, please select:");
        welcomeLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        welcomeLabel.setForeground(new Color(253, 253, 253));

        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");

        styleButton(loginButton);
        styleButton(registerButton);

        loginButton.addActionListener(e -> cardLayout.show(mainPanel, "Login"));
        registerButton.addActionListener(e -> cardLayout.show(mainPanel, "Register"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(welcomeLabel, gbc);

        gbc.gridy = 1;
        panel.add(loginButton, gbc);

        gbc.gridy = 2;
        panel.add(registerButton, gbc);

        mainPanel.add(panel, "MainMenu");
    }

    private static void initializeLoginPanel() {
        loginPanel = new JPanel(new GridBagLayout());
        loginPanel.setBackground(new Color(43, 43, 43));

        JLabel titleLabel = new JLabel("Login");
        titleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        titleLabel.setForeground(new Color(253, 253, 253));

        JTextField tcidField = new JTextField(15);
        JPasswordField passwordField = new JPasswordField(15);
        JButton loginButton = new JButton("Login");
        JButton backButton = new JButton("Back");

        styleButton(loginButton);
        styleButton(backButton);

        loginButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Login logic here"));
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "MainMenu"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        loginPanel.add(titleLabel, gbc);

        gbc.gridy = 1;
        loginPanel.add(new JLabel("TCID:"), gbc);

        gbc.gridx = 1;
        loginPanel.add(tcidField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        loginPanel.add(new JLabel("Password:"), gbc);

        gbc.gridx = 1;
        loginPanel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        loginPanel.add(loginButton, gbc);

        gbc.gridx = 1;
        loginPanel.add(backButton, gbc);

        mainPanel.add(loginPanel, "Login");
    }

    private static void initializeRegisterPanel() {
        registerPanel = new JPanel(new GridBagLayout());
        registerPanel.setBackground(new Color(43, 43, 43));

        JLabel titleLabel = new JLabel("Register");
        titleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        titleLabel.setForeground(new Color(253, 253, 253));

        JTextField firstNameField = new JTextField(15);
        JTextField lastNameField = new JTextField(15);
        JTextField tcidField = new JTextField(15);
        JPasswordField passwordField = new JPasswordField(15);
        JButton registerButton = new JButton("Register");
        JButton backButton = new JButton("Back");

        styleButton(registerButton);
        styleButton(backButton);

        registerButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Register logic here"));
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "MainMenu"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        registerPanel.add(titleLabel, gbc);

        gbc.gridy = 1;
        registerPanel.add(new JLabel("First Name:"), gbc);

        gbc.gridx = 1;
        registerPanel.add(firstNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        registerPanel.add(new JLabel("Last Name:"), gbc);

        gbc.gridx = 1;
        registerPanel.add(lastNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        registerPanel.add(new JLabel("TCID:"), gbc);

        gbc.gridx = 1;
        registerPanel.add(tcidField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        registerPanel.add(new JLabel("Password:"), gbc);

        gbc.gridx = 1;
        registerPanel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        registerPanel.add(registerButton, gbc);

        gbc.gridx = 1;
        registerPanel.add(backButton, gbc);

        mainPanel.add(registerPanel, "Register");
    }

    private static void initializeAccountPanel() {
        accountPanel = new JPanel(new BorderLayout());
        accountPanel.setBackground(new Color(30, 30, 30));

        JLabel accountLabel = new JLabel("Account Info:");
        accountLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        accountLabel.setForeground(new Color(253, 253, 253));

        JButton backButton = new JButton("Back");
        styleButton(backButton);

        backButton.addActionListener(e -> cardLayout.show(mainPanel, "MainMenu"));

        accountPanel.add(accountLabel, BorderLayout.CENTER);
        accountPanel.add(backButton, BorderLayout.SOUTH);

        mainPanel.add(accountPanel, "Account");
    }

    private static void styleButton(JButton button) {
        button.setBackground(new Color(43, 43, 43));
        button.setForeground(new Color(253, 253, 253));
        button.setFocusPainted(false);
        button.setFont(new Font("Segoe UI", Font.PLAIN, 14));
    }
}