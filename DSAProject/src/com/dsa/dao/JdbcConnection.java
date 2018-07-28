package com.dsa.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


// scene builder


class JdbcConnection {
    String driver = "com.mysql.jdbc.Driver";
    String url ="jdbc:mysql://localhost:3306/dsadb";
    String user = "root";
    String pw = "";
    JdbcConnection(){
        try {
            Class.forName(driver);
           con = DriverManager.getConnection(url,user,pw);
            stmt=con.createStatement();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JdbcConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JdbcConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    Connection con = null;
    Statement stmt= null;
public void con(){
    
    
    
    }
public Connection getCon(){
return con;
}
public void setconn(Connection conn){
  this.con=conn;
}

public Statement getstmt(){
return stmt;
}
public void setstmt(Connection stmt){
  this.con=stmt;
}


    public static void main(String[] args) {
        
    }
}
