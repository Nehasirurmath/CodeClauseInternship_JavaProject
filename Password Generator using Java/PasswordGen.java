import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;
import java.util.*;

public class PasswordGen extends JFrame {
    private JTextField passwordField;
    private JButton generateButton;
    private JComboBox<Integer> lengthComboBox;
    private static final String LOWERCASE_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARACTER = "!@#$%^&*()_+-=";

    public PasswordGen() {
        setTitle("Password Generator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        passwordField = new JTextField(20);
        passwordField.setEditable(false);
        generateButton = new JButton("Generate");
        generateButton.setPreferredSize(new Dimension(150, 150));
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setPreferredSize(new Dimension(300, 30));

        add(buttonPanel, BorderLayout.CENTER);

        lengthComboBox = new JComboBox<>();
        lengthComboBox.addItem(6);
        lengthComboBox.addItem(10);
        lengthComboBox.addItem(12);

        generateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int passwordLength = (int) lengthComboBox.getSelectedItem();
                String password = generatePassword(passwordLength);
                passwordField.setText(password);

            }
        });
        add(lengthComboBox);
        add(generateButton);
        add(passwordField);
        pack();
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    private String generatePassword(int length) {
        StringBuilder password = new StringBuilder();
        SecureRandom random = new SecureRandom();

        StringBuilder chracters = new StringBuilder();
        chracters.append(LOWERCASE_CHARACTERS);
        chracters.append(UPPERCASE_CHARACTERS);
        chracters.append(NUMBERS);
        chracters.append(SPECIAL_CHARACTER);
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(chracters.length());
            password.append(chracters.charAt(randomIndex));

        }
        return password.toString();

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PasswordGen();

            }
        });

    }
}