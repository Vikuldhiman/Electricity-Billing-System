package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Project extends JFrame implements ActionListener{
   String atype,meter;
    Project(String atype, String meter){
        this.atype = atype;
        this.meter = meter;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/four.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(1280,670,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        
        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);
        
        JMenu master = new JMenu("Master");
        master.setForeground(Color.BLUE);
        
        
        JMenuItem newcustomer = new JMenuItem("New Customer");
        newcustomer.setFont(new Font("monospaced",Font.PLAIN,12));
        newcustomer.setBackground(Color.WHITE);
        newcustomer.addActionListener(this);
        master.add(newcustomer);
        
        JMenuItem customerdetails = new JMenuItem("Customer Details");
        customerdetails.setFont(new Font("monospaced",Font.PLAIN,12));
        customerdetails.setBackground(Color.WHITE);
        customerdetails.addActionListener(this);
        master.add(customerdetails);
        
        JMenuItem depositdetails = new JMenuItem("Deposite Details");
        depositdetails.setFont(new Font("monospaced",Font.PLAIN,12));
        depositdetails.setBackground(Color.WHITE);
        depositdetails.addActionListener(this);
        master.add(depositdetails);
        
        JMenuItem calculatebill = new JMenuItem("Calculate Bill");
        calculatebill.setFont(new Font("monospaced",Font.PLAIN,12));
        calculatebill.setBackground(Color.WHITE);
        calculatebill.addActionListener(this);
        master.add(calculatebill);
        
        JMenu information = new JMenu("Information");
        information.setForeground(Color.BLUE);
        
        
        JMenuItem updateinfo = new JMenuItem("Update Information");
        updateinfo.setFont(new Font("monospaced",Font.PLAIN,12));
        updateinfo.setBackground(Color.WHITE);
        updateinfo.addActionListener(this);
        information.add(updateinfo);
        
        JMenuItem viewinfo = new JMenuItem("View Information");
        viewinfo.setFont(new Font("monospaced",Font.PLAIN,12));
        viewinfo.setBackground(Color.WHITE);
        viewinfo.addActionListener(this);
        information.add(viewinfo);
        
        
        JMenu user = new JMenu("User");
        user.setForeground(Color.BLUE);
        
        
        JMenuItem paybill = new JMenuItem("Pay Bill");
        paybill.setFont(new Font("monospaced",Font.PLAIN,12));
        paybill.setBackground(Color.WHITE);
        paybill.addActionListener(this);
        user.add(paybill);
        
        JMenuItem billdetails = new JMenuItem("Bill Details");
        billdetails.setFont(new Font("monospaced",Font.PLAIN,12));
        billdetails.setBackground(Color.WHITE);
        billdetails.addActionListener(this);
        user.add(billdetails);
        
        JMenu report = new JMenu("Report");
        report.setForeground(Color.BLUE);
        
        
        JMenuItem generatebill = new JMenuItem("Generate Bill");
        generatebill.setFont(new Font("monospaced",Font.PLAIN,12));
        generatebill.setBackground(Color.WHITE);
        generatebill.addActionListener(this);
        report.add(generatebill);
        
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.BLUE);
        
        
        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setFont(new Font("monospaced",Font.PLAIN,12));
        notepad.setBackground(Color.WHITE);
        notepad.addActionListener(this);
        utility.add(notepad);
        
        JMenuItem calculator = new JMenuItem("Calculator");
        calculator.setFont(new Font("monospaced",Font.PLAIN,12));
        calculator.setBackground(Color.WHITE);
        calculator.addActionListener(this);
        utility.add(calculator);
        
        JMenu mexit = new JMenu("Exit");
        mexit.setForeground(Color.BLUE);
        JMenuItem exit = new JMenuItem("Exit");
        exit.setFont(new Font("monospaced",Font.PLAIN,12));
        exit.setBackground(Color.WHITE);
        exit.addActionListener(this);
        mexit.add(exit);
        
        
        if(atype.equals("Admin")){
            mb.add(master);
        }
        else{
            mb.add(information);
            mb.add(user);
            mb.add(report);
            
        }
       
        mb.add(mexit);
        mb.add(utility);
        
        
        setLayout(new FlowLayout());
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();
        if(msg.equals("New Customer")){
            new NewCustomer();
        }else if(msg.equals("Customer Details")){
            new CustomerDetails();
        }else if(msg.equals("Deposite Details")){
            new DepositDetails();
        }else if(msg.equals("Calculate Bill")){
            new CalculateBill();
        } else if(msg.equals("View Information")){
            new ViewInformation(meter);
        }else if(msg.equals("Update Information")){
            new UpdateInformation(meter);
        }else if(msg.equals("Bill Details")){
            new BillDetails(meter);
        }
        else if(msg.equals("Notepad")){
            try{
                Runtime.getRuntime().exec("nodepad.exe");
            }catch(Exception e){
                e.printStackTrace();
            }
        } else if(msg.equals("Calculator")){
            try{
                Runtime.getRuntime().exec("calc.exe");
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(msg.equals("Exit")){
            setVisible(false);
            new Login();
        }else if(msg.equals("Pay Bill"))
        {
            new PayBill(meter);
        }else if(msg.equals("Generate Bill")){
            new GenerateBill(meter);
        }
    }
    public static void main(String[] args)
    {
        new Project("","");
    }
}
