package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MeterInfo extends JFrame implements ActionListener {
   
    JButton next;
    Choice meterlocation,metertype,phasecode,billtype;
    String meternumber;
    MeterInfo(String meternumber)
    {
        this.meternumber=meternumber;
        
         setSize(700,500);
        setLocation(400,200);
        
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(Color.WHITE);
        add(p);
        
        JLabel heading = new JLabel("Meter Information");
        heading.setBounds(0,10,200,25);
        heading.setFont(new Font("Tohoma",Font.PLAIN,24));
        p.add(heading);
        
        JLabel lblname = new JLabel("Meter Name");
        lblname.setBounds(30,80,100,20);
        p.add(lblname);
        
        JLabel lblmeternumber = new JLabel(meternumber);
        lblmeternumber.setBounds(150,80,150,20);
        p.add(lblmeternumber);
        
        JLabel lblmeterno = new JLabel("Meter Location");
        lblmeterno.setBounds(30,120,100,20);
        p.add(lblmeterno);
        
        meterlocation = new Choice();
        meterlocation.add("Outside");
        meterlocation.add("Inside");
        meterlocation.setBounds(150,120,150,20);
        p.add(meterlocation);
        
        
        JLabel address = new JLabel("Meter Type");
        address.setBounds(30,160,100,20);
        p.add(address);
        
        metertype = new Choice();
        metertype.add("Electric Meter");
        metertype.add("Solar Meter");
        metertype.add("Smart Meter");
        metertype.setBounds(150,160,150,20);
        p.add(metertype);
        
        JLabel state = new JLabel("Phase Code");
        state.setBounds(30,200,100,20);
        p.add(state);
        
        phasecode = new Choice();
        phasecode.add("011");
        phasecode.add("022");
        phasecode.add("033");
        phasecode.add("044");
        phasecode.add("055");
        phasecode.add("066");
        phasecode.add("077");
        phasecode.add("088");
        phasecode.add("099");
        phasecode.setBounds(150,200,150,20);
        p.add(phasecode);
        
        JLabel city = new JLabel("Bill Type");
        city.setBounds(30,240,100,20);
        p.add(city);
        
        billtype = new Choice();
        billtype.add("Normal");
        billtype.add("Industrial");
        billtype.setBounds(150,240,150,20);
        p.add(billtype);
        
        JLabel mail = new JLabel("Days");
        mail.setBounds(30,280,150,20);
        p.add(mail);
       
        JLabel mails = new JLabel("30 Days");
        mails.setBounds(150,280,150,20);
        p.add(mails);
        
        JLabel phone = new JLabel("Note :");
        phone.setBounds(30,320,100,20);
        p.add(phone);
        
        JLabel phones = new JLabel("By Default Bill is Calculated for 30 days only");
        phones.setBounds(70,320,500,20);
        p.add(phones);
        
        next = new JButton("Submit");
        next.setBounds(100,380,100,20);
        next.addActionListener(this);
        p.add(next);
       
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/seven.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(350,460,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image,"West");
        
        getContentPane().setBackground(Color.WHITE);
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == next){
            String meter = meternumber;
            String location = meterlocation.getSelectedItem();
            String type = metertype.getSelectedItem();
            String code = phasecode.getSelectedItem();
            String typebill = billtype.getSelectedItem();
            String days = "30";
            
            
            String query = "insert into meterinfo values('"+meter+"', '"+location+"', '"+type+"', '"+code+"', '"+typebill+"', '"+days+"')";
            
            
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Meter Information Added Successfully");
                setVisible(false);
                

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
        new MeterInfo("");
    }
}


