import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class ResumeBuild extends JFrame {
    private JTextField nameField, emailField;
    private JTextArea educationArea, exprienceArea, skillsArea;
    private JButton generateButton;

    public ResumeBuild() {
        setTitle("Resume Builder");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        // create component
        JLabel nameLabel = new JLabel("Name");
        JLabel emailLabel = new JLabel("Email");
        JLabel educationLabel = new JLabel("education");
        JLabel expreienceLabel = new JLabel("exprience");
        JLabel skillsLabel = new JLabel("skills");
        nameField = new JTextField(20);
        emailField = new JTextField(20);
        educationArea = new JTextArea(5, 20);
        exprienceArea = new JTextArea(5, 20);
        skillsArea = new JTextArea(5, 20);
        generateButton = new JButton("Generate Resume");

        // create pnels
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        inputPanel.add(nameLabel, gbc);
        gbc.gridx++;
        inputPanel.add(nameField, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        inputPanel.add(emailLabel, gbc);
        gbc.gridx++;
        inputPanel.add(emailField, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        inputPanel.add(educationLabel, gbc);
        gbc.gridy++;
        inputPanel.add(educationArea, gbc);
        gbc.gridy++;
        inputPanel.add(expreienceLabel, gbc);
        gbc.gridy++;
        inputPanel.add(exprienceArea, gbc);
        gbc.gridy++;
        inputPanel.add(skillsLabel, gbc);
        gbc.gridy++;
        inputPanel.add(skillsArea, gbc);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(generateButton);
        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        generateButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                generateResume();
            }

        });
    }

    private void generateResume() {
        String name = nameField.getText();
        String email = emailField.getText();
        String education = educationArea.getText();
        String experience = exprienceArea.getText();
        String skills = skillsArea.getText();

        StringBuilder resume = new StringBuilder();
        resume.append("Resume\n\n");
        resume.append("Name:").append(name).append("\n");
        resume.append("Email:").append(email).append("\n");
        resume.append("Education:").append(education).append("\n");
        resume.append("Expreience:").append(experience).append("\n");
        resume.append("Skills:").append(skills).append("\n");

        JOptionPane.showMessageDialog(this, resume.toString(), "generate resume", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        ResumeBuild build = new ResumeBuild();
        build.setVisible(true);
    }
}
