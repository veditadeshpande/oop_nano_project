package oop_assignment2;

import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Color.DARK_GRAY;
import static java.awt.Color.GREEN;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Match3 extends JFrame implements ActionListener
{
    JButton[] a= new JButton[5];JButton[] b= new JButton[5];
        JButton[] cc= new JButton[5];JButton[] d= new JButton[5];
        JButton submit,print; 
        JButton a1,a2,a3,a4,a5,b1,b2,b3,b4,b5,c1,c2,c3,c4,c5,d1,d2,d3,d4,d5;
        JPanel seat, info, avail, arr;
        JLabel title,name,email,pno,seats,match,date,time;
        JComboBox zone;
        JButton availb,yourb,reservedb;
        String z[]={"EAST","WEST","NORTH","SOUTH"};
  public  Match3()
  {
      // fixed for all frames -------------------------------------------
       this.setVisible(true);
       this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       this.setSize(700,500);
       this.setLocationRelativeTo(null);
       this.setTitle("Login Page"); 
       this.setResizable(true);
       
        this.setLayout(new BorderLayout());
        submit = new JButton("SUBMIT");
        seat = new JPanel();
        info = new JPanel(); 
        title = new JLabel("BOOK YOUR TICKETS-MATCH 1");
        this.add(info,BorderLayout.LINE_END);
        this.add(seat,BorderLayout.CENTER);
        this.add(title,BorderLayout.PAGE_START);
        this.add(submit,BorderLayout.PAGE_END); 
    // -----------------------------------------------------------
    // seat layout
        seat.setLayout(new BorderLayout()); 
        availb = new JButton("Available"); yourb = new JButton ("Selected"); reservedb = new JButton("Reserved");//the three buttons
        availb.setBackground(Color.LIGHT_GRAY); yourb.setBackground(Color.green); reservedb.setBackground(Color.DARK_GRAY);
        zone = new JComboBox(z);
        //seat.add(zone,BorderLayout.PAGE_START);
        
        avail= new JPanel();
        avail.setBounds(50, 50, 50, 50);
        avail.add(availb); avail.add(yourb); avail.add(reservedb);
        seat.add(avail,BorderLayout.PAGE_END);
        arr = new JPanel();
        arr.setLayout(new GridLayout(4,0,4,4));
        seat.add(arr,BorderLayout.CENTER);
        
        a1=new JButton("A1"); a2=new JButton("A2");a3=new JButton("A3");a4=new JButton("A4");a5=new JButton("A5");
        b1=new JButton("B1"); b2=new JButton("B2");b3=new JButton("B3");b4=new JButton("B4");b5=new JButton("B5");
        c1=new JButton("C1");c2=new JButton("C2");c3=new JButton("C3");c4=new JButton("C4");c5=new JButton("C5");
        d1=new JButton("D1");d2=new JButton("D2");d3=new JButton("D3");d4=new JButton("D4");d5=new JButton("D5");
        a1.addActionListener(this);a2.addActionListener(this);a3.addActionListener(this);a4.addActionListener(this);a5.addActionListener(this);
        b1.addActionListener(this);b2.addActionListener(this);b3.addActionListener(this);b4.addActionListener(this);b5.addActionListener(this);
        c1.addActionListener(this);c2.addActionListener(this);c3.addActionListener(this);c4.addActionListener(this);c5.addActionListener(this);
        d1.addActionListener(this);d2.addActionListener(this);d3.addActionListener(this);d4.addActionListener(this);d5.addActionListener(this);
        arr.add(a1);arr.add(a2);arr.add(a3);arr.add(a4);arr.add(a5);arr.add(b1);arr.add(b2);arr.add(b3);arr.add(b4);arr.add(b5);
        arr.add(c1);arr.add(c2);arr.add(c3);arr.add(c4);arr.add(c5);arr.add(d1);arr.add(d2);arr.add(d3);arr.add(d4);arr.add(d5);
//        match=new JLabel("Match:KKR vs DD"); date= new JLabel("8th April 2018"); time= new JLabel("8:00PM IST");
//        name = new JLabel("Name:");email=new JLabel("Email:");pno=new JLabel("Phone No.:");seats=new JLabel("Seats"); print= new JButton("PRINT");
//        info.setLayout(new BoxLayout(info,BoxLayout.Y_AXIS));
//        name.setBounds(100,100,100,100);email.setBounds(100,100,100,100);pno.setBounds(100,100,100,100);seats.setBounds(100,100,100,100);
//        print.setBounds(100,100,100,100);match.setBounds(100,100,100,100);
//        info.add(name);info.add(email);info.add(pno);info.add(seats);info.add(match);info.add(date);info.add(time);info.add(print);
        submit.addActionListener(this);
//        print.addActionListener(this);
   switch(Test.u.zone){
            case "EAST" :  this.set(0); break ;
            case "WEST" :  this.set(1); break ;
            case "NORTH" :  this.set(2); break ;
            case "SOUTH" :  this.set(3); break ;
            
        }
        
        
        
             a[0]=a1 ; a[1]=a2; a[2]=a3 ; a[3]=a4 ; a[4]=a5 ; 
         b[0]=b1 ; b[1]=b2; b[2]=b3 ; b[3]=b4 ; b[4]= b5 ; 
          cc[0]=c1 ; cc[1]=c2; cc[2]=c3 ; cc[3]=c4 ;cc[4]=c5 ; 
         d[0]=d1 ; d[1]=d2; d[2]=d3 ; d[3]=d4 ; d[4] = d5 ; 
        
  }
    
    
   @Override
    public void actionPerformed(ActionEvent e) 
    {
   Color c = GREEN;  Color g = DARK_GRAY ; 
    
       
        if(e.getSource()==a1 && a1.getBackground() != g)
        {    
            if(c!=a1.getBackground())
                a1.setBackground(Color.GREEN);
            else
                a1.setBackground(null);
        }    
        if(e.getSource()==a2 && a2.getBackground() != g)
        {    
            if(c!=a2.getBackground())
                a2.setBackground(Color.GREEN);
            else
                a2.setBackground(null);
        }    
        if(e.getSource()==a3 && a3.getBackground() != g)
        {    
           if(c!=a3.getBackground())
                a3.setBackground(Color.GREEN);
            else
                a3.setBackground(null);
        }    
        if(e.getSource()==a4 && a4.getBackground() != g)
        {    
            if(c!=a4.getBackground())
                a4.setBackground(Color.GREEN);
            else
                a4.setBackground(null);
        }
        if(e.getSource()==a5 && a5.getBackground() != g)
        {
            if(c!=a5.getBackground())
                a5.setBackground(Color.GREEN);
            else
                a5.setBackground(null);
        }
        if(e.getSource()==b1 && b1.getBackground() != g)
        {
            if(c!=b1.getBackground())
                b1.setBackground(Color.GREEN);
            else
                b1.setBackground(null);
        }
        if(e.getSource()==b2 && b2.getBackground() != g)
        {
            if(c!=b2.getBackground())
                b2.setBackground(Color.GREEN);
            else
                b2.setBackground(null);
        }
        if(e.getSource()==b3 && b3.getBackground() != g)
        {
            if(c!=b3.getBackground())
                b3.setBackground(Color.GREEN);
            else
                b3.setBackground(null);
        }
        if(e.getSource()==b4 && b4.getBackground() != g)
        {
            if(c!=b4.getBackground())
                b4.setBackground(Color.GREEN);
            else
                b4.setBackground(null);
        }
        if(e.getSource()==b5 && b5.getBackground() != g)
        {
            if(c!=b5.getBackground())
                b5.setBackground(Color.GREEN);
            else
                b5.setBackground(null);
        }
        if(e.getSource()==c1 && c1.getBackground() != g)
        {    
            if(c!=c1.getBackground())
                c1.setBackground(Color.GREEN);
            else
                c1.setBackground(null);
        }    
        if(e.getSource()==c2 && c2.getBackground() != g)
        {    
            if(c!=c2.getBackground())
                c2.setBackground(Color.GREEN);
            else
                c2.setBackground(null);
        }    
        if(e.getSource()==c3 && c3.getBackground() != g)
        {    
           if(c!=c3.getBackground())
                c3.setBackground(Color.GREEN);
            else
                c3.setBackground(null);
        }    
        if(e.getSource()==c4 && c4.getBackground() != g)
        {    
            if(c!=c4.getBackground())
                c4.setBackground(Color.GREEN);
            else
                c4.setBackground(null);
        }
        if(e.getSource()==c5 && c5.getBackground() != g)
        {
            if(c!=c5.getBackground())
                c5.setBackground(Color.GREEN);
            else
                c5.setBackground(null);
        }
        if(e.getSource()==d1 && d1.getBackground() != g)
        {
            if(c!=d1.getBackground())
                d1.setBackground(Color.GREEN);
            else
                d1.setBackground(null);
        }
        if(e.getSource()==d2 && d2.getBackground() != g)
        {
            if(c!=d2.getBackground())
                d2.setBackground(Color.GREEN);
            else
                d2.setBackground(null);
        }
        if(e.getSource()==d3 && d3.getBackground() != g)
        {
            if(c!=d3.getBackground())
                d3.setBackground(Color.GREEN);
            else
                d3.setBackground(null);
        }
        if(e.getSource()==d4 && d4.getBackground() != g)
        {
            if(c!=d4.getBackground())
                d4.setBackground(Color.GREEN);
            else
                d4.setBackground(null);
        }
        if(e.getSource()==d5 && d5.getBackground() != g)
        {
            if(c!=d5.getBackground())
                d5.setBackground(Color.GREEN);
            else
                d5.setBackground(null);
        }
        
        
                   if(e.getSource()== submit){
                              int zone_index = zone.getSelectedIndex();
             
             switch(zone_index){
                 case 0 : Test.u.zone ="EAST" ; break ; 
                  case 1 : Test.u.zone ="WEST" ; break ;
                   case 2 : Test.u.zone ="NORTH" ; break ;
                    case 3 : Test.u.zone ="SOUTH" ; break ;
             }
             
              
       
        for(int i=0 ; i<=4 ; i++){
            
            if(a[i].getBackground() == Color.GREEN){
                Seat temp = new Seat("a",i+1);
                Test.u.addToSeats(temp);
        
            }
            if(b[i].getBackground() == Color.GREEN){
                 Seat temp = new Seat("b",i+1);
                Test.u.addToSeats(temp);
        
            }
            if(cc[i].getBackground() == Color.GREEN){
                 Seat temp = new Seat("c",i+1);
                Test.u.addToSeats(temp);
        
            }
            if(d[i].getBackground() == Color.GREEN){
                 Seat temp = new Seat("d",i+1);
                Test.u.addToSeats(temp);
                
                
                
        
                
        
            }
        }  
        
                  // adding to the database   
          Test.u.addToDatabase();
        // final frame function
        FinalWindow f5 = new FinalWindow(Test.u);
        
        
         this.dispose(); 
        
                
        
}
  
        
//        this.setEnabled(false);
         

           //this.dispose();
    }
  
 public void set(int zone_index){
        
        // set the seats 
        
        Connection c = null ; Statement s = null ;ResultSet rs = null ; 
        
        try{
            c = DriverManager.getConnection("jdbc:derby://localhost:1527/test", "oop", "oop") ;
            s= c.createStatement();
        rs=    s.executeQuery("select * from match3 ");
        
        while(rs.next()){
         // change the color if required
         
         
  switch(zone_index){
      
      case 0 : // east
          String seatString_E = rs.getString("EAST") ;  
          if(seatString_E != null){
          process(seatString_E);  }break ;
      
       case 1 : // west
          String seatString_W = rs.getString("WEST") ;  
          if(seatString_W != null){
          process(seatString_W);  }break ;
      
       case 2 : // north
          String seatString_N = rs.getString("NORTH") ; 
          if(seatString_N != null){
          process(seatString_N);   }break ;
      
       case 3 : // south
          String seatString_S = rs.getString("SOUTH") ;  
          if(seatString_S != null){
          process(seatString_S);  }break ;
      
      
      
  }
             
             
             
             
             
         }
         
         
            
        }
       catch (SQLException ex) {
       ex.printStackTrace();
    }
        
        
        
        
        
    }
    
    public void process(String k){
        
        if(k.charAt(0)=='a'){
            
            switch(k.charAt(2)){
                
                
                case '1' : a1.setBackground(Color.DARK_GRAY); break ; 
                case '2' : a2.setBackground(Color.DARK_GRAY); break ; 
                case '3' : a3.setBackground(Color.DARK_GRAY); break ; 
                case '4' : a4.setBackground(Color.DARK_GRAY); break ; 
                case '5' : a5.setBackground(Color.DARK_GRAY); break ; 
                
            }
            
            
            
        }
        
        if(k.charAt(0)=='b'){
            
            switch(k.charAt(2)){
                
                
                case '1' :  b1.setBackground(Color.DARK_GRAY); break ; 
                case '2' :  b2.setBackground(Color.DARK_GRAY); break ; 
                case '3' :  b3.setBackground(Color.DARK_GRAY); break ; 
                case '4' :  b4.setBackground(Color.DARK_GRAY); break ; 
                case '5' :  b5.setBackground(Color.DARK_GRAY); break ; 
                
            }
            
            
            
            
        }
        if(k.charAt(0)=='c'){
            
            switch(k.charAt(2)){
                
                
                case '1' : c1.setBackground(Color.DARK_GRAY); break ; 
                case '2' : c2.setBackground(Color.DARK_GRAY); break ; 
                case '3' : c3.setBackground(Color.DARK_GRAY); break ; 
                case '4' : c4.setBackground(Color.DARK_GRAY); break ; 
                case '5' : c5.setBackground(Color.DARK_GRAY); break ; 
                
            }
            
            
            
        }
       if(k.charAt(0)=='d'){
           
           switch(k.charAt(2)){
                
                
                case '1' : d1.setBackground(Color.DARK_GRAY); break ; 
                case '2' : d2.setBackground(Color.DARK_GRAY); break ; 
                case '3' : d3.setBackground(Color.DARK_GRAY); break ; 
                case '4' : d4.setBackground(Color.DARK_GRAY); break ; 
                case '5' : d5.setBackground(Color.DARK_GRAY); break ; 
                
            }
           
       }
        
        
        
        
        
    }
      }
  



