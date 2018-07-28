/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dsa.dao;

import com.dsa.entities.CountryList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Manish Rmc
 */

public class CountryListDAO {
    public ObservableList getCountryList() throws SQLException{
         ArrayList<CountryList> alist = new ArrayList();
         
         JdbcConnection db = new JdbcConnection();
         ResultSet rs = db.stmt.executeQuery("select * from country");
         while(rs.next()){
             alist.add(new CountryList(rs.getInt("cid"),rs.getString("cname"),rs.getString("region"),rs.getInt("temperature")));
             
         }
         db.stmt.close();
         db.con.close();
         ObservableList<CountryList> list = FXCollections.observableArrayList(alist);
         return list;
        
    }
    // update operation
    public void updateCountryList(CountryList cl) throws SQLException{
    int cid = cl.getCid();
    String cname = cl.getCname();
    String region = cl.getRegion();
    int temperature = cl.getTemperature();
    
    JdbcConnection db = new JdbcConnection();
    String sql = "update country set cname='"+cname+"', region='"+region+"',temperature="+temperature+" where cid="+cid;
      System.out.println(sql);
      db.stmt.executeUpdate(sql);
      db.stmt.close();
      db.con.close();
    
    
  }
    // delete operation
    public void deleteCountryList(CountryList cl) throws SQLException{
    int cid = cl.getCid();
    String cname = cl.getCname();
    String region = cl.getRegion();
    int temperature = cl.getTemperature();
    
    JdbcConnection db = new JdbcConnection();
    String sql = "delete from country   where cid="+cid;
      System.out.println(sql);
      db.stmt.executeUpdate(sql);
      db.stmt.close();
      db.con.close();
    
    
  }
    public void sortCountryByAsc(CountryList cl) throws SQLException{
    int cid = cl.getCid();
    String cname = cl.getCname();
    String region = cl.getRegion();
    int temperature = cl.getTemperature();
    
    JdbcConnection db = new JdbcConnection();
    String sql = "select * from country ORDER BY cname ASC";
      System.out.println(sql);
      db.stmt.executeUpdate(sql);
      db.stmt.close();
      db.con.close();
    
    
  }
   
}
