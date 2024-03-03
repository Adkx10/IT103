
package MotorPH;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LogInPage extends JFrame implements ActionListener {
    
    private static JFrame frame;
    private static JPanel panel;
    private static JLabel label,pwLabel,success;
    private static JTextField userText;
    private static JPasswordField pwText;
    private static JButton button;
    
    
    public LogInPage(){
        
        frame = new JFrame();
        panel = new JPanel();
        frame.setTitle("MotorPH");
        frame.setSize(350,200);
        frame.setLocationRelativeTo(null);
        
        
        frame.add(panel);
        
        panel.setLayout(null);
        
        label = new JLabel("User Name:");
        label.setBounds(10,20,80,25);
        panel.add(label);
        
        userText = new JTextField(20);
        userText.setBounds(100,20,165,25);
        panel.add(userText);
        
        pwLabel = new JLabel("Password:");
        pwLabel.setBounds(10,60,80,25);
        panel.add(pwLabel);
        
        pwText = new JPasswordField();
        pwText.setBounds(100,60,165,25);
        panel.add(pwText);
        
        button = new JButton("Login");
        button.setBounds(135,90,80,25);
        button.addActionListener(this);
        panel.add(button);
        
        success = new JLabel("");
        success.setBounds(10,110,300,25);
        panel.add(success);
       
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user = userText.getText();
        String password = pwText.getText();
        
        if(user.equals("admin") && password.equals("MyfirstGUI")){
            success.setText("Login Successful!");
            success.setBounds(125, 110,300,25);
            HomePage home = new HomePage();
            home.setVisible(true);
            frame.dispose();
        } else {
            success.setText("Incorrect Username/Password!");
            success.setBounds(92, 110,300,25);
        }
        
    }
}
