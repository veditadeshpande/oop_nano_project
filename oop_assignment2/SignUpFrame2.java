package oop_assignment2;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import static java.awt.Image.SCALE_DEFAULT;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignUpFrame2 extends JFrame implements ActionListener{

    JTextField name ,pno,email ; JLabel n,no,pw,e ;  JPasswordField password;
     
    JLabel start,img ; JButton submit ; JPanel p ; 
    public SignUpFrame2(){
        // layout changes required 
         this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setSize(700,500);this.setLocationRelativeTo(null);
    this.setTitle("Information Page") ;  
    this.setLayout(new BorderLayout());
    
    this.setResizable(false);
        
        start = new JLabel(" Please enter the required information");
        start.setHorizontalAlignment(JLabel.CENTER);
    start.setVerticalAlignment(JLabel.CENTER);
    start.setFont(new Font("Times New Roman",Font.ITALIC,24));
        this.add(start,BorderLayout.PAGE_START);
        p = new JPanel();
        p.setLayout(null) ;
       /* ImageIcon i= new ImageIcon("C:\\Program Files\\NetBeans 8.2\\stadium.jpg");
        img=new JLabel("",i,JLabel.CENTER);
        img.setBounds(0,0,700,500);p.add(img);*/
       ImageIcon i= new ImageIcon("C:\\Users\\HP\\Desktop\\p2.png");
        img=new JLabel("",i,JLabel.CENTER);
        img.setBounds(0,0,700,500);
        p.add(img);
        
        n = new JLabel("Name"); n.setBounds(150,50,250,30); img.add(n);
        
        name = new JTextField("");name.setBounds(350,50,250,30); p.add(name);
        n.setFont(new Font("Times New Roman",Font.ITALIC,24));
        no = new JLabel("Contact Number") ;no.setBounds(150,100,250,30); img.add(no);
        pno =new JTextField(""); pno.setBounds(350,100,250,30); p.add(pno);
        no.setFont(new Font("Times New Roman",Font.ITALIC,24));
        e = new JLabel("Email") ;e.setBounds(150,150,250,30); img.add(e);
        email =new JTextField("");email.setBounds(350,150,250,30);p.add(email);
        e.setFont(new Font("Times New Roman",Font.ITALIC,24));
        pw = new JLabel("Password");pw.setBounds(150,200,250,30);img.add(pw) ;
       password =new JPasswordField("");password.setBounds(350,200,250,30);p.add(password);
        pw.setFont(new Font("Times New Roman",Font.ITALIC,24));        

       
       this.add(p,BorderLayout.CENTER) ;
        submit = new JButton("Submit") ;
        this.add(submit,BorderLayout.PAGE_END); submit.addActionListener(this);
        
//        name.requestFocusInWindow();
        
        this.setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==submit){
          // create new user   
           if(validateEmail(email.getText()) && validateName(name.getText()) && validateContact(pno.getText())){
          Test.u.setEmail(email.getText());
            Test.u.setName(name.getText());
            Test.u.setContact(pno.getText());
            Test.u.setPassword(password.getText()); 
      //      Test.u.addToDatabase();
//            this.setEnabled(false);






            this.dispose();
            SignUpFrame3_sel frame3 = new  SignUpFrame3_sel(); }
           
           else{
               // nothing 
           }
            
            
        }  
        
    }
    
    
    public boolean validateEmail(String n){
        if(n== null)
            return false ; 
            
            
        Connection c = null ; ResultSet rs ; int found = 0 ; 
        Statement s = null ; String temp ; 
        
        try{
            c = DriverManager.getConnection("jdbc:derby://localhost:1527/test", "oop", "oop") ;
            s=c.createStatement();
            rs = s.executeQuery("select * from info") ;
            while(rs.next()){
                
               temp = rs.getString("email");
                if(n.equals(temp))
                found = 1; 
                
            }
            
            
            
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        finally{
            if(c !=null){
                try {
                    c.close(); s.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SignUpFrame2.class.getName()).log(Level.SEVERE, null, ex);
                }
}
            
            
        }
        
        if(found == 0)
            return true ;
        else{
              
             JOptionPane.showMessageDialog(this, "email already exists "); return false ;    
        }
        
        
    }
    
    public boolean validateName(String n ){
        if(n== null)
            return false ;
        if(n.contains("!") || n.contains("*")||n.contains("@")  ||n.contains("#")  ||n.contains("&")            ){
      JOptionPane.showMessageDialog(this, "Incorrect name ");   return false;  }
        
        else
            return true ; 
        
        
    }
    
    public boolean validateContact(String n){
        
       if( Pattern.matches("[0-9]+", n))
           return true ;
       else{
         JOptionPane.showMessageDialog(this, "Incorrect contact ");   return false ;   }
    }
   
    
    
}