
package oop_assignment2;

import javax.swing.JButton;


public class Seat {
    String row ; int column ; 

    
    public Seat(){
    
    }
    
 public Seat(String row, int i) {
      this.row = row ; this.column =  i ; 
    }
 public String getSeat(){
    
     Integer g = new Integer(column);
     return row+" "+g.toString() ;
     
     
 }
    
}
