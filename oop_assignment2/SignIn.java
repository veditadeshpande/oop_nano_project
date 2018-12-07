package oop_assignment2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignIn extends JFrame implements ActionListener{

    JLabel e,p,s ,img; JTextField email=null,password=null ; JOptionPane errorFrame ; 
    JTextField emailField ; JButton submit ; ResultSet rs = null; JPasswordField passwordField;
    JPanel pv; ArrayList<String> m  = new ArrayList<>();
    ArrayList<String> emails  = new ArrayList<>();
     ArrayList<String> passwords  = new ArrayList<>();
     ArrayList<String> contacts  = new ArrayList<>();
     ArrayList<String> names  = new ArrayList();
    ArrayList<Double> costs  = new ArrayList();
    ArrayList<String> seats  = new ArrayList();
     ArrayList<String> zones  = new ArrayList();
    public SignIn(){
              // fixed for all frames -------------------------------------------
        this.setVisible(true);this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(700,500);this.setLocationRelativeTo(null);
        this.setTitle("Login Page");  this.setLayout(new BorderLayout());
        this.setResizable(false);
     //-----------------------------------------------------------
        s = new JLabel("SIGN IN");s.setFont(new Font("Sans Serif",Font.BOLD,40)); s.setHorizontalAlignment(JLabel.CENTER);
        this.add(s,BorderLayout.PAGE_START);
        
       /* pv=new JPanel();
        pv.setLayout(null);
        e = new JLabel("Email") ;e.setFont(new Font("Times New Roman",Font.BOLD,32));e.setBounds(150,50,250,30);pv.add(e); 
        emailField = new JTextField();emailField.setBounds(300,50,250,30);
         pv.add(emailField);
        p = new JLabel("Password");p.setBounds(150,100,150,30);
        p.setFont(new Font("Times New Roman",Font.BOLD,28));pv.add(p);
        passwordField = new JPasswordField() ;
        passwordField.setBounds(300,100,250,30); pv.add(passwordField);
        
    pv.setBackground(Color.orange);
        this.add(pv); 
      */        
        
    
    //-------------------------------------------------------------
    
    
    ImageIcon i= new ImageIcon("C:\\Users\\HP\\Desktop\\p2.png");
        img=new JLabel("",i,JLabel.CENTER);
        img.setBounds(0,0,700,500);
        
    // -----------------------------------------------------------
        s = new JLabel("SIGN IN");s.setFont(new Font("Sans Serif",Font.BOLD,40)); s.setHorizontalAlignment(JLabel.CENTER);
        this.add(s,BorderLayout.PAGE_START);
        
        pv=new JPanel();
        pv.setLayout(null);
        pv.add(img);pv.setBounds(0,0,700,500);
        e = new JLabel("Email") ;e.setFont(new Font("Times New Roman",Font.BOLD,32));
        e.setBounds(120,60,250,30);
        img.add(e); 
        emailField = new JTextField();emailField.setBounds(300,50,250,30);
         pv.add(emailField);
        p = new JLabel("Password");p.setBounds(120,110,150,30);
        p.setFont(new Font("Times New Roman",Font.BOLD,32));img.add(p);
        passwordField = new JPasswordField() ;
        passwordField.setBounds(300,100,250,30); pv.add(passwordField);
        
    //pv.setBackground(Color.orange);
        
        
    submit = new JButton("Submit") ;submit.addActionListener(this);
        this.add(submit,BorderLayout.PAGE_END);//submit.setBounds(350,300,150,30);
    
    
   this.add(pv); 
      
        
    }

    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        
        String e1 = emailField.getText() ;  String p1 = passwordField.getText();
        e1.trim(); p1.trim();
        
       
          set();
          int found =0; 
         System.out.println("Emails are----------");
        for(String t : emails){
            System.out.println(t);
        }
           System.out.println("Passwords are----------");
          for(String t : passwords){
            System.out.println(t);
        }
          
          int h=0  ; 
          
        for(int i =0 ;i<emails.size(); i++){
            
        System.out.println("Comparing "+emails.get(i) +" with "+ e1+ " and "+ passwords.get(i) +" with "+p1);
            if((emails.get(i).equals(e1))  && (passwords.get(i).equals(p1))){
                found=1 ; h = i ; 
            }
            
        }
          
          if(found==1){
             
              User r = new User();
              r.name = names.get(h) ; r.email = emails.get(h);
              r.pno = contacts.get(h) ; r.zone = zones.get(h) ; 
              r.k = seats.get(h); r.cost = costs.get(h) ;
              r.match_name = m.get(h);
          FinalWindow f5 = new FinalWindow(r);
              
              this.dispose();
          }
          else{
             JOptionPane.showMessageDialog(this, "Incorrect password or email entered "); 
          }
          
           
    }
    
    public void set(){
        
         // connect to the database
     Connection conn = null ;Statement s = null ;ResultSet rs1=null ;
    
        try {
      conn = DriverManager.getConnection("jdbc:derby://localhost:1527/test", "oop", "oop");
       s= conn.createStatement();
      String q = "select * from INFO" ;
       rs1 = s.executeQuery(q) ; 
             
             
             while(rs1.next()){
                 this.emails.add(rs1.getString("EMAIL")) ;
                 this.passwords.add(rs1.getString("PASSWORD")) ; 
                 this.names.add(rs1.getString("NAME"));
                 this.contacts.add(rs1.getString("CONTACT"));
                 // write function for match name ------------------- and seats
                 this.zones.add(rs1.getString("zone")) ; 
                 this.costs.add(rs1.getDouble("cost"));
                 this.seats.add(rs1.getString("seat")) ; 
                 this.m.add(rs1.getString("zone"));
                 
             }
             
             
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally{
            try{
                
                if(s!=null)
                    s.close();
            if(conn!=null)
                    conn.close();
            } catch (SQLException ex) {
                System.out.println("Exception occured while releasing resources");
            }
        
        
    }
   
}
}

