import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class CaptchaProj extends JFrame {
    private JLabel captchaLabel;
    private JTextField captchaTextField;
    private JButton generateButton;
    private String generatedCaptcha;

    public CaptchaProj() {
        setTitle("Captcha Generator");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        captchaLabel = new JLabel();
        captchaLabel.setFont(new Font("Arial", Font.BOLD, 20));
        captchaLabel.setForeground(Color.BLUE);
        captchaTextField = new JTextField(10);
        generateButton = new JButton("Generate Captcha");
        generateButton.setForeground(Color.RED);
        generateButton.setFont(new Font("Arial", Font.BOLD, 20));

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                generatedCaptcha = generateCaptcha();
                captchaLabel.setText(generatedCaptcha);

            }

        });
        JPanel panel = new JPanel();
        panel.add(captchaLabel);
        panel.add(captchaTextField);
        panel.add(generateButton);
        add(panel);

    }

    private String generateCaptcha() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefcghijklmnopqrstuvwxyz";
        StringBuilder captcha = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            char c = characters.charAt(random.nextInt(characters.length()));
            captcha.append(c);
        }
        return captcha.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CaptchaProj().setVisible(true);
            }
        });
    }
}