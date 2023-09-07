package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class NewCustomer extends JFrame implements ActionListener {
    
    JTextField textname,textaddress,textstate,textcity,textmail,textphone;
    JButton next,cancel;
    JLabel lblmeter;
    NewCustomer(){
        setSize(700,500);
        setLocation(400,200);
        
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(Color.WHITE);
        add(p);
        
        JLabel heading = new JLabel("New Customer");
        heading.setBounds(0,10,200,20);
        heading.setFont(new Font("Tohoma",Font.PLAIN,26));
        p.add(heading);
        
        JLabel cname = new JLabel("Customer Name");
        cname.setBounds(30,80,100,20);
        p.add(cname);
        
        textname = new JTextField();
        textname.setBounds(150,80,200,20);
        p.add(textname);
        
        JLabel meterno = new JLabel("Meter Number");
        meterno.setBounds(30,120,100,20);
        p.add(meterno);
        
        lblmeter = new JLabel("");
        lblmeter.setBounds(150,120,100,20);
        p.add(lblmeter);
        
        Random ran = new Random();
        long number = ran.nextLong() % 1000000;
        lblmeter.setText("" + Math.abs(number));
        
        JLabel address = new JLabel("Address");
        address.setBounds(30,160,100,20);
        p.add(address);
        
        textaddress = new JTextField();
        textaddress.setBounds(150,160,200,20);
        p.add(textaddress);
        
        JLabel state = new JLabel("State");
        state.setBounds(30,200,100,20);
        p.add(state);
        
        textstate = new JTextField();
        textstate.setBounds(150,200,200,20);
        p.add(textstate);
        
        JLabel city = new JLabel("City");
        city.setBounds(30,240,100,20);
        p.add(city);
        
        textcity = new JTextField();
        textcity.setBounds(150,240,200,20);
        p.add(textcity);
        
        JLabel mail = new JLabel("Mail ID");
        mail.setBounds(30,280,100,20);
        p.add(mail);
        
        textmail = new JTextField();
        textmail.setBounds(150,280,200,20);
        p.add(textmail);
        
        JLabel phone = new JLabel("Phone Number");
        phone.setBounds(30,320,100,20);
        p.add(phone);
        
        textphone = new JTextField();
        textphone.setBounds(150,320,200,20);
        p.add(textphone);
        
        next = new JButton("Next");
        next.setBounds(40,380,100,20);
        next.addActionListener(this);
        p.add(next);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(220,380,100,20);
        cancel.addActionListener(this);
        p.add(cancel);
        
//        setLayout(new BorderLayout());
//        add(p,"Center");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/six.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(300,350,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image,"West");
        
        getContentPane().setBackground(Color.WHITE);
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == next){
            String tname = textname.getText();
            String meter = lblmeter.getText();
            String taddress = textaddress.getText();
            String tstate = textstate.getText();
            String tcity = textcity.getText();
            String tmail = textmail.getText();
            String tphone = textphone.getText();
            
            String query1 = "insert into customer values('"+tname+"', '"+meter+"', '"+taddress+"', '"+tstate+"', '"+tcity+"', '"+tmail+"', '"+tphone+"')";
            String query2 = "insert into login values('"+meter+"', '', '"+tname+"', '', '')";
            
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null,"Customer Details Added Successfully");
                setVisible(false);
                
                new MeterInfo(meter);
                
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
        }
    }
    public static void main(String[] args)
    {
        new NewCustomer();
    }
}

