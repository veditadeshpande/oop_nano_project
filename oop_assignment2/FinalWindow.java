    
package oop_assignment2;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class FinalWindow extends JFrame implements ActionListener{
    User u ; JPanel p ; JLabel n ,e,c,seats,match_name,cost; JButton back ; 
    
    public FinalWindow(){
           
    }
    
    public FinalWindow(User u){
        this.u = u ; 
         // fixed for all frames -------------------------------------------
       this.setVisible(true);this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setSize(700,500);this.setLocationRelativeTo(null);
    this.setTitle("Details");  this.setLayout(new BorderLayout());
    this.setResizable(true);
    // -----------------------------------------------------------
    
    
        p= new JPanel(); 
        
        n= new JLabel("Name : "+u.name);
        
        e= new JLabel("Email : "+u.email);
        
        c= new JLabel("Contact : "+u.pno);
        cost = new JLabel("Cost :"+ u.cost) ;
        seats = new JLabel(); String m="Seats :"; 
        
        for(Seat temp : u.seats){
          m = m + " | "+temp.getSeat() ;
            
        }
       
        if(m== "Seats :"){
        m= u.k ; }
        seats.setText(m);
        match_name = new JLabel(u.match_name);
        p.setLayout(new GridLayout(5,0,50,50));
        p.setBackground(Color.orange);
        n.setFont(new Font("Sans Serif",Font.BOLD,28));
        e.setFont(new Font("Sans Serif",Font.BOLD,28));
        c.setFont(new Font("Sans Serif",Font.BOLD,28));
        match_name.setFont(new Font("Sans Serif",Font.BOLD,28));
        seats.setFont(new Font("Sans Serif",Font.BOLD,28));
        p.add(n);
        p.add(e); p.add(c); p.add(seats); p.add(match_name);
        cost.setFont(new Font("Sans Serif",Font.BOLD,28));
        p.add(cost);
        this.add (p);
        
        back = new JButton("Back") ; 
        back.setFont(new Font("Sans Serif",Font.BOLD,32));
        this.add(back,BorderLayout.PAGE_END)  ; 
   back.addActionListener(this);
        
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    if(e.getSource() == back){
        
        FirstFrame p = new FirstFrame();
        this.dispose();
        
    }





    }
    
    
    
    
}
