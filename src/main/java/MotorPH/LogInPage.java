
package MotorPH;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private String empNo;
    private String passKey;
    
    public void ReadCredentials(String search)throws FileNotFoundException, IOException, CsvValidationException {
        String filename = "Credentials.csv";
        try (CSVReader reader = new CSVReader(new FileReader(filename))) {
            String[] headers = reader.readNext();
            String[] employeeData;
            while((employeeData = reader.readNext()) != null){
                if(employeeData[0].equals(search)){
                    empNo = employeeData[0];
                    passKey = employeeData[2];
                    break;
                }
            }
        } 
    }
    
    
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
        try {
            String user = userText.getText();
            String password = pwText.getText();
            ReadCredentials(user);
            ReadCredentials(password);
            if(user.equals(empNo) && password.equals(passKey)){
                //success.setText("Login Successful!"); //For testing only
                //success.setBounds(125, 120,300,25);
                HomePage home = new HomePage();
                home.setVisible(true);
                frame.dispose();
            } else {
                success.setText("Incorrect Login Credentials");
                success.setBounds(92, 120,300,25);
            }
            
        } catch (IOException | CsvValidationException ex) {
            Logger.getLogger(LogInPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
