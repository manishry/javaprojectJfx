/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dsa.entities;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Manish Rmc
 */
public class CountryList {
    private SimpleIntegerProperty cid;
    private SimpleStringProperty cname;
    private SimpleStringProperty region;
    private SimpleIntegerProperty temperature;

    public CountryList() {
    }

    public CountryList(String cname, String region, Integer temperature) {
        this.cname =  new SimpleStringProperty(cname);
        this.region = new SimpleStringProperty(region);
        this.temperature = new SimpleIntegerProperty(temperature);
    }

    public CountryList(Integer cid, String cname, String region, Integer temperature) {
        this.cid = new SimpleIntegerProperty(cid);
        this.cname = new SimpleStringProperty(cname);
        this.region = new SimpleStringProperty(region);
        this.temperature =  new SimpleIntegerProperty(temperature);
    }

    public Integer getCid() {
        return cid.get();
    }

    public void setCid(Integer cid) {
        this.cid = new SimpleIntegerProperty(cid);
    }

    public String getCname() {
        return cname.get();
    }

    public void setCname(String cname) {
        this.cname = new SimpleStringProperty(cname);
    }

    public String getRegion() {
        return region.get();
    }

    public void setRegion(String region) {
        this.region = new SimpleStringProperty(region);
    }

    public Integer getTemperature() {
        return temperature.get();
    }

    public void setTemperature(Integer temperature) {
        this.temperature = new SimpleIntegerProperty(temperature);;
    }

    
}
