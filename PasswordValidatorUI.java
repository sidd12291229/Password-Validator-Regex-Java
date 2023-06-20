import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class PasswordValidatorUI extends JFrame {
    private static final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@!#$%^&+=])(?=.*[!_-])[A-Za-z\\d@#$%^&+=!_-]{8,}$";

    private JTextField passwordField;
    private JLabel resultLabel;

    public PasswordValidatorUI() {
        super("Password Validator");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel inputPanel = new JPanel(new FlowLayout());
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JTextField(15);
        inputPanel.add(passwordLabel);
        inputPanel.add(passwordField);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton validateButton = new JButton("Create");
        validateButton.addActionListener(new ValidateButtonListener());
        buttonPanel.add(validateButton);

        resultLabel = new JLabel();

        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(resultLabel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private boolean isValidPassword(String password) {
        return Pattern.matches(PASSWORD_REGEX, password);
    }

    private class ValidateButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String password = passwordField.getText();

            if (isValidPassword(password)) {
                resultLabel.setText("Password is valid.");
            } else {
                resultLabel.setText("Password is invalid.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                PasswordValidatorUI validatorUI = new PasswordValidatorUI();
                validatorUI.setVisible(true);
            }
        });
    }
}
