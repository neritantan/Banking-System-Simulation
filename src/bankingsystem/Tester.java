package bankingsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tester {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Tester().createUI());
    }

    public void createUI() {
        JFrame frame = new JFrame("Banking System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null); // Center the window
        frame.setResizable(false);
        
        // Set the overall background color to black
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLayout(new BorderLayout());

        // Create a welcome panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10));
        panel.setBackground(Color.BLACK);
        
        JLabel welcomeLabel = new JLabel("Welcome to the Banking System!", JLabel.CENTER);
        welcomeLabel.setForeground(Color.ORANGE);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel optionLabel = new JLabel("Please select an option:", JLabel.CENTER);
        optionLabel.setForeground(Color.ORANGE);
        
        // Login Button
        JButton loginButton = new JButton("Login");
        styleButton(loginButton);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call login method or show login screen
                System.out.println("Login clicked");
            }
        });

        // Register Button
        JButton registerButton = new JButton("Register");
        styleButton(registerButton);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call register method or show register screen
                System.out.println("Register clicked");
            }
        });

        panel.add(welcomeLabel);
        panel.add(optionLabel);
        panel.add(loginButton);
        panel.add(registerButton);

        // Add the panel to the frame
        frame.add(panel, BorderLayout.CENTER);
        
        // Make the window visible
        frame.setVisible(true);
    }

    // A helper method to style buttons with black background and orange text
    private void styleButton(JButton button) {
        button.setBackground(Color.BLACK);
        button.setForeground(Color.ORANGE);
        button.setFont(new Font("Arial", Font.PLAIN, 16));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
    }
}
