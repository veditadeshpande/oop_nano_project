
package oop_assignment2;
import java.awt.FlowLayout ; 
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;


public class SelectZone extends JFrame implements ActionListener{
    JButton north,south,east,west ;
    
    public SelectZone(){
        
        
                // fixed for all frames -------------------------------------------
       this.setVisible(true);this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setSize(700,500);this.setLocationRelativeTo(null);
    this.setTitle("Select Zone");  
    this.setResizable(true);
    // -----------------------------------------------------------
    this.setLayout(new GridLayout(2,2,50,100));
    north = new JButton("North");north.setFont(new Font("Times New Roman",Font.BOLD,32)); north.addActionListener(this);
    south = new JButton("South");south.setFont(new Font("Times New Roman",Font.BOLD,32));south.addActionListener(this);
    east = new JButton("East");east.setFont(new Font("Times New Roman",Font.BOLD,32));east.addActionListener(this);
    west = new JButton("West") ;west.setFont(new Font("Times New Roman",Font.BOLD,32));west.addActionListener(this);
    
    this.add(east) ; this.add(west); this.add(north); this.add(south);
    
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {


if(e.getSource() == north){
    Test.u.zone = "NORTH" ; 
}
if(e.getSource() == south){
  Test.u.zone = "SOUTH" ; 
}
if(e.getSource() == east){
  Test.u.zone = "EAST" ; 
}
if(e.getSource()== west) {
Test.u.zone = "WEST";   
}



switch(Test.u.match_name){
    case "Match:MI vs CSK" : SeatsForMatch1 t4 = new SeatsForMatch1();   break ;
    case "Match:RCB vs KXIP" : Match2 t5 = new Match2(); break ;
    case "Match:KKR vs DD" :  Match3 t6 = new Match3(); break ;
    
    
    
}




this.dispose();


    }
  
    
    
}
