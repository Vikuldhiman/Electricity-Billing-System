package electricity.billing.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;

public class Signup extends JFrame implements ActionListener  {
    
    JButton create,back;
    Choice accType;
    JTextField textMeter,textUser,textPassword,name;
    Signup(){
//        setSize(640,300);
//        setLocation(400,200);

        setBounds(450,150,700,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(30,30,650,300);
        panel.setBorder(new TitledBorder(new LineBorder(Color.WHITE),"Create-Account"));
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        add(panel);
        
        JLabel heading = new JLabel("Create Account as");
        heading.setBounds(50,50,140, 20);
        heading.setForeground(Color.GRAY);
        heading.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(heading);
        
        accType = new Choice();
        accType.add("Admin");
        accType.add("Customer");
        accType.setBounds(200,50,150,20);
        panel.add(accType);
        
//        accType.addFocusListener(l);
        
        JLabel meter = new JLabel("Meter Number");
        meter.setBounds(50,90,140,20);
        meter.setForeground(Color.GRAY);
        meter.setFont(new Font("Tahoma",Font.BOLD,14));
        meter.setVisible(false);
        panel.add(meter);
        
        textMeter = new JTextField();
        textMeter.setBounds(200,90,150,20);
        textMeter.setVisible(false);
        panel.add(textMeter);
       
        
        JLabel user = new JLabel("Username");
        user.setBounds(50,130,140,20);
        user.setForeground(Color.GRAY);
        user.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(user);
        
        textUser = new JTextField();
        textUser.setBounds(200,130,150,20);
        panel.add(textUser);
        
        JLabel lname = new JLabel("Name");
        lname.setBounds(50,170,140,20);
        lname.setForeground(Color.GRAY);
        lname.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(lname);
        
        name = new JTextField();
        name.setBounds(200,170,150,20);
        panel.add(name);
        
         textMeter.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {}
            
            @Override
            public void focusLost(FocusEvent fe) {
                try {
                    Conn c  = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from login where meterno = '"+textMeter.getText()+"'");
                    while(rs.next()) {
                        name.setText(rs.getString("name"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        JLabel password = new JLabel("Password");
        password.setBounds(50,210,140,20);
        password.setForeground(Color.GRAY);
        password.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(password);
        
        textPassword = new JTextField();
        textPassword.setBounds(200,210,150,20);
        panel.add(textPassword);
        
        accType.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ae){
                String user = accType.getSelectedItem();
                if(user.equals("Customer")){
                    meter.setVisible(true);
                    textMeter.setVisible(true);
                    name.setEditable(false);
                } else {
                    meter.setVisible(false);
                    textMeter.setVisible(false);
                    name.setEditable(true);
                }
            }
        });
        
        create = new JButton("Create");
//        create.setBackground(Color.BLACK);
        create.setBounds(60,260,120,25);
        create.addActionListener(this);
        panel.add(create);
        
        back = new JButton("Back");
//        create.setBackground(Color.BLACK);
        back.setBounds(210,260,120,25);
        back.addActionListener(this);
        panel.add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/three.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380,30,250,250);
        panel.add(image);
        
        
        setVisible(true);
    }
    
     public void actionPerformed(ActionEvent ae){
         if(ae.getSource() == create)
         {
             String atype = accType.getSelectedItem();
             String tuser = textUser.getText();
             String tname = name.getText();
             String tpass = textPassword.getText();
             String tmeter = textMeter.getText();
             
             try{
                 Conn c = new Conn();
                 
                 String query = null;
                 if(atype.equals("Admin")){
                        query = "insert into login values('"+tmeter+"', '"+tuser+"', '"+tname+"', '"+tpass+"', '"+atype+"' )";
                 } else {
                     query ="update login set username = '"+tuser+"', password = '"+tpass+"', user = '"+atype+"' where meterno = '"+tmeter+"'  ";
                 }
                         c.s.executeUpdate(query);
                 
                 JOptionPane.showMessageDialog(null,"Account Created Successfully");
                 
                 setVisible(false);
                 new Login();
             }catch(Exception e){
                 e.printStackTrace();
             }
         }
         else if(ae.getSource() == back)
         {
             setVisible(false);
             new Login();
         }
     }
            
    public static void main(String[] args){
        new Signup();
    }
}
 