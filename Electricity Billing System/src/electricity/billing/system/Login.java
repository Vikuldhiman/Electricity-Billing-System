package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
     
    JButton loginB,loginC,signup;
    JTextField textusername,textpassword;
    Choice loggin;
    Login()
    {
        super("Login Page");
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        
        
        JLabel username =  new JLabel("Username");
        username.setBounds(300,20,100,20);
        add(username);
        
        textusername = new JTextField();
        textusername.setBounds(400,20,150,20);
        add(textusername);
        
        JLabel password =  new JLabel("Password");
        password.setBounds(300,60,100,20);
        add(password);
        
        textpassword = new JTextField();
        textpassword.setBounds(400,60,150,20);
        add(textpassword);
        
        JLabel logging =  new JLabel("Loggin in as");
        logging.setBounds(300,100,100,20);
        add(logging);
        
        loggin =new Choice();
        loggin.add("Admin");
        loggin.add("Customer");
        loggin.setBounds(400,100,150,20);
        add(loggin);
        
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        
        loginB = new JButton("Login");
        loginB.setBounds(330,160,100,20);
        loginB.addActionListener(this);
        add(loginB);
        
        loginC = new JButton("Cancel");
        loginC.setBounds(450,160,100,20);
        loginC.addActionListener(this);
        add(loginC);
        
        signup = new JButton("Sign Up");
        signup.setBounds(380,200,100,20);
        signup.addActionListener(this);
        add(signup);
        
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icon/two.jpeg"));
        Image image1 = image.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon image2 = new ImageIcon(image1);
        JLabel image3 = new JLabel(image2);
        image3.setBounds(20,5,250,250);
        add(image3);
        
        setSize(640,300);
        setLocation(400,200);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == loginB)
        {
            String tuser = textusername.getText();
            String tpass = textpassword.getText();
            String user = loggin.getSelectedItem();
            
            try{
                Conn c = new Conn();
                String query = "Select * from login where username = '"+tuser+"' and password = '"+tpass+"' and user = '"+user+"' ";
                
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    String meter = rs.getString("meterno");
                    setVisible(false);
                    new Project(user, meter);
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid Login");
                    textusername.setText("");
                    textpassword.setText("");
                    
                }
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == loginC)
        {
            setVisible(false);
        }
        else if(ae.getSource() == signup)
        {
            setVisible(false);
            new Signup();
        }
    }
    public static void main(String[] args)
    {
        new Login();
    }
}
