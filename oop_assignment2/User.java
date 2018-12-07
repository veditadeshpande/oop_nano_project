
package oop_assignment2;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Vector;


public class User {
    String name ,pno ,password, email ; String match_name ; 
    Vector<Seat> seats = new Vector(); String zone ; double cost=0 ;  String k = "";
    static int id =0; 
    
    public User(){
        
    }
     
      
      public void setName(String name){
       this.name = name ;   
       
      }
      public void setContact(String c){
          pno = c ; 
      }
      public void setEmail(String e){
       email = e ;    
      }
      public void setPassword(String p){
       password = p ;    
      }
//      public void signin(){
//      
//      }
//      public void signup(){
      
//      }
     public void addToDatabase(){
         cost = 5000* seats.size() ;
         
         Connection conn = null;
        Statement s=null;String instruction ="";
          String k = "";
          
         for(Seat temp : seats){
             k = k +temp.getSeat() ;
         }
         
        try {
           
//            instruction = "INSERT INTO OOP.INFO(ID,NAME,EMAIL,PASSWORD,SEAT)VALUES(?,?,?,?,?)";
       conn = DriverManager.getConnection("jdbc:derby://localhost:1527/test", "oop", "oop");
       System.out.println("Connection established");
     
                   
       s= conn.createStatement();
       s.executeUpdate("insert into info values ('"+name+"','"+email+"','"+password+"','"+pno+"','"+match_name+"','"+zone+"',"+cost+",'"+k+"')");
    // for match 1------------------------------------------------------------------------------------    
        if(match_name == "Match:MI vs CSK"){
            switch(zone){
                case "EAST" : 
                    for(Seat temp : seats){
                    s.executeUpdate("insert into match1 (east)values('"+temp.getSeat()+"')"); } break;
                 case "WEST" : 
                    for(Seat temp : seats){
                    s.executeUpdate("insert into match1 (west)values('"+temp.getSeat()+"')"); } break;
                  
                  case "NORTH" : 
                    for(Seat temp : seats){
                    s.executeUpdate("insert into match1 (north)values('"+temp.getSeat()+"')"); } break;
                    case "SOUTH" : 
                    for(Seat temp : seats){
                    s.executeUpdate("insert into match1 (south)values('"+temp.getSeat()+"')"); } break;
                  
  }
        } 
        
        
        
        // for match 2-------------------------------------------------------------
        
         if(match_name == "Match:RCB vs KXIP"){
            switch(zone){
                case "EAST" : 
                    for(Seat temp : seats){
                    s.executeUpdate("insert into match2 (east)values('"+temp.getSeat()+"')"); } break;
                 case "WEST" : 
                    for(Seat temp : seats){
                    s.executeUpdate("insert into match2 (west)values('"+temp.getSeat()+"')"); } break;
                  
                  case "NORTH" : 
                    for(Seat temp : seats){
                    s.executeUpdate("insert into match2 (north)values('"+temp.getSeat()+"')"); } break;
                    case "SOUTH" : 
                    for(Seat temp : seats){
                    s.executeUpdate("insert into match2 (south)values('"+temp.getSeat()+"')"); } break;
                  
  }
        } 
        
           if(match_name == "Match:KKR vs DD"){
            switch(zone){
                case "EAST" : 
                    for(Seat temp : seats){
                    s.executeUpdate("insert into match3 (east)values('"+temp.getSeat()+"')"); } break;
                 case "WEST" : 
                    for(Seat temp : seats){
                    s.executeUpdate("insert into match3 (west)values('"+temp.getSeat()+"')"); } break;
                  
                  case "NORTH" : 
                    for(Seat temp : seats){
                    s.executeUpdate("insert into match3 (north)values('"+temp.getSeat()+"')"); } break;
                    case "SOUTH" : 
                    for(Seat temp : seats){
                    s.executeUpdate("insert into match3 (south)values('"+temp.getSeat()+"')"); } break;
                  
  }
        } 
        
        
            s.close();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
           finally
        {   //        Step 6: Close all resources
            try {
                
              
                if(conn!=null)
                    conn.close();
            } catch (SQLException ex) {
                System.out.println("Exception occured while releasing resources");
            }
        }
        
         
     }
     public void addToSeats(Seat temp){
         seats.add(temp);
         
     }
      
}
