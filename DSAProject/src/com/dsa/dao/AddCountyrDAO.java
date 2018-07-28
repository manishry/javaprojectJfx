/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dsa.dao;

import java.sql.SQLException;

/**
 *
 * @author Manish Rmc
 */
public class AddCountyrDAO {
    
    public void getCountryType(String cname,String region, int temperature) throws SQLException{
      JdbcConnection db = new JdbcConnection();
  
   String sql = "insert into country(cname,region,temperature) values('" + cname + "', '" + region + "', " + temperature + ")";
       
    db.stmt.execute(sql);
    db.con.close();
   
   
    }
    
}
