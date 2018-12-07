
package oop_assignment2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class FirstFrame extends JFrame implements ActionListener{
    JButton signin , signup ; JPanel p ;   JLabel title ; 
  public  FirstFrame(){
    this.setVisible(true);this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setSize(700,500);this.setLocationRelativeTo(null);
    this.setTitle("Login Page"); this.setLayout(new BorderLayout());
    this.setResizable(false);
   
title = new JLabel("  Indian Premier League 2018  ");
    title.setHorizontalAlignment(JLabel.CENTER);
    title.setVerticalAlignment(JLabel.CENTER);
    title.setFont(new Font ("Algerian",Font.PLAIN,40));
    this.add(title,BorderLayout.PAGE_START) ;
    p = new JPanel();p.setLayout(null);
   p.setBackground(Color.darkGray);
    

    signin = new JButton("Sign in"); signin.setBounds(225,100,250,70);
    signin.addActionListener(this);
    signin.setFont(new Font("SansSerif",Font.BOLD,32)); signin.setBackground(Color.ORANGE);
    signup = new JButton("Sign up") ;signup.setBounds(225,200,250,70);signup.addActionListener(this);
    signup.setFont(new Font("SansSerif",Font.BOLD,32));signup.setBackground(Color.ORANGE);
    p.add(signup);p.add(signin);
    this.add(p,BorderLayout.CENTER);
    
    
}

    @Override
    public void actionPerformed(ActionEvent e) {
       
        if(e.getSource()==signup){
            SignUpFrame2 f = new SignUpFrame2();
        }
        if(e.getSource()== signin){
            SignIn fv = new SignIn();
        }
        
        
//      this.setEnabled(false);
        
        this.dispose();
        
    }
  
}