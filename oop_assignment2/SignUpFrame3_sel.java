package oop_assignment2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.paint.Color;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class SignUpFrame3_sel extends JFrame implements ActionListener{

    JLabel start,m1,m2,m3 ; JRadioButton b1,b2,b3 ; JButton submit ;  ButtonGroup g; ImageIcon ic1,ic2,ic3;
    JPanel pv1;
    public SignUpFrame3_sel(){
               // fixed for all frames -------------------------------------------
       this.setVisible(true);this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setSize(700,500);this.setLocationRelativeTo(null);
    this.setTitle("match Page"); 
    this.setResizable(false);
    // -----------------------------------------------------------
    
        this.setLayout(new BorderLayout());
        ic1 = new ImageIcon("C:\\Users\\HP\\Desktop\\MIvsCSk.jpg");
        ic2 = new ImageIcon("C:\\Users\\HP\\Desktop\\RCBvsKXIP.jpg");
        ic3 = new ImageIcon("C:\\Users\\HP\\Desktop\\KKRvsDD.png");
        m1= new JLabel(ic1); m1.setBounds(100,50,100,50);
        m2= new JLabel(ic2); m2.setBounds(100,150,100,50);
        m3= new JLabel(ic3); m3.setBounds(100,250,100,50);
    start = new JLabel("Select a match ") ;
    start.setAlignmentX(JLabel.CENTER);
       start.setAlignmentY(JLabel.CENTER);
    start.setFont(new Font("Comic Sans MS",Font.BOLD,24));
    this.add(start,BorderLayout.PAGE_START);
    pv1=new JPanel();
    pv1.setBackground(java.awt.Color.blue);
    pv1.setLayout(new GridLayout(3,1,20,20)); 
    b1 = new JRadioButton("Match:MI vs CSK"); b1.setFont(new Font("Comic Sans MS",Font.ITALIC,20));
     b2 = new JRadioButton("Match:RCB vs KXIP ");b2.setFont(new Font("Comic Sans Ms",Font.ITALIC,20));
     b3 = new JRadioButton("Match:KKR vs DD");b3.setFont(new Font("Comic Sans MS",Font.ITALIC,20));
    
    b1.setAlignmentX(JRadioButton.CENTER);
       b1.setAlignmentY(JRadioButton.CENTER);
       b2.setAlignmentX(JRadioButton.CENTER);
       b2.setAlignmentY(JRadioButton.CENTER);
       b3.setAlignmentX(JRadioButton.CENTER);
       b3.setAlignmentY(JRadioButton.CENTER);
       
     g = new ButtonGroup();
    g.add(b1);  g.add(b2);  g.add(b3);
    pv1.add(b1);pv1.add(m1);pv1.add(b2);pv1.add(m2);pv1.add(b3);pv1.add(m3);
    this.add(pv1);
    submit = new JButton("Submit") ; submit.addActionListener(this);        
    this.add(submit,BorderLayout.PAGE_END);
       submit.setAlignmentX(JButton.CENTER);
       submit.setAlignmentY(JButton.CENTER);
        
    }
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==submit){
      // get the choice 
      
     if(b1.isSelected()){
     // if b1 is selected show me the seats for b1
  //   SeatsForMatch1 f4 = new SeatsForMatch1();
     
     Test.u.match_name = "Match:MI vs CSK";
     
     }
      if(b2.isSelected()){
//          Match2 f4 = new Match2();
             Test.u.match_name = "Match:RCB vs KXIP";
      }
      if(b3.isSelected()){
//            Match3 f4 = new Match3();
             Test.u.match_name = "Match:KKR vs DD";
      }
      
      SelectZone z = new SelectZone();
      
//      this.setEnabled(false);
        this.dispose();
    }
    
    
    
    }  
    
}