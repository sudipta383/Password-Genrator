import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class PasswordGenerator {
    private JFrame frame;
    private JPanel panel;
    private JLabel label;
    private JCheckBox lowercaseBox;
    private JCheckBox uppercaseBox;
    private JCheckBox specialCharsBox;
    private JCheckBox digitsBox;
    private JTextField lengthField;
    private JButton generateButton;
    private JTextArea passwordField;

    public PasswordGenerator() {
        
        frame = new JFrame("Password Generator");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setLayout(null);
        label = new JLabel("Password Options:");
        label.setBounds(20, 20, 120, 20);
        panel.add(label);
        lowercaseBox = new JCheckBox("Lowercase letters");
        lowercaseBox.setBounds(20, 50, 150, 20);
        panel.add(lowercaseBox);
        uppercaseBox = new JCheckBox("Uppercase letters");
        uppercaseBox.setBounds(20, 80, 150, 20);
        panel.add(uppercaseBox);
        specialCharsBox = new JCheckBox("Special characters");
        specialCharsBox.setBounds(20, 110, 150, 20);
        panel.add(specialCharsBox);
        digitsBox = new JCheckBox("Digits");
        digitsBox.setBounds(20, 140, 150, 20);
        panel.add(digitsBox);
        lengthField = new JTextField();
        lengthField.setBounds(20, 180, 50, 20);
        panel.add(lengthField);
        generateButton = new JButton("Generate");
        generateButton.setBounds(80, 180, 100, 20);
        panel.add(generateButton);

        passwordField = new JTextArea();
        passwordField.setBounds(20, 210, 250, 50);
        passwordField.setEditable(false);
        panel.add(passwordField);
        
        generateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String characters = "";
                if (lowercaseBox.isSelected()) {
                    characters += "abcdefghijklmnopqrstuvwxyz";
                }
                if (uppercaseBox.isSelected()) {
                    characters += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                }
                if (specialCharsBox.isSelected()) {
                    characters += "!@#$%^&*()";
                }
                if (digitsBox.isSelected()) {
                characters += "0123456789";
                }
                            
                            int length = Integer.parseInt(lengthField.getText());

            
            String password = generatePassword(characters, length);

            
            passwordField.setText(password);
        }
    });

    
    frame.add(panel);

    
    frame.setVisible(true);
}

private String generatePassword(String characters, int length) {
    Random rng = new Random();
    char[] text = new char[length];
    for (int i = 0; i < length; i++) {
        text[i] = characters.charAt(rng.nextInt(characters.length()));
    }
    return new String(text);
}

public static void main(String[] args) {
    new PasswordGenerator();
}
}
                
