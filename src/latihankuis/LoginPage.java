package latihankuis;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;


public class LoginPage extends JFrame implements ActionListener{
    JLabel ljudul = new JLabel("Login Page");
    JLabel lusername = new JLabel("Username:");
    JLabel lpass = new JLabel("Password:");
    
    JTextField usernameTF = new JTextField();
    JPasswordField passTF = new JPasswordField();
    
    JButton tlogin = new JButton("Login");
    
    LoginPage(){
        setTitle("Halaman Login");
        setSize(400, 270);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        
        setLayout(null);
        add(ljudul);
        ljudul.setBounds(10, 10, 80, 20);
        
        add(lusername);
        lusername.setBounds(10, 60, 80, 20);
        
        add(lpass);
        lpass.setBounds(10, 90, 80, 20);
                
        add(usernameTF);
        usernameTF.setBounds(120, 60, 100, 20);
        
        add(passTF);
        passTF.setBounds(120, 90, 100, 20);
        
        add(tlogin);
        tlogin.setBounds(130, 160, 80, 40);
        tlogin.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource() == tlogin){
                String username = usernameTF.getText();
                char[] pass = passTF.getPassword();
                String password = new String(pass);
                
                if(username.equals("123230092") && password.equals("ifkelasg")){
                   JOptionPane.showMessageDialog(this, "Login Sukses");
                   
                   new LandingPage(username);
                   this.dispose();
                }else{
                    JOptionPane.showMessageDialog(this, "Username atau Password Salah");
                }
            }
        }catch(Exception error){
        }
    }
}
